/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author eddki
 */
public class Survey extends javax.swing.JFrame {

    // Button group for radio buttons
    private ButtonGroup buttonGroup1;

    /**
     * Creates new form Survey
     */
    public Survey() {
        initComponents();

        // Initialize the button group and add radio buttons
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
    }

    // Method to get the selected radio button text
    private String getSelectedRadioButtonText() {
        if (jRadioButton1.isSelected()) {
            return "Teachers";
        } else if (jRadioButton2.isSelected()) {
            return "AI Tools";
        } else if (jRadioButton3.isSelected()) {
            return "Both";
        }
        return null;
    }

    // Method to get the selected checkboxes
    private String getSelectedCheckboxes() {
        StringBuilder tools = new StringBuilder();

        if (jCheckBox1.isSelected()) {
            tools.append("Google Gemini,");
        }
        if (jCheckBox2.isSelected()) {
            tools.append("Github Copilot,");
        }
        if (jCheckBox3.isSelected()) {
            tools.append("Chat GPT,");
        }
        if (jCheckBox4.isSelected()) {
            tools.append("Deepseek R1,");
        }

        // Remove trailing comma if exists
        if (tools.length() > 0) {
            tools.deleteCharAt(tools.length() - 1);
        }

        return tools.toString();
    }

    // Method to validate form data
    private boolean validateForm() {
        // Check if name is empty
        if (jTextField1.getText().trim().isEmpty() || "Enter your name".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter your name", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if age is a valid integer
        try {
            String ageText = jTextField2.getText().trim();
            if (ageText.isEmpty() || "Enter your age".equals(ageText)) {
                JOptionPane.showMessageDialog(this, "Please enter your age", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            int age = Integer.parseInt(ageText);
            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if email is empty
        if (jTextField3.getText().trim().isEmpty() || "Enter your email".equals(jTextField3.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter your email", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if a role is selected
        if (jComboBox1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select your role", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if learning preference is selected
        if (getSelectedRadioButtonText() == null) {
            JOptionPane.showMessageDialog(this, "Please select your learning preference", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Method to save the form data to database
    private boolean saveToDatabase() {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            // Get connection
            connection = Database.getConnection();

            if (connection == null) {
                JOptionPane.showMessageDialog(this, "Failed to connect to the database", "Database Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Prepare SQL statement
            String sql = "INSERT INTO SurveyResponses (name, age, email, role, preference, tools, thoughts) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);

            // Set values
            stmt.setString(1, jTextField1.getText().trim());
            stmt.setInt(2, Integer.parseInt(jTextField2.getText().trim()));
            stmt.setString(3, jTextField3.getText().trim());
            stmt.setString(4, jComboBox1.getSelectedItem().toString());
            stmt.setString(5, getSelectedRadioButtonText());
            stmt.setString(6, getSelectedCheckboxes());
            stmt.setString(7, jTextField4.getText().trim().equals("Write your thoughts.....") ? ""
                    : jTextField4.getText().trim());

            // Execute query
            int rowsInserted = stmt.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            // Close resources
            try {
                if (stmt != null)
                    stmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDWARDKING'S SURVEY FORM");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 3, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("This Survey Seeks To Gather Information On The Impact Of AI On How Students Learn");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        jTextField1.setFont(new java.awt.Font("Segoe Print", 2, 14)); // NOI18N
        jTextField1.setText("Enter your name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Age");

        jTextField2.setFont(new java.awt.Font("Segoe Print", 2, 14)); // NOI18N
        jTextField2.setText("Enter your age");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        jTextField3.setFont(new java.awt.Font("Segoe Print", 2, 14)); // NOI18N
        jTextField3.setText("Enter your email");

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("What best describes your current role? ");

        jComboBox1.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Do you prefer learning with teachers or AI tools ? ");

        jRadioButton1.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Teachers");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("AI Tools");

        jRadioButton3.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Both");

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Which AI tools do you use for learning ?");

        jCheckBox1.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Google Gemini");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Github Copilot");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Chat GPT");

        jCheckBox4.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Deepseek R1");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("What do you think the future of traditional education is as AI advances?");

        jTextField4.setFont(new java.awt.Font("Segoe Print", 2, 14)); // NOI18N
        jTextField4.setText("Write your thoughts.....");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jCheckBox2)
                                                                .addComponent(jCheckBox1)
                                                                .addComponent(jCheckBox3,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jCheckBox4,
                                                                        javax.swing.GroupLayout.Alignment.LEADING))
                                                        .addComponent(jTextField4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 621,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 592,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 592,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField3,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField2,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel4,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 511,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel6,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        294,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jComboBox1, 0,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addGroup(jPanel2Layout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jRadioButton2)
                                                                                        .addComponent(jRadioButton1)
                                                                                        .addComponent(jRadioButton3))
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addComponent(jLabel8,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 79,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41,
                                        Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 386, Short.MAX_VALUE)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(305, 305, 305))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 48, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        jComboBox1.addItem("Teacher"); // TODO add your handling code here:
        jComboBox1.addItem("Student");
        jComboBox1.addItem("Other");
        jComboBox1.removeItemAt(0); // Removes "Item 1"
        jComboBox1.removeItemAt(0); // Removes "Item 2" (previously at index 1, now at 0)
        jComboBox1.removeItemAt(0); // Removes "Item 3"
        jComboBox1.removeItemAt(0); // Removes "Item 4"

    }// GEN-LAST:event_formWindowOpened

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jRadioButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jCheckBox4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // Clear text fields
        jTextField1.setText("Enter your name");
        jTextField2.setText("Enter your age");
        jTextField3.setText("Enter your email");
        jTextField4.setText("Write your thoughts.....");

        // Reset combo box
        jComboBox1.setSelectedIndex(0);

        // Clear radio buttons
        buttonGroup1.clearSelection();

        // Uncheck checkboxes
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Validate form data
        if (!validateForm()) {
            return;
        }

        // Save to database
        if (saveToDatabase()) {
            JOptionPane.showMessageDialog(this, "Survey response submitted successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            // Reset form after successful submission
            jButton1ActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit survey response", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Survey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Survey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Survey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Survey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Survey().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
