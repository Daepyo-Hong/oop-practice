package org.example.calculator.calculate;

//벨류 오브젝트,
//PositiveNumber의 객체가 만들어진다면 음수가 아니고 양수라는 것을 보장할 수 있음.
public class PositiveNumber {
	private final int value;

	public PositiveNumber(int value) {
		validate(value);
		this.value = value;
	}

	private void validate(int value) {
		if(isNagativeNumber(value)){
			throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
		}
	}

	private boolean isNagativeNumber(int value) {
		return value <= 0;
	}

	public int toInt(){
		return value;
	}
}
