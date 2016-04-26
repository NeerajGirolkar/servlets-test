To create Eclipse Dynamic Web Project using Gradle:
1) Use the Gradle build file as given in this project.
2) Create standard directory structure.
3) > gradle clean build eclipse
4) Import the project in Eclipse.
5) Make sure that Project -> Build Automatically is checked in. (This took care of my problem of not generating .class files in deployed app in wtpwebapps directory in tomcat installation.)