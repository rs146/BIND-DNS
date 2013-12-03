package com.blackcrowsys.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.blackcrowsys.controller.admin.AdminController;
import com.blackcrowsys.dataaccess.user.UserDao;
import com.blackcrowsys.domain.User;

/**
 * Test for the AdminController.
 *
 * @author rahulsingh
 *
 */
public class AdminControllerTest extends AbstractControllerTest {

	private final List<User> users = new ArrayList<User>();

	private UserDao userDao;

	@Before
	public void initUsers() {
		// Init. users for mocked userDao
		User user = new User();
		user.setId(1);
		user.setUsername("Rahul");
		user.setPassword("Singh");
		users.add(user);
	}

	@Test
	public void testShowUserList() throws Exception {
		userDao = mock(UserDao.class);
		when(userDao.findAllUsers()).thenReturn(users);

		AdminController adminController = new AdminController();

		ReflectionTestUtils.setField(adminController, "userDao", userDao);

		ExtendedModelMap uiModel = new ExtendedModelMap();

		String result = adminController.showUserList(uiModel);

		assertNotNull(result);
		assertEquals(result, "admin/list");

		// users set to the view through model.addAttribte in controller.
		@SuppressWarnings("unchecked")
		List<User> modelUsers = (List<User>) uiModel.get("users");

		assertEquals(1, modelUsers.size());
	}
}
