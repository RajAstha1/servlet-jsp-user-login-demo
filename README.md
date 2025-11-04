# Servlet JSP User Login Demo

A Java EE web application demonstrating user login using Servlet and HTML form with personalized welcome message upon successful login.

## Project Overview

This is a **Part A** project that implements a basic user authentication system using:
- **HTML Form** - For user input (login.html)
- **Java Servlet** - For backend processing (LoginServlet.java)
- **Web Configuration** - For servlet mapping and application settings (web.xml)

## Project Structure

```
servlet-jsp-user-login-demo/
├── src/
│   └── com/example/servlet/
│       └── LoginServlet.java          # Servlet for processing login requests
├── webapp/
│   ├── login.html                      # HTML form for user login
│   └── WEB-INF/
│       └── web.xml                    # Web application configuration
├── .gitignore                          # Git ignore file for Java projects
└── README.md                           # This file
```

## Features

- ✅ User-friendly HTML login form with modern styling
- ✅ Server-side login validation using Java Servlet
- ✅ Personalized welcome message upon successful login
- ✅ Error handling for invalid credentials
- ✅ Session management configuration
- ✅ Java EE standard project structure

## Prerequisites

Before running this project, ensure you have the following installed:

1. **Java Development Kit (JDK)**
   - Version: JDK 8 or higher
   - Download: https://www.oracle.com/java/technologies/downloads/

2. **Apache Tomcat** (or any Java EE compatible servlet container)
   - Version: Tomcat 8.5 or higher
   - Download: https://tomcat.apache.org/download-90.cgi

3. **IDE (Optional but Recommended)**
   - Eclipse IDE for Enterprise Java Developers
   - IntelliJ IDEA (Community or Ultimate)
   - Apache NetBeans

## Setup Instructions

### Step 1: Clone the Repository

```bash
git clone https://github.com/RajAstha1/servlet-jsp-user-login-demo.git
cd servlet-jsp-user-login-demo
```

### Step 2: Compile the Java Code

#### Option A: Using Command Line

```bash
# Create bin directory
mkdir -p bin

# Compile Java files (adjust Tomcat path as needed)
javac -d bin -cp "$CATALINA_HOME/lib/servlet-api.jar" src/com/example/servlet/LoginServlet.java
```

#### Option B: Using IDE

- Import the project into your IDE
- Configure the build path to include Servlet API (javax.servlet)
- Build the project

### Step 3: Create WAR File

#### Manual WAR Creation:

```bash
# Create directory structure
mkdir -p build/servlet-jsp-user-login-demo/WEB-INF/classes
mkdir -p build/servlet-jsp-user-login-demo/WEB-INF/lib

# Copy compiled classes
cp -r bin/* build/servlet-jsp-user-login-demo/WEB-INF/classes/

# Copy web resources
cp webapp/login.html build/servlet-jsp-user-login-demo/

# Copy web.xml
cp webapp/WEB-INF/web.xml build/servlet-jsp-user-login-demo/WEB-INF/

# Create WAR file
cd build
jar cvf servlet-jsp-user-login-demo.war servlet-jsp-user-login-demo/
cd ..
```

#### Using IDE:
- Right-click on project → Export → WAR file
- Specify output location

### Step 4: Deploy to Tomcat

#### Option A: Manual Deployment

1. **Copy WAR to Tomcat**:
   ```bash
   cp build/servlet-jsp-user-login-demo.war $CATALINA_HOME/webapps/
   ```

2. **Start Tomcat** (if not already running):
   ```bash
   # Windows
   %CATALINA_HOME%\bin\startup.bat
   
   # Linux/Mac
   $CATALINA_HOME/bin/startup.sh
   ```

3. **Access the Application**:
   - URL: http://localhost:8080/servlet-jsp-user-login-demo/login.html
   - Or: http://localhost:8080/servlet-jsp-user-login-demo/ (if login.html is configured as welcome file)

#### Option B: Using Tomcat Manager (GUI)

1. Open Tomcat Manager: http://localhost:8080/manager/html
2. Click "Deploy" section
3. Select and upload the WAR file
4. Click "Deploy"

### Step 5: Test the Application

1. Navigate to: http://localhost:8080/servlet-jsp-user-login-demo/login.html
2. Enter credentials (demo credentials are shown on the form)
3. Click "Sign In"

#### Sample Test Credentials:
- **Username**: demo
- **Password**: demo123

## Login Validation Rules

The LoginServlet validates user input according to these rules:

- ✓ Username must not be empty
- ✓ Password must not be empty
- ✓ Password must be at least 6 characters long

*Note: This is a demo application. In production, implement proper database authentication and security measures.*

## File Descriptions

### LoginServlet.java

Main servlet that handles user authentication:
- **POST Request**: Processes login form submission
- **GET Request**: Redirects to login.html
- **Validation**: Checks username and password
- **Response**: Displays welcome message or error page

### login.html

User interface for login:
- Modern responsive design using CSS Grid/Flexbox
- Form fields for username and password
- Form validation (client-side)
- Links to demo credentials
- Error-friendly UI

### web.xml

Web application configuration:
- Servlet mapping (optional with @WebServlet annotation)
- Welcome files configuration
- Session settings
- Error page handling
- Cookie security settings

## Security Considerations

⚠️ **Important**: This is a demonstration project. For production use:

1. **Use HTTPS** - Always use SSL/TLS encryption
2. **Database Integration** - Store and verify credentials in a database
3. **Password Hashing** - Use bcrypt, PBKDF2, or Argon2 for password storage
4. **Input Validation** - Implement comprehensive input validation and sanitization
5. **CSRF Protection** - Use CSRF tokens for form submissions
6. **SQL Injection Prevention** - Use prepared statements
7. **Session Management** - Implement proper session timeout and security
8. **Logging & Monitoring** - Log authentication attempts and suspicious activities

## Troubleshooting

### Application shows 404 Error
- Ensure WAR file is deployed to `$CATALINA_HOME/webapps/`
- Check Tomcat is running: `http://localhost:8080`
- Verify application context name matches your WAR file
- Check Tomcat logs: `$CATALINA_HOME/logs/`

### Servlet Not Found
- Ensure LoginServlet is compiled to `WEB-INF/classes/com/example/servlet/`
- Verify `@WebServlet("/login")` annotation is present
- Check web.xml servlet mapping (if using)
- Restart Tomcat

### Form Submission Returns Error
- Verify form action URL matches servlet mapping
- Check browser console for any JavaScript errors
- Ensure password meets minimum 6 character requirement
- Check Tomcat logs for server-side errors

## Environment Variables

Set the CATALINA_HOME environment variable:

```bash
# Windows
set CATALINA_HOME=C:\path\to\tomcat

# Linux/Mac
export CATALINA_HOME=/path/to/tomcat
```

## Additional Resources

- [Servlet Documentation](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServlet.html)
- [Apache Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/)
- [Java EE Web Application Development](https://www.oracle.com/java/technologies/java-ee-glance.html)
- [HTML5 Form Validation](https://developer.mozilla.org/en-US/docs/Learn/HTML/Forms/Form_validation)

## License

This project is provided as-is for educational purposes.

## Author

RajAstha1

## Contributing

Feel free to fork this repository and make improvements. Pull requests are welcome!

---

**Last Updated**: November 2025
