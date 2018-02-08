package com.develop.sfaw.repository;

import org.springframework.security.core.SpringSecurityCoreVersion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAPI{

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	private String id;
	private String pwd;
	private String name;
	private String email;
	private String addr;
	private int enabled;	// 0: 사용 불가, 1: 사용 가능
	private String authority;
	private String point;
	private String regDt;
	private String regTm;
	private String updDt;
	private String updTm;

}
