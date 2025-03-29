---

### File: `.github/copilot-instructions.md`

```markdown
# GitHub Copilot Instructions

## Overview

This project merges a Java Swing survey form with a MySQL database backend. The objective is to capture user input from the form and store it in the database. Follow the steps below to implement the required functionality.

## Instructions

1. **Form Data Collection:**

    - Retrieve the input data from the following components:
        - **Name:** from `jTextField1`
        - **Age:** from `jTextField2` (ensure to validate that this is an integer)
        - **Email:** from `jTextField3`
        - **Role:** from `jComboBox1` (options: "Teacher", "Student", "Other")
        - **Learning Preference:** from the radio buttons (`jRadioButton1`, `jRadioButton2`, `jRadioButton3`) – options are "Teachers", "AI Tools", "Both"
        - **AI Tools Used:** from the checkboxes (`jCheckBox1`, `jCheckBox2`, `jCheckBox3`, `jCheckBox4`)
        - **Additional Thoughts:** from `jTextField4` or a JTextArea (if implemented)

2. **Radio Buttons Grouping:**

    - Create a `ButtonGroup` (e.g., `buttonGroup1`) to group the three radio buttons so that only one can be selected at any given time.
    - Ensure the group is initialized in the `initComponents()` method.

3. **Database Integration:**

    - Use the provided `Database.getConnection()` method to establish a connection with the MySQL database.
    - Implement a `PreparedStatement` to safely insert the collected data into the `SurveyResponses` table.
    - Handle exceptions appropriately, using try-catch blocks, and provide error messages via `JOptionPane`.

4. **SUBMIT Button (jButton2) Implementation:**

    - On click, validate the input data.
    - Connect to the database.
    - Execute the INSERT query using a `PreparedStatement`.
    - Display a success message on successful submission, or an error message if any issues occur.
    - Close the database connection after the operation.

5. **RESET Button (jButton1) Implementation:**

    - On click, clear all form inputs:
        - Set text fields to empty strings.
        - Reset the combo box to its default selection.
        - Clear the radio button selection using the `ButtonGroup`.
        - Uncheck all checkboxes.
        - Clear any text area if used.

6. **General Code Quality:**
    - Ensure that all user input is validated.
    - Write clear and concise code with appropriate comments.
    - Follow Java naming conventions and best practices.
    - Modularize the code where possible for readability and maintainability.

## Additional Resources

-   [Java Swing Tutorial – Oracle](https://docs.oracle.com/javase/tutorial/uiswing/)
-   [Using PreparedStatement in Java – Oracle](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
-   [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/8.0/en/)
-   [VS Code Java Guide](https://code.visualstudio.com/docs/languages/java)

GitHub Copilot should use these detailed instructions to generate or modify the necessary code for integrating the survey form with the database backend.
```
