package com.projectbypp.adminmanagementms.model;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

	private String userName;
	private String password;

	
}
