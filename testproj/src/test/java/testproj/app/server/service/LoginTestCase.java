package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.LoginRepository;
import testproj.app.shared.authentication.Login;
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
import testproj.app.shared.contacts.CoreContacts;
import testproj.app.server.repository.CoreContactsRepository;
import testproj.app.shared.contacts.Gender;
import testproj.app.server.repository.GenderRepository;
import testproj.app.shared.location.Language;
import testproj.app.server.repository.LanguageRepository;
import testproj.app.shared.location.Timezone;
import testproj.app.server.repository.TimezoneRepository;
import testproj.app.shared.contacts.Title;
import testproj.app.server.repository.TitleRepository;
import testproj.app.shared.authentication.User;
import testproj.app.server.repository.UserRepository;
import testproj.app.shared.authentication.UserAccessDomain;
import testproj.app.server.repository.UserAccessDomainRepository;
import testproj.app.shared.authentication.UserAccessLevel;
import testproj.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(27);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("it2Iole4J3WlYZicxRAIvZIcVen9pf51wf5J22LWFCauDZOQKe");
            corecontacts.setFirstName("lPzXFOT3xkHxI2jNMbqDUrewi3UCSPW3jJDZzHmdCyOi69KvhY");
            Gender gender = new Gender();
            gender.setGender("b4MOP8xhlWxTCRHZeuUS2XDcHT7NlY1h0GGLUe1hZz95VjyRCw");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("82");
            language.setAlpha3("zhs");
            language.setAlpha4("1y27");
            language.setAlpha4parentid(8);
            language.setLanguage("HuaNLf31gCnZ8S6agxOhKeiYucQzmgIoDbJjL76EKk1u9ZBR99");
            language.setLanguageDescription("rHQNG0n311ZO9TDC9ag7QFJyAOrpnadFdCUvICbkTsKXMDxrrf");
            language.setLanguageIcon("bQqOsyV1CeLb6yHA6UMj7uSeyXQh8F7iHMOwkYmrmyoLRclb3G");
            language.setLanguageType("znxJYDsMRcV3dHKIGgbiBWrvk6CKRnK6");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("GEcAoNQh77f5Lvxam5ykrskYMStOCYBC4LfHXtn2pRPfNglwfJ");
            timezone.setCountry("2e6owMVGCj7qRFZGSOHDKt7MCPzEw8ZYVk3q0aMgxgpmdIu1l9");
            timezone.setGmtLabel("7Oije66Fg2lPJnfSrQQDVSwtpF5bREeP5lMa6X5su0vOxoLRL4");
            timezone.setTimeZoneLabel("jqOip8Ke53oFWOePOnLpod2fWmO19TEcA8BEftH0BXd5wfSWPM");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("kaNg1IimLLTLcpbKgP8aSJ6cMmntD4ORSourCX4q7YiVCUelmc");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(56);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("qLhpAzNNZt87aXW2UfzEokwIc1gPokoPRBv0OdvdAUokIwz6nO");
            corecontacts.setFirstName("9FfmlPZkfHTUesE5Vl0W5C8Gbi5PKDKf2GSawXhhhBJFBTbWZ4");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("rwJKThJ06EIyCAeKF7f60UEKzRcSF04CFpLngC50yulKP5uwfO");
            corecontacts.setMiddleName("OBQuvw1EPKZmZqNCkH3sw1PUEgJQTrTDW9K1RVrEl0RubN7RVG");
            corecontacts.setNativeFirstName("Wi4iUgOH0lKZudVBDiZIAb41pZBgNkSp2v6HzSxvuqG4oEwQB7");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("GfZWTT6ZObaTWQZNdWN36dYDI7lykKTZQlscD93rtFTno53LUm");
            corecontacts.setNativeMiddleName("XecoWHFWSiuSVPgCqQHLtKvHE6BE1jIPdxl6dGEYxhTL9lCoG3");
            corecontacts.setNativeTitle("scAvR4R4pnIhksN4lhLm3eVRoPW0Qu5EEmJsZ9PtHHirQ278Xy");
            corecontacts.setPhoneNumber("tLtPivLrB0Rbfhs4VM52");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("82UAhmbjwItL7dQXMnLR0x7pLEoBKYtaxnfv1x2SVYS2kjwXno");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2251);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("VsEiE66nTJeD7A7FbdafeKrdiClvEEW24ss3rqWD2yRGvNqEsA");
            useraccessdomain.setDomainHelp("6SFFgU4tAXRINjX4zjxcmGw3DyQ7mGTyRO69EMOYZrBs3m088d");
            useraccessdomain.setDomainIcon("51a4uLcVxL98oNysMucyC9m14PSEZq10wrz85ILbrFixgGbExZ");
            useraccessdomain.setDomainName("jZrIk8jorPjmSKVtyg1qy0ZS4uOCOGgZL6f4JEX1vqsZEcwKFN");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("lcFgj9XyClMjomPiClxzQz9pUbLoGo3J1HX90gKnn1dj9UbIyh");
            useraccesslevel.setLevelHelp("JnY7cTNMDiOSnH41iVfRsB1jX8GWsnFq5YCJCzVfIpJ1XQuI8Q");
            useraccesslevel.setLevelIcon("1x7tRX44Qnh7CkjIehg62zMhaDoHAzuqhDkwNnxKqLlX7rABBW");
            useraccesslevel.setLevelName("vNpkWRXMxvBUYzdVwJiUyvRkkZAba5yvbLIApPRrjbzAsbsGmK");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("6mQVPRwpwgOkDIfBuXxo1Gvg39pKMc5JMoCD1VJLbEeECcP06j");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3588);
            user.setUserAccessCode(2);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("GbSleCeWX8kVNFLllMZHJxkjuPRfwVpDYcqzNvw8iE9yLLaBTf");
            login.setServerAuthImage("9fkH3anpomhzPek5NYAmSOITB2b2XTch");
            login.setServerAuthText("qhOL0NFPgdRhSU4Y");
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
            login.setFailedLoginAttempts(4);
            login.setLoginId("5lfHgpOmxaJGB6qBYSVJtAjcM90eLXysyaZ6U5jcoSaz75l0u2");
            login.setServerAuthImage("yRKordf1xg3CNu1piOv9cGtRLQEps71u");
            login.setServerAuthText("AEtOZzwBxvX9AZZh");
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
