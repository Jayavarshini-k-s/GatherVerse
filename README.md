# 🎉 GatherVerse - College Event Management System  

![GATHER_VERSE - Made with PosterMyWall](https://github.com/user-attachments/assets/91f91182-466f-48c2-9783-b3bd03e2793a)

## 📸 Website Screenshots  
<p align="center">
  <img src="https://github.com/user-attachments/assets/5a1dc0f3-572f-400c-97cf-9c701f0a8558" width="80%" alt="Homepage">
</p>


## 📌 Introduction  
GatherVerse is a **college event management website** designed to streamline **event organization and participation** for students and administrators. It provides an **intuitive interface** for event discovery, registration, and management, making campus events **more accessible and well-organized**.

---

## 🚀 Features  

### 🔹 Student (Elites) Portal  
- 👤 **Student Login** – Log in using credentials stored in a MySQL database.  
- 📅 **Event Listing** – View all upcoming events with ID, date, name, price, and location details.  
- 🔍 **Event Search** – Easily search for specific events.  
- 🎟 **Event Registration** – Register for events seamlessly.
  
  ![Image](https://github.com/user-attachments/assets/ad8c4359-2a69-413f-886a-2113e6bd92f1)

  ![Image](https://github.com/user-attachments/assets/34f319f9-c205-44e5-bc13-d01a2ff79183)

### 🔹 Admin (EventNexus) Panel  
- 🔐 **Admin Login** – Secure login with database authentication.  
- ➕ **Add Events** – Admins can add new events with essential details.  
- ✏ **Edit Events** – Modify event details such as ID, date, name, price, and location.  
- ❌ **Delete Events** – Remove events from the system.  
- 📋 **Dashboard Navigation** – Includes options like `"All Current Events"`, `"Search"`, `"Add"`, `"Event Nexus (Admin)"`.  
![Image](https://github.com/user-attachments/assets/5b026fca-0c74-49e8-ae26-fee144d055c5)
![Image](https://github.com/user-attachments/assets/61b35836-2b7a-4842-bf91-d5678d177f60)

---

## 🛠️ Tech Stack  

| **Technology** | **Used For** |
|--------------|------------|
| **Frontend** | HTML, CSS, JavaScript, Thymeleaf |
| **Backend**  | Java, Spring Boot |
| **Database** | MySQL (stores user credentials & event details) |
| **Version Control** | Git & GitHub |

---

## 📂 Project Structure  
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
```bash
  git clone https://github.com/your-username/GatherVerse.git cd GatherVerse 
```
2️⃣ Set Up MySQL Database

Create a database named eventmanagement. 
Import the provided .sql file (if available). 
Configure database credentials in application.properties: 
```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/eventmanagement spring.datasource.username=root spring.datasource.password=yourpassword spring.jpa.hibernate.ddl-auto=update
```

3️⃣ Run the Project 
## Deployment

To deploy this project run

```bash
  mvn spring-boot:run
```
or
```bash
  java -jar target/eventmanagement.jar
```

📩 Contributions & Feedback Feel free to contribute, open issues, or suggest improvements! 🚀
🌱 Future Enhancements
🔹 Implement user authentication with JWT for security.
🔹 Add event categories & filters.
🔹 Enable email notifications for event reminders.
🔹 Deploy on a free hosting platform (e.g., Render, Railway).

📩 Contributions & Feedback
Feel free to contribute, open issues, or suggest improvements! 🚀

