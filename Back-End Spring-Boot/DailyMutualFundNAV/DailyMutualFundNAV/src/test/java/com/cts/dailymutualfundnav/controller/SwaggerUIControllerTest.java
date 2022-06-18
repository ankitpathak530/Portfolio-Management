package com.cts.dailymutualfundnav.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootTest
public class SwaggerUIControllerTest {

	@Autowired
	private SwaggerUIController swaggerUIController;
	
	@Test
	void SwaggerUIController()
	{
		RedirectView redirect = this.swaggerUIController.redirect();
	    assertEquals("/swagger-ui/", redirect.getUrl());
	}
}
