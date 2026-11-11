package team.projectpulse.notification.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OwingTeamDtoTest {

    @Test
    void snapshotsStudentsWithoutChangingNullCollectionSemantics() {
        List<OwingStudentDto> source = new ArrayList<>();
        OwingTeamDto dto = new OwingTeamDto(1, "Team A", source);

        source.add(null);

        assertThat(dto.students()).isEmpty();
        assertThatThrownBy(() -> dto.students().add(null))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThat(new OwingTeamDto(1, "Team A", null).students()).isNull();
    }
}
