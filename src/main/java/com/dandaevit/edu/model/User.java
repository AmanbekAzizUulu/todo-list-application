package com.dandaevit.edu.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@With
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class User {
	private final Integer id;
	private final String userCode;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;

	private final List<Integer> taskIds;
}
