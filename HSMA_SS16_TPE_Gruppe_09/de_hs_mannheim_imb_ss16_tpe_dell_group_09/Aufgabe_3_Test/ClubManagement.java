package Aufgabe_3_Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Aufgabe_3.*;

public class ClubManagement {
	public static MembershipList vereinsListe = new MembershipList();
	public static MembershipList vereinsListeZwei = new MembershipList();
	public static Member heinzm = new Member(2, "Heinz", "Mustermann", 16);
	public static Member anettek = new Member(6, "Anette", "Koch", 15);
	public static Member barts = new Member(5, "Bart", "Simpson", 9);
	public static Member lisas = new Member(3, "Lisa", "Simpson", 5);
	public static Member lisaneu = new Member(2, "Lisa", "Simpson", 5);

	public static void main(String[] args) {
		vereinsListe.put(anettek);
		vereinsListe.put(heinzm);
		vereinsListe.put(barts);
		vereinsListe.put(lisas);
		System.out.println("Länge der ersten Liste: " + vereinsListe.size() + "\n");
		System.out.println("Inhalt der ersten Liste:\n" + vereinsListe);
		vereinsListe.remove(2);
		vereinsListeZwei = (MembershipList) vereinsListe.clone();
		System.out.println("Zweite Liste:\n" + vereinsListeZwei);
		vereinsListeZwei.put(lisaneu);
		System.out.println("Erste Liste:\n" + vereinsListeZwei);
		System.out.println("Erste Liste - Mitglied mit Nummer 2: " + vereinsListe.get(2));
		System.out.println("Zweite Liste - Mitglied mit Nummer 2: " + vereinsListeZwei.get(2) + "\n");
		System.out.println("Erste Liste:\n" + vereinsListe);
		System.out.println("Erste Liste - Mitglied mit Nummer 5: " + vereinsListe.get(5));
		vereinsListe.get(5).setVorname("Günter");
		System.out.println("Erste Liste - Mitglied mit Nummer 5: " + vereinsListe.get(5) + "\n");
		vereinsListeZwei.remove(5);
		System.out.println("Erste Liste:\n" + vereinsListe + "\nZweite Liste:\n" + vereinsListeZwei);
		vereinsListe.clear();
		vereinsListeZwei.clear();
		System.out.println("Länge der ersten Liste: " + vereinsListe.size());
		System.out.println("Länge der zweiten Liste: " + vereinsListeZwei.size());

	}

}
