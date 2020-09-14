### Global Logic Test

  API RESTful de creación de usuarios.

### Prerequisitos

    H2 Database
    RUN create_tables.sql

* **URL**

  ```http://localhost:8083/ ```

* **Metodo:**

  `registro`
  
  <_Request Type_>

  `POST`

  <_Content Type_>
  
  `JSON`

*  **URL Parametros**

   <_Especificación parámetros URL._> 

   **Requerido:**
 
   ```nombre=[string]
   correo=[string]
   correo=[string]
   telefonos=[Lista]
        numero=[string]
        codigoCiudad=[string]
        codigoPais=[string]


* **Parámetros de datos**

  ```{
    "nombre":"aaaa",
    "correo":"abe@abc.cl",
    "contrasena":"Aaa22",
    "telefonos":[{
        "numero":"12345678",
        "codigoCiudad":"9",
        "codigoPais":"56"
    },{
        "numero":"12345678",
        "codigoCiudad":"9",
        "codigoPais":"56"
    }]
    }

* **Respuesta exitosa:**

  * **Codigo:** 200 <br />
    **Contenido:** 
    ```{"id": 1,
    "fechaCreacion": "2020-09-13T22:45:47.448+00:00",
    "fechaModificacion": "2020-09-13T22:45:47.448+00:00",
    "ultimoIngreso": "2020-09-13T22:45:47.448+00:00",
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWJlQGFiYy5jbCIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDAwMzcxNDcsImV4cCI6MTYwMDAzNzc0N30.nbKrBezKJq527MREcO_OrT1apjxU7wCMZY80OEk6Qt3UFN7BQprwoIDO063spG79_ncBrELasRmzm96-PJuUag",
    "activo": true}
 
* **Respuesta error:**


  * **Codigo:** 404 UNAUTHORIZED <br />
    **Contenido:** `{ "mensaje" : "URL no encontrada" }`

  OR

  * **Code:** 400 BAD REQUEST <br />
    **Contenido:** `{ "mensaje" : "Peticion de entrada incorrecta" }`

  OR

  * **Code:** 400 BAD REQUEST <br />
    **Contenido:** `{ "mensaje" : "El formato del correo es incorrecto (aaaaaaa@dominio.cl​)" }`

  OR

  * **Code:** 400 BAD REQUEST <br />
    **Contenido:** `{ "mensaje" : "El formato de la contraseña debe al menos una mayúscula, letras minúsculas y dos números" }`

  OR

  * **Code:** 302 FOUND <br />
    **Contenido:** `{ "mensaje" : "El registro ingresado ya se encuentra en el sistema" }`

  OR

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Contenido:** `{ "mensaje" : "Servicio suspendido, por favor contartarse con el administrador" }`

## Autor

* **Yethro Villalon** - (https://github.com/yethrovillalon/api-globallogic.git)

