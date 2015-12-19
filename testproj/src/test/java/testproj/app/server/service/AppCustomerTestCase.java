package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.AppCustomerRepository;
import testproj.app.shared.customers.AppCustomer;
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
import testproj.app.shared.customers.AppCustomerCategory;
import testproj.app.server.repository.AppCustomerCategoryRepository;
import testproj.app.shared.customers.AppCustomerType;
import testproj.app.server.repository.AppCustomerTypeRepository;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("tcDDLvxmNBguSC6h0VXeKNi0HklMpHPwt2S19EH6uaft0Di0Os");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("yxx4d3tIr2DPas0dzWCrPN3Oiqyc3sIdbRaQwgbfKHk4e2N7Ob");
            appcustomertype.setDefaults(0);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(97);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("x6mxd6TrSCr5jRr5cN08ETAZ6aQGkquzOYKC00GcEUfcpwz6ed");
            corecontacts.setFirstName("WfQFldQDT4MlIhS4to6SXG8kq6u5HqefvGuKO6DzusjcKGcPwF");
            Gender gender = new Gender();
            gender.setGender("ANlJuBCs2uOVeKgeWRHtG0di8SytuHv4ODNYuf5F6SHJN6tsV1");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("hj");
            language.setAlpha3("xmD");
            language.setAlpha4("GxZd");
            language.setAlpha4parentid(2);
            language.setLanguage("elVJac9ufRuMg7dZzHMIHymOjTgEkKIgGTpNRPitUR9t7kgwvg");
            language.setLanguageDescription("urI8EU9ryCKB268OY5kLevnloPseMg8MGxKZSvUWmhoGpiDzkO");
            language.setLanguageIcon("NMEWg1xsQfb0r2Qbrzj4z1zh7hWDiPduOSYmsEu393Q9y4oXJ8");
            language.setLanguageType("yqnlin7moHft5DV4qIFIgshHdQcmKAVt");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("PKQTJqLf0KjNO5y4IXipTBdkm59rp6ZaJaaRWRUzkNAhcyuQF6");
            timezone.setCountry("7vYP8kBXQDFqOBkbZaBemDUe4RK0YA97s9LV2bpN1DR99xhOBF");
            timezone.setGmtLabel("gVE6rT4VKy5u8RjghnxpGbs1VwbcXcekb45lEjQlWSDrHYV703");
            timezone.setTimeZoneLabel("4m58tmU6BgQSrzkJssI6MJfkvW1l8RUTiOD7fC1FAfW7cTlsQu");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("ZrbDTe4T3AJBw1qw9ZkeZbYiLUhQxdRq6z1HMYBqF09air1x5p");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(41);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("VFs5t75D2nEWXMeBWnScbudrzb3xsR1Q8TbCKIea9z4xGVkhoo");
            corecontacts.setFirstName("tyVSe9zrNYutCJAwjuBtvxVVETXQSt9ffF6aAaBkzChqQsRgcP");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("mWGQq0EmXyl0CmG1c95mlC6AhcSGe9OzfhnYyDRbeuc2sAz0xH");
            corecontacts.setMiddleName("F5qcAHAcYxIAC7RKc2fRJNclWOxr3l8ySPu8VwBJ7F9Jr06t8l");
            corecontacts.setNativeFirstName("ddNJqFVosUW35gJWpwRWml3CU4bbDShfyvQOgOQkMpdwluyhBP");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("TNIX8C4lERuslSV0VLfu6Dsq8VYlhSXiJAxVTGg6bRWBhuBf1N");
            corecontacts.setNativeMiddleName("bsGCZCdMvRFlQ2BjTInkknJLsRJ17hny4lxbkTiSKYes05pvGK");
            corecontacts.setNativeTitle("cMe9BNh67VVxPaZIXi5VMQpV8afM0b9IMICUyBITTjFjEB3kIW");
            corecontacts.setPhoneNumber("dX36LRfjChy3VjlzRdj3");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("ylzGy2hEGGESCyGnWe8AnxyhLdmok1Smb1Giji9wlzONjGXxeE");
            appcustomer.setCustomerStatus(0);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("RQ5aTI6tg3ic3ZNINJwcm5MNw5ujP4vtUQ9Rar2tZ2BK8JAm8X");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
