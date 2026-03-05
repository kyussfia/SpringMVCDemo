package com.kyussfia.demo.controller;

import com.kyussfia.demo.captcha.CaptchaService;
import com.kyussfia.demo.config.SecurityConfig;
import com.kyussfia.demo.repository.GroupRepository;
import com.kyussfia.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

abstract class AbstractControllerTest {

	@MockBean
	protected UserRepository userRepository;

	@MockBean
	protected GroupRepository groupRepository;

	@MockBean
	protected CaptchaService captchaService;

	@Autowired
	protected SecurityConfig securityConfig;

	@Autowired
	protected MockMvc mvc;
}
