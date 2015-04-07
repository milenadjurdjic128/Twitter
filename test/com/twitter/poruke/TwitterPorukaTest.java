package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tweet;
	
	@Before
	public void setUp() throws Exception {
		tweet = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tweet = null;
	}

	@Test
	public void testSetKorisnik() {
		tweet.setKorisnik("Laka");
		
		assertEquals("Laka", tweet.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tweet.setKorisnik(null);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		tweet.setKorisnik("");
		
	}
	
	@Test 
	public void testSetPoruka() {
			tweet.setPoruka("Pokusacu da te poljubim a ti se pravi luuudaaaa.");
		
		assertEquals("Pokusacu da te poljubim a ti se pravi luuudaaaa.", tweet.getPoruka());
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
			tweet.setPoruka(null);
		
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaOutOfScope() {
			tweet.setPoruka("Ne silazi sa cardaka reko mi je pjevac Laka"
					+ "ne klepeci nanulama nemoj da se pravis dama"
					+ "ne silazi sa cardaka reko mi je pjevac Laka "
					+ "na moju moju omiljenu fooru prevarim faunu i flooru"
					+ "da zivot nije postao u mooru nego od ljuuubavi"
					+ "ljuuubavi ljuuubavi OD LJUUUBAVI :D"
					+ "kolike protracismo daane, lezeci jeduci banaane"
					+ "pa spadosmo na niske granee "
					+ "bez ljubavi, ljubavi, ljubavi, bez ljubaavi."
					+ "pokusacu da te poljudim a ti se pravi luuuda"
					+ "pokusacu da te probudim a ti se pravi budna..");
		
		
	}
	
	@Test
	public void testToString(){
		tweet.setKorisnik("Milena");
		tweet.setPoruka("Prolazi");
		assertEquals("KORISNIK:" + "Milena" + " PORUKA:" + "Prolazi", tweet.toString());
	}
	


}
