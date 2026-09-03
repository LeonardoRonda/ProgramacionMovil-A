##titulo: Jetpack compose

##Estudiante: Leonardo Favio Ronda Vidalon

##Descripcion: en este proyecto se creo un layout donde se crearon campos para ingresar datos y un
boton de agragar producos como también un resumen del producto agregado.

##¿qué pasaría si declaras las variables de los campos SIN remember?

Lo que sucederia es que cada vez que el usuario interactuara con interfaz con los elementos que cambian de estado como los botones, lo que ocurre es que la interfaz se reinicia o vuelve a cargar en cada interacción, mientras que cuando se usa remember este guarda como una especie de memoria caché.

##Capturas de pantalla

<img width="497" height="818" alt="image" src="https://github.com/user-attachments/assets/9a819d21-9e43-4ff0-8bb0-f3c8cdf90c14" />

<img width="472" height="639" alt="image" src="https://github.com/user-attachments/assets/5a20eb33-be2c-4bde-b1b0-66e1738e140a" />

<img width="427" height="478" alt="image" src="https://github.com/user-attachments/assets/3d79a274-75f0-4d85-a838-dd07ee230065" />


## Bitácora de Prompts e Interacción con IA

| Prompt que usé                                                                                                                                                                                                                                        | Qué generó Gemini                                                                              | Qué acepté o corregí (y por qué)                                                                                                         |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------|
| "necesito que evalues el siguiente codigo kotlin que estoy usando para crear un layout para gregar productos en un archivo MainActivity y desarrolles los cambios que te dare después. <br/>Este es el código: (introduje el codigo del MainActivity ...." | Primero lo hice entender como funciona el codiog y el conexto en el que estoy desarrollando    | **Acepté:** Porque primero esta analizando la situacion                                                                                  |
| "Mejora los siguientes cambios dentro de PantallaRegistro, debe evaluarse si los campos de nombre de producto, precio y cantidad estan comlpetados, en caso que esten vacios debe arrojar  <br/>un mensaje de error en lugar de la card. A demás implementa<br/> un boton con el mensaje "Limpiar", que se encargue de limpiar el formulario de nombre de producto, precio y cantidad."                                                                                                                                       | Código completo con estados de error, botones en `Row`, teclados numéricos y limpieza.         | **Acepté:**, porque si cumplia con lo solicitados y evaluaba mediantes condicionales if, else y else if el comportamiento de los cmapos. |
             
