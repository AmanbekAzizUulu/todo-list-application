package com.dandaevit.edu.dto;

import com.dandaevit.edu.model.task.Priorities;
import com.dandaevit.edu.model.task.Ratings;
import com.dandaevit.edu.model.task.Statuses;

public record TaskDTO(
	String title,
	String description,
	Statuses status,
	Priorities priority,
	Ratings rating
) {

}
