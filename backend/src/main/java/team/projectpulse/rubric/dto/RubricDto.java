package team.projectpulse.rubric.dto;

import java.util.Set;

public record RubricDto(
        Integer rubricId,
        String rubricName,
        Set<CriterionDto> criteria,
        Integer courseId) {
    public RubricDto {
        criteria = criteria == null ? null : Set.copyOf(criteria);
    }
}
