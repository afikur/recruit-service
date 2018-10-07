package org.ni.recruitservice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.ni.recruitservice.service.ApplicationServiceUnitTest;
import org.ni.recruitservice.service.OfferServiceIntegrationTest;
import org.ni.recruitservice.service.OfferServiceUnitTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OfferServiceIntegrationTest.class,
        OfferServiceUnitTest.class,
        ApplicationServiceUnitTest.class
})
public class RecruitServiceApplicationTests {
}
