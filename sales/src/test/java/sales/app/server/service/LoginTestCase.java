package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.LoginRepository;
import sales.app.shared.authentication.Login;
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
import sales.app.shared.contacts.CoreContacts;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.authentication.User;
import sales.app.server.repository.UserRepository;
import sales.app.shared.authentication.UserAccessDomain;
import sales.app.server.repository.UserAccessDomainRepository;
import sales.app.shared.authentication.UserAccessLevel;
import sales.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(106);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("IZimHVp0M1BfFv1LAq5w4Pm7eeWc5gEQ4osMqaxdaPhuWLdJGZ");
            corecontacts.setFirstName("lZQOtDJ0dATFM2dhdyIEaYXfhPtGOXxZ8RkOQDLX9GWaVxYr77");
            Gender gender = new Gender();
            gender.setGender("XsNzC96e2IGsOWguEEaQkTI5FaWSICOgl3J7bshEzJlMgztWGz");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("pE");
            language.setAlpha3("zZX");
            language.setAlpha4("0S4r");
            language.setAlpha4parentid(8);
            language.setLanguage("nQwgj2x6FSiqXvYSkRFfB6AZKyIAubWBnQwCZO53h9EsGlOORX");
            language.setLanguageDescription("Q9SDEvFvG6lTrvfLhoXHJao88f4ba4AEDGKVvuFwJPPlTGLR5U");
            language.setLanguageIcon("bderYMGnQZs8PjEjqEHPVHJWNUoPwifpwEeT4fETl2J25fGeGT");
            language.setLanguageType("935QCTqKrrkdpkJkMB6yMVHFJR0qahRi");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("AYp2nCy2dyW4xn2QinLPbDxqOdvHU8TOxUegNKZmHfoYJbDl22");
            timezone.setCountry("cLhKHH5M36mRjSs3gYB6ci21sfZVz1wPRnna71D1JFUPqfIIBi");
            timezone.setGmtLabel("wY2GbHKtW4f54nK3hyOZqMLcXAG2rBbbFJxhC382T2leVjBQqQ");
            timezone.setTimeZoneLabel("s8dPVd6IosYPD1JNzbwBLfs16sb3NUgYEyytfbG8xkVIL5hB1l");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("CapVGYF4ADSUpdHvHwJyUF1TbO5TPE0uoaHi68ls7Js6Dy3QUO");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(59);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("eDkcnZZCUZ3N2WyAN9jbI1LC8qxYqGyPyymi5u68yIhdjqyWL8");
            corecontacts.setFirstName("KC9etotEb0fz9qwyAyWIuiX7YvH1iutFVHm3NI7sRqj4HxwRs5");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("3PmuDZsM6pqNAWNLYo5T7TYvq79AAo1QM6N9YR3sYzamOko228");
            corecontacts.setMiddleName("2Se24Frc9YYbRlXrdBKMDUKEu5XyZ1c0yjLiXesO2BXA5FDwvf");
            corecontacts.setNativeFirstName("9mcK8KaSOOjKu9XfnDupmiSwoVsiCHl6zYoyxheuy3M1KCKiea");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("XXgiYKXA5bskJvBi9ANr9YjqDDWgTIOuaLlOECLJTMl28oDW96");
            corecontacts.setNativeMiddleName("eqSkW0CO4CBDMO55uvohMprvHp6DZhp02y2a37shw1qcuUe8rZ");
            corecontacts.setNativeTitle("449aEhfrxeUv0aYQ7tvCvLbl2Td5Me9V3ThTj46FwBdD8TISL7");
            corecontacts.setPhoneNumber("ozl3ZYMImqIDS5bGX9Av");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("aVnP6mxPnqq0MqoX1Oa7rdQeyNUVkmfgsbekyRum89UruQxihW");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(150);
            user.setUserAccessCode(7);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("c9eXKYicnqWybr0MqjkaYvDWu3mKI57kTrMlGpQNYVnJzHw56R");
            useraccessdomain.setDomainHelp("BIdeYAP5hEABxzxvBuOzTrROR0CFeWiXB3dYDDM5VROtx1eRjg");
            useraccessdomain.setDomainIcon("WxonygYtjCB8DskvdAwS99uXd6OcYXhvLyEs9GqwTGkXbPdRo0");
            useraccessdomain.setDomainName("HTwLEtn4eBYgtIkdDcrNXbCP4rt45hzMynHIpIfKSdTGh3SeI7");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("aZrYhSWfDzDOy32xHaYE81tLBp6BaxaSPIHRCcShTzdk2wBaGu");
            useraccesslevel.setLevelHelp("35rbz5yaAURZnWGFNH3rvPDDL4VLJ9GRAfB4JJ8aDh4jY2vFNa");
            useraccesslevel.setLevelIcon("beLcHxfaxzpBzNwPiTu0lDC0FlwkwSIL3inYuxtjc3WjJEft9t");
            useraccesslevel.setLevelName("GBwFvU7RRb6ieglBow6NimqdzUjyp8foes9FYk7qKcNrwIRYYw");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("7bMbNPo9RMzfaCs5yomCFwrqPRTKd3QQusjlUFVKFBP2hrrTWJ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(822);
            user.setUserAccessCode(9);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("Eb3VlEgObqqePx8SFXBSOdww6beN1EZ4TCDTJifdwyZWjCtNPw");
            login.setServerAuthImage("g0ED6noVj5k99naQhBmI972jhaau55s8");
            login.setServerAuthText("vQvvTgkUup0dOXVL");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(11);
            login.setLoginId("jkDtIXXFvwywXxZjUlvg0fAO4Imdp7OqzP5K060dRyJISRYNtW");
            login.setServerAuthImage("qSdQn9PUckIK7POmAR9ZdrZcRkuQrfuc");
            login.setServerAuthText("iIAcepQhyAdfONFL");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
