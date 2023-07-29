package org.example.gradeCalculator;

import java.util.List;

public class GradeCalculator {


	private final Courses courses;

	public GradeCalculator(List<Course> courses) {
		this.courses = new Courses(courses);
	}

	/**
	 * 요구사항
	 * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
	 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
	 * • 일급 컬렉션 사용
	 */
	public double calculateGrade() {
/*
		double multifliedCreditAndGradeNumber = 0;
		int totCredit = 0;
		for (Course course : courses) {
			//multifliedCreditAndGradeNumber += course.getCredit() * course.getGradeToNumber();
			// 위 부분은 이 작업이 여러 클래스에서 수행될 때 계산식(곱셈)에 수정이 있으면 모두 다 수정해주어야 함.
			// 코드 응집도가 낮음. 그래서 곱셈 과정을 Course에서 하도록 개선
			multifliedCreditAndGradeNumber += course.multiplyCreditAndGradeNumber();
			totCredit += course.getCredit();

			//그리고 이 과정을 일급 컬렉션을 사용함으로써 GradeCalculator 말고 Courses클래스에서 처리할 수 있음.
		}
*/

		double multifliedCreditAndGradeNumber = courses.getMultifliedCreditAndGradeNumber();
		int totCredit = courses.getTotCredit();

		return multifliedCreditAndGradeNumber / totCredit;
	}
}
