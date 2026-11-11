package team.projectpulse.ram.requirement.dto;

import java.util.List;

public record ArtifactTraceability(Long artifactId,
                                   List<ArtifactLinkViewDto> incoming,
                                   List<ArtifactLinkViewDto> outgoing) {
    public ArtifactTraceability {
        incoming = incoming == null ? null : List.copyOf(incoming);
        outgoing = outgoing == null ? null : List.copyOf(outgoing);
    }
}
