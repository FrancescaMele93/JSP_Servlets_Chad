package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;
					
		try {
			//get a connection
			myConnection = dataSource.getConnection();
		
			//create sql statement
			String sql = "select * from student order by last_name";
		
			myStatement = myConnection.createStatement();
			
			//execute query
			myResultSet = myStatement.executeQuery(sql);
			
			//process result set
			while (myResultSet.next()) {
				//retrieve data from result set row
				int id = myResultSet.getInt("id");
				String firstName = myResultSet.getString("first_name");
				String lastName = myResultSet.getString("last_name");
				String email = myResultSet.getString("email");
				
				//create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				
				//add it to the list of students
				students.add(tempStudent);
			}
			
			return students;
		}
		finally {
			//close JDBC objects
			close(myConnection, myStatement, myResultSet);
		}
		
		
	}

	private void close(Connection myConnection, Statement myStatement, ResultSet myResultSet) {
		
		try {
			if (myResultSet != null) {
				myResultSet.close();
			}
			
			if (myStatement != null) {
				myStatement.close();
			}
			
			if (myConnection != null) {
				//Doesn't really close it: just sets it back to being available for others to use
				myConnection.close();
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	public void addStudent(Student theStudent) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql for insert
			String sql = "insert into student "
					+ "(first_name, last_name, email) "
					+ "values (?, ?, ?)";
			myStmt = myConn.prepareStatement(sql);
			
			//set param values for stud
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			
			//execute sql insert
			myStmt.execute();
		} finally {
			close(myConn, myStmt, null);
		}
		
		
		//clean up JDBC objects
		
	}

	public Student getStudent(String theStudentId) throws Exception {
		Student theStudent = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			//convert stud if to int
			studentId = Integer.parseInt(theStudentId);
			//get connection to db
			myConn = dataSource.getConnection();
			//create sql to get selected student
			String sql = "select * from student where id=?";
			//create prepared statement
			myStmt = myConn.prepareStatement(sql);
			//set params
			myStmt.setInt(1, studentId);
			//execute statement
			myRs = myStmt.executeQuery();
			
			//retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				theStudent = new Student(studentId, firstName, lastName, email);
			} else {
				throw new Exception("Could not find student it: " + studentId);
			}
			
			return theStudent;
		}
		finally {
			//JDBC obj cleanup
			close(myConn, myStmt, myRs);
		}
	}

}
