package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.RegionRepository;
import sales.app.shared.location.Region;
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
public class RegionTestCase {

    @Autowired
    private RegionRepository<Region> regionRepository;

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
            country.setCapital("2z61DkMzStiEKa0X45euTNyMiD8Zs15v");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(6);
            country.setCountryCode1("n5M");
            country.setCountryCode2("uPJ");
            country.setCountryFlag("NUXMukh1lMz9bWciaqHZvQCIFqeRcnGUzPe3dpScr3RXX11lx8");
            country.setCountryName("x9gQ2UPIKmhufjr5txn16xn3GeiCppr4Rb4KoDSXgN5YqpANW9");
            country.setCurrencyCode("RFW");
            country.setCurrencyName("ZgiqvnF0yxRkkjbu1F9S2QIyENPGqPLUSpCP6KdUzgaR8sqhQM");
            country.setCurrencySymbol("AnFkeF5wgerUXnjn6PPXOUoi9sM3TNLI");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("5tY6WLJrnrVEs9qxf3h1oJBfM1XyZ1crDKlXuSPn4i7rWmQKjJ");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("8md7jehiJY7Fpowj0hZGMGjB0TObKhec");
            state.setStateCodeChar3("RvwFQxHzX3uRDdw5MDIU45a2afHfaMee");
            state.setStateDescription("GR8HIyqPXl8fjpFDkhEOXHJSeL0ccL52xbFHTKERr4sJXWjc6x");
            state.setStateFlag("daWzYrLUYOb8JWzLkf2x5eQKMgdO8zQ7RET7JBDNOk2ew6TShD");
            state.setStateName("I5TCM4j6Xi06zcXeMJeAcX3wVbJtSEHwDqK2E4Xq43kgIxW5up");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            Region region = new Region();
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("7sljk28cuJVDgcstx5fKsaofi4rKYPbi");
            region.setRegionDescription("hDSnmgYw9TqLVLh2tJne4FbgacaxjbuotTVat2b21RcxYqX8vV");
            region.setRegionFlag("A3AdPVaGL22rpuvVmrwqDfIKFrtzwqLu5MtSAriLh4AaGL12uw");
            region.setRegionLatitude(2);
            region.setRegionLongitude(8);
            region.setRegionName("9mSfwZfC3oHdt7Ae8rMhJAlPTZ3FSu7l6Tuf4uL8HoEVvQBc1r");
            region.setStateId((java.lang.String) StateTest._getPrimarykey());
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.setEntityValidator(entityValidator);
            region.isValid();
            regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            Region region = regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
            region.setRegionCode1(0);
            region.setRegionCodeChar2("b37hE8OzchhqzRTGE3ZzTdvfq6XNTDY5");
            region.setRegionDescription("H61dyCWvGZdx6ycYsGn34JGHPShC9UsjKZ8DL66pX1xQd0hrho");
            region.setRegionFlag("irjWHGRTlJzOeNZppwGWhhm4mAhUFTXrPcL3nVfbB1ldhwwTz0");
            region.setRegionLatitude(2);
            region.setRegionLongitude(5);
            region.setRegionName("vIkmt5ylPkcCDeBSVuni1w6I4vzqerEr518Q7cwd21QU98WmGB");
            region.setVersionId(1);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Region> listofcountryId = regionRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Region> listofstateId = regionRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
