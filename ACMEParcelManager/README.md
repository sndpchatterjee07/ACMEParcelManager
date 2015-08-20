# ACMEParcelManager

Readme file for the project containing all the information required to run and test this Java application.


## Application Requirements:

* [Requirement specification](https://pastebin.com/MDMk1LWJ)
* [Sample Input file](https://pastebin.com/M5Uh5Bz0)
* [Generated Output File](https://pastebin.com/hgJCYUpX)


## Documentation:

### Softwares used:

 * Operating system: 64-bit Ubuntu - 3.13.0-61-generic
 * Java version: 1.8.0_51
 * Eclipse version: Luna Service 1(4.4.1)
 * Maven version: 3.0.5

### Steps performed:

 * From terminal, navigated to the folder where we wanted to create the Java project ACMEParcelManager.
 * Ran the following command on terminal:
```
mvn archetype:generate -DgroupId=com.teamsuccesso.www -DartifactId=ACMEParcelManager -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
 
  * Successful build would create a project named 'ACMEParcelManager' and all source code puts in folder '/src/main/java/', all unit test code puts in '/src/test/java/'.

* Also, a standard pom.xml is generated which describes the entire project information, everything from directory structure, project plugins, dependencies.

* To make this project an Eclipse project, we navigated to “ACMEParcelManager” project and ran the following command to generate all project files that are required by Eclipse IDE:

```mvn eclipse:Eclipse```
* Next, we imported the project into Eclipse IDE using:

```File -> Import... -> General -> Existing Projects into Workspace" and providing path to the root directory 'ACMEParcelManager```

* Updated 'pom.xml' to set Java source & target versions to 1.8, add [JUnit 4.11](http://mvnrepository.com/artifact/junit/junit/4.11), [Guava 18.0](https://github.com/google/guava) and [EqualsVerifier 1.7.4](http://www.jqno.nl/equalsverifier/) dependencies. See [Final pom.xml](https://pastebin.com/j8xpYJB2)

* Created directory 'lib' and added all project dependency jars there so that they can be added as individual User libraries, added to Eclipse project build path for any build related issues while testing the application.

* Added the 'resources' directory under '/src/main/' and '/src/test/' because that is where our 'Input.txt' and 'Output.txt' is going to reside.

* See [Final Project directory structure](http://i.imgur.com/CuCmhkC.png).

* [Clone this repository from eclipse ](http://www.vogella.com/tutorials/EclipseGit/article.html#clone_repository). To test and use this application, run MainApp.java. This would read/parse the file 'SRC_InputResourceForUnitTestWith20Entries.txt' under '/src/main/resources' and generate the file 'Output.txt' there.

### Assumptions
* As the output path has been hardcoded, please change the value of 'outputPath' to your desired location(to avoid any exception) in:
  - /path/to/repo/[ACMEParcelManager]/src/main/java/com/teamsuccesso/www/assignmentOne/main/MainApp.java 
  - /path/to/repo/[ACMEParcelManager]/src/test/java/com/teamsuccesso/www/assignmentOne/main/ApplicationMainTest.java

* The scenario where coincidentally one(or more) postal code(s) may have the same number of parcel deliveries has not been taken into account. 

* See 'ApplicationMainTest.java' for all the unit-test which is located at: /path/to/repo/[ACMEParcelManager]/src/test/java/com/teamsuccesso/www/assignmentOne/main/.

* To be added, if necessary.

### How can you contribute?
* [Fork](https://help.github.com/articles/fork-a-repo)
* [Send a PR](https://help.github.com/articles/using-pull-requests)

For any queries/suggestions/feedbacks, feel free to drop me an e-mail at: `sndpchatterjee07@gmail.com`.

Cheers! :+1:
