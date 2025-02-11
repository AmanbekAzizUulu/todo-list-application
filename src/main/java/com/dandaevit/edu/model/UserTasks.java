package com.dandaevit.edu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@With
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserTasks {
	private final Integer taskId;
	private final Integer userTask;
}
