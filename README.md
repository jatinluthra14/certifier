# Certifier Project

This project generates a certificate. It runs on Vert.x, and is built on the Gradle build system.


## Features
* Students can generate certificates of completion for a variety of courses.
* Mentors can generate certificates for students from data in CSV files.


## Setting up the project


* ***Fork*** this git repository and ***clone*** the fork to a local directory or download [.zip](https://github.com/jboss-outreach/certifier/archive/master.zip) file.
* If you prefer using an IDE, install [Intellij IDEA](https://www.jetbrains.com/idea) or another preferred IDE


###### If using an IDE like Intellij IDEA,
1. [Download JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK 8, as 9 won't work)
2. [Configure Intellij project defaults](https://www.jetbrains.com/help/idea/defining-a-jdk-and-a-mobile-sdk-in-intellij-idea.html), project structure, to set the project SDK to java version 1.8 
    ```configure --> Project Defaults --> Project Structure --> Select JDK 1.8 location```
3. Import the cloned repository into your IDE
4. After importing there should be a notification in the bottom right, asking you to link the project to gradle. Click on it and it will occur automatically.
5. Right click the **App** class
6. Right click on the vertx at the top of the code and use the suggested help from intellij to link it to the project
7. Click **Run App.main()**


### If using on terminal in Linux/Unix,
```sh
./gradlew run         # pwd should be project home dir
```
* If permission is denied then use ```chmod +x ./gradlew```
### If using on Command Prompt in Windows
```sh
gradlew run           # pwd should be project home dir & open cmd as admin
```
## Running the app
* Open http://localhost:4000 in your browser

## Help/Reference

If you are stuck anywhere or need any help, you can refer the following:

1. [Git Handbook](https://guides.github.com/introduction/git-handbook)
2. [Introduction](https://guides.github.com/introduction/flow)
3. [Chat](https://gitter.im/jboss-outreach/gci)
4. [Terminal Handbook](http://linuxcommand.org/)
5. [Command Prompt Handbook](http://www.makeuseof.com/tag/a-beginners-guide-to-the-windows-command-line/)

## Contributing to the project

1. Make your intended changes on your locally cloned repository
2. *Commit* the changes and *push* the commit to your forked repository on GitHub
3. Ensure the changes on the commit pushed to your GitHub fork are right
4. Create a *pull request* requesting to merge the commits on your fork to this repository.
5. Write a concise and convincing pull request message explaining the purpose of your commits.
