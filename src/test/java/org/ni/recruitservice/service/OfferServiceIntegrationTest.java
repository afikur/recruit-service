package org.ni.recruitservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ni.recruitservice.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OfferServiceIntegrationTest {
    @Autowired
    private OfferService offerService;

    @Test
    public void testSaveOffer() {
        Offer offer = new Offer();
        offer.setTitle("A sample offer");
        offer.setStartDate(new Date());
        Offer newOffer = offerService.saveOrUpdateOffer(offer);
        assertNotNull(newOffer);
        assertNotNull(newOffer.getId());
        assertEquals("A sample offer", newOffer.getTitle());
    }
}
