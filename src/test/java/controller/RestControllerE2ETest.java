package controller;

import com.arca.poc.PocApplication;
import com.arca.poc.dominio.TotaleBancaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PocApplication.class)
@AutoConfigureMockMvc
public class RestControllerE2ETest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getTotaleAccountBanca() throws Exception {

        String idInput = "1";
        MvcResult mvcResult = mvc.perform(get("/totaleAccountBanca").param("id", idInput).contentType(MediaType.APPLICATION_JSON)).andReturn();


        String expected = "{\"codiceCliente\":\"1\",\"totaleConto\":11111}";
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());



    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    }
