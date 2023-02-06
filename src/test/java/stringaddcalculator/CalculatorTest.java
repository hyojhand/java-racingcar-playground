package stringaddcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("null 또는 빈문자 테스트")
    void null_or_empty_test() {
        assertAll(
                () -> assertThat(calculator.calculate(null)).isEqualTo(0),
                () -> assertThat(calculator.calculate("")).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("숫자 하나 테스트")
    void one_number_test() {
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("구분자 쉼표 테스트")
    void comma_separator_test() {
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자 공백포함 테스트")
    void comma_separator_include_empty_test() {
        assertAll(
                () -> assertThat(calculator.calculate("1,,")).isEqualTo(1),
                () -> assertThat(calculator.calculate("1,,2")).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("구분자 쉼표 콜론 테스트")
    void comma_colon_separator_test() {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void custom_separator_test() {
        assertAll(
                () -> assertThat(calculator.calculate("//;\n1,2;3")).isEqualTo(6),
                () -> assertThat(calculator.calculate("//-\n1,2-3")).isEqualTo(6)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,2,3"})
    @DisplayName("숫자가 아닌 예외 테스트")
    void not_number_exception_test(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아니거나 음수입니다");
    }
}