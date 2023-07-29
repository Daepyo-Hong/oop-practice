package org.example.gradeCalculator;

import java.util.List;

public class Courses {
	List<Course> courses;
	public Courses(List<Course> courses) {
		this.courses=courses;
	}

	public double getMultifliedCreditAndGradeNumber() {
		double multifliedCreditAndGradeNumber = 0;
		for(Course course : courses){
			multifliedCreditAndGradeNumber += course.getCredit()*course.getGradeToNumber();
		}
		return multifliedCreditAndGradeNumber;
	}

	public int getTotCredit() {
		/*
		int totCredit = 0;
		for(Course course: courses){
			totCredit += course.getCredit();
		}
		return totCredit;
		*/
		//깔끔하게 리팩토링도 가능
		return courses.stream().mapToInt(Course::getCredit).sum();
	}
}
