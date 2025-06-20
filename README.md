# 🌙 DreamWell — Journal Application

DreamWell is a full-stack journal app where users can log and manage their dreams. Built with a modern tech stack for performance, scalability, and ease of use.

---

## 📁 Project Structure

```
dreamwell/
├── backend/ # Spring Boot API
└── frontend/ # React + Vite + Tailwind UI
```

---

## 🔧 Tech Stack

### Frontend:
- React (TypeScript)
- Vite
- Tailwind CSS
- React Router
- Fetch API

### Backend:
- Spring Boot
- Spring Data JPA
- PostgreSQL (or H2 for dev)
- RESTful APIs
- Lombok

---

## 🚀 Features

- 📋 **Dashboard** view of all dreams
- ➕ **Add Dream**: title, description, dream date (ISO format)
- 🔍 **Dream Detail**: full view with delete button
- 🧭 **Routing**: handled with `react-router-dom`
- 🎨 **Custom theme**: navy, lavender, pale green

---

## 🧪 Local Development

### 🔹 Frontend Setup

```bash
cd frontend
npm install
npm run dev
```

### 🔹 Backend Setup

```bash
cd backend
./mvnw spring-boot:run
```

Ensure your `application.properties` or `application.yml` configures CORS correctly:

```properties
spring.web.cors.allowed-origins=http://localhost:5173
```


---

## 📬 API Endpoints (Backend)

| Method | Endpoint | Description |
|--------|------------------------------|-----------------------------|
| GET | `/api/dreams/user/{userId}` | Get dreams for a user |
| GET | `/api/dreams/{id}` | Get single dream by ID |
| POST | `/api/dreams` | Create a new dream |
| DELETE | `/api/dreams/{id}` | Delete a dream by ID |


---

## 📸 UI Pages

- **Dashboard**: `/`
- **Add Dream**: `/new`
- **Dream Detail**: `/dreams/:id`

---

## 🛡 Authentication

🔐 Authentication not yet implemented. Will use JWT or session-based auth in future releases.

---

## ✅ Todos / Coming Soon

- [ ] Edit Dream functionality
- [ ] Mood/tagging system
- [ ] Search + filter dreams
- [ ] User registration and login
- [ ] Responsive mobile styles

---

## 🧠 Author Notes

This project was built to practice full-stack engineering, CI/CD, and deployment