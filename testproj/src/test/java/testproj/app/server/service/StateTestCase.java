package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.StateRepository;
import testproj.app.shared.location.State;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import testproj.app.shared.location.Country;
import testproj.app.server.repository.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Country country = new Country();
            country.setCapital("8HQ9Nr2XaU7befvohpei9GesaXkCrXAg");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(1);
            country.setCountryCode1("mdM");
            country.setCountryCode2("1OB");
            country.setCountryFlag("0wqoVHDSMu5slgAKCiRO2ZU2ORO0c8WrvZJEoocG3T4Q4877Cz");
            country.setCountryName("MWFOQWjuRMfYh0z8ie4A8plFunhim00FilW5qBhHdv9Errzgwq");
            country.setCurrencyCode("BJm");
            country.setCurrencyName("tCxgToOxDAX7yPrAW6HCw9dkKCGYFVkqAgIeCPl8FzGSJM79XQ");
            country.setCurrencySymbol("mpjrSZp8Ypd06h9eGRRgYp9ZVwqXQrXt");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateCapital("yzBxhH3cJq04VDwfQOkkuIvFHSNx2FTeaPZQWm80GAB7NNOgBS");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(4);
            state.setStateCode(2);
            state.setStateCodeChar2("JfS1hGCjUTlNvwtjlIVdrYBblxUPkbNc");
            state.setStateCodeChar3("moTFsIGklvX6SPQOfW1p5qjKWoIAJ2fX");
            state.setStateDescription("pjwQGyrwLpRglHeiKtjySYdZL3auYYGoH2932tzwsYCd5rV40F");
            state.setStateFlag("0fvGHKukDfZnci22owfBbv64JhRcbQxW003WiIJpJZpa488LKu");
            state.setStateName("lMOEX1Yy7pNlJ4LbnmNjgxj0zOtHD6iHthY4fHBsGm5IgyJc44");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("znyKeuQ19UZSebFpgHpCOp8NdyWZsE75zvbwXNfodpwOF2JsIu");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("xybPnb7AZzJB9BX0tlKpKhEjnluzNA3T");
            state.setStateCodeChar3("1j5EvxMb2oRiEvlFwRzaUBlYK6er7sYT");
            state.setStateDescription("L35M459ShoOjH8i780CWqja9175GofAeDwZTlSPaiqKDB0Zhiz");
            state.setStateFlag("MOxXe8jEL4wD6xqEPY2iA2ahRiLSTMPatQuPEOhxkcAZgieX7F");
            state.setStateName("QlFhjJrXtMakv5vL9yEKbqrRnaunNeBra118ykDcqSr2jhthnJ");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
