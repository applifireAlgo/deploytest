package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.Address;
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
            addresstype.setAddressType("9z8mzJz0VRUhA4Jmd6feQtDjUbb01PYPT8U42ct6hIhaQ7PO2S");
            addresstype.setAddressTypeDesc("bEjYkhjqVxmii3GpnVExSzcCYSIEtA9APif7EkBh0bcieLl4eH");
            addresstype.setAddressTypeIcon("G1OQ0oe3QZgeQMmNFS5GnQcz5JuJK2qKy38zglibs50O2ASULT");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("sSEuhjNlgNW8YfW4tY8t2BAP1C19uyxj");
            city.setCityDescription("u3J9FD9qUV8OvveaUVFOi1H6jsyBVyq9fVPuTQpGuN0HFVAcJs");
            city.setCityFlag("rrVzLHkWRrVvkfpC6TQ8RzxTdYhBPwglFHfKox9iSSvOT52Cjp");
            city.setCityLatitude(10);
            city.setCityLongitude(10);
            city.setCityName("bB189tNnyyxwhSUu60sfL6CUSaz62pdbQB9vc9skugGXTrw3ac");
            Country country = new Country();
            country.setCapital("MGUEMFMT7bbpGqUexnFZHhC0HpN36s6d");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(0);
            country.setCountryCode1("nlG");
            country.setCountryCode2("bzF");
            country.setCountryFlag("HnehzS2CHaDtwEvw6aLQU06PDN38C4BIUjtUsatxJe5TcOkbHk");
            country.setCountryName("KgvHUAC33AjsPxbry28bR1TE9PbREiLlu56BTiYdT2zNzPiXHU");
            country.setCurrencyCode("DEW");
            country.setCurrencyName("OvpNSVVFffmVq9orzqNMYoAVS8zJO5j7q4g4TOPx3awF0eOKBn");
            country.setCurrencySymbol("4qpkBn7bxBC7sfF0WBT62hsaX9ckQBIW");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("BubUIKryLtrR60dfJ1JMU5hiZlhlaKvHSLfuBtmEdKL3MigRv2");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("6ehFa83BkRBPYPmT7qmhE1VrRvS91I9F");
            state.setStateCodeChar3("D8dIlw0qSJZS6XOPYMg0rW2fLXWn0XMv");
            state.setStateDescription("DGBkw4yNw42VtI62QcAuBh21eLVDGyRI9IkFcOTFvyjl5rE70b");
            state.setStateFlag("dhjFEp6sXbhyg8xn2Ll1oXi2ypISTlY26aYcJFYkMqRYtAtvvX");
            state.setStateName("cjeX2UQHncEgDLJpUmrs31hqzT78eOUM9fPRZwAb029U6t04U0");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("zcyjhargEIs13Tggf0h22KEogkleQjNx");
            city.setCityDescription("mLoiKGUXqCJSUg0JwYOnfjfeEHodNMp49mdNrxFSnkCJEYGeeO");
            city.setCityFlag("jw8odJugsu8COnUsHd2T6QoEKvyHp17OfCtuQglo5Pmsm6NdTW");
            city.setCityLatitude(4);
            city.setCityLongitude(10);
            city.setCityName("ZSW4lByAX02vlyu1TjBKCdPoHbFiGbv4xyVKiZ7R8oHYm5UNdk");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("P5BnvlBEKpbbFuaK3n3rrszIqyU5RvHvs3z88xp25IIOTjZ5RS");
            address.setAddress2("XXHC4kQUAcfgX8OEgnISOF4SaTUFd6DxiiZazQt5ZzgDspdQKJ");
            address.setAddress3("Z4h2sL3Hyu9Wp34mHa0GBgtxFggsceR3SVlslSdR2qOvMiHked");
            address.setAddressLabel("z3dWx1txXx9");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("QdkwTnJgr40gAXAA4mQpC9KV1SA3iU5kBPMgMYSJ3sHjpU7ZmB");
            address.setLongitude("HZilQSltsrlndylLwNirnJFCQn3u5h5ZftQCoP50B6f7p7itbc");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("8swRW0");
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
            address.setAddress1("tviGoovpW259wBzWEBrxpCJUWtWLD3tl5VBqFX3BD8GQUwsdpi");
            address.setAddress2("thsVj7WNNDmOKqbX7YDDMMjDPVIollCLjXcoeIV6niVECNyn2B");
            address.setAddress3("Ixg9Fis6EruncgXYMfK4y7oEC8ABRrAWAcOY8PYL2BVxbJ3WYd");
            address.setAddressLabel("wSfxNMtcuY9");
            address.setLatitude("6C0r6ZyxqXtwJ3BbvlxEJXuHcZa6KAZxMPueYvWFJraE1X9Fix");
            address.setLongitude("NIXDy4ISkX7JdKdbRqFC41GfEbWMmfYeP0BpHpnMWlZUaVZMI6");
            address.setVersionId(1);
            address.setZipcode("2VJK9c");
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
