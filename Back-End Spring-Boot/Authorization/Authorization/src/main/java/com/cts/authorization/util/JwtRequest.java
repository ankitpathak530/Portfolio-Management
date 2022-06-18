package com.cts.authorization.util;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtRequest {

	private String username;
	private String password;
}