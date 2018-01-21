package com.develop.sfaw.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.develop.sfaw.repository.UserVO;
import com.develop.sfaw.service.UserService;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@GetMapping("/")
	public ModelAndView home(ModelAndView model) {


		UserVO vo = service.getUser();
		model.setViewName("home");
		model.addObject("vo", vo );

		return model;
	}

}
