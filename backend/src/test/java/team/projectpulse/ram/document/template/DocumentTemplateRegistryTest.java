package team.projectpulse.ram.document.template;

import org.junit.jupiter.api.Test;
import team.projectpulse.ram.document.DocumentType;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DocumentTemplateRegistryTest {

    @Test
    void loadsYamlTemplatesAndExposesSectionsAsReadOnlySnapshots() {
        DocumentTemplateRegistry registry = new DocumentTemplateRegistry();
        registry.loadAllTemplates();

        DocumentTemplate template = registry.find(DocumentType.SRS).orElseThrow();

        assertThat(template.getSections()).isNotEmpty();
        assertThatThrownBy(() -> template.getSections().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void setterDoesNotRetainCallersMutableList() {
        DocumentTemplate template = new DocumentTemplate();
        List<DocumentTemplate.SectionTemplate> source = new ArrayList<>();
        template.setSections(source);

        source.add(new DocumentTemplate.SectionTemplate());

        assertThat(template.getSections()).isEmpty();
    }
}
