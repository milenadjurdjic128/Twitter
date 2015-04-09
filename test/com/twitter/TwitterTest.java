package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private TwitterPoruka tweet;
	private Twitter tviter;
	private LinkedList<TwitterPoruka> lista;
	
	@Before
	public void setUp() throws Exception {
		tweet = new TwitterPoruka();
		tviter = new Twitter();
		lista = new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		tweet = null;
		tviter = null;
		lista = null;
	}

	@Test
	public void testVratiSvePorukeNull() {
		
		assertEquals(lista, tviter.vratiSvePoruke());
		
	}
	
	@Test
	public void testVratiSvePorukeJedna() {
		tweet.setKorisnik("Laka");
		tweet.setPoruka("Porukica");
		
		tviter.unesi(tweet.getKorisnik(), tweet.getPoruka());
		lista.addLast(tweet);
		
		assertEquals(lista, tviter.vratiSvePoruke());
		
	}
	
	@Test
	public void testVratiSvePoruke2() {
		tweet.setKorisnik("Laka");
		tweet.setPoruka("Porukica");
		
		TwitterPoruka tweet2 = new TwitterPoruka();

		tweet2.setKorisnik("Little Mouse");
		tweet2.setPoruka("I'm an albatraoz hey!");
		
		tviter.unesi(tweet.getKorisnik(), tweet.getPoruka());
		tviter.unesi(tweet2.getKorisnik(), tweet2.getPoruka());
		
		lista.addLast(tweet);
		lista.addLast(tweet2);
		
		assertEquals(lista, tviter.vratiSvePoruke());
		
	} 

	@Test
	public void testUnesiJedan() {
		tweet.setKorisnik("Laka");
		tweet.setPoruka("Porukica");
		
		tviter.unesi(tweet.getKorisnik(), tweet.getPoruka());
		lista.addLast(tweet);
		
		assertEquals(lista, tviter.vratiSvePoruke());
		//uoceno je da nije pravilno napisana metoda u klasi Twitter, jer umesto "korisnik" treba da pise samo korisnik kako se ne bi vrednost postavljala na "korisnik" vec na unetu vrednost
		//greska je ispravljena
		
	} 
	
	@Test
	public void testUnesiDva() {
		tweet.setKorisnik("Laka");
		tweet.setPoruka("Porukica");
		
		TwitterPoruka tweet2 = new TwitterPoruka();

		tweet2.setKorisnik("Little Mouse");
		tweet2.setPoruka("I'm an albatraoz hey!");
		
		tviter.unesi(tweet.getKorisnik(), tweet.getPoruka());
		tviter.unesi(tweet2.getKorisnik(), tweet2.getPoruka());
		
		lista.addLast(tweet);
		lista.addLast(tweet2);
		
		assertEquals(lista, tviter.vratiSvePoruke());
		
	} 
	
	
	@Test
	public void testVratiPoruke() {
		tweet.setKorisnik("Laka");
		tweet.setPoruka("poruka jedan");
		
		TwitterPoruka tweet2 = new TwitterPoruka();
		
		tweet2.setKorisnik("Zika");
		tweet2.setPoruka("poruka dva!");
		
		TwitterPoruka[] niz = new TwitterPoruka[2];
		
		niz[0] = tweet;
		niz[1] = tweet2;
		tviter.unesi(tweet.getKorisnik(), tweet.getPoruka());
		tviter.unesi(tweet2.getKorisnik(), tweet2.getPoruka());
		
		
		assertArrayEquals(niz, tviter.vratiPoruke(2, "poruka"));
		//postoji greska u metodi, kada se postavlja u niz pronadjeni element sa odredjenim tagom, postavlja se na brojac+1 a potrebno je da se postavi na brojac
		//jer ce u suprotnom izaci iz granica niza
		//greska je ispracljena
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJeNull() {
		tviter.vratiPoruke(10, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJePrazan() {
		tviter.vratiPoruke(10, "");
	}

	

}
