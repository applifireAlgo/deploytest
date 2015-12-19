package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.VillageRepository;
import testproj.app.shared.location.Village;
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
import testproj.app.shared.location.Taluka;
import testproj.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("tH8KLItHyUENSCo5BwHmqJgbz9aoSWTT");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(9);
            country.setCountryCode1("OZk");
            country.setCountryCode2("S3N");
            country.setCountryFlag("00I0HmiZhkWOMsfAVAVPaEwkZdES0yw0sxpU77ic7lJrjoGyMi");
            country.setCountryName("KWRwzfzZYwuhs1SpBQlZ80VB3ebxVYzufGAZ6KUwB1m77HOoP8");
            country.setCurrencyCode("wP6");
            country.setCurrencyName("ih2jrnqNUeTZK7u8sksmfwv1FAnUMPK4gV5Q7pcrGsHImi6vxh");
            country.setCurrencySymbol("sVVG3sE3oBoCKwi4kdIOkzHTNng8GCTS");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("GXcqc04ZgntjYDKERTqlR6uxDzQTpbjZ");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("KNY3UewAL954fJdWwsmJRfTIB3OEVMdlfNX0OhfIibfRzU5Dwu");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(0);
            state.setStateCode(0);
            state.setStateCodeChar2("P2wu66xxMt1i2zKD32IaxR7mi3BOyKCa");
            state.setStateCodeChar3("69ogtbnEwoizykcjR7qN4Q35xFVvJx1N");
            state.setStateDescription("413Q6QfMw7IgQn1yKuDJUoF0lY2uBTUPNmZDBAGGTycI5ji0fu");
            state.setStateFlag("DUfRCYAleCqPMG7aW6GyI8hrqXzcEffhIPMYfDMbQVKwUkDC8o");
            state.setStateName("afUfiJAYTFaRESCSMa1bRRhWE0vDfKbBCtIQZLIKxlZHQmp18P");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("HbWmC3RpABoPzl0FO31gB01q9fqUN8jk");
            region.setRegionDescription("IZ2AD6VQldkIE5B2gcJP9IbypMfrLXHU0YYyYJUqtsSBdEow12");
            region.setRegionFlag("i03b2viUTyQoOVvdWmr0UgfK3TStUxqS6AF22IIAR0DWLE6PAJ");
            region.setRegionLatitude(7);
            region.setRegionLongitude(9);
            region.setRegionName("tokKB3lJqnEWDtExN16eXVFQWr9LIyUk4OJeukbeR1WJmTbiHt");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("WnR4QWWpvQYH0jL7Ua5FGD9Ed1yxQwNw");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("gSqqKCP5yDVsqsCA418uPMA7CM6ECvMGCplU4gydcZEcdVrNwZ");
            district.setDistrictFlag("m23Hqd42VHkgonS0VbtSARhBXTduaa4Vs8k2zBMUqzt41vsqWV");
            district.setDistrictLatitude(7);
            district.setDistrictLongitude(6);
            district.setName("2WSN0Q0aQiKbGGtXZlTv6ffTXl85ogfqU7BEaWj4lv1lPupULb");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("jmOqJbFMXSDGx2LzFlPZhJ4ic7BgpREK");
            taluka.setTalukaDescription("Tpi5lUf57tWL6W9q43SrfA1Xe0K0wwYUUg3MU9k13mtPCGOQO9");
            taluka.setTalukaFlag("YlznqmaZqwQt6wmySD0IBdulIQrn39OVPVbSB8hx82Ma9M8grb");
            taluka.setTalukaLatitude(0);
            taluka.setTalukaLongitude(9);
            taluka.setTalukaName("9s15wm39ldz8bH2cjxrsyItFW5GBIbquEXCEqwmS43rPALOH4M");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("tl4hcHfRGWtEsuKCJFSz4HOAnk1p5EKQ");
            village.setVillageDescription("VC6q8S3McPK5tgV4Z7gZOxSfDNNy4M4ZOHPbYVZn4xo92416oV");
            village.setVillageFlag("HGc2ADmUQaZwks4kxmxuvGij4O5gQ7FlmE5wjDBzBNwXsGQult");
            village.setVillageLatitude("AHYK25DGo37");
            village.setVillageLongtitude(6);
            village.setVillageName("l08emnc2DAGYHyVkkNdnXfDj6dcKcAHCnxLGdUBfwTbWNh6BFv");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
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

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("58MpGqUipCMGC0e047d1qwbj2d92QVvu");
            village.setVillageDescription("iWROKeZWcqZEfBhdvyi8OvFhxczpmvXNr85w0GuL4DO4Y4hAPB");
            village.setVillageFlag("CoGpz7iF7Sm40vXjJ0muwbIOUxrlo8I4w53RV0G91O8q34B4Zy");
            village.setVillageLatitude("kuoHFJ0zPcz");
            village.setVillageLongtitude(10);
            village.setVillageName("C8MEFSKad1LxrxVR5Jh7TI6DejpE7sHjQjZXh3vHsDE5Mvrahu");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
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
