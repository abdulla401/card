package com.zilch.card.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zilch.card.modal.ZilchTxn;
import com.zilch.card.service.ZilchTxnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = ZilchTxnController.class,
        excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class ZilchTxnControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ZilchTxnService zilchTxnService;

    @Test
    void testFindAll_returnsListOfStudents() throws Exception {
        List<ZilchTxn> list = new ArrayList<>();
        ZilchTxn zilchTxn1 = new ZilchTxn(1l, "tesco", new BigDecimal("11.22"), 14l);
        ZilchTxn zilchTxn2 = new ZilchTxn(2l, "pharmacy", new BigDecimal("5.50"), 14l);
        list.add(zilchTxn1);
        list.add(zilchTxn2);
        when(zilchTxnService.finalAll()).thenReturn(list);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/list")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String responseBodyAsString = mvcResult.getResponse().getContentAsString();
        List<ZilchTxn> response = new ObjectMapper()
                .readValue(responseBodyAsString, new TypeReference<List<ZilchTxn>>(){});
        assertEquals(2,response.size() );
    }


}