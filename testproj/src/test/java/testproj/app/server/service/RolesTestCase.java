package testproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testproj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testproj.app.server.repository.RolesRepository;
import testproj.app.shared.authorization.Roles;
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
import testproj.app.shared.authorization.RoleMenuBridge;
import testproj.app.shared.authorization.AppMenus;
import testproj.app.server.repository.AppMenusRepository;

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
            roles.setRoleDescription("ZJgtDrnnAeQF9hvv1y52GrlwmSjBNV0cGMor6MILBhGG2NoY4y");
            roles.setRoleHelp("Etb6KEjHyX7wYFVyCG4oM5puJsHF0F5iPXj27N65VTTXv0W5p3");
            roles.setRoleIcon("dQKPs7PXgqLQ4S17RwA4z1vKpxDtjUJmTzTmQR5uNctuA4R2NQ");
            roles.setRoleName("bZNJRjm9yfTF1Xy2Zvgb6aSM4Jv3k60jtC6s0Cpq8PUPIiHW5Q");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("8rprrsAYYlex0VO4uVsvQyKLVOhZTs7rPopSWl0TR5oKopWokK");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuAction("ixgfE1IRnsbxwGLbVO1gIWcGvm5gMwEnRPkyuyH8QUXMiI0klm");
            appmenus.setMenuCommands("YSCWfmQNLZluqs5TXOTYLzHWQIIiofcv0czgYzuYuXrvYhI6Re");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("aI6s3sr5LMXxzoctjScJHKsZDbpeXK2ANQaXrOqExaQ3fgwGak");
            appmenus.setMenuLabel("iPYRp8R2flYx3PJmFCEwE3wFGfnOtoy3i46nYB2v8PwHMh6Fex");
            appmenus.setMenuTreeId("OQEnu2dpBwX2rlnd2xuXEDxZE2t7uKrO2uISHXxd4Eh9dVAPpy");
            appmenus.setRefObjectId("MHgacN7AsDUFG9bBt1eKgK3QWo4lgqr6loFUb04Btyi2gIowsT");
            appmenus.setUiType("NvY");
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
            roles.setRoleDescription("WLjlmpFzIX2r4tCpyFFQJiYr1oxl3G9mQl2t4EqFbBso288Qpp");
            roles.setRoleHelp("WvrqLT6WCJWpl8Qoe4sb8fWLlmY7Xu87TUJu1JWcsPTPrVR6vy");
            roles.setRoleIcon("BcOVnJ6Nb3CO9rwHOO3JrtC5fiRrlUDO9Nbt1dR3l2PCNs8Cj4");
            roles.setRoleName("qB6uPYhgcksJWlzXV3IoDUznKoqsuXr7GSvHFrGPSSEwUSp6cZ");
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
