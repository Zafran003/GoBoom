Last update 16 June 17.30 pm 
# Maven - How to run Unit Test
Maven unit test examples, JUnit 5.

Project Link - https://www.mkyong.com/maven/how-to-run-unit-test-with-maven/

# Challenges and Learning Curve
1. Research new tools like Eclipse, scene builder for GUI and Java FX. Using stackoverflow for better research tool 
https://stackoverflow.com/questions/10121991/javafx-application-icon

2. Loose coupling design - separate into smaller code like classes

3. Inheritance - Executor.switchUser - single method but reuse/inherited for console and GUI

## How to run this project?
```
$ git clone https://github.com/Zafran003/GoBoom
$ cd GoBoom
$ mvn clean install

```

To run from Eclipse add the following arguments

Program arguments 
```
console 
```

JVM
```
--module-path D:\javafx-sdk-20.0.1\lib --add-modules javafx.controls,javafx.fxml
```

