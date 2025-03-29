# Survey Form Prompt

This project is a Java Swing-based survey form that collects user input and stores it in a MySQL database. The survey form includes the following components:

-   **Text Fields:**

    -   **Name:** (`jTextField1`)
    -   **Age:** (`jTextField2`) – must be a valid integer.
    -   **Email:** (`jTextField3`)
    -   **Additional Thoughts:** (`jTextField4` or a JTextArea if preferred)

-   **Combo Box:**

    -   **Role:** (`jComboBox1`) with options to be dynamically set to "Teacher", "Student", "Other".

-   **Radio Buttons:**

    -   **Learning Preference:** Options are "Teachers", "AI Tools", and "Both".
    -   **Requirement:** Group these using a `ButtonGroup` so only one option is selectable at a time.

-   **Checkboxes:**

    -   **AI Tools Used:** Options include "Google Gemini", "Github Copilot", "Chat GPT", and "Deepseek R1".

-   **Buttons:**
    -   **SUBMIT (jButton2):** When clicked, the form should:
        -   Collect all input data.
        -   Validate inputs (e.g., ensure age is numeric).
        -   Use a database connection (via the provided `Database` class) to insert the data into a MySQL table.
        -   Use a `PreparedStatement` for safe insertion.
        -   Provide user feedback via `JOptionPane` dialogs.
    -   **RESET (jButton1):** When clicked, the form should:
        -   Clear all form inputs (text fields, combo box, radio buttons, checkboxes, and any text area).

**Database Integration:**

The database connection is handled by the `Database` class. Use the following connection parameters:

-   **JDBC URL:** `jdbc:mysql://localhost:3306/javaTest`
-   **Username:** `root`
-   **Password:** `MySql1234`
-   **MySQL JDBC Driver:** Ensure `com.mysql.cj.jdbc.Driver` is available.

**Database Table Schema:**

Make sure the MySQL database has a table defined as follows:

```sql
CREATE TABLE SurveyResponses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    email VARCHAR(255),
    role VARCHAR(100),
    preference VARCHAR(50),
    tools VARCHAR(255),
    thoughts TEXT
);
```
