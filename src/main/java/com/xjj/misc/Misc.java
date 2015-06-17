package com.xjj.misc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

public class Misc {

	@Test
	public void test1() throws MalformedURLException {
		final String[] URL_NAMES = { "http://javapuzzlers.com",
				"http://apache2-snort.skybar.dreamhost.com",
				"http://www.google.com",
				"http://javapuzzlers.com",
				"http://findbugs.sourceforge.net",
				"http://www.cs.umd.edu" };
		
		Set<URL> favorites = new HashSet<URL>();
		for (String urlName : URL_NAMES)
			favorites.add(new URL(urlName));
		System.out.println(favorites.size());
		
		
	}

	@Test
	public void test2() {
        Random rnd = new Random();
        boolean toBe = rnd.nextBoolean();
        Number result = (toBe || !toBe) ?
                new Integer(3) : new Float(1);
        System.out.println(result);
    }
	
	@Test
	public void test3(){
		Map<String, Double> m = new HashMap<>();
		m.put("aaaa", 123456.789);
		JSONObject jsonObject = new JSONObject(m);
		System.out.println(jsonObject);
		
		String[] s = new String[]{"a","b"};
		
		List<String> l = Arrays.asList(s);
		System.out.println(l);
		
		//List<String> l2 = new LinkedList<>();
		//List<String> l3 = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		(new Misc()).new MyClass().start();
	}
	
	@Test
	public void newThread() {
		new MyClass().start();
	}
	
	private class MyClass extends Thread{
		@Override
		public void run() {
			System.out.println("hahaha");
		}
	}
	
	
	@Test
	public void maxInteger() {
		System.out.println(Integer.MAX_VALUE);
	}
}
