# CompSolveHub

CompSolveHub is a **Spring Boot-based complaint management system** built with **Java, HTML, Bootstrap, and JavaScript**. It allows users to register, log in, raise complaints, and track their complaint status, while admins can view complaints and update their status.

## Features

* User registration and login
* Role-based access for **User** and **Admin**
* Raise new complaints with title and description
* View complaints submitted by a user
* Admin dashboard to view all complaints
* Update complaint status
* Email notification when a complaint status changes
* MySQL database integration
* Thymeleaf-based server-side rendered pages

## Tech Stack

* **Backend:** Java, Spring Boot, Spring MVC, Spring Data JPA
* **Frontend:** HTML, Bootstrap, JavaScript, Thymeleaf
* **Database:** MySQL
* **Mail Service:** Spring Boot Mail
* **Build Tool:** Maven

## Project Structure

```bash
CompSolveHub/
├── src/
│   └── main/
│       ├── java/lt/codeacademy/
│       │   ├── controller/
│       │   ├── entity/
│       │   ├── repository/
│       │   └── service/
│       └── resources/
│           ├── static/
│           └── templates/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Main Modules

### Controllers

* `AuthController` – handles landing page, login, registration, and logout
* `UserController` – handles user dashboard and complaint creation
* `AdminController` – handles admin dashboard and complaint status updates

### Entities

* `User` – stores user details such as name, email, password, and role
* `Complaint` – stores complaint details such as title, description, status, timestamps, and related user

### Services

* `UserService` – handles user registration and login
* `ComplaintService` – handles complaint creation, fetching, and status updates
* `EmailService` – sends complaint status update emails

## Setup and Installation

### 1. Clone the repository

```bash
git clone https://github.com/Harikesh10/CompSolveHub.git
cd CompSolveHub
```

### 2. Configure the database

Create a MySQL database and update `src/main/resources/application.properties` if needed.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Configure email settings

The project uses Spring Mail for status update notifications.

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
```

### 4. Run the project

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Then open:

```bash
http://localhost:8080
```

## Application Flow

1. A new user registers on the site.
2. The user logs in and creates a complaint.
3. The complaint is stored with status **OPEN**.
4. The admin reviews the complaint from the admin dashboard.
5. The admin updates the complaint status.
6. The user receives an email notification when the status changes.

## Screens

* Home page
* Login page
* Register page
* User dashboard
* Create complaint page
* Admin dashboard

## Dependencies

The project uses:

* `spring-boot-starter-web`
* `spring-boot-starter-thymeleaf`
* `spring-boot-starter-data-jpa`
* `mysql-connector-j`
* `spring-boot-starter-mail`
* `spring-boot-devtools`

## Notes

* Complaint status is updated by the admin.
* Complaint creation automatically sets the status to `OPEN`.
* When a complaint is marked `RESOLVED`, the resolved timestamp is saved.

## Future Improvements

* Add password hashing
* Add form validation
* Add search and filter for complaints
* Add pagination for large complaint lists
* Improve UI with better dashboard styling

## Author

Created by **Harikesh**.

## License

This project is for educational and personal use.
