import java.sql.*;
import java.util.Scanner;


public class StudentDBController {
   
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // replace with your database URL
        String user = "username"; // replace with your MySQL username
        String password = "password"; // replace with your MySQL password
   
   public void  CreateTables {
      try {
         
      // create a SQL statement to create a new table
            String sql = "CREATE TABLE Grades (" +
                    "Subject VARCHAR(250) ," +
                    "Grade VARCHAR(250) ," +
                    "Student_ID INT NOT NULL ," +
                    "FOREIGN KEY (Student_ID) REFRENCES STUDENT (STUDENT_ID)" +
                    ");";
            Statement statement = conn.createStatement();
      
            statement.close();
      
      // create a SQL statement to create a new table
         String sql = "create table Parent(" +
                      " Parent_FName VARCHAR(100) NOT NULL," +
                      " Parent_LName VARCHAR(100) NOT NULL," +
                      " Parent_Address VARCHAR(255) NOT NULL," +
                      " Occupation VARCHAR(255)," +
                      " Phone_Number VARCHAR (255)," +
                      " Relation VARCHAR (100)," +
                      " Student_ID INT," +

                      " Foreign Key (Student_ID) REFERENCES Student (Student_ID) " +
                      " );";
         Statement statement = conn.createStatement();
      
         statement.close();

      String sql = " Create Table Report(" +
                    "Days_Absent INT,"+
                    "Days_presnet INT,"+
                    "Term INT,"+
                    "Student_ID INT,"+
                    "Foreign Key (Student_ID) REFERENCES Student (Student_ID)"+
                  ");"
         Statement statement = conn.createStatement();
      
         statement.close();
      
         
         
      String sql = " create table Student(" +
                     " Student_ID INT NOT NULL AUTO_INCREMENT," +
                     " Student_FName VARCHAR(100) NOT NULL," +
                     " Student_LName VARCHAR(100) NOT NULL,"+
                     " Student_DOB DATE NOT NULL,"+
                     " Age TINYINT NOT NULL,"+
                     " Class VARCHAR (100),"+
                     " Address VARCHAR (100),"+
                     " Gender VARCHAR(25),"+
                     " PRIMARY KEY ( Student_ID)"+
                  ");";
         Statement statement = conn.createStatement();
      
         statement.close();   
   
   
   
      }
   }

    public void addStudent(Student st) {

        try {
            // create a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // create a SQL statement to insert data into the database
            String sql = "INSERT INTO customers (first_name, last_name, DOB, Age,Class, Address, Gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, DOB);
            statement.setString(4, Age);
            statement.setString(5, Class);
            statement.setString(6, Address);
            statement.setString(7, Gender);

            // execute the SQL statement and insert the data
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }
            else{
                System.out.println("Error Data Not Updated");
            }

            
    

    public void addGrades(Student student, Grade grades) {


        try {
 

            // create a SQL statement to insert data into the database
            String sql = "INSERT INTO Grades (Subject, Totalmarks, Student_ID) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Subject);
            statement.setString(2, marks);
            statement.setString(3, sid);
 

            // execute the SQL statement and insert the data
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }
            else{
                System.out.println("Error Data Not Updated");
            }

            // close the connection and scanner
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }

    public void addReport(Report report) {
    }

    public void setClass(Student st, String cl) {

        try {
            // create a connection to the database



            // create a SQL statement to update data in the table
            String sql = "UPDATE Student SET Class = ? WHERE Student_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newClass);
            statement.setInt(2, studentId);

            // execute the SQL statement and update the data
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
            }
            else{
                System.out.println("Error Data Not Updated");
            }


    }
    }
       
       public void SelectStudents {


        try {

            // create a SQL statement to select all data from the table
            String sql = "SELECT * FROM Students";
            Statement statement = conn.createStatement();

            // execute the SQL statement and get the result set
            ResultSet resultSet = statement.executeQuery(sql);

            // iterate through the result set and print the data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date dob = resultSet.getDate("dob");
                int age = resultSet.getInt("age");
                String Class = resultSet.getString("class");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                

                System.out.println(id + " | " + firstName + " | " + lastName + " | " + dob + " | " + age  + " | " + Class + " | " + address + " | " + gender );
            }

            // close the result set, statement, and connection
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        
    }
}
       public void SelectSpecificStudent {
    

        try {
            // create a connection to the database


            // prompt the user for input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();

            // create a SQL statement to select data from the table based on the customer ID
            String sql = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, studentId);

            // execute the SQL statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            // iterate through the result set and print the data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date dob = resultSet.getDate("dob");
                int age = resultSet.getString("age");
                String Class = resultSet.getString("class");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                

                System.out.println(id + " | " + firstName + " | " + lastName + " | " + dob + " | " + age  + " | " + Class + " | " + address + " | " + gender );
            }

            // close the result set, statement, connection, and scanner
            resultSet.close();
            statement.close();
            scanner.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       public void SelectStudentGrade { 

  

        try {


            // prompt the user for input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();

            // create a SQL statement to select data from the table based on the customer ID
            String sql = "SELECT Student.Student_ID, Student.FName, Student.LName, Grades.Subject, Grades.TotalMarks, Student.Class " +
            "FROM Grades " +
            "INNER JOIN Student ON Student.Student_ID = Grades.Student_ID " +
            "WHERE Student.Student_ID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, studentId);

            // execute the SQL statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            // iterate through the result set and print the data
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String subject = resultSet.getString("subject");
                int totalMarks = resultSet.getString("age");
                String cla = resultSet.getString("class");
                
                
                

                System.out.println(sid + " | " + firstName + " | " + lastName + " | " + subject + " | " + totalMarks+ " | " + cla);
            }

            // close the result set, statement, connection, and scanner
            resultSet.close();
            statement.close();
            scanner.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       
       public void SelectNoclass {

        try {


            // create a SQL statement to select all data from the table
            String sql = "SELECT Student_FName,Student_LName,Age, Student_ID"+
            "FROM Student"+
            "WHERE Class IS NULL;";
            Statement statement = conn.createStatement();

            // execute the SQL statement and get the result set
            ResultSet resultSet = statement.executeQuery(sql);

            // iterate through the result set and print the data
            while (resultSet.next()) {
                
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getString("age");
                int id = resultSet.getInt("id");

                

                System.out.println(firstName + " | " + lastName + " | " + age + " | " + id );
            }

            // close the result set, statement, and connection
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       
       public void UpdateClass {

        try {
            // create a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // prompt the user for input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Student Class: ");
            String newClass = scanner.nextLine();

            // create a SQL statement to update data in the table
            String sql = "UPDATE Student SET Class = ? WHERE Student_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newClass);
            statement.setInt(2, studentId);

            // execute the SQL statement and update the data
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
            }
            else{
                System.out.println("Error Data Not Updated");
            }

            // close the statement, connection, and scanner
            statement.close();
            scanner.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       
       public void DeleteStudent {

        try {


            // prompt the user for input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID: ");
            int sId = scanner.nextInt();

            // create a SQL statement to delete rows from the table based on the customer ID
            String sql = "DELETE FROM customers WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, sId);

            // execute the SQL statement
            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");

            // close the statement, connection, and scanner
            statement.close();

            scanner.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }





       
       
       
       
       
       
       
       
           
       
       
       
       // close the connection
            conn.close();
        } 
    }
}
