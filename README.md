# 📚 Library Management System

A console-based Library Management System built with **Core Java**, demonstrating Object-Oriented Programming concepts like **Inheritance, Encapsulation, Polymorphism, and Abstraction**.

## 🛠️ Tech Stack
- Java (Core Java, OOP)
- File Handling concepts
- Collections (ArrayList)

## ✨ Features
- ➕ Add new books to the library
- 📖 View all available books
- 🔍 Search books by title or author
- 🗑️ Delete books from the system
- 👤 Register new members
- 📋 View all registered members
- 📤 Borrow a book (availability check included)
- 📥 Return a borrowed book

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or above installed

### Steps
```bash
# 1. Clone the repository
git clone https://github.com/niharika2588/library-management-system.git

# 2. Navigate to the project folder
cd library-management-system

# 3. Compile all Java files
javac *.java

# 4. Run the program
java Main
```

## 📁 Project Structure
```
LibraryManagement/
│
├── Book.java      → Book entity class (OOP - Encapsulation)
├── Member.java    → Member entity class
├── Library.java   → Core business logic (borrow, return, search)
└── Main.java      → Entry point with interactive menu
```

## 💡 OOP Concepts Used
| Concept | Where Used |
|---|---|
| Encapsulation | Private fields with getters/setters in Book, Member |
| Abstraction | Library class hides internal logic from Main |
| Polymorphism | toString() overridden in Book and Member |
| Collections | ArrayList to store books and members dynamically |

## 👩‍💻 Author
**Arumuru Sai Niharika**  
B.Tech AI & ML, Mohan Babu University  
[GitHub](https://github.com/niharika2588) | [LeetCode](https://leetcode.com/u/niharika1405/)
