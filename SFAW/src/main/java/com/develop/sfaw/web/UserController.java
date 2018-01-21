package com.develop.sfaw.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.develop.sfaw.common.CommonStatus;
import com.develop.sfaw.repository.UserAPI;
import com.develop.sfaw.security.SHAEncoder;
import com.develop.sfaw.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "shaEncoder")
	private SHAEncoder encoder;

	@Resource(name = "userService")
	private UserService userService;

	@GetMapping("/signin")
	public ModelAndView signIn(ModelAndView model) {
		int logCount = 1;
		log.info("signIn-{}.", (logCount++));
		model.setViewName("/user/signinPage");
		return model;
	}

	@GetMapping("/signup")
	public ModelAndView signUp() {
		int logCount = 1;
		log.info("signUp-{}.", (logCount++));
		return new ModelAndView("/user/signupPage");
	}

	@PostMapping("/createUser")
	public ModelAndView createUser(ModelAndView model, @ModelAttribute UserAPI api) {
		int logCount = 1;
		log.info("createUser-{}", (logCount++));

		String dbpw = encoder.encoding(api.getPwd());
		api.setPwd(dbpw);
		log.info("createUser-{}. Encoding password : {}.", (logCount++), api.getPwd());

		String result = userService.createUser(api);
		log.info("createUser-{}. Result : {}.", (logCount++), result);

		if(result.equals(CommonStatus.SUCCESS))	{
			model.setViewName("redirect:/");
			return model;
		}else {
			model.setViewName("/user/errorPage");
			return model;
		}
	}

}
