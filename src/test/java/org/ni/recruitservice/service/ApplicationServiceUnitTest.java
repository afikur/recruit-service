package org.ni.recruitservice.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.ni.recruitservice.enums.ApplicationStatus;
import org.ni.recruitservice.model.Application;
import org.ni.recruitservice.model.Offer;
import org.ni.recruitservice.repository.ApplicationRepository;
import org.ni.recruitservice.repository.OfferRepository;
import org.ni.recruitservice.service.impl.ApplicationServiceImpl;
import org.ni.recruitservice.service.impl.OfferServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ApplicationServiceUnitTest {
    @Mock
    private OfferRepository offerRepository;

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private OfferServiceImpl offerService;

    @InjectMocks
    private ApplicationServiceImpl applicationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddApplication() {
        Offer offer = new Offer();
        offer.setTitle("A sample offer");
        offer.setStartDate(new Date());

        Application application = new Application();
        application.setResume("a sample resume");
        application.setApplicationStatus(ApplicationStatus.APPLIED);
        application.setCandidateEmail("nazmul.islam@dsinnovators.com");
        application.setOffer(offer);

        when(applicationService.saveOrUpdateApplication(any())).thenReturn(application);

        Application newApplication = applicationService.saveOrUpdateApplication(null);

        assertEquals("nazmul.islam@dsinnovators.com", newApplication.getCandidateEmail());
    }
}
