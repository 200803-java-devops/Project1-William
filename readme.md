## Log File Manager

## Proposal
This application will be a log file manager for the batch's project 0s.  Some restrictions will have to be applied as most project 0s included very primitive logging.  Flexibility within this application for different projects and circumstances will be added over time.  The initial function of this application will be to search log files for keywords e.g. "exception."  Later, a SQL database connection will be added.

## Tech stack
- [x] JavaSE 8
- [x] JavaEE 7:
    - [x] Servlet
- [ ] PostgreSQL
- [x] Maven 3
- [x] JUnit 5
- [ ] Docker
- [ ] Amazon Web Services
- [x] Git SCM

## Features
- [x] Ability to pass user input to a servlet.
- [x] Using user input, application will scan for log files and return all instances of the keyword, utilizing regular expressions.
- [ ] Ability to view all log files within the path.
- [ ] A docker feature will need to be added.
- [ ] Ability to upload to an SQL database.

## User Stories
-The user will be able to search through all log files for keywords and shown which files contain that keyword and where.
-The user will be able to view log files in whole from the application.
-The user will be able to upload log file information to a SQL database.
