package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.CityRepository;
import testproj.app.shared.location.City;
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
import testproj.app.shared.location.State;
import testproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            country.setCapital("QCVdK9838fLM6CcJe6hab49Y5enta5dd");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(7);
            country.setCountryCode1("KC9");
            country.setCountryCode2("Nxb");
            country.setCountryFlag("lqqRns912bnoFU588aw0285NpClp8MU7h7afkJu7VZRpikuSAM");
            country.setCountryName("ztX2XxiRc7Cjs4EDRw8OWTMIibhPCIIvOJG2b2fUFH5oDlSEps");
            country.setCurrencyCode("ZtF");
            country.setCurrencyName("fk3PJ89JkBSj87AJbtK4Zyq4A2HG7aaQYxTMGCFWY2OQ0vqmEg");
            country.setCurrencySymbol("OhNvDKpFVD23RKjmlZ8oL7xJ5Dh72QsH");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("BOYQxu6apdL6KXwDffrHNxY34144AmOz0nVGQvLdim7p3r6lQW");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("hPZKzv3oRge4Ya46ePDnQpZvrter9Pop");
            state.setStateCodeChar3("rA7UOzF2KY4qs7gcvvPrK5v0vfHZu5ou");
            state.setStateDescription("6YFG9AQ1sqvjNxZZFQwZwPhNBUOmEmeQAw3O2XJfXP4FUNePID");
            state.setStateFlag("WhwcsFnQEzbBJi5qN7h40VRhpXB9aRArIrulTgAocdhxWUGwnJ");
            state.setStateName("rIItx0RRliuhIiNtakrsWdaRnYyPTfPvWaLN6DbArh7MTw1qKg");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("FFfujEg8qQPyPloT6CKUdS06tsB51Qyw");
            city.setCityDescription("6TDiDLF7pwq9CXVrondsfoHzXNs7iMWHQuQqo141nL6LcCPyEl");
            city.setCityFlag("WtY4mSMotVaJeAnHZndRdIZrsR82dP8j2CF17KdNqvMe66vwqf");
            city.setCityLatitude(6);
            city.setCityLongitude(9);
            city.setCityName("DlTwj1xerSypCRqthqH2KECPEy6TPcG4UmSfJsXafZm35SV3GR");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityCode(1);
            city.setCityCodeChar2("J93lhFiZJ6eBpwrG4T1IJXfW8Pl9dqWS");
            city.setCityDescription("wDpmNCgvRrXX7gN5uZHzOsrchmkbYEZ0yzogApIAvyMPgga0W3");
            city.setCityFlag("KKi6ko9XlPOpXjEEoJX6WtUczI4n3zTikQ3qR8U3FxQVNg2uyc");
            city.setCityLatitude(10);
            city.setCityLongitude(10);
            city.setCityName("K4LJQSExCqj38QjvLr6pQoDDUfyzSuWayLMcfgrDye0hgx9z6q");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
