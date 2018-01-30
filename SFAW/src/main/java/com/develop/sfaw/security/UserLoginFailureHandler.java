package com.develop.sfaw.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UserLoginFailureHandler implements AuthenticationFailureHandler {

	private static final Logger log = LoggerFactory.getLogger(UserLoginFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException auth)
			throws IOException, ServletException {
		log.info("LocalizedMessage : {}.", auth.getLocalizedMessage());
		log.info("Message : {}.", auth.getMessage());

		// req.setAttribute("errMsg", auth.getMessage());
		req.setAttribute("errMsg", "아이디 혹은 패스워드를 확인해주세요");
		req.getRequestDispatcher("/WEB-INF/views/user/signinPage.jsp").forward(req, res);
	}
}
