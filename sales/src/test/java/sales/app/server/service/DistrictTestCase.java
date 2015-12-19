package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.DistrictRepository;
import sales.app.shared.location.District;
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
import sales.app.shared.location.Region;
import sales.app.server.repository.RegionRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;

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
            country.setCapital("vyhNpztXLyQRCJZUI8Hk1UL7fW0dLc1b");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(2);
            country.setCountryCode1("42X");
            country.setCountryCode2("s9x");
            country.setCountryFlag("4zXNW6ZMXd5fBhENXCFhMvEnUugRxsmFmlu8BPxDhXsMXknrCv");
            country.setCountryName("Ky4ZgD5kRNl9odiBroie9QwmzTJYTmXyaAoG2fmlinBeubMeGH");
            country.setCurrencyCode("u1a");
            country.setCurrencyName("GjhFLyeVzgeCZofFdcv2Nt8l8ckv3N8YK3Y9SJaFrQV9UAz3cN");
            country.setCurrencySymbol("sD1PPjC81ldPAtoP6BMCFF0slRTo499u");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("kbwXRHaNtGNEqMihj0qLR7uhluGxi4yWcIZknKG6VLo49fxL1r");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(10);
            state.setStateCode(2);
            state.setStateCodeChar2("bEQr8MNopiyxIfgs3bf1IAZdfF4lXJny");
            state.setStateCodeChar3("fU5ytXEpwtAw6jlIhjWW4r3mPKrwvycZ");
            state.setStateDescription("ejmcVPxgwRrxCFPwCVEAWn4s8PbsGOFszIrU6EnVCJ8aAXduGM");
            state.setStateFlag("JHEnzLZfVIyLQCBVuprMF7dyEjV7axS9GNFH1K34cjFlA5glA4");
            state.setStateName("mNBIVvq3PUlGVvfXtyjAdoLvZeFYZsdmDNUyfhUsNEtiH6Ky20");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("simyYbImZbS7kZu6CRAkPvpndCvTsFpd");
            region.setRegionDescription("qP8pUzkn23GKPfKgywn39GkzYeScDzRV97uOSJyajobFtuolp9");
            region.setRegionFlag("ONPCedZ5wWscpc7XjlWV2n9U5bmunwnCfdVykeKCUqhYZJ6sha");
            region.setRegionLatitude(5);
            region.setRegionLongitude(4);
            region.setRegionName("a8Mav7S5cGKovpnE8adaUNU1xHCCv3E77C6nx0cOemNenjYze6");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("vLrXiF75dZhbQvGXvNTaTrtFoduutHZY");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("QpuP5cLUnMNkSaxK5U4wOKdfE0emVKG54JwQwMovmGn20aCxOe");
            district.setDistrictFlag("ambBdh4jgInMwCGFpDnTitWow0etf9abqEbA8Ni8y4L3CsKdi0");
            district.setDistrictLatitude(1);
            district.setDistrictLongitude(2);
            district.setName("tF32glyVdcBrP2pJaRgx8nVBCsmj6s7w0BIPQ3d9DOXktlzNID");
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
            district.setCode2("HL2cEs1fFgvHcIY9RfuTXaxCSntlnoRT");
            district.setDistrictDescription("aZAM0OPtGtzVMWmvQnyfPwt69Lca4FaG4SBEReTadNnbKeGgE2");
            district.setDistrictFlag("YsEbCIbkucBYZBXou3RJwxK9nc2pJJ5ptmmfKu81Ex6tXuV5UY");
            district.setDistrictLatitude(5);
            district.setDistrictLongitude(10);
            district.setName("T5Kid8uHvk50vnZcuEj1xE38yguXaMkMfEl2ZEZZdN1jbFbMEO");
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
