package com.abellmann.junit.junit_sample;

public abstract class Price {
	abstract double getCharge(int daysRented);

	int getPoints(int daysRented) {
		return 1;
	}
}