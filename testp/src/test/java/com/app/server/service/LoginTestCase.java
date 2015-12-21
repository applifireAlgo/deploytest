package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(107);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("2TUklEcm7kMxjMvGnKR5I487Me4wtZnY8L7VkZS5ZKVC1t24FP");
            corecontacts.setFirstName("jwlP00FUgz3jnjSBKHat7wZVGZRCZDHxM5RFCTvI1ot0Re7VVo");
            Gender gender = new Gender();
            gender.setGender("TCkfonTBGcNKwRu5cyvQnTaz1m33FHSAGuVIAjoEh8KhDxooQF");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Ov");
            language.setAlpha3("hUE");
            language.setAlpha4("LHxM");
            language.setAlpha4parentid(2);
            language.setLanguage("ReF0dbJSMOpRX9HDws48FJaYqjx9p6r9tKmK5jyZ6qMPt1h5Kj");
            language.setLanguageDescription("pQDpYALKvdV6icWP5HtfYMlUKE6ZsxDV0MrW4Dm88p4Y06uRK6");
            language.setLanguageIcon("Ls0cnkzqCGW87FJUxGhzXjT3HmjClXfiIhsYfSpikJcJWI4qnu");
            language.setLanguageType("NXsULeXzOjTygzA1YBy7H40Mv2OKwNXt");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("JFkmic32JrDk33rhOLYl0TsEf5qP60yDV25La7elTzoHKKi4oM");
            timezone.setCountry("s5q9EebLeILpBYQL1625JiaNVKu6SXjUKOwIPF5CDbkciXUzAP");
            timezone.setGmtLabel("XYvP1SOAIbfH1244b63U1wEVwlgGDwx8syppbhZa6vZHmnDv66");
            timezone.setTimeZoneLabel("2ocjCRu9gYDUund2f6SOrQVDnHyuIVLtcc0kEFmP30uC127DmR");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("DhrP66EH8Heq0XzDX8p0ZJRxuupnjIL1AAr2szOwgn7xUXddZg");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(58);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ZWsVvSuE6vsIRd4ERVThvPOH2j96kUj294hvyn6wiRjpyBwVpb");
            corecontacts.setFirstName("0wGdrxItyuS6KJKrnnrnT7Synb2LJMUGxpzYcgw5IWDXM5WR0E");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("qdPat6NPP0JF75WaaqqicpsERdB92Nj122MyVubiM0aUHsUItk");
            corecontacts.setMiddleName("IbloaNoXJt0tItLXM154J5YFS1QRDbsVm0Y1ItkdhujQFFzwZb");
            corecontacts.setNativeFirstName("Ju6MJL7ao8qq1lyeOPrg3iaVwNT77ibPp84tD4zU3pwJ6q6TLL");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("ZlJVWvfvuCw6uw0uh6qAPT7hpczPlreBqSXiEqjceeHXzzN4vu");
            corecontacts.setNativeMiddleName("q1hAOzJl0PivoA5osSHpgedAyw4BEHiAi4jhYVi7NBVGc1sCy4");
            corecontacts.setNativeTitle("nuk6nThqdakkGxe1yq87H5uIeQnpQRMk3fPj2Io3kF1K4wfbaF");
            corecontacts.setPhoneNumber("oUetrG3OMMG4FcNwnUxr");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("19yPHQMsgcgVReDS57mtl8TudwQqixO9y8RQFs4b6tzfR5SBQz");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2982);
            user.setUserAccessCode(7);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("UwfsJMqX8CMubbhcg442gPGhAZbLUBwjjcKyRnxLvd9i0qjObn");
            useraccessdomain.setDomainHelp("FJTjPT7unraaHeJa4x7ZRclPEFBPPDVMaqacvdwsSk3JITIPUQ");
            useraccessdomain.setDomainIcon("1SqnX0oP9HPmcijLgbFGoJdSnsZRHrFcRHLSHoTgPjSOH3WwZm");
            useraccessdomain.setDomainName("ArXFuHsD080I6rDSEm5QJSJRPEY6VrMbLzt2onvBufVFZn2HNP");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("kJDlg15p3xBi2ZQc5Zf4fdzgGVckeAHAKBptCAyxNY3rlTVIvu");
            useraccesslevel.setLevelHelp("bngIjodADAcrt84K9J1HjKhf548S14HloAinPUxapqPa4IP9Xd");
            useraccesslevel.setLevelIcon("QplthcuLfMLKNiGszqk3U7hHKursfM2mMo8x6StIJHKI12Qq8p");
            useraccesslevel.setLevelName("zfaiA94iAAGRe9NMlrSuHOOG1f3OJgykjKnOjXfxgjpvp2CCJN");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("dNiUV6CAmiFMcYwcFkcThTB942Spnz4SSbTvRvSBHCEZ2IDO9M");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(100);
            user.setUserAccessCode(11);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("MuNW5R46OdplOn3ojnke6WKotNTcXvmzSmaUu8ouMurGKiYg15");
            login.setServerAuthImage("iVLTMgSEAyWphnwy9ta1W4gJ6jAdYmvm");
            login.setServerAuthText("rBe0QNVtKPUk9WjP");
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
            login.setFailedLoginAttempts(7);
            login.setLoginId("yfkba32dPG9RHCORVZAJ2XzmEZY8iHqyMXmS27B5ankq3wox1A");
            login.setServerAuthImage("NYWke9tnpCgVHPL1TBgpnNovWThV8iZX");
            login.setServerAuthText("EwOsyqIl1in6tR6e");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
