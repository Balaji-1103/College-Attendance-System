Developed a web-based application for managing and automating the attendance tracking system for students and teachers. 
The system provides an interface for teachers to mark attendance, view attendance reports, and generate statistics, while students can view their own attendance history.

Features
•	Teachers can log in and mark attendance for students.
•	Students can view their attendance history.
•	Role-based access control for teachers and students.
•	Real-time attendance reports.
•	Database-driven design using MySQL (XAMPP).

Technologies Used
•	Backend: Java, Servlets
•	Frontend: JSP (JavaServer Pages)
•	Database: MySQL (via XAMPP)
•	IDE: Eclipse
•	Web Server: Apache Tomcat (J2EE Concept)
•	JDBC: For database connectivity

Prerequisites
Ensure that the following software is installed on your system:
•	Eclipse IDE (with J2EE support)
•	XAMPP (for MySQL and Apache server)
•	Apache Tomcat Server (for deploying the application)
•	Java Development Kit (JDK) (version 8 or higher)

Project Setup
Step 1: Clone the repository bash
•	git clone https://github.com/your-username/college-attendance-system.git

Step 2: Open the project in Eclipse
•	Open Eclipse IDE.
•	Go to File > Import > Existing Maven Projects.
•	Navigate to the directory where you cloned the repository.
•	Click Finish.

Step 3: Configure Tomcat Server
•	In Eclipse, go to Window > Preferences > Server > Runtime Environment.
•	Click Add and select Apache Tomcat.
•	Set the path to your Tomcat installation directory and click Finish.

Step 4: Add the MySQL Connector JAR
•	Download the MySQL JDBC Driver from here.
•	Add the JAR to the project’s Build Path by right-clicking the project > Build Path > Configure Build Path > Libraries tab > Add External JARs.

Database Setup (XAMPP)
Step 1: Start MySQL
•	Open XAMPP and click Start for Apache and MySQL.
Step 2: Create the database
•	Go to http://localhost/phpmyadmin in your browser.
•	Create a new database named attendance_system.
Step 3: Import the SQL schema
•	Use the provided attendance_system.sql file (located in the db/ folder of the repository) to set up your database schema and tables.
•	Go to phpMyAdmin, select the database, and click on the Import tab.
•	Select the attendance_system.sql file and click Go.

Running the Project
Step 1: Deploy on Tomcat Server
•	In Eclipse, right-click the project and select Run As > Run on Server.
•	Select Apache Tomcat and click Finish.
Step 2: Access the Application
•	Open a web browser and navigate to http://localhost:8080/CollegeAttendanceSystem/.
