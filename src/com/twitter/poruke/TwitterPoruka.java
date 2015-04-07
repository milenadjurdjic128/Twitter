package com.twitter.poruke;

/**
 * Naziv klase je TwitterPoruka i sadrzi get, set i toString metode za atribute.
 * 
 * @author Milena
 *
 */

public class TwitterPoruka {
	/**
	 * Korisnik je atribut koji identifikuje lice koje postavlja tvit.
	 */
	private String korisnik; 
	
	/**
	 * Poruka je atribut koji predstavlja sadrzaj poruke koju je korisnik tvitovao.
	 */
	private String poruka; 
	
	/**
	 * Metoda vraca naziv korisnika.
	 * 
	 * @return username korisnika
	 * 
	 */
	public String getKorisnik() { 
		return korisnik; 
	} 
	/**
	 * Metoda koja postavlja naziv korisnika na unetu vrednost.
	 * Metoda ima logicku kontrolu:
	 * 		<ul>
	 * 		<li> parametar ne sme biti null,</li>
	 * 		<li> parametar ne sme biti prazan string.</li>
	 * 		</ul>
	 * 
	 * @param odredjeni korisnik
	 * 
	 */
	public void setKorisnik(String korisnik) { 
		if (korisnik == null || korisnik.equals("")) 
			throw new RuntimeException("Ime korisnika mora biti uneto"); 
		this.korisnik = korisnik; 
	} 
	
	/**
	 * Metoda vraca poruku korisnika.
	 * 
	 * @return poruka korisnika
	 * 
	 */
	public String getPoruka() { 
		return poruka; 
	} 
	/**
	 * Metoda postavlja poruku na unetu vrednost.
	 * Metoda ima logicku kontrolu:
	 * 		<ul>
	 * 			<li> parametar ne sme biti null, </li>
	 * 			<li> duzina unete poruke ne sme biti duzi od 140 karaktera.</li>
	 * 		</ul>
	 * 
	 * @param uneta poruka 
	 * 
	 */
	public void setPoruka(String poruka) { 
		if (poruka == null || poruka.length() > 140) 
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka; 
	} 
	
	/**
	 * Metoda vraca se parametre kao jedan String.
	 */
	public String toString(){ 
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka; 
	} 

}
