package com.pharma.app.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pharma.config.HibernateDBTestConfig;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.User;

@ActiveProfiles("pharmaTest")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={HibernateDBTestConfig.class})
public class PharmaAppTest {

	@Autowired
	private PharmaModel pharmaModel;
	
	@Test
	public void testAdminLogon() {
		assertTrue(pharmaModel.isValidAdminLogon(new User("sandeep", "sandeep")));
	}
}
