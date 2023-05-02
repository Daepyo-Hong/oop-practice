package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * - 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * - 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * - 경계조건에 대해 테스트 코드를 작성해야 한다
 */
public class PasswordValidatorTest {
	@DisplayName("비밀번호는 최소 8자 이상 12자 이하면 예외가 발생하지 않는다")    //의도를 나타내기 위해
	@Test
	void validatePasswordTest() {
		assertThatCode(() -> PasswordValidator.validate("serverwizard")) //해당 부분이 호출됐을 때
				.doesNotThrowAnyException();    //예외가 발생하지 않으면 테스트 통과
	}

	@DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.")
	@ParameterizedTest //경계값 체크위해
	@ValueSource(strings = {"aabbccd","aabbccddeeffg"})     //여러개 넣어주면
	void validatePasswordTest2(String password) {           //파라미터로 받을 수 있음
		assertThatCode(() -> PasswordValidator.validate(password))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
	}
}
