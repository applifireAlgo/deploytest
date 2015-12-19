package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.TalukaRepository;
import testproj.app.shared.location.Taluka;
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
import testproj.app.shared.location.District;
import testproj.app.server.repository.DistrictRepository;
import testproj.app.shared.location.Region;
import testproj.app.server.repository.RegionRepository;
import testproj.app.shared.location.State;
import testproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("4sS4galKmrdiO3hX9xApeMTikDrDxhi7");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(8);
            country.setCountryCode1("8fo");
            country.setCountryCode2("hXU");
            country.setCountryFlag("Jp0zpbJCjLAry9vebjCgAON39ls7mXybFLcSMbGs6OoDUbKeMJ");
            country.setCountryName("rbzl8Nb6y7rohWlt52Ddpac42BIRAMcV57bMaWO2bIYGQJ18Eu");
            country.setCurrencyCode("fMs");
            country.setCurrencyName("UN5c7HOnQ126RZDtCqdi2uKLoPui9TOdmmZjZXVd1503J3O89R");
            country.setCurrencySymbol("fdyoy029K69AxnILdceDgLq2mxhytTi5");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("9OjlgVrzZWtvIzXpkZ4NVQsqYmmk23pM");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("OAOgqEaVoKfvAs3DgoitvRtwHTwD2m0FCf7jq9mtzFrWTC6WiK");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(3);
            state.setStateCode(1);
            state.setStateCodeChar2("9iV5Xb2dT5rRxueUYqSMLSXXzJgU4NzQ");
            state.setStateCodeChar3("GNhSG1ERNyDxjLnlwJNK90Ya5Mbwkyt5");
            state.setStateDescription("Dq7O9Pz0rwyPqDl8DiozQ5EM1R9kUe4ezwQ1mkbnHXKA8D5s4i");
            state.setStateFlag("u3V0Ksz3w9jrbbL11TzD2mVPWU5gmCCdDzWXA6pKUpkXqt4WTU");
            state.setStateName("w4pS4Umul8q4pIoYJeO0SLrzPtto8199YbW3wFTywUJsL5APyw");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("rWfB2mmkVzmnPticpGK0oY8Oc1rZSxoP");
            region.setRegionDescription("OHPQ7cGZlWJWTlY4TZ5JJ1BKcsYQzPw4iWrTVmKOj7p6MiuSov");
            region.setRegionFlag("WyqV5XkLDK58gKOnLaXRdi7GvlifcPX7kSqg3vUTPQZhWBO4vg");
            region.setRegionLatitude(6);
            region.setRegionLongitude(3);
            region.setRegionName("dwLEylH3Atg3zeQtMXyCOnRUyfzle2fSaIXn5e4iPzbYSikAYv");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("xOtYv1vDJCgRDBTk0STiDC0BAxBZqIi7");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("kibVp2S53O4QQnW4FGuBc5hJTHH27W8yLuBSTyR7lFO33ahkeq");
            district.setDistrictFlag("ElO5SI4UjotSfCpVCUFon8T1pE422ylMiy7z6ZPnNKHfLPHizD");
            district.setDistrictLatitude(4);
            district.setDistrictLongitude(1);
            district.setName("thp8aNtehdVVTdbOta7PUE3ZUvxofvKpbtbcTi9Xkzjofmz3gM");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("IKtoMaNCyCBrtP1RNd8T86yGYVgX0QDa");
            taluka.setTalukaDescription("kEUTD8NTS8JOoA9WEqSuCe4RarGMll4VimhpFwhbbFrCpeZF7x");
            taluka.setTalukaFlag("edH1sF12wcyb94QGCQDVsB3REFjbYdtnN6GyYfaLXZRyqM7JLn");
            taluka.setTalukaLatitude(0);
            taluka.setTalukaLongitude(5);
            taluka.setTalukaName("MZjUGsfVrhreYCb7vGVv35Hf93acXCDdheFhAn6OA2RBWtqNO6");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("MVTsv01LBQmIigKdGxCUva0LsQdE0uBG");
            taluka.setTalukaDescription("RIYsgAYuJz0ENxi5eifv2nOabELLlB0fjQPcvRzrzLW3OlcoPt");
            taluka.setTalukaFlag("rtVnnQ96Pzc2srNnxgePe6GRu5FkP2IM9JlOSgyjfuo7dDQb6x");
            taluka.setTalukaLatitude(11);
            taluka.setTalukaLongitude(10);
            taluka.setTalukaName("dysgmB8kN0keDGWT9kOyNWRrTgMGDeefcacoeOo3aDpDWdALDn");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
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
