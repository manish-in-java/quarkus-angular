# Quarkus with Angular

This project uses Quarkus, the Supersonic Subatomic Java Framework, which
offers multiple advantages over traditional Java runtimes, including:

1. Built-in support for containers like Docker;
1. Fast application startup time;
1. Low memory consumption;
1. Fast response times;
1. Out-of-the-box support for standard Java technologies - JAX RS, JPA, and
so on;
1. Live reload of code during development, doing away with the need for
repeated, time-consuming application restarts;
1. Native executable generation using GraalVM.

All in all, Quarkus builds upon all the benefits of the JVM and makes Java
applications first-class citizens in a containerized environment, in turn
making it straightforward to adopt modern architectural patterns like
microservices.

To learn more about Quarkus, please visit its website: https://quarkus.io/.

This application provides a REST API built using Quarkus, and a frontend built
using Angular.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
mvn quarkus:dev
```

The backend should then be available on http://localhost:8080. You can quickly
test whether the application has started correctly by opening
http://localhost:8080/greet in a web browser and ensuring that the message
_hello_ gets displayed in the browser window.

When run in the dev mode, the Angular application is not bundled with the
Java application. You can run the Angular application using:

```
ng serve
```

The Angular application should then be available on http://localhost:4200.

## Packaging and running the application

The application can be packaged using `mvn package`.
It produces the `quarkus-angular-1.0-SNAPSHOT-runner.jar` file in the `/target`
directory. Be aware that it's not an _über-jar_ as the dependencies are copied
into the `target/lib` directory.

The application is now runnable using:
```
java -jar target/quarkus-angular-1.0-SNAPSHOT-runner.jar
```

## Creating a native executable

You can create a native executable using: `mvn package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable
build in a container using:
```
mvn package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with:
```
./target/quarkus-angular-1.0-SNAPSHOT-runner
```

If you want to learn more about building native executables, please consult
https://quarkus.io/guides/building-native-image.