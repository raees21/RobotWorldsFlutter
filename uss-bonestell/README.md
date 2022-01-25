# 0039-robot-worlds
Team_0039_group_project_robot_worlds
# Robot Worlds

Mulit client-server interactive game where robots battle each other.

## Getting Started

In you terminal run git clone https://github.com/wtc-cohort-2020/0039-robot-worlds.git alternatively download the zip folder and extract the contents.
Search for the .jar files in the targets folder.

### Prerequisites

Java 11.
Maven.

### Installing

Once .jar files are located run  java -jar (filename).jar to run the program.
Please note that you are required to run the Server side application first, this should have the filename:
ServerSideApplication.jar then only will the ClientSideApplication.jar run successfully. Also, not that
the IP address of the server as well as the port number will need to be provided in the commandline when running the client.

## Running the tests

Navigate to the ServerSideApplication/ClientSideApplication module and run: mvn test
from the commandline to run all the unit tests.

### Break down into end to end tests

Client Side Application:
-Tests were used to mock communication between the client-server
as well as the handling of said protocol. Connection tests were also conducted.

Server Side Application:
-Test were written to establish the handling of the multi client connections to the server,
handling of protocol requests from the client and responses from the server. Test were also conducted
on all the commands that the server ought to process.


## Deployment

To deploy from source run: mvn clean package to create the .jar files of each module.

## Built With

* [JAVA 11](https://www.oracle.com/za/java/technologies/javase-jdk11-downloads.html) - The language used
* [Maven](https://maven.apache.org/) - Dependency Management
* [TURTLE](https://sites.google.com/a/asmsa.org/java-turtle/documentation) - Used to generate GUI


## Authors

* **Issa Kalonji** - *Client & Server Side* - [GitHub](https://github.com/IKalonji)
* **Thonifo Muhali** - *Server Side & GUI* - [GitHub](https://github.com/tony-rsa)
* **Sarah Matsena** - *Client Side, GUI & Tests* - [GitHub](https://github.com/smatsena)
* **Tsepo Moshole** - *Server Side & Tests* - [GitHub](https://github.com/tmoshole)

See also the list of [contributors](https://github.com/wtc-cohort-2020/0039-robot-worlds/graphs/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* StackOverflow
* GeeksforGeeks
* David Dobervich *Sockect Interaction* [YOUTUBE](https://www.youtube.com/channel/UCsFOxji6B-tAHvXkIxBuVyA)

