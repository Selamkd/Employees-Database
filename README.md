# Employee Data Management System
This Employee Data Management System is a group project by the 'The Great Wall of Code' consisting of Selam, Alastair, Mamoon, Alex, Howard, Daniell and Irina. 👋
## Overview
This project involves parsing corrupted employee data from a CSV file, cleaning it, and storing it in a MySQL database. The program also provides a Data Access Object (DAO) class for performing CRUD operations on the employee data.

## Requirements
- Java
- MySQL database
- IntelliJ

## Dependencies
- Junit
- Hamcrest-core
- JDBC
- MySQL

## More about the project
Our application allows the user to query the data in the following ways:
- **🆔 Get all valid employees:** get a list of all employee data that is stored in the database.
- **Get Employee by ID:** get a single Employee record by searching for that Employee's ID.
- **Insert employees:** add a list of employees to the database.
- **Delete employee records by ID:** delete a single employee record by providing that Employee's ID.
- **Edit Employee first name:** edit a single Employee record by searching by ID and inputting a new first name.
- **Load and validate employee data from a file:** Load employee data from a file of potentially corrupted employee data.
- **🧮 Count number of Employees:** count the total number of Employee records in the database.


We aim to enhance the functionality of our queries by optimising our methods to retrieve data from our public records, ensuring quicker data retrieval.

### Setup
Ensure you have both Java and MySQL installed on your system.
On the top-level directory of the repository, you will find a file named **schemaBuildScript.sql**.  This contains a list of SQL Queries that you should run to set up or reset your local database.

### Steps
1. **Fork this repository:** Click on the "Fork" button at the top right corner of the repository page to create a copy of the project in your GitHub account.

2. **Clone the forked repository:** Clone the forked repository to your local machine using the following command:
 - `git clone git@github.com:Selamkd/Employees-Database.git`

3. Replace `<repository_url>` with the URL of your forked repository.

4. **Import into your preferred Java IDE:** Open your preferred Java Integrated Development Environment (IDE) and import the cloned project.

5. **Add your contributions:** Make your desired contributions to the project, whether it's code improvements, bug fixes, or documentation updates.

6. **Commit and push:** Once you've made your changes, commit them to your local repository and push them to your forked repository on GitHub using the following commands:
- `git add .`
- `git commit -m "Your commit message"`
- `git push origin main`


7. **Wait for pull request to be merged:** After pushing your changes to your forked repository, create a pull request (PR) from your fork to the original repository. Wait for the project maintainers to review and merge your changes into the main project.

By following these steps, you can effectively contribute to and collaborate on the project.

## How to Use the Project  
- Any of the DAO methods can be called within the App class, and these have been commented out.  Please feel free to uncomment these lines to experiement with the various methods that have been implemented.
- The initial command that must be run is ui.openDBConnection();  This ensures that the connection to the database is correctly established.
- The second command that must be run is ui.loadValidatedEmployeeData();  This ensures that the validated employee data is properly added to the database, ready to be manipulated.
- The final command that must be run is ui.closeDBConnection();  This ensures that the connection to the database is correctly closed.
- In the future, a more established user interface can be developed to cater to the client's requirements.

📫 If you come across any bugs, please don't hesitate to open an issue to inform us. Additionally, we appreciate any suggestions for updates or improvements you may have!


