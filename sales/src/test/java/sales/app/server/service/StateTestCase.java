package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.StateRepository;
import sales.app.shared.location.State;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

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
            country.setCapital("OvWidyk6l0Ebgr2BHKSBsoYue0bfe0L5");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(2);
            country.setCountryCode1("btO");
            country.setCountryCode2("6CS");
            country.setCountryFlag("ZPZsFQwE2CiiswJyTuClXyyLLJS6tPezUjgzYYicX5regtpaVd");
            country.setCountryName("x9KoqDMPUgdT5aa5vjqrL1Z1zCEroVD0Km2ZVmJdGnh1h7vylQ");
            country.setCurrencyCode("kpv");
            country.setCurrencyName("UcvT5tykUi8P4AzlnewdY5folnkKE0GDsvx71bW3qqj1uvqoe7");
            country.setCurrencySymbol("PS5dRAF6h03mdzTpARN0UzSUG0SBvMRe");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateCapital("kMqaiBYUCkJDsRMFzWQWqS0Qin58FE2fCH9LoT1FRBRpJ7HJp1");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(10);
            state.setStateCode(2);
            state.setStateCodeChar2("I7mLdDqoc0vpf4gQ2qzMP76CH9XjMLJh");
            state.setStateCodeChar3("xZOKkQCwNeLWtSl8NVCmvErSbeehLezv");
            state.setStateDescription("4eXwEDUdQiYAIZUg0VptHOoRyEcJarR1F15xuIeQ80NXzcfSGQ");
            state.setStateFlag("iMEmVBBVZto9kFgvCRMmdpjGcnPQ0txmv3LGwvcVYZFilmFJBr");
            state.setStateName("1qPlhOp8Zbyj5YhniNa0a15iwOHTQsMjUKuRquMreZM1FRLK4W");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("m1XhAI8ZJNH1PYIfNQqf5JCTPi4ZAzH5PAgRI0o0B28AhPo7Pb");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(7);
            state.setStateCode(0);
            state.setStateCodeChar2("Z9z8S4qbsgWGds8WPhZudyhlkyMMbWL9");
            state.setStateCodeChar3("typjbOZ3ibhjhyd0N90BrY8dzH0yyucD");
            state.setStateDescription("zfNqoapKWaraOSW5f33BR9GDtlMUvhKrl115GFT5YaD74M7vhK");
            state.setStateFlag("CjMvbHJJU0E3Wh9ctM99j4vd0QkJKZ3wZu9epHu46U3iAchcrK");
            state.setStateName("aUSmn1Vz7glP85yMVeBQwKIddibIFHo5QHe2BZ5qADSqe605Eq");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
