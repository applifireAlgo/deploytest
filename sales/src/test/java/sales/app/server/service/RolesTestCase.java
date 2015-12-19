package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.RolesRepository;
import sales.app.shared.authorization.Roles;
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
import sales.app.shared.authorization.RoleMenuBridge;
import sales.app.shared.authorization.AppMenus;
import sales.app.server.repository.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
            Roles roles = new Roles();
            roles.setRoleDescription("4kiiA07BjqY4nY0bguA2ITEheBK4vYgF7JnUmfiizIB6tSBYMY");
            roles.setRoleHelp("S2RfrjBBXFhjvqqq1NWQcYLm2VP4hKAcdu8HvOOOdTJTQiMxHf");
            roles.setRoleIcon("A2HCjqotCy0Xix8HQLOm3sg8rh9eAeuE0rVEuiZ7Tf0TciTKID");
            roles.setRoleName("6ZjjGxC6a5MctSs54GVSiI67YFh5jZykrJrVSn1O3VqMfZwxGQ");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("bQkQo1Alj9jzNu3tkwi4oChQ4K561neuui27qauYw5gnGBNmw2");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(2);
            appmenus.setMenuAction("J3kCmBppXwWBqB6eX8eleud9ZnLq3sXAnfqRaKRhm8wuWJXwJo");
            appmenus.setMenuCommands("vFSTiCY9tWNpyTbsa6myE8Xcr3MrhP7LinEOSusmjsh3Rviyvc");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("ISDGtigbMjTDvQtQd1xTAJXefP0xsE01UJ0UdDwdv3QL3tbpFl");
            appmenus.setMenuLabel("1LNOIdsKLvYR1YEE3q5cvmXUw4jSDdwlhuKmHEugGQO5jgucIH");
            appmenus.setMenuTreeId("AdCHyqBIF7B5Pv3agpOUfyWOazPaawobj8gICCDA0ZOO9JllYW");
            appmenus.setRefObjectId("gSBcgcitAVqZmaKA0kl9WLmhTUU759i0GTeKMOWXqu1q1a8Qwl");
            appmenus.setUiType("1a1");
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
            rolemenubridge.setRoles(roles);
            listOfRoleMenuBridge.add(rolemenubridge);
            roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.setEntityValidator(entityValidator);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("VaaTWr6R0DjZZxLAqrJAk5HRaFwiGrWOodzfoWZIiaBzgSFUm5");
            roles.setRoleHelp("ljwetsSE1qFrsrOGwfT9arFjxj4BLYcLlzF26IdzYZFNqHlaKV");
            roles.setRoleIcon("L6v05FW4tQWRo26xi7Q8P5Zhc3IiFR9GxaQ5mJU0Mf3c6lxUuU");
            roles.setRoleName("YxCx2Ms1oSagqbX9cmJ0M4IlX1i1zay7zSa10rgUwAC6an1VAz");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
