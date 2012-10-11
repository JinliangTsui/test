package com.ego.util;

import java.util.Random;

public class GenerateRandom {
	
	public String generate() {
		Random rdm = new Random(System.currentTimeMillis());
		int intRd = Math.abs(rdm.nextInt());
		return Integer.toString(intRd);
	}

}
