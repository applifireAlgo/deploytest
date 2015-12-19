package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.City;
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
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;

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
            country.setCapital("NxPBwh79X7zrugwmUw5gMGG6io07KY4L");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(10);
            country.setCountryCode1("Qwf");
            country.setCountryCode2("ia5");
            country.setCountryFlag("7y3UuM6B0rFIm3aBy2d1e6VxKV5POxT971YSZZIJnTbLNwMBMo");
            country.setCountryName("LHgz5Hopl0MPZrNJNzYvbqptjFUqlmBUYtVMykZaEJpN1gaIeq");
            country.setCurrencyCode("Q83");
            country.setCurrencyName("AqOeAp4wbRnDY5RtoiiLC5F0iSwAO1CdbsaYG1G3XzmwtK6Zqj");
            country.setCurrencySymbol("UACrCaT60GhhBiknONdUBrG22tzkVeFd");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("38erkltHISHi2TI7wAzu9J9sAkxT3dxjmr2Gb4FKZ0WthXWtDs");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("eiom4gvjvo2bLD8UC8d3JG1LfMPzUDdF");
            state.setStateCodeChar3("tywC0TajN4XDVGK6NBvxLJVNJHWBwvDw");
            state.setStateDescription("OU92arweqjD0xx3pdzz59ZdWi37Ef2oGx5Zq0HWgvF4P14PHk2");
            state.setStateFlag("8jGJAsNQI1odxJTTAmIuXxh4JrxCgHOsgiBFXtcgT7awqkwy86");
            state.setStateName("p6wtJwDmLyV0LzxDNZlFHE6Hl8db0l53uKFKKwmLBhkuJKeZmr");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("LFIvOJFqYRT9rEUznFBMFPLUy0Ij4b5m");
            city.setCityDescription("JXk6zVncWfu3B47npStxlecJSMabo36rnStadEzEcHOBunKEiP");
            city.setCityFlag("l5NaAp7kJaaw2f727XCTpIulcD3P1A1GUiQA2jqxPUflsCerLG");
            city.setCityLatitude(4);
            city.setCityLongitude(2);
            city.setCityName("tz4hc3kcIlTFWFghrq1T4C9uYDGVMVNdRfAfFjZ2FM6i7cZpMf");
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
            city.setCityCode(2);
            city.setCityCodeChar2("9MZATRrWxNXSFr9xXpoYmLjshSCAnFqg");
            city.setCityDescription("kxy2umv79pNdGPfG4ERON0lHHVmNpW2LNAFb71ulEqOwAndIH7");
            city.setCityFlag("E9DTAyGb1bUhxzNzVzujyZr4nUzcJFAWS1saqgRjrbIww6H5Pu");
            city.setCityLatitude(2);
            city.setCityLongitude(10);
            city.setCityName("zDz2kEe5b3NLAj3gABGIHy4CdYNFauYmIsKSNUTPviALa939dl");
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
