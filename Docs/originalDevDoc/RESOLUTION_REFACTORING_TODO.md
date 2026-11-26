# Tarea pendiente — Adaptación de resolución y pantalla

**Proyecto:** PortDrHousePCByLoko / DoctorHousePC  
**Estado:** Pendiente de implementación y validación incremental.  
**Referencia:** `source_code.zip`, `java/class_3.java` (líneas de esa versión), y las propuestas posteriores de `GameConfiguration`, `GameCanvas` y `Display` compartidas en la conversación.

## 1. Objetivo

Centralizar la resolución en `GameConfiguration.java`, identificar todos los cálculos dependientes del tamaño de pantalla y adaptar únicamente los que lo requieran. Mantener la jugabilidad, las colisiones, las animaciones y los recursos originales. No introducir dependencias externas; conservar compatibilidad con Java 17 y 21.

El usuario informó que el juego funciona con una resolución ampliada; queda pendiente validar sistemáticamente todos los modos. La integración posterior de la configuración no está incluida en el ZIP de referencia y debe comprobarse en el repositorio actual.

## 2. Configuración centralizada

Ruta: `src/src/main/java/configuration/GameConfiguration.java`.

```java
public static final Resolution SELECTED_RESOLUTION = Resolution.TV_SD;
public static final int WINDOW_SCALE = 1;
public static final boolean FULLSCREEN = false;
```

| Preset | Ancho | Alto | Aspecto |
|---|---:|---:|---|
| ORIGINAL | 240 | 320 | 3:4 |
| QVGA | 320 | 240 | 4:3 |
| TV_SD | 640 | 480 | 4:3 |
| HD | 1280 | 720 | 16:9 |
| FULL_HD | 1920 | 1080 | 16:9 |

- [ ] Verificar que `GameCanvas.width` y `height` provienen de `SELECTED_RESOLUTION`.
- [ ] Verificar que `buffer` y `front` usan estas dimensiones.
- [ ] Verificar `panel.setPreferredSize(new Dimension(width * GameConfiguration.WINDOW_SCALE, height * GameConfiguration.WINDOW_SCALE))`.
- [ ] Verificar que `Display` ejecuta `setUndecorated()` antes de `pack()` y aplica `FULLSCREEN` antes de mostrar la ventana.
- [ ] Confirmar que no quedan propiedades `house.width` / `house.height` en conflicto con la configuración.
- [ ] Compilar con Java 17 y 21. Cada modificación de la configuración Java requiere recompilación.

## 3. Desofuscación semántica previa

Archivo: `src/src/main/java/class_3.java`. Renombrar globalmente, preservando tipos, visibilidad y algoritmos.

| Pendiente | Línea | Original | Propuesto |
|---|---:|---|---|
| [ ] | 36 | `field_31` | `canvasWidth` |
| [ ] | 38 | `field_32` | `canvasHeight` |
| [ ] | 299 | `field_165` | `renderBufferWidth` |
| [ ] | 301 | `field_166` | `renderBufferHeight` |
| [ ] | 498 | `field_222` | `screenWidth` |
| [ ] | 500 | `field_223` | `screenHeight` |
| [ ] | 502 | `field_224` | `screenCenterX` |
| [ ] | 504 | `field_225` | `screenCenterY` |

- [ ] Investigar `method_100()` y renombrar, candidato `setRenderBufferSize()`.
- [ ] Investigar `field_167` / `field_168` (líneas 2815–2818): reciben ancho y alto del clip; candidatos a nombres asociados al viewport, no confirmados.
- [ ] Compilar y probar antes de introducir cambios funcionales.

Flujo confirmado en el ZIP:

```text
GameCanvas.getWidth()/getHeight()
    -> method_12(): field_31 / field_32
    -> method_230(): field_222 / field_223
    -> centros field_224 / field_225
    -> method_100(): field_165 / field_166
    -> method_101(): Image.createImage(...)
```

## 4. Reglas para adaptar el motor

- Usar ancho y alto configurados para operaciones de pantalla completa y posicionamiento global.
- Calcular centros mediante `screenWidth / 2` y `screenHeight / 2` (equivalente a `>> 1` para dimensiones positivas).
- Mantener separados los píxeles de pantalla, coordenadas del mundo, coordenadas locales de minijuegos y coordenadas de imágenes fuente.
- No sustituir automáticamente 176 por `screenWidth`, ni 208 por `screenHeight`: pueden representar un tablero con reglas propias.
- Si se desea ampliar un tablero, considerar una transformación uniforme: `scale = Math.min((double) screenWidth / logicalWidth, (double) screenHeight / logicalHeight)`; calcular offsets centrados y convertir las entradas al espacio lógico cuando corresponda. Es una propuesta, no una implementación validada.
- Para márgenes y texto, decidir si deben mantenerse fijos, escalarse o derivarse de la métrica real de fuentes/sprites. Evitar escalar dos veces (motor y ventana).
- Una tarea por commit: identificar, renombrar, probar; después modificar y volver a probar.

## 5. Dimensiones fijas prioritarias

### 5.1 Buffer inicial — `method_98()` (2753–2754)

```java
field_165 = 10;
field_166 = 10;
```

- [ ] Confirmar el ciclo de inicialización y si siempre se sobrescribe mediante `method_100()` antes de crear/usar el buffer.
- [ ] Conservar el valor provisional si es necesario; no reemplazarlo sin evidencia.

### 5.2 Área de minijuego 176 × 128 — `method_399()` (8454–8468 y siguientes)

```java
int var4 = field_222 - 176 >> 1;
int var7 = field_223 - 128 >> 1;
field_228.clipRect(0, var7, field_222, 128);
```

También hay un bucle de fondo hasta 128, bandas negras arriba/abajo y posiciones locales como `var4 + 27`, `var7 + 26` (8471).

- [ ] Identificar el minijuego mediante ejecución.
- [ ] Revisar el centrado, el clip, los bucles del fondo y las bandas negras.
- [ ] Revisar todas las posiciones locales de imágenes y sus dimensiones.
- [ ] Extraer constantes semánticas para 176 y 128 antes de decidir si se escalan.
- [ ] Probar el minijuego completo en cada resolución.

### 5.3 Área de minijuego 176 × 208 — `method_401()` (8590–8601)

```java
field_426 = field_222 - 176 >> 1;
field_427 = field_223 - 208 >> 1;
field_420 = 88;
field_421 = 104;
```

- [ ] Identificar el tablero y su sistema local. 88 y 104 son sus centros.
- [ ] Revisar offsets de piezas `+42` y `+48` (8591–8592).
- [ ] Derivar los centros a partir de dimensiones lógicas del tablero, no de la pantalla directamente.
- [ ] Mantener las posiciones objetivo y las reglas del minijuego.

### 5.4 Movimiento y límites — `method_402()` (8631–8677)

```java
int var3 = field_222 - 176 >> 1;
int var4 = field_223 - 208 >> 1;
// Límites del cursor:
field_421 = Math.min(208, field_421 + 4);
field_420 = Math.min(176, field_420 + 4);
```

- [ ] Revisar los límites inferiores 0 y los superiores 176/208.
- [ ] Revisar velocidad de cursor de 4 píxeles por actualización y recentrado de 1 píxel.
- [ ] Revisar desplazamiento del tablero cuando el cursor excede el ancho o alto de pantalla (8667–8677).
- [ ] Comprobar selección de piezas y tolerancias de posición; no cambiar la dificultad.
- [ ] Investigar posibles límites inclusivos que dejan el cursor en el borde del clip; corregir solo si se reproduce un defecto.

### 5.5 Renderizado del tablero — `method_407()` (8780–8855)

```java
field_228.clipRect(0, field_427, field_222, 208);
if (176 < field_222) { /* fondo */ }
if (176 >= field_222) { /* fondo local */ }
field_228.drawRect(41, 47, 91, 112);
```

- [ ] Revisar relleno del fondo y bucles con 176/208 (8785–8799).
- [ ] Revisar traslación `field_426`, `field_427` y restauración del clip.
- [ ] Revisar rectángulo de tablero (8811) y posiciones de piezas (`method_406()`).
- [ ] Revisar clips de cursor 16×16 y 13×11, offsets 8, 6, 5 y 16 (8826–8830); podrían ser dimensiones propias del sprite.
- [ ] Revisar indicadores de bordes y condiciones `field_427 + 208 > field_223`, `field_426 + 176 > field_222` (8840–8852).
- [ ] Adaptar conjuntamente con `method_401()` y `method_402()`.

## 6. Interfaz gráfica: operaciones mixtas (dinámicas + constantes)

Cada fila es una tarea pendiente. Los valores pueden ser márgenes, métricas de fuente o tamaños de recursos; confirmar antes de parametrizar.

| Pendiente | Líneas aprox. | Método | Valores / investigación |
|---|---|---|---|
| [ ] | 5420 | `method_237()` | Márgenes 20/40 en llamada a `method_267()`. |
| [ ] | 5844–5858 | `method_267()` | Ancho menos 16; altura de línea 16; márgenes 20, 19, 2; ajuste inferior. |
| [ ] | 5919–5940 | `method_270()` | Indicadores a ±10; texto x=8, ancho menos 16; clip completo. |
| [ ] | 5968–5983 | `method_272()`, `method_273()` | Repetición gráfica cada 3 píxeles; comprobar recurso antes de escalar. |
| [ ] | 6003–6040 | `method_276()` | Área fija de 32; márgenes 20/10; valores 16/24 del bloque por clasificar. |
| [ ] | 6173, 6182 | `method_281()`, `method_282()` | Márgenes 20/40. |
| [ ] | 6242, 6251 | `method_287()`, `method_288()` | Márgenes 20/40. |
| [ ] | 6460 | `method_297()` | Área de contenido menos 40, desplazamiento 20. |
| [ ] | 6752 | `method_308()` | Clip de pantalla menos `field_358` y 20. |
| [ ] | 7312–7329 | `method_343()`, `method_344()`, `method_345()` | Márgenes 20/40. |
| [ ] | 7434–7462 | `method_356()` | Interfaz inferior: 14, 48, 16, 3, 4; posición de imagen dinámica. |
| [ ] | 7651–7685 | `method_362()` | Altura `field_358`; offsets 11 y 6. |
| [ ] | 7775–7806 | `method_368()` | Margen 13, altura de texto 16, reserva vertical 40. |
| [ ] | 7912–7918 | `method_374()` | Indicadores a ±10 del contenido. |

### Ejemplos de cálculo a revisar

```java
// method_267(): diálogo
field_280 = method_61(field_222 - 16, field_270, field_271, 0);
int var4 = field_280 * 16;
field_274 = Math.min(var2, var4);
field_275 = var1 + (field_223 - var1 - 20 - field_274 >> 1);

// method_356(): interfaz inferior
field_352 = 14;
field_358 = 48;
field_357 = field_223 - field_358;
field_354 = field_357 - 16;
field_354 += 3;
field_356 = 14 + field_358;
field_353 = 4;
field_355 = field_222 - 4;
```

- [ ] Identificar las métricas de fuente en `method_61()`, `method_62()` y métodos auxiliares antes de cambiar las alturas de texto.
- [ ] Si se escala la interfaz inferior, coordinar su altura con el clip de `method_308()` y el renderizado de `method_362()`.
- [ ] Decidir si introducir constantes o una configuración de layout derivada de la resolución base. No duplicar el ancho/alto global en otras clases.

## 7. Operaciones ya dinámicas — verificar, no reescribir automáticamente

| Pendiente | Líneas aprox. | Método | Responsabilidad observada |
|---|---|---|---|
| [ ] | 1004–1006 | `method_12()` | Lee ancho y alto del canvas. |
| [ ] | 1110 | `method_16()` | Clip de pantalla. |
| [ ] | 1123 aprox. | `method_18()` | Recibe área gráfica; revisar implementación. |
| [ ] | 2770–2771 | `method_100()` | Dimensiones del buffer. |
| [ ] | 2783 | `method_101()` | Creación del buffer. |
| [ ] | 2815–2821 | `method_106()` | Clip y dimensiones del buffer, llama a `method_111()`. |
| [ ] | 3085 aprox. | `method_111()` | Cálculos asociados al buffer; investigar cámara y límites. |
| [ ] | 5268–5287 | `method_230()` | Dimensiones y centros de pantalla. |
| [ ] | 5317–5318 | `renderSplashScreen()` | Fondo completo y logo centrado. |
| [ ] | 5333–5340 | `method_234()` | Posición según altura de imágenes y pantalla. |
| [ ] | 5443 | `method_238()` | Área de contenido. |
| [ ] | 5468 | `method_240()` | Posición horizontal fuera de pantalla. |
| [ ] | 5496–5498 | `method_242()` | Fondo e imagen centrada. |
| [ ] | 5601–5619 | `method_252()` a `method_254()` | Restauración de clip. |
| [ ] | 5674 | `method_258()` | Posicionamiento horizontal. |
| [ ] | 5953 | `method_271()` | Posicionamiento por cuartos de pantalla. |
| [ ] | 6161 | `method_280()` | Imagen centrada. |
| [ ] | 6289–6302 | `method_292()` | Posiciones según imágenes y ancho disponible. |
| [ ] | 7110 | `method_330()` | Transición circular proporcional. |
| [ ] | 7143–7164 | `method_333()`, `method_335()`, `method_336()` | Posicionamiento de contenido. |
| [ ] | 7651–7697 | `method_362()`, `method_363()` | Interfaz y centrado de contenido. |
| [ ] | 7868–7918 | `method_372()` a `method_374()` | Clip, fondo y contenido. |

## 8. Escalado de ventana — GameCanvas y Display

```java
int scale = Math.max(1, Math.min(getWidth() / width, getHeight() / height));
```

- [ ] Confirmar que `getWidth()` / `getHeight()` dentro de `paintComponent()` corresponden al JPanel y `width` / `height` al canvas lógico.
- [ ] Investigar reducción de imagen: el mínimo 1 recorta cuando el panel es menor que la resolución interna.
- [ ] Decidir entre mantener escalado entero para pixel art y permitir reducción proporcional cuando sea necesario.
- [ ] Revisar centrado y bandas negras.
- [ ] Verificar `WINDOW_SCALE` mayor que cero y tamaño de ventana frente al monitor disponible.
- [ ] Verificar `frame.pack()` y tamaño preferido del panel: no eliminar sin proporcionar otro tamaño inicial.
- [ ] Verificar `FULLSCREEN`: maximizado sin bordes, no modo exclusivo; probar cierre, foco y teclado.
- [ ] Revisar `Graphics.java` (`drawRegion`, `drawImage`, `ax`, `ay`) y `Image.java`: no se debe alterar la región fuente ni anclajes para adaptar la pantalla.
- [ ] Revisar `Font.java` (fuente AWT de 12 píxeles) y determinar si se usa en la interfaz relevante; distinguir fuentes de sprites.

## 9. Auditoría adicional pendiente

- [ ] Rastrear cálculos indirectos a partir de `field_167` / `field_168`, clip, cámara y proyección isométrica.
- [ ] Revisar operaciones `drawImage`, `drawRegion`, `fillRect`, `drawRect`, `clipRect`, `setClip`, `translate` con coordenadas literales sin referencia directa al tamaño de pantalla.
- [ ] Revisar tablas y arrays de posiciones, recursos gráficos y datos de mapas que puedan depender de un área fija.
- [ ] Clasificar cada hallazgo: pantalla global, interfaz, tablero local, sprite, mapa, animación o color/ID ajeno a dimensiones.
- [ ] Registrar nuevos hallazgos en este archivo antes de modificar el motor.

## 10. Matriz de pruebas

Marcar cada celda tras una prueba real. No considerar una resolución validada solo porque abre el menú.

| Resolución | Arranque | Menús | Hospital / cámara | Diálogos | Minijuegos | Guardar / cargar | Resultado |
|---|---|---|---|---|---|---|---|
| 240×320 | [ ] | [ ] | [ ] | [ ] | [ ] | [ ] | Pendiente |
| 320×240 | [ ] | [ ] | [ ] | [ ] | [ ] | [ ] | Pendiente |
| 640×480 | [ ] | [ ] | [ ] | [ ] | [ ] | [ ] | Prueba inicial favorable informada; falta regresión |
| 1280×720 | [ ] | [ ] | [ ] | [ ] | [ ] | [ ] | Pendiente |
| 1920×1080 | [ ] | [ ] | [ ] | [ ] | [ ] | [ ] | Pendiente |

- [ ] Probar `WINDOW_SCALE` 1 y 2 donde el monitor lo permita.
- [ ] Probar `FULLSCREEN` activado y desactivado.
- [ ] Probar redimensionamiento, pérdida de foco, teclado, transiciones, límites de mapa y rendimiento.
- [ ] Confirmar que las partidas guardadas siguen siendo compatibles.
- [ ] Compilar con Java 17 y 21 al terminar cada bloque.

## 11. Orden de trabajo recomendado

- [ ] Fase 1: verificar configuración centralizada y compilación.
- [ ] Fase 2: renombrar los ocho atributos de resolución sin cambiar lógica.
- [ ] Fase 3: mejorar escalado de ventana y validar el modo de pantalla completa.
- [ ] Fase 4: auditar cámara, clips y área visible del escenario.
- [ ] Fase 5: adaptar diálogos, menús e interfaz inferior según pruebas.
- [ ] Fase 6: investigar y adaptar los minijuegos con sus sistemas locales intactos.
- [ ] Fase 7: ejecutar la matriz completa de regresión y documentar resultados.

## 12. Registro de cada intervención

Copiar esta plantilla por cada tarea:

```text
Método / atributo:
Archivo y línea:
Valor original:
Responsabilidad confirmada:
Tipo de coordenada (pantalla / local / sprite / mundo):
Cálculo propuesto:
Resoluciones probadas:
Resultado:
Commit:
```

## Alcance de esta investigación

Se reabrió `source_code.zip` y se contrastaron las referencias directas a los ocho atributos de dimensiones y los bloques de minijuegos indicados. El inventario conserva también las líneas de investigación de la revisión anterior. No constituye una auditoría exhaustiva de todas las coordenadas indirectas o recursos binarios. Los nombres semánticos y transformaciones sugeridas son propuestas pendientes de validación. No se ha modificado ni recompilado el videojuego en esta tarea documental.
