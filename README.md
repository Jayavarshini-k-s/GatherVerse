📌 GatherVerse - College Event Management System
GatherVerse is a college event management website designed to streamline event organization and participation for students and administrators. It provides an intuitive interface for event discovery, registration, and management, making campus events more accessible and well-organized.

🚀 Features
🔹 Student (Elites) Portal
👤 Student Login – Students log in using their credentials stored in a MySQL database.
📅 Event Listing – View all upcoming events with ID, date, name, price, and location details.
🔍 Event Search – Easily search for specific events.
🎟 Event Registration – Students can register for events.

🔹 Admin (EventNexus) Panel
🔐 Admin Login – Secure login with database authentication.
➕ Add Events – Admins can add new events with essential details.
✏ Edit Events – Modify event details such as ID, date, name, price, and place.
❌ Delete Events – Remove an event from the system.
📋 Dashboard Navigation – Includes options like "All Current Events," "Search," "Add," "Event Nexus (Admin)".

🛠️ Tech Stack
Frontend: HTML, CSS, JavaScript, Thymeleaf
Backend: Java, Spring Boot
Database: MySQL (stores user credentials & event details)
Version Control: Git & GitHub

📂 Project Structure
GatherVerse/  
│── src/  
│   ├── main/  
│   │   ├── java/com/jaya/GatherVerse/  
│   │   │   ├── controllers/           # Handles HTTP requests (e.g., AdminController, UserController)  
│   │   │   ├── data/                   # Data access layer (Repositories, Data Access Interfaces)  
│   │   │   ├── models/                 # Entity models (Event, User, etc.)  
│   │   │   ├── services/               # Business logic layer (Service classes)  
│   │   │   ├── GatherVerseApplication.java  # Main Spring Boot Application class  
│   │   │   ├── SpringConfig.java        # Configuration file for Spring settings  
│   ├── resources/  
│   │   ├── templates/                   # Thymeleaf HTML templates (userDashboard.html, ordersAdmin.html)  
│   │   ├── static/                       # Static assets (CSS, JS, images)  
│   │   ├── application.properties        # Database & application configurations  
│── pom.xml                               # Maven dependencies  
│── README.md                             # Project documentation  
│── .gitignore                            # Git ignore file  


💻 Setup & Installation
1️⃣ Clone the Repository
git clone https://github.com/your-username/GatherVerse.git
cd GatherVerse

2️⃣ Set Up MySQL Database
Create a database named eventmanagement.
Import the provided .sql file (if available).
Configure database credentials in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/eventmanagement
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3️⃣ Run the Project
mvn spring-boot:run
or
java -jar target/eventmanagement.jar

🌱 Future Enhancements
🔹 Implement user authentication with JWT for security.
🔹 Add event categories & filters.
🔹 Enable email notifications for event reminders.
🔹 Deploy on a free hosting platform (e.g., Render, Railway).

📩 Contributions & Feedback
Feel free to contribute, open issues, or suggest improvements! 🚀
