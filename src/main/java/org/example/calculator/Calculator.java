package org.example.calculator;

import org.example.calculator.calculate.*;

import java.util.List;

public class Calculator {
	public static final List<NewArithmeticOperator> arithmeticOperators =
			List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
	public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
		/* 이 주석문과 같이 직접 계산하는 것보다
		if ("+".equals(operator)) {
			return operand1 + operand2;
		}else if ("-".equals(operator)){
			return operand1 - operand2;
		}else if ("*".equals(operator)){
			return operand1 * operand2;
		}else if("/".equals(operator)){
			return operand1 / operand2;
		}
		return 0;
		*/
		//아래와 같이 enum을 이용해서 처리하는것이 더 좋고
		//return ArithmeticOperator.calculate(operand1, operator, operand2);

		//여기서 더 리팩토링을 하면 인터페이스와, 인터페이스를 구현한 클래스를 이용해서 처리할 수 있다.
		//각 클래스의 메서드를 호출해서 객체지향적으로 프로그래밍 할 수 있다.
		return arithmeticOperators.stream()
				.filter(arithmeticOperator -> arithmeticOperator.supports(operator))
				.map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
				.findFirst()
				.orElseThrow(()->new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
	}
}
