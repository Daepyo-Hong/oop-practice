package org.example.calculator;

import org.example.calculator.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * • 요구사항
 * • 간단한 사칙연산을 할 수 있다.
 * • 양수로만 계산할 수 있다.
 * • 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

	// 1 + 2 ---> Calculator
	//    3  <---
	@DisplayName("덧셈 연산을 수행한다.")
	@ParameterizedTest
	@MethodSource("formulaAndResult")   //저 메서드를 사용할거야.
	void calculateTest(int operand1, String operator, int operand2, int result) {

		int CalculatorResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

		assertThat(CalculatorResult).isEqualTo(result);
	}

	private static Stream<Arguments> formulaAndResult() {
		return Stream.of(
				Arguments.arguments(1, "+", 2, 3),
				Arguments.arguments(1, "-", 2, -1),
				Arguments.arguments(4,"*",2, 8),
				Arguments.arguments(4,"/",2, 2)
		);
	}

	/**
	 * 이 부분은 PositiveNumber가 생성될 때 걸러주므로 테스트코드를 PositiveNumberTest에서 수행하면 된다.
	 */
	/*
	@DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
	@Test
	void calculateExceptionTest() {
		assertThatCode(()->Calculator.calculate(new PositiveNumber(10),"/",new PositiveNumber(0)))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("0으로는 나눌 수 없습니다.");
	}
	 */
}
