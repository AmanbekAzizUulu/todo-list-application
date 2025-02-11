package com.dandaevit.edu.dto;

import lombok.Builder;

@Builder
public record UserDTO
		(
			Integer id,
			String firstName,
			String lastName,
			String email,
			String password
		) {
}
