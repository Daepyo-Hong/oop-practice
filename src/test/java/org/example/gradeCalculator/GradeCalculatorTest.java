package org.example.gradeCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
 * 요구사항
 * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * • 일급 컬렉션 사용
 * 일급 컬렉션이란 하나의 클래스 컬렉션만 가지는 클래스. EX) Courses (Course의 리스트를 가짐)
 */
public class GradeCalculatorTest {
	//학점계산기 도메인 : 이수한 과목(객체지향프로그래밍, 자료구조, 중국어회화 등등), 학점 계산기
	// 객체지향프로그래밍, 자료구조, 중국어회화 --> 과목(코스) 클래스

	// 이수한 과목들을 전달해서 평균학점 계산을 요청한다. -->
	// 학점계산기                                 --> 학점계산기는 계산만 해서 리턴
	// (학점수×교과목 평점)의 합계/수강신청 총학점 수 --> 정보들은 과목(코스) 에게 요청
	@DisplayName("평균 학점을 계산한다.")
	@Test
	void calculateGradeTest() {
		List<Course> courses = List.of(new Course("OOP", 3, "A+"),
				new Course("자료구조", 3, "A"),
				new Course("중국어회화", 3, "B+"));

		GradeCalculator gradeCalculator = new GradeCalculator(courses);
		double gradeResult = gradeCalculator.calculateGrade();

		assertThat(gradeResult).isEqualTo(4);
	}
}
