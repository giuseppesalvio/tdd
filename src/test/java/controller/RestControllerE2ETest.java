package controller;

import com.arca.poc.PocApplication;
import com.arca.poc.dominio.TotaleAccountBancaPostRequest;
import com.arca.poc.dominio.TotaleBancaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    public void getTotaleAccountBancaConEccezione() throws Exception {

        String idInput = "ABC";
        MvcResult mvcResult = mvc.perform(get("/totaleAccountBanca").param("id", idInput).contentType(MediaType.APPLICATION_JSON)).andReturn();


        String expected = "{\"codiceCliente\":\"1\",\"totaleConto\":11111}";
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());


    }


    @Test
    public void getTotaleAccountBancaPost() throws Exception {

        TotaleAccountBancaPostRequest idInput =  TotaleAccountBancaPostRequest.builder().id("1").build();
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(idInput );

        MvcResult mvcResult =   mvc.perform(post("/totaleAccountBancaPost").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk()).andReturn();



        String expected = "{\"codiceCliente\":\"1\",\"totaleConto\":11111}";
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());


    }
}
