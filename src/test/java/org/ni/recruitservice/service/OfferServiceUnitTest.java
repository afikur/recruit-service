package org.ni.recruitservice.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.ni.recruitservice.model.Offer;
import org.ni.recruitservice.repository.OfferRepository;
import org.ni.recruitservice.service.impl.OfferServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OfferServiceUnitTest {
    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private OfferServiceImpl offerService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddOffer() {
        Offer offer = new Offer();
        offer.setTitle("A sample offer");
        offer.setStartDate(new Date());

        when(offerService.saveOrUpdateOffer(any())).thenReturn(offer);

        Offer newOffer = offerService.saveOrUpdateOffer(null);

        assertEquals("A sample offer", newOffer.getTitle());
    }

    @Test
    public void testGetOfferById() {
        Offer offer = new Offer();
        offer.setTitle("A sample offer");
        offer.setStartDate(new Date());

        when(offerService.getOfferByOfferId(any())).thenReturn(offer);

        Offer newOffer = offerService.getOfferByOfferId(1L);
        assertEquals("A sample offer", newOffer.getTitle());
    }
}
