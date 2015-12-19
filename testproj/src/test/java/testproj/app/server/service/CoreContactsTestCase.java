package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.CoreContactsRepository;
import testproj.app.shared.contacts.CoreContacts;
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
import testproj.app.shared.contacts.Gender;
import testproj.app.server.repository.GenderRepository;
import testproj.app.shared.location.Language;
import testproj.app.server.repository.LanguageRepository;
import testproj.app.shared.location.Timezone;
import testproj.app.server.repository.TimezoneRepository;
import testproj.app.shared.contacts.Title;
import testproj.app.server.repository.TitleRepository;
import testproj.app.shared.location.Address;
import testproj.app.server.repository.AddressRepository;
import testproj.app.shared.location.AddressType;
import testproj.app.server.repository.AddressTypeRepository;
import testproj.app.shared.location.City;
import testproj.app.server.repository.CityRepository;
import testproj.app.shared.location.Country;
import testproj.app.server.repository.CountryRepository;
import testproj.app.shared.location.State;
import testproj.app.server.repository.StateRepository;
import testproj.app.shared.contacts.CommunicationData;
import testproj.app.shared.contacts.CommunicationGroup;
import testproj.app.server.repository.CommunicationGroupRepository;
import testproj.app.shared.contacts.CommunicationType;
import testproj.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("WVoJinSl8rQJOuXtd7LqgR5Adl39QJlE1Ep7rU0A5rfedo2uiZ");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Zf");
            language.setAlpha3("cnI");
            language.setAlpha4("Px2d");
            language.setAlpha4parentid(9);
            language.setLanguage("vx7jfhiPs8tQ8foGGdmJbBrgEvvmaYZlinSSPY1nJkOi1DJ1j9");
            language.setLanguageDescription("KHfBX5rZcmpeszhFIwLuJR9kxzkXNlmN6KWah8hUpRDkPnZweP");
            language.setLanguageIcon("nZIFqOfONwiaKoHKSJTYxAkjwSbv9XjbDph33M8fvD5TRXTDoe");
            language.setLanguageType("NeYtHoFT27W4viuXH2DKf00C33LGmBbF");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("S4AAxxgnuPmwsmNJOfhquHgCSFey75V3YwvtgInAsS36m0IS24");
            timezone.setCountry("rc6i2uHWtKthpwryEDWzvCABjpr3qBU34mkNVnfCwkYijcqFeV");
            timezone.setGmtLabel("l7szIIYDCIZFxCwSk4WN3jZWavV1VCwsJdbS1PlW3pAfMmmyuH");
            timezone.setTimeZoneLabel("5tmo3EHygkPHqaYLnmVHEBz1aY0Mn7k1xxjWTrAspowIUnw4eD");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("VQ4qmjScr92v4rx9tNzBValm1A2vpJHqYpWdswAabTaB41jcYi");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(83);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("XwDkovdB61Coc5TFMG3zcqkSK6Os7PAzC89ph6E3I8uj0nZWEe");
            corecontacts.setFirstName("hgssOmS3waXEfVvH7uSyDgfKFEyCYQJMNc4PmoNhwwEfIBciQb");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("AahvlFaCtO7iS82bo048qTk94CMo1FkMuqyrRIaLOX5lkFuiZc");
            corecontacts.setMiddleName("8vh6B1t5RuYkdXFE6PD5U4Poh0Cqws8aRxRvhPYJjECy6U4eB5");
            corecontacts.setNativeFirstName("5M8aBdHGBkGkyfjQrjderHqq0iMOFWIDL9PVRnlaEJXFb1DeOd");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("mU49ekSUSPN7Lscl8rzzUxUw0rFJdJj4cvA3QVcoNF3Jt8IWXg");
            corecontacts.setNativeMiddleName("g5ZJGCrkjD4q1j8i0ZeyPqTfhrBPiL5Yvu0yIl4qoelNlhrRPt");
            corecontacts.setNativeTitle("AjXQAdC9KOBzMuJomwb4largNGX8lXxjCbGvJUJUeV7kwQ692G");
            corecontacts.setPhoneNumber("VeTOzJ1CARRBZd7kiuJQ");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("LWpAjuKjsz2BLkPtg6WzQZNcsFZoMZkvqf27LLsZmfi5ARNsIW");
            address.setAddress2("QTTvEBwFj1CryOJ0Ty7SK6on1SLEhAGyHPULDZ8wXf8HAuIF4A");
            address.setAddress3("9D3WFwuGW4AAfViJ1W27M8BtP9Ehfr6SGjeJBegaxThA5VjeYm");
            address.setAddressLabel("qSyD6yRWVaC");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("gFLodb9NQmQGQdVQbTXJwFcywBZO37jng8OQWmoVtsqHDSlC0L");
            addresstype.setAddressTypeDesc("GIRWsbmWErEts7ex9dfKEeUVCZsYMtv9odf2f8TD8zHlVEsfMx");
            addresstype.setAddressTypeIcon("2tTEpRUJY3aaKF62PzfT7Q0GPXL55BO7Qll0UdI5vgJeWoWWhP");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("r4Cd1yPUM05D0gARaLxpbycVRLm1hhuK");
            city.setCityDescription("P0ZQpV4IkC3w2AbBPLKJvJUUIDcRWjUZL1ti3tc5aT7AwqZbZy");
            city.setCityFlag("7NHwEriRLNvPUmctE5NqOLGHAr3Fgfgm4p2In8ZThBwklr3upI");
            city.setCityLatitude(6);
            city.setCityLongitude(11);
            city.setCityName("aI00F2EmYzlP13vIYKurmUpsgXmqWJJqvLtLLeBgGH5FsABmuu");
            Country country = new Country();
            country.setCapital("95HTceZLiI0NUg00r0KTzMvcgpDLqecJ");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(5);
            country.setCountryCode1("3KZ");
            country.setCountryCode2("Res");
            country.setCountryFlag("iPCPnlgUbm3lSJM0SbIskBLPfHAReDxYyxmY358qQ62yexhfjm");
            country.setCountryName("DsmbTOdxCWRxqblQpheJitfVmENzaxoqfK3C8mo04egbSNZmDd");
            country.setCurrencyCode("zm9");
            country.setCurrencyName("FFNlhltNewRblXqjByBBuqKRgholRb2FsCC48q4bjvkJ3vQdtX");
            country.setCurrencySymbol("PnmMyLn8l4KH6YaAk1oVWN6KjLRjoGVA");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("K2DROyAYWeR1RK847ZBvdvvRvJobOAfnvgYJEDPs6mA7CHla0r");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("QrTvhs6LdCFSLvjjVmWLfNfKLERW6Rzh");
            state.setStateCodeChar3("oTKalvUF4mbM0Z4t9QoaGRmSznh854rN");
            state.setStateDescription("v6m4qxa0vwl5Y7sfNtnuGXSOuywCexx0cRued60Vbuivv7MNnC");
            state.setStateFlag("eIWp8aqNTFjicN0bGaf5MCwqBMcpeoOs3R6PZkZ5N79jfV3mW6");
            state.setStateName("VfZJEVzjnt1pnygVOondIZwaKMwYAjIhOgEipX2qUd2en9RetE");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("uBeo5YKnDt7AyzMevycSiPN6crRS4eV3");
            city.setCityDescription("CA8b6zEy51XBXcOSTjJGzul02gxd5zTuHelK4BzsvuOlmgbjli");
            city.setCityFlag("BhDqB646MD7bANU50M1CZq82u4vCj2n5cx20GFF9zkuBLHs7De");
            city.setCityLatitude(7);
            city.setCityLongitude(4);
            city.setCityName("FXY2WVIUoHVr06ig0t8HCvzAH4RfBVt9yOCWDrlseOCBoqo9dQ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("S0EzfoJA13z8ctYQmHdsM7yUNkQwbt8YmybdwcJLaY4totGOkv");
            address.setAddress2("1etlGMhAezuDpOUaIYaVh0jTO8u6YFyNz29VE5hLFRhgzsswGu");
            address.setAddress3("D8tHKa5kKte57nzJDJ83X7wKt1906EIaIVMMyvo2frFdYHoM6B");
            address.setAddressLabel("bu0HKnSbtkM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("fmEkbxYrqQQigQ6C7N6mry3LVyui8QP8qHc0fkg20g1EZDl3wm");
            address.setLongitude("0pW0vR5iCV2saO9KMauHC7vF0i3MvQ6YuJ1pmVv0khjvsqHhfY");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("sA8uiT");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("OPM");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("3A6zGskCuCmgvvmcCAANcuDqxsaM4vbiBsZYT60zlXUsQqccbx");
            communicationgroup.setCommGroupName("j3fIjINA9znJzzeyIY3ncy3ouCFPmo7nDhN6k6r9330TffXq3e");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("2FkErV6w04vljAf4BHzvMrmwZwLY2QfGqizSJ4OEuvJpmHJ3LZ");
            communicationtype.setCommTypeName("8BpRTzEWPC2qXXvgv4oaQRQDgxFBKLwkhYKThtrHBoa5xQDREX");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("yoy");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(117);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("LcgwtvLhWQL92BOD4mBfk0wcvvcQpNlNFUi80Fwte9Kust2iVv");
            corecontacts.setFirstName("ILQTb971fFfN661po2hbD02NiLrGxEd0KKwonFfw9CvRD4n2QV");
            corecontacts.setLastName("zofWF0kz5sxpAKrV4DqlJm8YhPTDknwS6zwSm2tZg8h5oCUrbU");
            corecontacts.setMiddleName("M1zWuQREyV3yGvSGUrpEbk5GpUag09AfHJHp3tc08WzYqLxRjz");
            corecontacts.setNativeFirstName("XHAOeeDCKSgmDAtXLpgOAfKgdKNUMLG8v3waSvIxxfBqhN9HqA");
            corecontacts.setNativeLastName("Jd2b6hJIvRhI0g2uc6PGEzCsXZTum9M9uWbicJyxucv0CxLbmP");
            corecontacts.setNativeMiddleName("RDN5rpXVFhA5WAqZKM4aNCHUNoIF7JaPIAQvfgiO7AfTn2soy4");
            corecontacts.setNativeTitle("hWtHjX0LnqaarTz4tGik2tXWhp4ovYPsv4PE6wrJmo1z4H7nMg");
            corecontacts.setPhoneNumber("ImghjNOFeQuugKsMdOZJ");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
