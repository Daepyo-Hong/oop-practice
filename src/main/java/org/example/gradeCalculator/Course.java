package org.example.gradeCalculator;

public class Course {
	private final String subject;   //과목명
	private final int credit;       //학점
	private final String grade;     //성적

	public Course(String subject, int credit, String grade) {
		this.subject = subject;
		this.credit = credit;
		this.grade = grade;
	}

	public int getCredit() {
		return credit;
	}

	public double getGradeToNumber() {
		if(grade.equals("A+"))
			return 4.5;
		else if (grade.equals("A"))
			return 4.0;
		else if (grade.equals("B+"))
			return 3.5;
		else return 0.0;
	}

	public double multiplyCreditAndGradeNumber() {
		return credit*getGradeToNumber();
	}
}
