package com.develop.sfaw.security;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("shaEncoder")
public class SHAEncoder {

	@Resource(name = "passwordEncoder")
	private ShaPasswordEncoder encoder;

	public String encoding(String str) {
		return encoder.encodePassword(str, null);
	}
}
