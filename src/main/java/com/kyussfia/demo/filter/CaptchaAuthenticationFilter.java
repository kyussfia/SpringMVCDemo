package com.kyussfia.demo.filter;

import com.kyussfia.demo.captcha.CaptchaService;
import com.kyussfia.demo.entity.User;
import com.kyussfia.demo.handler.InvalidCaptchaException;
import com.kyussfia.demo.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final UserRepository userRepository;

	private final Integer attemptsBeforeCaptcha;

	private final CaptchaService captchaService;

	public CaptchaAuthenticationFilter(UserRepository userRepository, CaptchaService captchaService, Integer attemptsBeforeCaptcha) {
		this.userRepository = userRepository;
		this.captchaService = captchaService;
		this.attemptsBeforeCaptcha = attemptsBeforeCaptcha;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		User user = this.userRepository.findByUsername(request.getParameter("username"));
		if (
				null != user &&
				user.haveToAnswerCaptcha(this.attemptsBeforeCaptcha) &&
				!this.isCaptchaValid(request.getSession(), request.getParameter("captcha"))
		) {
			try {
				super.getFailureHandler().onAuthenticationFailure(request, response, new InvalidCaptchaException("Invalid Captcha!"));
			} catch (IOException | ServletException e) {
				throw new RuntimeException(e);
			}
			return null;
		}

		return super.attemptAuthentication(request, response);
	}

	private boolean isCaptchaValid(HttpSession session, String userCaptcha) {
		return null != userCaptcha && !userCaptcha.isEmpty() && this.captchaService.load(session).equals(userCaptcha);
	}
}
