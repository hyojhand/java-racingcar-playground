package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("같은 이름의 객체 테스트")
    void same_name_test() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @Test
    @DisplayName("이름이 5자를 초과하지 않는다")
    void name_under_five_test() {
        assertThatThrownBy(() -> new Car("veryLongName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없다");
    }
}