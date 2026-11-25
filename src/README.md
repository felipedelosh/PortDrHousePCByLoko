# DoctorHousePC

**Port experimental de House (2008) a Java SE — versión 0.1.0**

Proyecto personal de preservación, aprendizaje e ingeniería inversa asistida por inteligencia artificial. Su objetivo es ejecutar el videojuego original de Doctor House en PC, conservando su lógica, gráficos, diálogos y comportamiento, sin depender de un emulador Java ME durante la ejecución del port.

## 1. Información del juego original

| Propiedad | Valor |
|---|---|
| Nombre | House |
| Versión | 1.01 |
| Año de referencia | 2008 |
| Desarrollador | mobiground.com |
| Plataforma | Java ME (J2ME) |
| Configuración declarada | CLDC 1.0 |
| Perfil declarado | MIDP 1.0 |
| Clase principal original | `Mapp` |
| Idiomas | Inglés y español |
| Almacenamiento declarado | 512 bytes |

Los metadatos se encuentran en `META-INF/MANIFEST.MF`. Aunque el manifiesto declara MIDP 1.0, el código utiliza `GameCanvas` y otras APIs que requieren una implementación de compatibilidad más amplia.

## 2. Tecnologías del port

| Tecnología | Responsabilidad |
|---|---|
| Java SE 17 / 21 | Compilación y ejecución del port |
| Swing | Ventana, panel y eventos de teclado |
| Java2D | Renderizado gráfico |
| Java Sound / MIDI | Audio original |
| Java NIO | Persistencia local |
| Gradle | Gestión y compilación opcional (configurado inicialmente para Java 21) |
| Visual Studio Code | Entorno de desarrollo elegido |
| Vineflower 1.12.0 | Descompilación y renombrado de miembros |
| ChatGPT | Análisis, ingeniería inversa, implementación y corrección incremental |
| Git | Control de versiones |

No se requieren dependencias externas de Java ME para ejecutar el port. CFR es un descompilador alternativo opcional, no utilizado como requisito de esta versión.

## 3. Estructura del proyecto

La siguiente estructura reúne el material original, los archivos entregados en la versión 0.1.0 y los documentos planificados. Los dos scripts específicos de Java se entregaron por separado del ZIP inicial.

```text
DoctorHousePC/
├── Docs/
│   ├── PROJECT.md                 # Planificado
│   ├── ARCHITECTURE.md            # Planificado
│   ├── CLASS_MAPPING.md           # Planificado
│   ├── METHOD_MAPPING.md          # Planificado
│   ├── GAME_FLOW.md               # Planificado
│   └── RESOURCE_FORMATS.md        # Planificado
├── INPUT/
│   └── DrHouse.jar
├── TOOLS/
│   └── vineflower-1.12.0.jar
├── DECOMPILED/
│   └── VINEFLOWER/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Main.java
│   │   │   ├── Mapp.java
│   │   │   ├── class_2.java
│   │   │   ├── class_3.java
│   │   │   ├── SpriteData.java
│   │   │   └── javax/microedition/
│   │   │       ├── lcdui/
│   │   │       │   ├── Display.java
│   │   │       │   ├── Font.java
│   │   │       │   ├── Graphics.java
│   │   │       │   ├── Image.java
│   │   │       │   └── game/GameCanvas.java
│   │   │       ├── media/
│   │   │       │   ├── Manager.java
│   │   │       │   ├── Player.java
│   │   │       │   └── control/VolumeControl.java
│   │   │       ├── midlet/MIDlet.java
│   │   │       └── rms/RecordStore.java
│   │   └── resources/
│   │       ├── META-INF/MANIFEST.MF
│   │       └── Recursos originales (.png, .bin, .tx, .flh, .pal)
│   └── test/java/                 # Vacío en la versión inicial
├── build.gradle
├── settings.gradle
├── run.ps1                        # Script original para Java 21
├── run-java17.ps1
├── run-java21.ps1
├── README_PORT.md                 # Notas de la entrega inicial
├── README.md
├── AGENTS.md                      # Propuesto
└── .gitignore                     # Recomendado
```

`INPUT` y `DECOMPILED` son referencias que deben conservarse sin alterar. `src` contiene el código que sí podemos modificar. `build` se genera al compilar y no necesita versionarse.

## 4. Ejecutar en Windows

### Requisitos

- JDK 17 o JDK 21 (no basta con un JRE).
- PowerShell y una sesión gráfica de Windows.
- Visual Studio Code es opcional para ejecutar; se recomienda para desarrollar.

Extraer `DoctorHousePC_0.1.0.zip` en la raíz del proyecto, no dentro de `src`. Colocar los scripts `run-java17.ps1` y `run-java21.ps1` también en la raíz. Conservar las carpetas existentes de documentación y material original.

Abrir una terminal PowerShell en la raíz y comprobar:

```powershell
java -version
javac -version
```

### Java 17

```powershell
powershell -ExecutionPolicy Bypass -File .\run-java17.ps1
```

### Java 21

```powershell
powershell -ExecutionPolicy Bypass -File .\run-java21.ps1
```

Los scripts buscan el JDK en `JAVA_HOME_17` o `JAVA_HOME_21`, respectivamente; si no existe esa variable, usan `JAVA_HOME` y, si tampoco existe, buscan los ejecutables en `PATH`. Exigen que tanto `java` como `javac` correspondan a la versión seleccionada.

Si hay varias instalaciones, configurar las rutas reales en la sesión actual de PowerShell:

```powershell
$env:JAVA_HOME_17 = "C:\Program Files\Java\jdk-17"
$env:JAVA_HOME_21 = "C:\Program Files\Java\jdk-21"
```

Cada script compila con `--release`, codificación UTF-8 y ejecuta `Main` con los recursos en el classpath. Las salidas quedan en `build/classes-java17` y `build/classes-java21`. No es necesario instalar Gradle ni modificar `build.gradle` para usar los scripts.

### Alternativa con Gradle

Con una instalación de Gradle compatible con el JDK elegido:

```powershell
gradle run
```

El `build.gradle` entregado originalmente selecciona Java 21 mediante toolchain. Para usar exclusivamente Java 17 con Gradle, cambiar `JavaLanguageVersion.of(21)` a `JavaLanguageVersion.of(17)`. No se incluye Gradle Wrapper y esta ruta de ejecución no se ha validado todavía.

### Compilación manual (opcional)

Ejemplo para Java 17, con el JDK correcto configurado:

```powershell
$classes = '.\build\classes-java17'
New-Item -ItemType Directory -Force -Path $classes | Out-Null
$files = @(Get-ChildItem '.\src\main\java' -Recurse -Filter '*.java' | ForEach-Object { $_.FullName })
javac --release 17 -encoding UTF-8 -d $classes @files
if ($LASTEXITCODE -eq 0) {
    java -cp "$classes;.\src\main\resources" Main
}
```

## 5. Controles

| Teclado PC | Acción |
|---|---|
| Flechas o 2/4/6/8 | Movimiento y navegación |
| Enter, espacio o 5 | Seleccionar e interactuar |
| F1 | Softkey izquierda |
| F2 o Escape | Softkey derecha |
| 0–9 | Teclado numérico original |
| * y # | Teclas especiales |

Si no responde el teclado, hacer clic dentro de la ventana para recuperar el foco.

## 6. Arquitectura técnica

```text
Main (entrada Java SE, Swing)
  └── Mapp (ciclo de vida MIDlet)
      └── class_3 (motor original recuperado)
          ├── Game Loop y estados
          ├── Renderizado y sprites (SpriteData)
          ├── Controles
          ├── Escenarios, scripts y diálogos
          ├── Audio y persistencia
          └── class_2 (servicios promocionales deshabilitados)
                     │
                     ▼
          Adaptadores javax.microedition
                     │
                     ▼
          Swing / Java2D / Java Sound / Java NIO
```

La estrategia es conservar el motor descompilado y reemplazar las APIs de Java ME por adaptadores escritos en Java SE. Los paquetes `javax.microedition` de este proyecto son implementaciones locales y parciales, no una distribución oficial de Java ME.

| Java ME | Implementación de escritorio |
|---|---|
| MIDlet | Ciclo de vida local |
| Display | JFrame |
| GameCanvas | JPanel, buffers de imagen y bucle original |
| Graphics | Graphics2D |
| Image | BufferedImage |
| Font | Adaptador de java.awt.Font |
| keyPressed / keyReleased | Eventos Swing |
| RecordStore | Archivos locales |
| Player / Manager | javax.sound.midi |
| VolumeControl | Interfaz presente, control efectivo pendiente |

### Clases principales

| Archivo | Función |
|---|---|
| Main.java | Punto de entrada del port |
| Mapp.java | Inicialización y finalización del motor |
| class_3.java | Motor recuperado de la clase original `c`; lógica, renderizado, controles y recursos |
| SpriteData.java | Reconstrucción de la estructura original `b` |
| class_2.java | Sustituto mínimo de la clase `a`; SMS y promociones deshabilitados |

La clase original `d`, correspondiente a un hilo auxiliar, se reconstruyó mediante una lambda. Se mantienen nombres ofuscados como `method_19` y `field_52` hasta comprender su significado y poder renombrarlos de forma segura.

### Game Loop y pantalla

El bucle original limita el intervalo mínimo a 62 ms durante el funcionamiento normal (aproximadamente 16 iteraciones por segundo). No se fuerza a 60 FPS para evitar alterar animaciones y lógica temporal.

Se eligió una resolución lógica inicial de 240 × 320 píxeles, con tamaño de ventana preferido al doble y escalado entero. Es una decisión del port, no una resolución original confirmada.

Ejemplo de ajuste después de compilar con Java 17:

```powershell
java -Dhouse.width=240 -Dhouse.height=320 -cp ".\build\classes-java17;.\src\main\resources" Main
```

### Persistencia

La implementación adapta el registro `House` a un archivo local:

```text
%USERPROFILE%\.doctorhousepc\House.sav
```

Se puede modificar el directorio mediante la propiedad JVM `house.saveDir`. El motor inicializa 512 bytes para sus datos persistentes; falta validar el ciclo completo de guardar y reanudar.

## 7. Recursos originales

| Recurso | Uso identificado |
|---|---|
| PNG | Personajes, logotipos, sprites, fuentes gráficas y elementos de interfaz |
| isomap.bin | Datos de escenarios isométricos |
| script.bin | Datos de scripts del juego |
| anims.bin | Datos de animaciones |
| pack.bin, personajes.bin, carap.bin, carta.bin, f.bin, fa.bin | Datos asociados a recursos gráficos |
| pack.flh, personajes.flh | Datos de composición gráfica |
| f.pal | Variantes de paleta |
| en_a.tx, en_b.tx, es_a.tx, es_b.tx | Textos y diálogos codificados |
| s0.bin a s4.bin | Recursos tratados por el motor como audio MIDI |
| META-INF/MANIFEST.MF | Metadatos y configuración de idioma |

Los formatos internos no se han documentado exhaustivamente. El motor busca recursos por su nombre y ruta originales, por ejemplo `/house.png` y `/script.bin`.

**No organizar `src/main/resources` por extensión.** Si se usa un script Python para clasificar archivos descompilados, hacerlo sobre una copia de análisis. Conservar siempre una copia intacta con las rutas originales.

## 8. Cómo se realizó la ingeniería inversa con IA

### 8.1 Recuperación y preservación

Se partió del juego original `DrHouse.jar` y de una copia extraída (`UnPack.zip`). Se identificaron las cinco clases compiladas `Mapp`, `a`, `b`, `c` y `d`, además del manifiesto y los recursos. La inspección del bytecode permitió identificar dependencias de Java ME y la concentración de lógica en `c`.

### 8.2 Descompilación

Se utilizó Vineflower 1.12.0 para recuperar código Java. El comando recomendado para reproducir esta etapa desde la raíz es:

```powershell
New-Item -ItemType Directory -Force -Path '.\DECOMPILED\VINEFLOWER' | Out-Null
java -jar .\TOOLS\vineflower-1.12.0.jar --rename-members=true --folder .\INPUT\DrHouse.jar .\DECOMPILED\VINEFLOWER
```

Vineflower necesita Java 17 o superior. Los archivos recuperados principales fueron `Mapp.java`, `class_2.java` y `class_3.java`. Las estructuras auxiliares quedaron representadas de forma incompleta dentro del resultado de descompilación.

### 8.3 Análisis asistido por ChatGPT

Se proporcionaron a ChatGPT los archivos Java descompilados y los recursos en ZIP. Se analizaron las responsabilidades de las clases, importaciones, llamadas, estados, carga de recursos y referencias a nombres originales. El análisis no recupera mágicamente los nombres fuente perdidos: se deducen responsabilidades a partir de evidencia y se documentan las incertidumbres.

Ejemplos de métodos identificados en `class_3.java` (nombres de Vineflower):

| Método | Responsabilidad |
|---|---|
| run() | Bucle principal |
| method_8() | Configuración de idiomas |
| method_12() | Dimensiones de pantalla |
| method_16() | Renderizado principal |
| method_19() / method_20() | Interpretación y actualización de controles |
| method_31() / method_32() | Inicialización y carga de estructuras gráficas |
| method_36() | Carga de imágenes y variantes de paleta |
| method_57() | Codificación interna de caracteres |
| method_63() | Carga de textos por idioma |
| method_68() / method_69() | Inicialización y reproducción de audio |
| method_80() / method_83() | Inicialización y escritura de persistencia |
| method_84() | Lectura de recursos binarios |

### 8.4 Reparación del código descompilado

El resultado de Vineflower no era directamente compilable. Se reconstruyeron tipos marcados como `<unrepresentable>`, se corrigieron referencias `Class.forName("c")` que no coincidían con la clase renombrada, declaraciones `var` sin inicializador y conversiones a `byte`. Se recuperó la estructura `SpriteData` y se reconstruyó el hilo auxiliar. Durante las pruebas se detectaron bucles con contadores `byte` que desbordaban al superar 127; se ampliaron a `int` para evitar bloqueos de renderizado.

### 8.5 Port y pruebas incrementales

ChatGPT generó los adaptadores Java SE, el punto de entrada de escritorio y los scripts de compilación. Se conservó el motor original tanto como fue posible. La compilación y las pruebas gráficas permitieron detectar y corregir problemas concretos. Se deshabilitaron SMS y enlaces comerciales antiguos, ya que no forman parte del objetivo de jugabilidad y el manifiesto no habilita Play2Me.

La IA se utilizó como asistente de ingeniería, no como sustituto de la compilación, inspección del código o pruebas. No se afirma que se haya recuperado el código fuente original exacto ni que todos los métodos estén comprendidos.

### 8.6 Prompt reutilizable para futuras investigaciones

```text
Analiza el código original/descompilado y la implementación actual de DoctorHousePC.
Identifica la responsabilidad del componente indicado y sus dependencias.
Respalda cada conclusión con clases, métodos o referencias al bytecode.
Diferencia hechos comprobados de hipótesis.
No modifiques INPUT ni DECOMPILED.
Propón el cambio mínimo, conservando el comportamiento original.
Incluye una prueba reproducible y documenta las limitaciones.
```

Este prompt es una propuesta de trabajo futuro; no es una transcripción de todas las instrucciones utilizadas durante el desarrollo inicial.

## 9. Estado de la versión 0.1.0

| Funcionalidad | Estado |
|---|---|
| Compilación Java 21 | Verificada en la entrega inicial |
| Compilación con --release 17 | Compatible; ejecución con JDK 17 real pendiente |
| Arranque y selección de idioma | Probados |
| Menú principal e inicio de partida | Probados |
| Renderizado del hospital y diálogo en español | Probados |
| Movimiento y controles durante toda la historia | Pendiente de validación completa |
| Audio MIDI | Implementado; reproducción audible pendiente de validación |
| Control de volumen | Pendiente de implementación |
| Guardar y reanudar | Implementado parcialmente; pendiente de pruebas |
| Minijuegos y final de historia | Pendientes |
| Comparación contra un emulador del original | Pendiente |
| Ejecución física en Windows y scripts PowerShell | Pendiente de validación |
| Pruebas automatizadas | Pendientes |

Las pruebas iniciales se realizaron en Linux con Java 21 y una pantalla virtual Xvfb, enviando eventos al listener Swing. No equivalen a una validación completa de jugabilidad ni de fidelidad gráfica. Algunas APIs de compatibilidad son parciales y pueden persistir errores de descompilación o concurrencia.

## 10. Plan de desarrollo

| Fase | Objetivo | Estado |
|---|---|---|
| 1. Recuperación | Preservar binarios y verificar el JAR original en emulador | Material recuperado; emulador pendiente |
| 2. Descompilación | Recuperar Java y reparar errores | Avanzada |
| 3. Ingeniería inversa | Identificar clases, métodos, estados y formatos | En progreso |
| 4. Compatibilidad | Implementar APIs necesarias de Java ME | Implementación inicial |
| 5. Primer arranque | Mostrar menú original en PC | Alcanzado en pruebas iniciales |
| 6. Jugabilidad | Validar movimiento, diálogos y minijuegos | En progreso |
| 7. Persistencia y audio | Verificar partidas y reproducción MIDI | Pendiente de validación |
| 8. Modernización | Escalado, controles configurables y empaquetado | Parcial; mejoras pendientes |

La prioridad es recuperar y validar el comportamiento original antes de refactorizar o modernizar el motor.

## 11. Solución de problemas

| Problema | Acción recomendada |
|---|---|
| `JDK 17/21 required` | Revisar las variables JAVA_HOME correspondientes y las versiones de java/javac |
| `javac` no reconocido | Instalar un JDK completo o configurar su ruta |
| No se encuentra Main | Ejecutar desde la raíz y verificar src/main/java/Main.java |
| Pantalla negra o recursos faltantes | Comprobar que los recursos conserven sus rutas originales |
| Teclado sin respuesta | Hacer clic en el panel y volver a probar |
| Audio ausente | Registrar el problema; MIDI todavía requiere validación |
| Error de compilación tras cambios | Revisar la primera excepción o error y comparar con la versión anterior |

Para reportar un error, registrar versión del JDK, sistema operativo, comando ejecutado, salida completa de consola, pasos de reproducción y captura si corresponde.

## 12. Control de versiones y mantenimiento

Se recomienda trabajar con commits pequeños, conservar la versión 0.1.0 como referencia y documentar cambios en `Docs/`. Excluir del repositorio las salidas de compilación (`build/`, `.gradle/`, `*.class`), partidas personales (`*.sav`) y, especialmente si el repositorio es público, los binarios, recursos y código recuperado de terceros sin autorización. Mantener copias privadas del material original.

## 13. Créditos y derechos

- Juego original: House, mobiground.com (según su manifiesto).
- Descompilación: Vineflower 1.12.0.
- Ingeniería inversa y desarrollo del port: proyecto personal asistido por ChatGPT.

Este proyecto no es una edición oficial ni implica afiliación con los titulares del videojuego o de la serie. Los derechos del código, personajes, marcas y recursos originales corresponden a sus respectivos titulares. No se concede una licencia sobre dichos materiales. Antes de publicar o distribuir el port y sus recursos, verificar los permisos y derechos aplicables.

---

**Primero recuperar. Después comprender. Finalmente portear.**
