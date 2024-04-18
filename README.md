Metodos Http

1. POST (/api/v1/personas): Este método HTTP crea un nuevo recurso enviando los datos del mismo en el cuerpo de la solicitud. En el contexto de esta aplicación, se utiliza para crear una nueva entrada de persona en la base de datos MongoDB.
2. GET (/api/v1/personas): Este método HTTP recupera una lista de recursos existentes. En este caso, devuelve todas las personas almacenadas en la base de datos.
2. GET (/api/v1/persona/{id}): Este método HTTP recupera un recurso específico mediante su identificador único (ID). En esta aplicación, se utiliza para obtener los detalles de una persona específica basándose en su ID.
4. DELETE (/api/v1/delete/{id}): Este método HTTP elimina un recurso existente. En este contexto, se utiliza para eliminar una persona específica de la base de datos, identificada por su ID.
5. PUT (/api/v1/update): Este método HTTP actualiza completamente un recurso existente con los datos proporcionados en el cuerpo de la solicitud. En esta aplicación, se utiliza para actualizar los detalles de una persona existente.
6. PATCH (/api/v1/personas/{id}): Este método HTTP actualiza parcialmente un recurso existente, aplicando solo los cambios proporcionados en el cuerpo de la solicitud. En esta aplicación, se utiliza para actualizar selectivamente los detalles de una persona existente.
7. HEAD (/api/v1/personas/{id}): Este método HTTP solicita solo la cabecera de respuesta del servidor, sin el cuerpo de la respuesta. En esta aplicación, se utiliza para verificar la existencia de una persona en la base de datos basándose en su ID.
8. OPTIONS (/api/v1/personas): Este método HTTP solicita información sobre las opciones y/o requisitos de comunicación disponibles en el recurso objetivo. En esta aplicación, se utiliza para proporcionar detalles sobre las opciones de comunicación disponibles para la entidad de personas.
