# Employee Management System

A simple and effective web application to manage employee records, built using **Spring Boot**, **Java**, and **MySQL**. This project performs all basic CRUD operations (Create, Read, Update, Delete) with backend validations.

## 🛠️ Technologies Used

- **Backend:** Java, Spring Boot, Spring MVC
- **Frontend:** HTML, CSS (basic UI)
- **Database:** MySQL
- **Build Tool:** Maven
- **IDE:** Spring Tool Suite (STS)
- **Version Control:** Git & GitHub

## 📌 Features

- Add New Employee
- View All Employees
- Update Employee Information
- Delete Employee Records
- Search Employee (by name or ID)
- Form Validation on Backend

## 📂 Project Structure

employee-management/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/employee/management/
│       │       ├── controller/
│       │       ├── model/
│       │       ├── repository/
│       │       └── service/
│       └── resources/
│           └── application.properties
├── pom.xml

## 🚀 How to Run the Project

1. Clone the Repository 
git clone https://github.com/Manasa-Vadde-20/employee-management-system.git

2. Navigate to the project directory
cd employee-management-system

3. Import as Maven Project
- Open Spring Tool Suite (STS)
- Go to File → Import → Existing Maven Projects
- Select the folder where pom.xml is located
- Click Finish

4. Configure MySQL DB in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password

5. Run the Project  
Using Spring Tool Suite:
- Right-click the project → Run As→ Spring Boot App

Or use terminal:
mvn spring-boot:run

6. Test APIs Using Postman

📬 API Endpoints

| Method | Endpoint             | Description               |
|--------|----------------------|---------------------------|
| GET    | /employees           | Get all employees         |
| POST   | /employees           | Add a new employee        |
| PUT    | /employees/{id}      | Update an employee by ID  |
| DELETE | /employees/{id}      | Delete an employee by ID  |

