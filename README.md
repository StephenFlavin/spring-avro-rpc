# spring-avro-rpc
A simple avro rpc app with spring boot.

The application consists of a client a server and a schema.

The schema is created using [AvroIdl](https://avro.apache.org/docs/1.8.2/idl.html).

## How to run
Since the App uses spring boot you can use `mvn spring-boot:run`.

Start the `/server` first and then the `/client`, the client will log received Greetings and publish new Greetings which
appear in the server logs.
