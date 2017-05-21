package com.zm;

import java.util.Base64;

import org.junit.Test;

public class PWTest {
	
	@Test
	public void testCreat(){ 
		
		String str = Base64.getEncoder().encodeToString("2017".getBytes());
		System.out.println(str);
	}

}
