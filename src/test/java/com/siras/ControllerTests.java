package com.siras;


import com.siras.controller.PersonController;
import com.siras.domain.Person;
import com.siras.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Sujan on 4/1/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class ControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    @Test
    public void testPersonGet() throws Exception {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("sujan", "sujan@test", "abcd1234", "1231"));
        given(this.personService.findAll())
                .willReturn(persons);
        mvc.perform(get("/person/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/person/index.jsp"))
                .andExpect(model().attribute("persons", hasSize(1)))
                .andExpect(model().attribute("persons", hasItem(
                        allOf(
                                hasProperty("name", is("sujan")),
                                hasProperty("email", is("sujan@test"))
                        )
                )));

    }
}
