package com.develop.sfaw.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.develop.sfaw.common.CommonConstants;
import com.develop.sfaw.repository.UserAPI;
import com.develop.sfaw.service.UserService;
import com.develop.sfaw.util.SHAEncoder;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "shaEncoder")
	private SHAEncoder encoder;

	@Resource(name = "userService")
	private UserService userService;

	@GetMapping("/checkId")
	public Map<String, Object> checkId(@RequestParam(defaultValue="", required=false) String id) {
		int logCount = 1;
		log.info("checkId-start-{}.", logCount++);

		String result = userService.checkId(id);
		log.info("checkId-end-{}. Result : {}", (logCount++), result);

		Map<String, Object> map = new HashMap<>();
		map.put("canUse", result.equals(CommonConstants.SUCCESS));
		return map;
	}

	@PostMapping("/createUser")
	public ModelAndView createUser(ModelAndView model, @ModelAttribute UserAPI api) {
		int logCount = 1;
		log.info("createUser-start-{}", (logCount++));

		String dbpw = encoder.encoding(api.getPassword());
		api.setPassword(dbpw);
		log.info("createUser-{}. Encoding password : {}.", (logCount++), api.getPassword());

		String result = userService.createUser(api);
		log.info("createUser-end-{}. Result : {}.", (logCount++), result);

		if(result.equals(CommonConstants.SUCCESS))	{
			model.setViewName("redirect:/");
			return model;
		}else {
			model.setViewName("/user/errorPage");
			return model;
		}
	}

}
