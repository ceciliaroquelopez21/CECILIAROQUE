#language: es
@api
Característica: Rest test (#1)
  ReqRes es una WEB API demo para fines de entrenamiento (por favor ver: https://reqres.in)

  -- DESCRIPCION --
  Para este ejercicio, es nesario ingresar a la página 'reqres.in' para conocer y analizar el contrato del servicio de Lista de Usuarios.
  - Analiza el request, response, codigo de estado de respuesta
  - Tomar en cuenta las indicaciones numeradas.
  - Ejecutar el escenario desde la clase Tests a partir de las anotaciones.
  - Resolver los errores de compilación y ejecución hasta completar correctamente el escensario.
  - Analiza el código actual y valida si puedes reutilizarlo, de lo contratio,
  sientete libre de programar y agregar código si lo consideras necesario

  1) Ingresar al repositorio de APIs 'https://reqres.in' y analizar el servicio 'List Users'
  2) Enviar como parametro de consulta el número de paginación 2
  3) Por ultimo, validar de la respuesta si el numero de pagina enviado es el correcto
  4) Generar reportes Cucumber (html/json) y/o SerenityReport

  @caso1
  Escenario: Validar si la paginación solicitada es correcta
    Dado que la URL es: "api.users"
    Cuando consulto la pagina 0
    Entonces valido que el estado del servicio sea 201
    Y que la respuesta contenga el numero de paginacion solicitado