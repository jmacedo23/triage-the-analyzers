package team.projectpulse.ram.usecase.dto;

import java.util.List;

public record UseCaseMainStepDto(
        Long id,
        String actor,
        String actionText,
        List<UseCaseExtensionDto> extensions) {
    public UseCaseMainStepDto {
        extensions = extensions == null ? null : List.copyOf(extensions);
    }
}
