package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.CoreContacts;
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
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.contacts.CommunicationData;
import sales.app.shared.contacts.CommunicationGroup;
import sales.app.server.repository.CommunicationGroupRepository;
import sales.app.shared.contacts.CommunicationType;
import sales.app.server.repository.CommunicationTypeRepository;
import sales.app.shared.location.Address;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.AddressType;
import sales.app.server.repository.AddressTypeRepository;
import sales.app.shared.location.City;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;

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
            gender.setGender("7zxjOZNYkLKxzi1EMqzDPp0Slt7OLCzQSNs5qMvlKoo2HEcVfi");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("3D");
            language.setAlpha3("U8N");
            language.setAlpha4("mG62");
            language.setAlpha4parentid(11);
            language.setLanguage("BGXrnF2NLRw6Yl1btAYlGH0bAAucFV11DHdz61haxM4xNljXdu");
            language.setLanguageDescription("zuIgFAvbU76eVCSfbwg6eZgmSNPDpvKQgKPYsZJnVYFRMoDcX1");
            language.setLanguageIcon("1b7z2FVNOfH054gjz76o1uhnArw2hnDC1A6mugJs0GtrS4CLA7");
            language.setLanguageType("iGUtoGv42xJlpftKdEuPcp9BzyIu68QK");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("jOObpl5xxbw4tKCEWl2ibKhAkRxtXzBMubkTbG271kiAN3v5Ys");
            timezone.setCountry("eVCnJyiqeGItv307XlTDUEj4jzKmBBKR88Rnuap6CgBHyqYJhI");
            timezone.setGmtLabel("pXmfWqdo8qoFPliXCd82RNEDafI0j8ShwSvcxsxRSUFaipCm55");
            timezone.setTimeZoneLabel("5u5UwWqQYM4lSoBDpEkGI40Jzp2KkqWoLipt4vPirjNzoVInug");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("Ik8FCBMGqxv33WqIMgX0uhmeLipUh0rgvQnUiPw27ya7kKAfxC");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(22);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("eW21R2miph74aEQ9Tu30rV33FRl38ocgLjPrVIpLy2g9Ozzzoq");
            corecontacts.setFirstName("0jRfO9IM83bRXnsi3w0PMmWfdJT6aja31TG8utxfXlKw8WUBVA");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("FnKosyWRQ5ZYd3uw3jSZtcpKMp8XLlReKX02IZ1Z7MNFaREVIf");
            corecontacts.setMiddleName("aI0GlZUgxA5zkjbGWu3bowuH3E8TETqvTq12dmvBFEgLsZwxSW");
            corecontacts.setNativeFirstName("aYJ5IolpidhfJacbFO0QrRPrdzfDDkmzXYOzTiOLnbGWJX2vpf");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("KKxEFbCHjnAziSXw1O3ePCp2uDpyuSYPM6t3wRtxdntyLfCzfP");
            corecontacts.setNativeMiddleName("5bNuaOercNEESYBmFvFOUL6MsGgVogssyU8e6kCtkJZmVWG6HS");
            corecontacts.setNativeTitle("DzBihwTkV35zDPzeWWoztS2Ew5Z8UCIlP0yIjsHI7xs70GKpTk");
            corecontacts.setPhoneNumber("TIfbHeVNXfDuq0Pp366P");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("qsi");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ePWnB2dTGVn8CS6u1mhLlAEItxp1XbOpZWY7Fy3Y4Nhdq9Bm3H");
            communicationgroup.setCommGroupName("8rsAfXdtCxTt6zd3SgVyD0rO6G05xtrnaxTFhZq0eJ0w9LioqI");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("bXf5M8652kbqWjG7FTeanIHnoReiWq6cXAY03b5iglw5MEkcLh");
            communicationtype.setCommTypeName("g9vDHZ6Hg9A5BuM65amdorsqIRM6YRZLRJVLLUv6PyQMam8pS3");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("f5v");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("oAtmQtP1N601euxXVRUkBh4Gq4dLOQp6OBewcwK3QIjCajLRqx");
            address.setAddress2("qT4nSubOyf6LpezyGyot2K6lYqMqgQYnVX4pJaJjAQZc3FQLCA");
            address.setAddress3("LN5P2bl1Wmm5OVcdc61DX1jrDNCs29MQtUCSNpCe3OHUMpPDYx");
            address.setAddressLabel("LgH1DyOL8So");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("QfZRqe9gJdyIPbPZ3Nh3aS8tzgJWQwXwL5F81udzpV6F8Ar20q");
            addresstype.setAddressTypeDesc("tb4TYbdOvoQWHSBUIXqEGgokTnjdb5T2rbo9VICGASHWZkvWyj");
            addresstype.setAddressTypeIcon("MugbCRkZdGqCCVDypJCVciKtgmFcgR5EBLoEjeB92HVROf7pWq");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("mNOru7UuWm4NWly6RWxX1g60wxxPdJ6V");
            city.setCityDescription("ccTsqcFNDxXu25w2AvlUeDFPsuf5h4HKd5jHtjntJVVz9nDW9V");
            city.setCityFlag("LMNRVzfabFspDB5VGqbOAUDcJHcs50IahNe16hcFY60xb3P8RL");
            city.setCityLatitude(1);
            city.setCityLongitude(7);
            city.setCityName("Nss54G86KOHksOUfIVbmbvgQQNdnxTY8NCLrrXUM10st84XDws");
            Country country = new Country();
            country.setCapital("GwDKXfIy87iL790uLXbdy7wrrlTenrfU");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(7);
            country.setCountryCode1("nmz");
            country.setCountryCode2("ziY");
            country.setCountryFlag("4jSkXNwQvRLE1cdTvbV1uxO0JAUvE7T0bdMzHwIoYPUMldCxWm");
            country.setCountryName("Rg7unOcwLvpRtjkqNvnYUzftScPhkSqPinxbjm86ivDHOwVfmy");
            country.setCurrencyCode("Z2v");
            country.setCurrencyName("L2KhR85mGjYjPn0KzOPCSQkB9ezFxODADzLLpgBd05rkiFYaXQ");
            country.setCurrencySymbol("rJv8JfqjbpfQclnVAeflMqf1J8rZOmPm");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("CODYEpbbjwxwfby0bfrSp2ieGVj0LopiOHJLagMbbbLV5GvMiv");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(8);
            state.setStateCode(1);
            state.setStateCodeChar2("zmIvysgqNfLi30vGPFA3yrniQhppr7Ii");
            state.setStateCodeChar3("tWkqRJuTKYJhik2bWvu1zNuaHN1MDWgN");
            state.setStateDescription("d68LeeEnp24eeqgjVF9ngOxJDbgC5CXsKkyT9BGyQICvSYqgX9");
            state.setStateFlag("UICQ3lDrDvIDtkaftuqO6c0O8hec85lfWFENw2k0vxQiKDgWIv");
            state.setStateName("X0B78SH0Icq5rR7tXmVsId6rehMULsj39125LD8bYiMqWvO77i");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("fKbs3J4co2IfNMGaqrj0xFyHULrmYHIP");
            city.setCityDescription("FWuBXTF0zxWaD0nLPcr9M7lCCUEEjQEFP9z6V6B6MAIqzmMuJs");
            city.setCityFlag("kqCv4O9MVME00ahO650fJFGCf7ZYPQhMxDPjKPbkm9qHeHu1Q2");
            city.setCityLatitude(4);
            city.setCityLongitude(3);
            city.setCityName("WxUG3ay3R0cKTiAGh9bgG1AxOtY2YoAzR4aQO66NSQDaYL0sqc");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("moMRHbsSy8aFvPGjaQrZASwshZ5s2Z5JirslTYWKkZQos2Uxyl");
            address.setAddress2("arc27OXiXL2gKuRaVEmNpeh5aA5gVB7cSLrX92jQcfcMuGDHPO");
            address.setAddress3("VoVLSo8drWVJ7XHbDiw9e988fZ9c4yXnf5kR7Wyz4Su4SEKhqy");
            address.setAddressLabel("3MweiavpcG0");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("fDO94LWSgZ95RjWBXUIedrVd5gfPaKF1cx52E9TW0sr3hmCYPm");
            address.setLongitude("dFRtlDal53Pk1DqqACS4Ohch5LIRROxpjFXzj8EtDzGSxRZGoC");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("6RpoLG");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(113);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("pSlTz3usFDXcNvFSowDnycbalbqeCzbhmwi1xOv5I9S3bb7AUC");
            corecontacts.setFirstName("FOYCvC6OLhxmWi3J3KjDvJbXGvSKOvICvrABXxcLyNIaGtkOD2");
            corecontacts.setLastName("gy7UUumqakrj9zA5jyCdeYw62oYxCKFa1fn7YfR0dHET3x3mhJ");
            corecontacts.setMiddleName("2fTojQNcCYub4KfBvG42GSz81id42t4ufZKGqK7KyBvALTzNd4");
            corecontacts.setNativeFirstName("VUseYQ3m7DKZlWeKvk46EFHIIkklXzDIQMZcQp4MgRUb8UZpZg");
            corecontacts.setNativeLastName("lv3LVjqNi1wC8YUoTQ1L8WE6AIveoUZPiJIDrTn6bZYwZvDwrG");
            corecontacts.setNativeMiddleName("Ab3Vnr6ME0P6m2Gz8y5Q8ZISBrzgQRSfBWMj2fDgrM0gz5idoT");
            corecontacts.setNativeTitle("XnOKSMx8KbYAvXG8gTPeDSm3eQO9AGXKBTMjzUwyyeuJFKuxXx");
            corecontacts.setPhoneNumber("hq0B5guuKnUDwH5aNAz9");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
