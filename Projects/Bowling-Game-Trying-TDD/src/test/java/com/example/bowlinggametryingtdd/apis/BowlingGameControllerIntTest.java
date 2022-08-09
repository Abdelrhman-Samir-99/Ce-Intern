package com.example.bowlinggametryingtdd.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
public class BowlingGameControllerIntTest {
    @Autowired
    protected MockMvc mvc;
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void testCallingGetPopularMoviesWithPageReturnsPageOfMovies() throws Exception {
        // Arrange (Given)
        final int page = 1;
        final String url = "/api/v1/movies/popular";

        // Action (When)
        ResultActions result = this.mvc.perform(get(url).queryParam("page", page + ""));

        // Assert (Then)
        result.andExpect(status().isOk()).andExpect(jsonPath("$.page", is(page))).andExpect(jsonPath("$.results", notNullValue()));
    }
}
