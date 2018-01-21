package com.develop.sfaw.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class UserDeniedHandler implements AccessDeniedHandler{

	private static final Logger log = LoggerFactory.getLogger(UserDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res,
			AccessDeniedException ade) throws IOException, ServletException {
		log.info("Exceiption : {}",ade);
		log.info("LocalizedMessage : {}",ade.getLocalizedMessage());
		log.info("Message : {}",ade.getMessage());
		log.info("StackTrace : {}",ade.getStackTrace());

		req.setAttribute("errMsg",ade.getMessage());
		req.getRequestDispatcher("/WEB-INF/views/user/denied.jsp").forward(req, res);
	}

}
