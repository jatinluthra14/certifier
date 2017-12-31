# Certifier Project [![Gitter chat](https://badges.gitter.im/gitterHQ/services.png)](https://gitter.im/jboss-outreach)


This project generates a certificate. It runs on Vert.x, and is built on the Gradle build system.

## Contents
* [Features](#features)
* [Setting up the project](#setup)
* [Running the App](#run)
* [Contributing](#contributing)
* [Help/Reference](#help)

## <a id = "features"> </a>Features

* Students can generate certificates of completion for a variety of courses.
* Mentors can generate bulk certificates for students from data in CSV files.


## <a id = "setup"> </a> Setting up the Project

## Dependencies
* [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8 (Dont use Java 9) 
* [Gradle 4.0.0](https://gradle.org/releases/) or higher

### Initial Setup

* **Fork** ![forkImage](https://camo.githubusercontent.com/ba881041f4d7c96895e8466eece0c43317919f56/68747470733a2f2f696d6167652e6962622e636f2f667953745a6d2f666f726b2e706e67) this git repository to your github account.
* **Clone** the fork to your local directory by running the following command in git bash:
						
		$ git clone https://github.com/[YOUR-USERNAME]/certifier.git
           

###### Alternatively

* You can also download the [.zip](https://github.com/jboss-outreach/certifier/archive/master.zip) file.

### Set up in your local machine

1. Download [Download JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK 8, as 9 won't work). Make sure it is for your specific operating system!
2. Make sure you have declared the `JAVA_HOME` environment variable to the directory where JDK was installed. 
3. The project can be run by two methods:
	* [Using An IDE like Intellij IDea or Eclipse that supports Java Development](#ide)
	* [Via Command User Interface](#cui)
	
#### <a id = "ide"> </a> Using an IDE

##### Using IntelliJ Idea
1. Download and install [Intellij Idea] (https://www.jetbrains.com/idea)
2. Configure Intellij project defaults, project structure, to set the project SDK to java version 1.8:

    ```
    configure --> Project Defaults --> Project Structure --> Select JDK 1.8 location
    ```
    
	* [Refer this for further help](https://www.jetbrains.com/help/idea/defining-a-jdk-and-a-mobile-sdk-in-intellij-idea.html)
3. Import the cloned repository into your IDE
4. After importing there should be a notification in the bottom right, asking you to link the project to gradle. Click on it and it will occur automatically.
5. Right click the **App** class
6. Right click on the vertx at the top of the code and use the suggested help from intelliJ to link it to the project
7. Click **Run App.main()**

##### Using Eclipse IDE 
1. Download and install [Eclipse IDE](https://eclipse.org/)
2. Get gradle plugin for Eclipse from [here](https://steffenschaefer.github.io/gwt-gradle-plugin/doc/latest/eclipse)
3. Configure Eclipse project defaults, project structure, to set the project SDK to java version 1.8:

	```
    Window --> Preferences --> Java --> Compiler --> Set Compiler Compliance Level to 1.8
    ```
4. Import the cloned repository into your IDE.
5. Implement vert.x in the project.
5. Click **Run App.main()**

#### <a id = "cui"> </a> Running via the Command User Interface
	
### If using on terminal in Linux/Unix,
```sh
./gradlew run         # pwd should be project home dir
```
* If permission is denied then use ```chmod +x ./gradlew```

###### If using on Command Prompt in Windows
* Run the following command: 

	```sh
	gradlew run      # pwd should be project home dir & open cmd as admin
	```
## <a id = "run"> </a> Running the app
* Open http://localhost:4000 in your browser

## <a id = "contributing"> </a>Contributing to the project

**Step 1: Fork this project**: 

Go to the top right of the project page and click on "Fork". A clone of this repo will be created on your GitHub account.

**Step 2: Code your changes**: 

Create a new branch, and create/edit files as per your coding requirements. Ensure that your code is clean and efficient, and avoid redundancies. It is also advised to follow naming conventions as and where specified. Also make sure that your code is your own, and is not closed-source or stolen.

**Step 3: Commiting and pushing the changes:** 

*Commit* the changes and *push* the commit to your forked repository on GitHub by running the following commands:
 
			$ git add filename.extension 		# for including inidividual files OR
			$ git add . 				# for including all files at once
			$ git commit -m"Your commit message here"	
			$ git push origin 

If stuck at this point, refer [here](https://readwrite.com/2013/10/02/github-for-beginners-part-2/)

**Step 4: Sending a Pull Request (PR):** 

Once you are done coding the changes, commit the files and create a [*PR*](https://help.github.com/articles/about-pull-requests/). Click on "Compare across forks" when creating the PR, and select the master branch of this repo as the base. Set the head to your branch on your fork. Click on the button "Create Pull Request". Give your PR a meaningful title and a brief message explaining the purpose of your commits.

**Step 5: Ensuring code quality** 

Once a PR has been created, check if it can be merged without any issues or conflicts. If there are any issues, repeat from **Step 2** and try to resolve them. Wait for a reviewer to cross check your changes, and then merge your changes.

* Additional Reference regarding clone, fork and editing a repository [**here**](https://egghead.io/lessons/javascript-how-to-fork-and-clone-a-github-repository).

## <a id = "help"> </a>Help/Reference

If you are stuck anywhere or need any help, you can refer the following:
1. [Understanding the Github Flow](https://guides.github.com/introduction/flow)
2. [Getting started with Git](https://git-scm.com/book/en/v1/Getting-Started)
3. [Git Handbook](https://guides.github.com/introduction/git-handbook)
4. [Practice git and have fun!](https://try.github.io)
5. [Read the vert.x documentation](http://vertx.io/docs/)
6. [Terminal Handbook](http://linuxcommand.org/)
7. [Command Prompt Handbook](http://www.makeuseof.com/tag/a-beginners-guide-to-the-windows-command-line/)
8. [Need further help? Chat with us!](https://gitter.im/jboss-outreach/gci)

You can have a look this [**web page**](https://egghead.io/lessons/javascript-how-to-fork-and-clone-a-github-repository) to know how to Clone, Fork and edit the project on a local respository. 
Keep contributing!
