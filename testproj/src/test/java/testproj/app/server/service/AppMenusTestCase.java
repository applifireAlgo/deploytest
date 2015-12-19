package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.AppMenusRepository;
import testproj.app.shared.authorization.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("TSsxhJJtkfmmzH9sREuKzNnVd49qkImmSIoeOQhjLmQTt8mDeY");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(10);
            appmenus.setMenuAction("JYtxCo770NL5CD1RwnAdiuJ6R8YJ5SCFlIIAiIYwlCzeEaIzx1");
            appmenus.setMenuCommands("2gQHU5OIkAaHZC8nTUhvuEZ3hngJTZ5N58L8oFzhyAaEDaQJcI");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("bV1EnRy7ekaFvfO7rf1U1LckcvWgYbizfo5JLBp1A9fVGEsn0o");
            appmenus.setMenuLabel("Lfnnh2O2yrvybxkGqlUHDn2BISKFo7aBnJlaBqu9FHyGqFsABb");
            appmenus.setMenuTreeId("E9JFvzx50bJJILhqbgVd5YDvV8Cv1OYDIBMUF9MyErTVHTmuGq");
            appmenus.setRefObjectId("jll8AqCXOCil0RRVLMO27woBRDm3WwlTqbfmmMeXoLbbhLcMEv");
            appmenus.setUiType("37c");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("koAH127oWg014OxO0c3UH2MKIMRuVJNNXoeg3QT8NYul530pU4");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(5);
            appmenus.setMenuAction("6dum5jyrx1AO27gscQRsR5A5Pt9jexdI28FF0cFbfCEyMqUhla");
            appmenus.setMenuCommands("yHkGDwVey7qH7U40CLBbdSV9WvXLX6HqWXdP3UnfVS9VKo52Ba");
            appmenus.setMenuIcon("63CNRNqusvmeTHbIOATNttkpYHzwWMKuOLzWdlaSnE8BSBiTx7");
            appmenus.setMenuLabel("qgFJr7HlepZKdjHx66zUAhWPqtZbzR46j1bxIgeGK0LDhgd9CW");
            appmenus.setMenuTreeId("z3KPKpZG2mb2LvlUMM71msvHlzGdFEkEvdJ9HM7HGL4AxmyApW");
            appmenus.setRefObjectId("NNp8Vq1PKOpJX8QPnY5ktnaBsAGS9YrKenuYshkvPehA8NESua");
            appmenus.setUiType("1Tj");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
