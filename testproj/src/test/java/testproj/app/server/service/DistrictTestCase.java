package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.DistrictRepository;
import testproj.app.shared.location.District;
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
import testproj.app.shared.location.Region;
import testproj.app.server.repository.RegionRepository;
import testproj.app.shared.location.State;
import testproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase {

    @Autowired
    private DistrictRepository<District> districtRepository;

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
            country.setCapital("nwx3nKrBiE4EWPcr5GQJvx4u2rNvYpdB");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(4);
            country.setCountryCode1("AB7");
            country.setCountryCode2("Ajm");
            country.setCountryFlag("ZEQrs5l5oBB1nmGGvb1gy7ybqa6u7Z5ojkY379roT1zbzVflPR");
            country.setCountryName("5Jdeol8gDPn5Bbh3EoX475BCTbgPdq2sjRy9sIC5RPnkoYkGxB");
            country.setCurrencyCode("Jvw");
            country.setCurrencyName("JuahZjVsmYETQgndm2Ld5VR6olweIBkVtzDfNfQnUI3NS2rrc3");
            country.setCurrencySymbol("sr8NPYiFnn7UX5sbF80k4O5t10sWRxZl");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("q427z40sFyECLeoqIkJioG4YpZ71756vVaH3Cgz5mdEki601TR");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("EtoysxJbrOh1eAQojswI9S73rNtZliDS");
            state.setStateCodeChar3("Sx6uheTFG5efr9JuH9WGg1PVD5Wbr3rx");
            state.setStateDescription("MlndlmJplr5PN67Zs9u1at40hmh3CDJQzT6eYv5j7kDYCKPAUL");
            state.setStateFlag("SEwuBAnxXHSEYaeA6fLSDlUn2YU1oVcUH92ZgmZByJay7a7e1i");
            state.setStateName("2bxQigZ7EJ1NPz1eeohNw0rDH5hs3YeUpJQpDmerRke5PxVCxk");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("btkm9DdJM3fMj9yU6q6p2A0GNW79sJsy");
            region.setRegionDescription("sr8eOEo0f7014KWdWgelEDU17MRqj2a2hjwy3jTVHgMGGMlXz0");
            region.setRegionFlag("akVI72tQypvPyAaKlK0OIwnlbpJJqYSv6PWn3fIJ65Y6r0RGUP");
            region.setRegionLatitude(4);
            region.setRegionLongitude(5);
            region.setRegionName("ZomaW7ba4Dya7xUgcrGOoxnKF11q1EOjEQVaFZgKl6uyTmlqrH");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("ZRbFdylQoCDuzowbTgSTDADTsiZNIGmk");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("m3yQBDCuS6xxUaAvQMcPGlugjq6x0MPZ9ZJ8i93vkziWQNHKDb");
            district.setDistrictFlag("H8vefU31CMLAFfw9bOOmRTrjw1pFmISOgAghjFRtq3AcuytZtz");
            district.setDistrictLatitude(8);
            district.setDistrictLongitude(11);
            district.setName("gnxVNLkWkoDlfxfLyCnpfeq28Yun4eNnTp4rWJExSGqi64qgPk");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey());
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.setEntityValidator(entityValidator);
            district.isValid();
            districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            District district = districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
            district.setCode2("orTWvyeNdX1KDrT0y5XZvqT46VlPiYPV");
            district.setDistrictDescription("3eGabzh4n5FljHGnMTjIfdrRsA89nYY8vHwAamy642QYZPPgVH");
            district.setDistrictFlag("8yuLy55oAw5OoMMF0umS93IoL2TwSRxGak5BN6IBMCM90HpWHj");
            district.setDistrictLatitude(3);
            district.setDistrictLongitude(11);
            district.setName("aPkRv154kEzG9suV1tI0hBt8KjgRfGnFIbiy5tQJBNA5BuQsua");
            district.setVersionId(1);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<District> listofcountryId = districtRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<District> listofregionId = districtRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<District> listofstateId = districtRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
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
