# Save the Game — DoctorHousePC

Documentación técnica del sistema de guardado y carga de partidas del port de House (2008) a Java SE 17/21.

## 1. Sistema de persistencia

El juego original utiliza RMS (Record Management System), mediante la API `javax.microedition.rms.RecordStore` de Java ME. En el port se implementó una capa de compatibilidad que conserva el contrato utilizado por el motor, pero almacena los datos en un archivo binario local mediante Java NIO (`java.nio.file`). No requiere una base de datos ni conexión a Internet.

Las clases involucradas son:

```text
src/src/main/java/
├── class_3.java
├── Mapp.java
└── javax/microedition/rms/
    └── RecordStore.java
```

La ruta anterior corresponde a la estructura actual del repositorio, donde el proyecto Java está dentro de `src/`.

## 2. Ubicación de la partida

El archivo se llama `House.sav`. La implementación de `RecordStore` determina su ubicación mediante el siguiente código:

```java
path = Path.of(
    System.getProperty(
        "house.saveDir",
        Path.of(
            System.getProperty("user.home"),
            ".doctorhousepc"
        ).toString()
    ),
    name + ".sav"
);
```

Si no se proporciona la propiedad `house.saveDir`, el directorio predeterminado es `.doctorhousepc` dentro de `user.home`. Por ejemplo, en Windows 11:

```text
C:\Users\docto\.doctorhousepc\House.sav
```

Esta ruta es un ejemplo, no una confirmación de la ubicación efectiva en el equipo. El valor de `user.home` reconocido por Java puede diferir de la variable de entorno `USERPROFILE`.

## 3. Cómo encontrar la partida en Windows 11

### 3.1. Consultar el directorio de usuario de Java

Desde PowerShell, ejecutar:

```powershell
java -XshowSettings:properties -version 2>&1 | Select-String "user.home"
```

Ejemplo de salida:

```text
    user.home = C:\Users\docto
```

A esa ruta se debe añadir `\.doctorhousepc\House.sav`, siempre que no exista una configuración personalizada de `house.saveDir`.

Si los scripts de ejecución utilizan un JDK diferente al del comando `java` disponible en PATH, realizar la consulta con el ejecutable `java.exe` de ese mismo JDK.

### 3.2. Comprobar y abrir el directorio predeterminado

Si `user.home` coincide con `USERPROFILE`:

```powershell
Test-Path "$env:USERPROFILE\.doctorhousepc\House.sav"
explorer "$env:USERPROFILE\.doctorhousepc"
```

`Test-Path` devuelve `True` si existe el archivo y `False` si no existe.

### 3.3. Buscar el archivo en el perfil de Windows

```powershell
Get-ChildItem -Path "$env:USERPROFILE" -Filter "House.sav" -File -Recurse -Force -ErrorAction SilentlyContinue
```

Esta búsqueda puede tardar y no encontrará partidas almacenadas fuera del perfil indicado.

### 3.4. Confirmar la ruta real mediante logs

Si no se encuentra el archivo, agregar las siguientes líneas al constructor de `RecordStore.java`, inmediatamente después de inicializar `path`:

```java
System.out.println("[SAVE] File path: " + path.toAbsolutePath().normalize());
System.out.println("[SAVE] File exists: " + Files.exists(path));
```

Recompilar y ejecutar el juego. La consola mostrará la ruta efectiva utilizada por el proceso y si el archivo existía al abrir el almacenamiento. Esta es la comprobación más fiable, incluso cuando se utiliza `house.saveDir`.

Los logs son una mejora de diagnóstico propuesta; no forman parte del código original mostrado.

## 4. Cómo se inicializa y carga la partida

En `class_3.java`, el método `method_80()` inicializa el almacenamiento:

```java
field_71 = new byte[512];
field_71[0] = -1;

try {
    field_70 = RecordStore.openRecordStore("House", true);
    if (field_70.getNumRecords() != 0) {
        method_82();
        return;
    }
    field_70.addRecord(field_71, 0, field_71.length);
} catch (Exception var1) {
    field_70 = null;
}
```

1. Se crea un arreglo de 512 bytes y se inicializa su primer byte a `-1`.
2. Se abre el almacenamiento denominado `House`.
3. El constructor de `RecordStore` lee `House.sav` con `Files.readAllBytes(path)` si existe.
4. Si hay un registro, `method_82()` recupera los datos mediante `getRecord(1)`.
5. Si no hay un registro, `addRecord()` crea y escribe el registro inicial en disco.

```java
public static final void method_82() {
    try {
        field_71 = field_70.getRecord(1);
    } catch (Exception var1) {
    }
}
```

La implementación devuelve una copia del arreglo mediante `data.clone()`. Por tanto, modificar el arreglo del motor no modifica automáticamente el archivo en disco.

## 5. Cómo se guarda la partida

El método `method_83()` solicita la escritura del registro:

```java
public static final boolean method_83() {
    try {
        field_70.setRecord(1, field_71, 0, field_71.length);
        return true;
    } catch (Exception var1) {
        return false;
    }
}
```

La implementación actual de `RecordStore.setRecord()` es:

```java
public void setRecord(int id, byte[] b, int o, int l) throws IOException {
    data = Arrays.copyOfRange(b, o, o + l);
    Files.createDirectories(path.getParent());
    Files.write(path, data);
}
```

Se copia el segmento indicado del arreglo, se crea el directorio de guardado si es necesario y se escribe el contenido binario. Si el archivo ya existe, `Files.write()` lo reemplaza en su ubicación actual.

Durante el cierre normal, `method_81()` llama a `method_83()` y posteriormente a `closeRecordStore()`. Este último método no realiza ninguna operación en el port actual: la escritura ya se efectuó en `setRecord()`.

No se ha determinado todavía la totalidad de los eventos de jugabilidad que invocan el guardado, ni qué campos del progreso se actualizan en cada evento.

## 6. Mapeo de atributos y métodos

| Nombre actual | Nombre propuesto | Responsabilidad |
|---|---|---|
| `field_70` | `recordStore` | Referencia al almacenamiento. |
| `field_71` | `saveData` | Datos binarios utilizados por el motor. |
| `method_80()` | `initializeSaveStorage()` | Abre o inicializa el registro. |
| `method_81()` | `closeSaveStorage()` | Solicita el guardado y cierre. |
| `method_82()` | `loadSaveData()` | Carga el registro en memoria. |
| `method_83()` | `writeSaveData()` | Escribe el registro y devuelve el resultado. |

Los nombres descriptivos son propuestas para la futura fase de desofuscación semántica. No implican cambios ya aplicados al código.

## 7. Cómo borrar o reiniciar una partida

Cerrar completamente el juego antes de borrar el archivo para evitar que el motor vuelva a guardarlo al salir.

Si se confirmó que la ubicación coincide con el perfil de Windows:

```powershell
Remove-Item -LiteralPath "$env:USERPROFILE\.doctorhousepc\House.sav"
```

También se puede eliminar manualmente desde el Explorador de archivos. Si se utiliza otro directorio, sustituir la ruta por la obtenida mediante los logs.

Al volver a ejecutar el juego, `method_80()` creará un nuevo registro inicial si no existe el archivo y la escritura se realiza correctamente. Esto elimina tanto el progreso como cualquier configuración que estuviera almacenada dentro del mismo registro.

### Copia de seguridad (opcional)

En lugar de eliminar el archivo, se puede renombrar:

```powershell
Rename-Item -LiteralPath "$env:USERPROFILE\.doctorhousepc\House.sav" -NewName "House.backup.sav"
```

Para recuperar la copia, cerrar el juego, conservar o retirar el nuevo `House.sav` y renombrar la copia como `House.sav`.

## 8. Cambiar la ubicación de guardado

La propiedad JVM `house.saveDir` permite especificar un directorio personalizado. Por ejemplo:

```text
-Dhouse.saveDir=./SAVES
```

Agregar este argumento a la invocación de `java` en `run-java17.ps1` o `run-java21.ps1`, antes del nombre de la clase principal `Main`. No agregarlo a `javac`.

La ruta relativa `./SAVES` se resuelve respecto al directorio de trabajo del proceso Java, no necesariamente respecto a la raíz del repositorio. También se puede utilizar una ruta absoluta.

Cambiar el directorio no migra automáticamente una partida existente. Para conservarla, cerrar el juego y copiar `House.sav` al nuevo directorio antes de ejecutar nuevamente.

Para evitar subir partidas personales al repositorio, conservar la regla `*.sav` en `.gitignore`.

## 9. Limitaciones y futuras investigaciones

- El motor inicializa un registro de 512 bytes; la implementación del port no valida que un archivo existente tenga exactamente ese tamaño.
- La capa de compatibilidad soporta un único registro y no distingue entre diferentes identificadores de registro.
- El parámetro `create` de `openRecordStore()` no se utiliza actualmente.
- No hay validación de integridad, versionado del formato, copias automáticas ni escritura atómica.
- Algunas excepciones de persistencia se silencian en el motor original.
- Todavía no se conoce el significado de cada byte del archivo ni se ha validado la compatibilidad con partidas extraídas de celulares o emuladores.

La siguiente fase de ingeniería inversa del sistema de persistencia deberá identificar los índices de `field_71`, sus tipos de datos, los eventos que modifican el progreso y los puntos de guardado y restauración.

## 10. Referencias internas

- `class_3.java`: inicialización, lectura y escritura de los datos del motor.
- `javax/microedition/rms/RecordStore.java`: implementación de persistencia para Java SE.
- `Mapp.java`: ciclo de vida y cierre de la aplicación.
- `run-java17.ps1` y `run-java21.ps1`: configuración de ejecución de la JVM.

Esta documentación se basa en el código recuperado y en la implementación de `RecordStore` compartida durante el desarrollo. La ubicación efectiva en cada equipo debe comprobarse en tiempo de ejecución.
