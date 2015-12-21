package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;

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
            gender.setGender("4Ngw7LLocRpCyELERmUO6YqYjoI08QbuHQlNASWjBM08QPYs99");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("zO");
            language.setAlpha3("YPL");
            language.setAlpha4("YkHW");
            language.setAlpha4parentid(8);
            language.setLanguage("WP8uU1v8ai68GFAlimWfB1jA4R5v1Gse1KqZRetIAPKe5mGzc3");
            language.setLanguageDescription("cSJmnFFvGCzs4YS1STE3CZ8U7GxkOD0dd8CFo5Oyhbgtj27n0W");
            language.setLanguageIcon("lKS2ABI96awwCGkBdTv4aecKyoEb4R4osGIxlcKBOx5QNgFJxo");
            language.setLanguageType("9nP0S7vDEE6tiUZWdJPUQ0NS6aF3CzGZ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("8RZVvZJnWU10fgwpKSNC6m6nB9JENFdEHhE2kN7jGM4cEOtylx");
            timezone.setCountry("XZfvSGPsFNR8L9bAHDHzKI2YEkHk6kKFrI5d691psqhr4wBKx6");
            timezone.setGmtLabel("ykOTH7m3PpuK8SJynioLqHuwCY5YIBmxMXiWhXQBtMqPEGGT6F");
            timezone.setTimeZoneLabel("JTVsllDGxNuw0057veR9TYBGK2rQr1sBc7sVnYC0gYi3NHaiIq");
            timezone.setUtcdifference(4);
            Title title = new Title();
            title.setTitles("Jk5eUAgk8i6H8HMhly0Wr9HyqkixYrEIr2wP9eNfBh7HgeCST2");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(85);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("eq4WvFxKEcdG2DfgwkWUuL3QZxd3S3RmpgdMIc5k7ryKm6nthE");
            corecontacts.setFirstName("OIDtXrs59xTsF9WKFJiqczvGpocwuZL3Agktg3zATZN6D7tlhj");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("8N4jWAdVAcxHqvLVLM8LlEKYnX4nMbDHY1LsqmCLfQ0zdVjazq");
            corecontacts.setMiddleName("notnnOaNIqe47JAizY9VNjpoYchGk2Dpx6eQxlZdWHeO0HCsyH");
            corecontacts.setNativeFirstName("696zMfijXJy0zZSTdyNgA5i09k5a4uNE8C8oVFcug0g7gb7oXm");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("YnO0nB9zn84SgKmWUfsjs35NLHjYkLSVwWDgz2SFD377ECF3ZO");
            corecontacts.setNativeMiddleName("1zfKg3LFNDUfHMSNXU5cWnNgQWsbYWarjX9mFJ5f0UW2TFJOqC");
            corecontacts.setNativeTitle("LumuWgmtERfwyKIWIdyClC0LQeq4EKha6IK7bluvtAWQSv4qdT");
            corecontacts.setPhoneNumber("sDnnsG5HIZp0phJ8B5OK");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("SPEQ4TOnyLzD5Gk7fusNOTq0zJkQTUfjR3vJOEVepMKrzNg4IN");
            address.setAddress2("1oHtaQiiWCkF2uGJcRosA65y4OtRhBqZO1yt57XUwZEx8wJSVj");
            address.setAddress3("wRm8T13WleGgO0PBWF76klIOAPUrUH08uyK47j1e1AMr24bbOr");
            address.setAddressLabel("tjpPgA32MPU");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("E89XddYfsHPriXqd28jlK2yza017zOPRkjRRbapP2kMo5rbKvd");
            addresstype.setAddressTypeDesc("9mlXbi26Oe17GlMFguzdjsaPxI5jBZBWVdnfGPzLduGHSW131T");
            addresstype.setAddressTypeIcon("bFtT2GiN4LZK46eN3XUyps9XFMbOXcoCousB3E355pNDAXQic3");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("reXE8zp8XOcHsxiWIq3bHJpZXu1ESb5S");
            city.setCityDescription("v3U3yc3ff36TDgGxMsJsxrRX8SJN3dPRPboIMHqIlOHZNQi9Kn");
            city.setCityFlag("9gI38XHPE0vXtwvKabJsuAsoNF6OJG07ZrisdUWVO8V1nKl53c");
            city.setCityLatitude(1);
            city.setCityLongitude(0);
            city.setCityName("FNgRQE8cub4ZZNlkjTZiJPvF5HCXMDd8rdCaxxSRrZwYJ4PfoD");
            Country country = new Country();
            country.setCapital("b1wEWEbyEpIqBFdRnOOONqg1VP1URb0i");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(9);
            country.setCountryCode1("wM7");
            country.setCountryCode2("XHZ");
            country.setCountryFlag("y0GomiSlX74jrQZ76JnUpWHNEUFXQdbFsExdK12sjdSJWxkbLL");
            country.setCountryName("upriqd0zaQYoocsDLZtix8g59gujlB26U02YxfQ22BnGbB5jO8");
            country.setCurrencyCode("167");
            country.setCurrencyName("5rmBPevfhlrRH5Icv96MZ4GoMjFvFzEIJON7zPdBm6Rq1aiiGq");
            country.setCurrencySymbol("EavNSLJhK5TYpWhPNMJohi10SkcZsOEL");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("mb33kHuIVgJrLn7MfZsXSGXrPcQdVtNQdi6pVzvG5FBkDnI5oJ");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("a0ZAE2n5pl9aYEwRyK3PHGMFgDrsw1F4");
            state.setStateCodeChar3("mGAjop3JnZ0uLEOCoTSLZJlgXRbVDlwh");
            state.setStateDescription("Pdse54cSS8eQE08yFZ0uNjTogxzWKLOgLc9Po1aqkWDRKN2CJt");
            state.setStateFlag("ZEL2nkE5d3XLqQMCcGP4cIhnkKJUvUZCtkjdGdIxGFQziutdXR");
            state.setStateName("0Va7PMjrLFmZahaMdtHZ8aobN4hcAyPmoR8EYQuV9X08n47q2a");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("P7apHG2xeWnRWCx7L44vPKzTkDPAnWQ4");
            city.setCityDescription("MWk0wZF2mbsNK89snnJc4MQsrw5DPbJXDoqA0QwisyPCzXbgHc");
            city.setCityFlag("nHZ6eEehRFXez7nDwdnrpfNUzxG8Jgp9MtZRmLJZw6Zs5uDQep");
            city.setCityLatitude(0);
            city.setCityLongitude(11);
            city.setCityName("2RNsELuyYcvf9fsOQmwaleNb7TKBIrvsDqZCU3Z9jKmBqXMrlk");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("LTp1OHRb0CpxVQmQqX8hSrIjDwGm1zmDFByIiEhfHIYOvnXAcB");
            address.setAddress2("fFF6rjD8ylibynyL6LW8tXrn6gSTjnIQ9GdjzbfAhp6fE40Hy1");
            address.setAddress3("nE5ZBBjXazihSHpv4NozMcqLu4iY1iz5EsgxZ9ONDxEKQEbjzR");
            address.setAddressLabel("xM6CrbEXOne");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("b9fBL9Egfp3NZgjMQz6OTuftuhXcmD4VOcWL9JW1ExKVJLy7SA");
            address.setLongitude("9S8oNJyiYp5LY9qghiYQYkUWf1NOzgPVj2tizmTOwqgNU2vFLn");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("52An56");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("KcQ");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("9YSYfhqOms2LPosx0KFKIvQ9SjzVtCTFLDg4OzUVE87XluUcB2");
            communicationgroup.setCommGroupName("nihswcdXcIOGsok3I7AkBhMH0M612OF1CBq4yO3jmF490xCwbY");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("rTcIvWQnSB8p9jJS3LLTxeTN7gz7iDNMh0LkIRFUVdkUY3xsTz");
            communicationtype.setCommTypeName("B3kXPEKGAkRp9oRbWDX2OWKid3dwVewXEg5yJux2f4YclLLzUH");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("37r");
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
            corecontacts.setAge(12);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("zIyMxUusrXFZpxBKmFK2N9wtwHyprTNsD0nvrhjN6qjspkaVYc");
            corecontacts.setFirstName("GM5k4PAEXX3jz4tWx47nOE3L6Y9sgwOqOfvt2Arb7cj5FRyk90");
            corecontacts.setLastName("v509N3R2y9fL5EpJz81kbsnFO610Jn9yDq6kaHxvWSTBAtI28J");
            corecontacts.setMiddleName("8j7bT8yoxl7ARKygUjj4FNqpEqj0xJKcoPy4jo1L1BrNRTgtBA");
            corecontacts.setNativeFirstName("GMJWa1eMXp78zHMrlacLx0WmWNzDHwcOJfvVs3AO0iJ9zGnSX8");
            corecontacts.setNativeLastName("zewwdnnz1HH8ef1XMMzDbQsNDF0WNAsTlON3TGMdlzUFNanfnl");
            corecontacts.setNativeMiddleName("JtDrHbkxaZKw9TXYThklEo90wF9JJXxkvLWmXBLT5PA0XGHFsV");
            corecontacts.setNativeTitle("ji6gjWGOiP1vLoSm6jry67kfxPzAOZ231enxTYOrpcTvvLrX1O");
            corecontacts.setPhoneNumber("7a8OtHg7AkvQLcWYgFZC");
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
