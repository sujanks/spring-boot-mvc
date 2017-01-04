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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        given(this.personService.findById(1l))
                .willReturn(new Person("sujan", "sujan@test", "abcd1234", "1231"));
        mvc.perform(get("/person/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/person/index.jsp"));

    }
}
