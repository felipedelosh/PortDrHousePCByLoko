# DoctorHousePC - port inicial 0.1.0

Extraer en la raiz de DoctorHousePC. El ZIP incluye src/ y tres archivos auxiliares de raiz (build.gradle, settings.gradle, run.ps1). No reemplaza INPUT, Docs, TOOLS ni DECOMPILED.

## Ejecutar en Windows (JDK 21)

Desde PowerShell en la raiz:

```powershell
java -version
javac -version
powershell -ExecutionPolicy Bypass -File .\run.ps1
```

Alternativamente, si Gradle compatible con Java 21 esta instalado: `gradle run`. No se incluye Gradle Wrapper; Gradle no estaba disponible en el entorno de pruebas. No hay dependencias externas de Java ME.

Controles: flechas o 2/4/6/8, Enter/Espacio o 5, F1 (softkey izquierda), F2/Escape (softkey derecha), numeros 0-9, * y #. Si la ventana no recibe teclas, hacer clic dentro. La resolucion logica inicial es 240x320 (suposicion de port), escalada x2. Se puede ajustar mediante propiedades JVM `house.width` y `house.height`. Guardado: ~/.doctorhousepc/House.sav (se puede cambiar con `-Dhouse.saveDir=...`).

## Implementacion

- Main inicia Mapp en Swing; class_3 conserva el motor descompilado.
- SpriteData recupera la estructura b; el hilo d se reconstruye con una lambda que captura el argumento.
- Se corrigen tipos no representables, referencias Class.forName("c"), variables var sin inicializador y conversiones a byte. Se amplian contadores de bucles que desbordaban a 127 y bloqueaban el renderizado.
- Adaptadores javax.microedition implementados con Swing, Java2D, archivos y Java MIDI. No se utiliza un emulador ni bytecode original en tiempo de ejecucion.
- class_2 deshabilita SMS y enlaces promocionales antiguos; el manifest original no habilita Play2Me.
- Los recursos originales mantienen sus nombres y rutas de classpath; no agrupar por extension en src/main/resources.

## Validacion y limitaciones

Compilacion con javac 21 en Linux; prueba de interfaz bajo Xvfb mediante eventos enviados al listener Swing: seleccion de Espanol, confirmacion de sonido, menu e inicio de partida con escenario del hospital y dialogo de House. No se ha verificado teclado fisico en Windows ni comparado contra un emulador. No se han completado todas las misiones, minijuegos, persistencia/reanudacion ni fidelidad grafica. MIDI implementado, pero reproduccion audible y volumen no verificados; VolumeControl no implementado. Algunas semanticas J2ME son parciales. Quedan posibles errores de descompilacion y de concurrencia. Este es un port experimental, no una version final.
