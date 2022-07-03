package de.htwberlin.webtech.brightideas.service;

import de.htwberlin.webtech.brightideas.persistence.FlashcardEntity;
import de.htwberlin.webtech.brightideas.persistence.SetEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static de.htwberlin.webtech.brightideas.persistence.Subject.English;
import static org.mockito.Mockito.doReturn;

public class SetTransformerTest implements WithAssertions {

    private final SetTransformer underTest = new SetTransformer();

    @Test
    @DisplayName("should transform SetEntity to Set")
    void should_transform_set_entity_to_set() {
        // given
        var setEntity = Mockito.mock(SetEntity.class);
        doReturn(111L).when(setEntity).getId();
        doReturn("Vocabulary").when(setEntity).getTitle();
        doReturn("Tenses").when(setEntity).getDescription();
        doReturn(List.of(new FlashcardEntity())).when(setEntity).getDeck();
        doReturn(English).when(setEntity).getSubject();


        // when
        var result = underTest.transformEntity(setEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getTitle()).isEqualTo("Vocabulary");
        assertThat(result.getDescription()).isEqualTo("Tenses");
        assertThat(result.getDeck()).hasSize(1);
        assertThat(result.getSubject()).isEqualTo("English");
    }
}
