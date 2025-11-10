💱 Conversor de Monedas – Desafío Java
📖 Descripción

Proyecto realizado como parte del programa Oracle Next Education (ONE).
El objetivo es implementar un conversor de monedas en Java utilizando la API ExchangeRate para obtener tasas de cambio actualizadas.

El programa permite convertir entre:

Dólar estadounidense (USD)

Peso argentino (ARS)

Real brasileño (BRL)

Euro (EUR)

⚙️ Tecnologías utilizadas

Java 17

HttpClient (java.net.http) – para realizar solicitudes a la API.

Gson (com.google.code.gson) – para analizar y filtrar la respuesta JSON.

ExchangeRate API – fuente de datos actualizados sobre tasas de cambio.

🧠 Conceptos aplicados

Consumo de APIs REST con HttpClient.

Manejo de respuestas HTTP con HttpResponse.

Análisis de JSON con Gson.

Interacción por consola con Scanner.

Programación modular y estructurada en Java.

🚀 Ejecución del proyecto

Clona el repositorio o descarga el archivo .java.

Asegúrate de tener Java 17 o superior instalado.

Agrega la dependencia Gson (en tu pom.xml o manualmente en el classpath).

Regístrate en ExchangeRate API
 y obtén tu API Key.

Reemplaza "TU_API_KEY" en el código por tu clave real.

Compila y ejecuta el programa:

javac ConversorMonedas.java
java ConversorMonedas


Selecciona el tipo de conversión desde el menú interactivo.

🧩 Ejemplo de uso
=== Conversor de Monedas ===
1. USD → ARS
2. ARS → USD
3. USD → BRL
4. BRL → USD
5. USD → EUR
6. EUR → USD
0. Salir

Seleccione una opción: 1
Monto a convertir: 100
Resultado: 98745.60

🧪 Pruebas sugeridas

Verificar el funcionamiento ante errores de conexión.

Probar cada par de conversión con distintos montos.

Ingresar opciones no válidas para comprobar el manejo de errores.

👨‍💻 Autor

Emiliano Nakayama Romera
Desarrollador Backend Java – Programa ONE / Alura LATAM
