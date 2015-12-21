package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("YacVBxwDYkFMjYu2X08dsjnZKE9I6ODRD0OIcgUujQYXeSCBkF");
            addresstype.setAddressTypeDesc("BdcjdiAjVPBzAltaCOllVDFDDZDHIs4IrQioteQScbdRGR5T4N");
            addresstype.setAddressTypeIcon("Z4Y1L11ZcXOCG1g9kBpUJfMTNytH0HTwkJ8nXa9Gec4THUjVcY");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("9ccLYPVYMM884TCLxV82KAfVcQCFZvev");
            city.setCityDescription("dM4Jp4DMJ2CtbepvXrhj2Rij4XuoDyaw2ig93XPN0u9JWgrXx3");
            city.setCityFlag("7TfAkg8G7mZW8ikE2WvpFbsHWmippP1jfsCwkECBc6cOe0n6v9");
            city.setCityLatitude(1);
            city.setCityLongitude(9);
            city.setCityName("0dg20Jip75p2iJm8KyMv3PC0XYr4OEg4rGdBAYj7RDFWgti3Ii");
            Country country = new Country();
            country.setCapital("MGuXOyao2R7a49BB3wPfFQiKttp1vKNm");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(3);
            country.setCountryCode1("bwN");
            country.setCountryCode2("wIt");
            country.setCountryFlag("W8jZm31MlE1lkfrUAzqJB5hnpKnSoA0PkrhJFXcFpmpuR3depL");
            country.setCountryName("fEFwTL55qqrLkn3H5QA1vvY0NgS5ww4lta6lLWvcs1YqiZ4yMZ");
            country.setCurrencyCode("iuq");
            country.setCurrencyName("yBzkRwiqTq3cC07ARi6bfdNmUP4snVWvz15JndCFvkIo8ji02G");
            country.setCurrencySymbol("BIk80Qm9aMJDTNndOC5BdoO5DstPRnxa");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("pr1nsntb3RxoXeeppoX7hDS94gGaWFB3TgHIf9fIiXcWvZjkhi");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(9);
            state.setStateCode(0);
            state.setStateCodeChar2("5VIABhHqigpcMX4uPsRgcNhRiAqMPVST");
            state.setStateCodeChar3("cTocHo9Kost111l2IfsFyEYGeMQdWD22");
            state.setStateDescription("mLxtclbPpMiVOr2xXpaomW9Lu91NibU5Wf3lVx74YopV3lxn1O");
            state.setStateFlag("TmSKvMPGeYtmDWyjevUsRQUMNKOgTZ32mrvrzGjEGsLYKY99mp");
            state.setStateName("qDYtquNxlxt6sun9p4IiFopNLSbSvodHffXI7jofHWmaFkIJM3");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("DyTsq48zDk1Yuh2T65WEqAaGJNNLqELl");
            city.setCityDescription("jOvNP2G10HCSqPfBGAoFamA9dTyrplZLklt4je4HDKMJENARLE");
            city.setCityFlag("WHu87pfW1qo1PBWjNgBKM5Bjj4zFUWEjG4JTzSP48ByrynRhvj");
            city.setCityLatitude(8);
            city.setCityLongitude(2);
            city.setCityName("YlXjqYPFuMRPDqMyaPODgRx6B1YIU63qTSKstf7bS5lBLwNrD5");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("Sd6W437pdd97mr0OzbPfgbdcEQkxa1CZov6WWjSCK9TKAUCY2b");
            address.setAddress2("zlPKqA26f0Jp5G6Yr6KeE2cI5gMt1T2YNAWUX1t6302O1mSnzw");
            address.setAddress3("wX0VA6aCZRFgbR33MRf1XVfkGjs3uLnPGMJAYnkqV7oTH9L7ff");
            address.setAddressLabel("hmoyRpwm4Gd");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Ayzy1pCVs5n0gPhPWgcZPDYNWIb8qCJPxj03H1wDo4AjFGZuk5");
            address.setLongitude("H0fh9GfFIuZra1N5vjBCLPwhBRcdxZWubAn5iZjcLUrJ40MNFK");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("3wZjEU");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("3ketwWCYupIKp4pTSzfJ0HQZn98PHaCe1bgybMRJfxh8tMy8Cj");
            address.setAddress2("gmK3o9o2nBFMA00eAqYEDk4WWXCzvcpA4i0sLdRqc6VF2fZbar");
            address.setAddress3("rX48efHmX8h4wYxXEpNeV63xoOceZIoAg28dYKKDpAq96jgUBD");
            address.setAddressLabel("4d50D48V7rY");
            address.setLatitude("U96XnZID3OWwcOE0kuDKHz378WvqnK3LTiiGPh0ARas5BDrgn9");
            address.setLongitude("3mSvKgflRCUhHSAD0TvL54mvR5uSlaWB4Eqz8gNqIkjkJ88Oek");
            address.setVersionId(1);
            address.setZipcode("AEouqc");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
