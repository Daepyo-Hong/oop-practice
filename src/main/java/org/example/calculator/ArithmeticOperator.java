package org.example.calculator;

import java.util.Arrays;

public enum ArithmeticOperator {
	ADDITION("+") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 + operand2;
		}
	}, SUBTRACTION("-") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 - operand2;
		}
	}, MULTIPLICATION("*") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 * operand2;
		}
	}, DIVISION("/") {
		@Override
		public int arithmeticCalculate(int operand1, int operand2) {
			return operand1 / operand2;
		}
	};

	private final String operator;

	ArithmeticOperator(String operator) {
		this.operator = operator;
	}


	public abstract int arithmeticCalculate(final int operand1, final int operand2);
	//추상 메서드에 대한 오버라이드가 각각의 이넘에 적용될 수 있다.


	//외부에 노출되는 퍼블릭 인터페이스 부분
	public static int calculate(int operand1, String operator, int operand2) {
		ArithmeticOperator arithmeticOperator = Arrays.stream(values())
				.filter(v -> v.operator.equals(operator))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
		return arithmeticOperator.arithmeticCalculate(operand1, operand2);
	}
}
