ChatRoom Application

The ChatRoom application is a simple chat server system developed in Java using Spring Boot, allowing users to join chat rooms, send messages, and access chat history.

Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.
Prerequisites
Make sure you have the following installed on your machine:
	•	Java Development Kit (JDK) 11 or later
	•	Apache Maven
	•	Git (optional, if you want to clone the repository)
	•	

Installing

Clone the repository to your local machine: 
Navigate to the project directory:
                
git clone https://github.com/mjora88/chat-room.git

Running the Application

Build the project using Maven:
		
man clean install
		
Run the application:
java -jar target/chatroom-0.0.1-SNAPSHOT.jar

The application will start and be accessible at http://localhost:8080.
Accessing H2 Database Console
You can access the H2 Database Console to view and manage the database by visiting http://localhost:8080/h2-console. Make sure to use the correct JDBC URL (jdbc:h2:mem:testdb) and credentials (sa/<password> by default).
Testing
The application comes with unit tests to ensure its functionality. You can run the tests using Maven:
mvn test

Built With
	•	Spring Boot - Framework for building Java applications
	•	Maven - Dependency management
	•	H2 Database - In-memory database for development and testing
Authors
	•	https://github.com/mjora88
