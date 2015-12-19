package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.AddressRepository;
import testproj.app.shared.location.Address;
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
import testproj.app.shared.location.AddressType;
import testproj.app.server.repository.AddressTypeRepository;
import testproj.app.shared.location.City;
import testproj.app.server.repository.CityRepository;
import testproj.app.shared.location.Country;
import testproj.app.server.repository.CountryRepository;
import testproj.app.shared.location.State;
import testproj.app.server.repository.StateRepository;

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
            addresstype.setAddressType("9x97RZbb25fE6aVW1e8NsNPICq0wjFlwWyPsZvqzocu0HcFZwA");
            addresstype.setAddressTypeDesc("tMtxy6V85SiPBW4GeK5rQ4AgujyGd04KxxZp3tHfzCZ5DBaIPc");
            addresstype.setAddressTypeIcon("thmiMbiWNYiJ1lsNw4s35jD9Sdep1ltbNXd7NDKz0mIAdj7NAB");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("0827mLeRWWb54W1ZKROsYEK7dZQBkSyo");
            city.setCityDescription("L8N4SoEMOOpPL1OmqmUFaY1T6iTtIyyBZGwy4X8QwLWqFz61K7");
            city.setCityFlag("4IAfOONlGpFfuNbqMxrszaC5RGSiLW7QnE4pR1KCxhlW2CXBsH");
            city.setCityLatitude(4);
            city.setCityLongitude(2);
            city.setCityName("g3LQqpJOlfVF7mycuboASzbZA3Qmb8ZA0JwYOBQUh1oBI8dK6D");
            Country country = new Country();
            country.setCapital("1XtDibw32OTZRXinYPHchtzReiFcQrPd");
            country.setCapitalLatitude(2);
            country.setCapitalLongitude(2);
            country.setCountryCode1("j4i");
            country.setCountryCode2("666");
            country.setCountryFlag("u74ss1uorGhC4urZZv9fx1jdoGQi0HMMlo9QWLYKA6Rknom1FF");
            country.setCountryName("XLCiVTkROfRrmk4WDnvlz7wM84okuwcLgkO4PBLAhmHdvEhZKg");
            country.setCurrencyCode("Hpk");
            country.setCurrencyName("LS80Hbw8VZIlrLEdyG9XMllxrnSvssNCQKiju87uQpcrkh8RkY");
            country.setCurrencySymbol("NQ615EuVURqA3aAIoxmm8303uUgnY8eS");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("miAlptt8K9EuncIhsuvh5Z5xXNEJngSnrRIhgQfrKhrIDY5rwS");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(11);
            state.setStateCode(0);
            state.setStateCodeChar2("EfSkr8x3LPbDs19PjjZFm2OClMRuXfvx");
            state.setStateCodeChar3("1NaiXXxkCdKW8PO6greS22LnNAnBLQzE");
            state.setStateDescription("FVN3z4RL89hLDZDCOszKlgkMxoZido97el5m0kSHY2fmTrpFie");
            state.setStateFlag("Z1o3TUGJAYS6yQfvZdolJiZei8xneIANwNF8d4GVsrALQaG3QR");
            state.setStateName("DAIXu7aBu5s4oIyPHezzNSLtA0qKPDq6XfPpK1C32uizPUfDOw");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("nZ7XlhZc3xqXS2vhxvD8LEnZdTfEFiai");
            city.setCityDescription("v2FGrYHPTNMdOqJrasHgL4pEmt0rXhImc9sBZzJFaChPsmJZeN");
            city.setCityFlag("J42276xzt8QwcEbI41BShaImgbKTHm2Y9Al8UEg9RZ91MAIew6");
            city.setCityLatitude(4);
            city.setCityLongitude(3);
            city.setCityName("OZseRi1lrqjmwefosZygAwME4fCrtZZ79i6yCz2Hk9F5IT4O2C");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("EvICL4kIWPzrnMcdlEyDP29SVtWQTe3V1Gb4hEtNLX1ydSi0k1");
            address.setAddress2("nb7p6YuEM5QxH4NkHpyf02IDmXuTf05FjQaa35C4Y4JRcEYyuB");
            address.setAddress3("tXDhFAodXxa9C5zHbpjXXKzpfsJpDItdnliKdsNSUsfVFErHBQ");
            address.setAddressLabel("Vm3XpmKkQFr");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("7HI6QeseMETzzWs0XyY26wGw1kM3rfWmzKlZqPAevTUwSqaAn5");
            address.setLongitude("Qu2vtQDr8Gk8QPyxoQXKYN6AAE5EJNLjlG7VD1kT7HmK8OZAob");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("7XONb4");
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
            address.setAddress1("Y1haLwI4TsABskvXOyz3XpavIcVxUh8r1zccG3vvFcRjQdzqZr");
            address.setAddress2("t29JrW49nQaQQaNoaXFqGDV2kgfj0hpPsly5V2ckrEuZOAIbsF");
            address.setAddress3("861xyQsHIIjKsiiQOOhMhQYJsqMZXWnkstbyfjLg6m33ryAgKR");
            address.setAddressLabel("yJz9R04mf4g");
            address.setLatitude("rv1BYX69razrxy5plSda38TwjCimx9itwAecL71TmUzGirxZ5e");
            address.setLongitude("h1dfj5WTk9Z9Cb5dVFvWWMw0xu10wCzBYIrYqCkdOPuGMgLwpF");
            address.setVersionId(1);
            address.setZipcode("Tvg5hX");
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
