package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("같은 위치 테스트")
    void same_position_test() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("위치 음수 값 예외 테스트")
    void minus_position_exception_test() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Position은 음수가 될 수 없다");
    }

    @Test
    @DisplayName("이동 테스트")
    void move_test() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("최대 위치값 테스트")
    void find_max_position_test() {
        Position position = new Position(3);
        Position maxPosition = position.findMaxPosition(new Position(4));
        assertThat(maxPosition).isEqualTo(new Position(4));
    }
}