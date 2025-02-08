package com.dandaevit.edu.model.task;

public enum Ratings {
	A(1),
	B(2),
	C(3),
	D(4),
	E(5);

	private final int value;

	Ratings(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Ratings fromInteger(int value) {
		return switch (value) {
			case 1 -> A;
			case 2 -> B;
			case 3 -> C;
			case 4 -> D;
			case 5 -> E;
			default -> throw new IllegalArgumentException("Invalid rating value: " + value);
		};
	}
}
