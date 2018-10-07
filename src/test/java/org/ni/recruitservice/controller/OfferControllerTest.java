package org.ni.recruitservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ni.recruitservice.controllers.OfferController;
import org.ni.recruitservice.model.Offer;
import org.ni.recruitservice.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(OfferController.class)
public class OfferControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfferRepository offerRepository;

    private JacksonTester<Offer> jsonOffer;

    @Before
    public void init() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

//    @Test
//    public void testSaveOffer() throws Exception {
//        Offer offer = new Offer();
//        offer.setTitle("An Offer");
//        offer.setStartDate(new Date());
//        MockHttpServletResponse response = mockMvc.perform(
//                post("/offers").contentType(MediaType.APPLICATION_JSON).content(
//                        jsonOffer.write(offer).getJson())).andReturn().getResponse();
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
//    }

//    @Test
//    public void testGetWhenExists() throws Exception {
//        Offer offer = new Offer();
//        offer.setTitle("An Offer");
//        offer.setStartDate(new Date());
//
//        given(offerRepository.getOne(1L))
//                .willReturn(offer);
//
//        MockHttpServletResponse response = mockMvc.perform(
//                get("/offers/1")
//                    .accept(MediaType.APPLICATION_JSON_VALUE))
//                .andReturn().getResponse();
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//    }
}
