package com.dandaevit.edu.model.task;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@With
@Data
@Builder
@AllArgsConstructor
public class Task {
	private final String title;			// Название.
	private final String taskCode;
	private final String description;	// Описание.
	private final Statuses status;		// Статус (выполнено, в процессе, провалена).
	private final Priorities priority;	// Приоритет (важное/обычное).
	private final Ratings rating;		// Оценка (от 1 до 5, только для выполненных задач).
	private LocalDate dateOfCreation;	// Дата создания.
	private LocalDate lastUpdatedDate;	// Дата последнего обновления.
}
