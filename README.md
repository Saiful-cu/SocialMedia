# 🧪 UI Automation Testing Project

## 📌 Project Overview
This project is designed to automate key user flows and functional features on a web platform (e.g., Facebook or similar), including:
- User login
- Post creation, editing, liking, and deletion (CRUD operations)
- Profile update
- Search functionality

Automation is developed using **Selenium WebDriver**, **TestNG**, and **Java**, following best practices in test design, locator strategies, and maintainable code structure.

---

## 🛠️ Tech Stack
| Tool/Technology | Description |
|-----------------|-------------|
| Java            | Programming Language |
| Selenium WebDriver | Web UI automation |
| TestNG          | Test framework for running test cases |
| Maven           | Project build and dependency management |
| Allure          | Test report generation (optional) |
| Git             | Version control |
| ChromeDriver/GeckoDriver | Browser automation drivers |

---

## 📂 Project Structure

src
├── main
│ └── java
│ └── Pages/ # Page Object Model classes
│
└── test
└── java
└── tests/ # Test classes
└── BaseTest.java # Test setup/teardown logic



---

## ✅ Test Scenarios

| Test Name        | Description |
|------------------|-------------|
| `testLogin()`     | Verifies login with valid credentials |
| `testPostCURD()`  | Creates a post, edits it, likes it, and deletes it |
| `testSearch()`    | Searches for a user and validates the result |
| `testProfileEdit()` | Edits the user’s profile and saves the changes |

---

## 🚀 How to Run the Tests

### Prerequisites:
- JDK 8 or above
- Maven installed
- Chrome browser
- ChromeDriver in PATH

### Run all tests:
```bash
mvn clean 
mvn test -DsuiteXmlFile=testng.xml
