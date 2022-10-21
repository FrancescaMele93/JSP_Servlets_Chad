package com.luv2code.servletdemo.mcvtwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	
	public static List<Student> getStudents() {
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("Mary", "Poppins", "supercalifragilistichespira@lido.so"));
		studentList.add(new Student("John R.R.", "Tolkien", "arda4ever@oxforduni.co.uk"));
		studentList.add(new Student("Doctor", "Who", "gallifrey@timelords.co.uk"));
		
		return studentList;
	}

}
