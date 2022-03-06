# Robot Worlds Flutter - API

## Robot Worlds

### Project Target Audience

Anyone that like to play games on a mobile app

### Requirements

1. Dart - Flutter
2. Java - JDK and JRE
3. SQLite

### Application Setup Steps

1. Install Java IDE such as Intellij
2. Install DB Browser
3. Install Android Studio with Flutter Depencies
4. Install Mobile Phone SDK's
5. Clone Repsoitory
6. SQLite Database so it has a Database in the Repository
7. Run IntellJ for JAVA Api
8. Run Android Studio for Front End
9. Have Fun!!

### Architecture

This application makes use of 3 Tier Architecture: FontEnd (UI) - BackEnd (API) - DataBase

UI (MVC) --> API (DDD) --> Database 

## FrontEnd

1. Controllers
 - Control the flow of data between the UI and the Backend Logic of the Application
2. Models
 - Models are used to translate the data from the database into identifiable objects so it can be used to proccess logic in the Backend of the Application
3. Views/UI
 - The actual Dart code used to render the User Interface of the project which gets rendered from the controllers
4. Assets
 - Common icons, pictures and other images used to help render the interface

## BackEnd

1. Domain Driven Design
 - Each area of code is broken up according to its Domain ie. Database Connection code, API, Backend Logic

### Testing

These are the tests I executed to test the Application

a) Preliminary Checks, See if I have Correct tools <br/>
b) Start API and Database is popualted <br/>
c) Start Flutter Front end <br/>
d) Test Admin Commands r <br/>
e) Test Robots moving  <br/>
f) Test Get Methods API <br/>
g) Test Post API  <br/>

Expected Outcomes

a) All Preliminary checks done and correct tools was installed <br/>
b) API Starts and connects to Database <br/>
c) Ensure Virtual phone starts and opens app <br/>
d) Admin Commands work, purging - saving - obs and robot lists <br/>
e) Robot moves <br/>
f) API returns correct values <br/>
g) API Posts Success <br/>




