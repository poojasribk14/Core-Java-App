package com.corejavaapp.main.utility;

public class IDUtil {

	public int getRandomId() {
		double random = Math.random() * 100000;
		return (int) random;
	}
}
