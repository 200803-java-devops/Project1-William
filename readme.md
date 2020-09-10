## Log File Manager

## Proposal
This application is a log file manager for any software.  It is designed to view log files, search their contents, and submit them with comments to a database that a developer would have access to.  This application is meant to be used by low level developers or end users.  The database is hosted on an EC2 instance inside a Docker container. 

## Tech stack
- [x] JavaSE 8
- [x] JavaEE 7:
    - [x] Servlet
- [x] PostgreSQL
- [x] Maven 3
- [x] JUnit 5
- [x] Docker
- [x] Amazon Web Services
- [x] Git SCM

## Features
- [x] Ability to pass user input to a servlet.
- [x] Using user input, application will scan for log files and return all instances of the keyword, utilizing regular expressions.
- [x] Ability to view all log files within the path.
- [x] Docker running on AWS EC2 instance containing PostgreSQL database.
- [x] Ability to upload log files to an SQL database.

## Future additions
- [] The Javascript that is meant to provide the comments sent to the database is not working.  This needs to be fixed.
- [] Restrictions to prevent errors
- [] RESTful design
- [] Additional Junit testing
- [] Further fleshed out logging
- [] Place SQL database credentials into a configuration file


## User Stories
-The user will be able to search through all log files for keywords and shown which files contain that keyword and where.

-The user will be able to view log files in whole from the application.

-The user will be able to upload log file information to a SQL database.


## Usage
Simply launch the jar file in the root directory to start the local server application.  Navigate to http://localhost:8080/Project1 in your web browser to begin interacting with the UI.  Note that the EC2 must be running for all functions to work properly.  Alternatively, if you would like to recompile the application, run the following command:

'''mvn clean compile assembly:single'''

Proceed to then move the newly created jar file from the target folder to the project root directory.  It can then be executed.
