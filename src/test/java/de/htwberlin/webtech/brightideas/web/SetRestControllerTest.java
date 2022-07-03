package de.htwberlin.webtech.brightideas.web;

import de.htwberlin.webtech.brightideas.service.SetService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SetRestController.class)
class PersonRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SetService setService;

    @Test
    @DisplayName("should return found sets from set service")
    void should_return_found_set_from_set_service() throws Exception {
        // given
        var sets = List.of(
                new Set(1, "Lineare Algebra", "yes","Math", Collections.emptyList()),
                new Set(2, "Tenses", "hallo",  "English", Collections.emptyList())
        );
        doReturn(sets).when(setService).findAll();

        // when
        mockMvc.perform(get("/api/v1/sets"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Lineare Algebra"))
                .andExpect(jsonPath("$[0].description").value("yes"))
                .andExpect(jsonPath("$[0].subject").value("Math"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Tenses"))
                .andExpect(jsonPath("$[1].description").value("hallo"))
                .andExpect(jsonPath("$[1].subject").value("English"));
    }

    @Test
    @DisplayName("should return 404 if set is not found")
    void should_return_404_if_set_is_not_found() throws Exception {
        // given
        doReturn(null).when(setService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/sets/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a person")
    void should_return_201_http_status_and_location_header_when_creating_a_person() throws Exception {
        // given
        String setToCreateAsJson = "{\"title\": \"Tenses\", \"description\":\"yes\",\"subject\": “English \"}";
        var set = new Set(123, null, null, null, null);
        doReturn(set).when(setService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/sets")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(setToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/sets/" + set.getId()))));

    }

    @Test
    @DisplayName("should validate create set request")
    void should_validate_create_set_request() throws Exception {
        // given
        String setToCreateAsJson = "{\"title\": \"a\", \"description\":\"\", \"subject\":\"Math\", \"deck\": []}";

        // when
        mockMvc.perform(
                        post("/api/v1/sets")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(setToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
