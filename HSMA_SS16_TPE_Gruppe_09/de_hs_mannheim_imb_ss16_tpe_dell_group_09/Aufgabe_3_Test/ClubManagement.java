package Aufgabe_3_Test;

import Aufgabe_3.*;

/**
 * Testumgebung
 * 
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class ClubManagement {
	// Erstellen zweier Listen und 5 Testmitgliedern zur Veranschaulichung
	public static MembershipList vereinsListe = new MembershipList();
	public static MembershipList vereinsListeZwei = new MembershipList();
	public static Member heinzm = new Member(2, "Heinz", "Mustermann", 16);
	public static Member anettek = new Member(6, "Anette", "Koch", 15);
	public static Member barts = new Member(5, "Bart", "Simpson", 9);
	public static Member lisas = new Member(3, "Lisa", "Simpson", 5);
	public static Member lisaneu = new Member(2, "Lisa", "Simpson", 5);

	// DEMO zu Veranschaulichungszwecken
	public static void main(String[] args) {
		// Zuerst fügen wir 4 Mitglieder der Liste hinzu
		vereinsListe.put(anettek);
		vereinsListe.put(heinzm);
		vereinsListe.put(barts);
		vereinsListe.put(lisas);
		// Nun geben wir die Länge und den Inhalt der Liste aus
		System.out.println("Länge der ersten Liste: " + vereinsListe.size() + "\n");
		System.out.println("Erste Liste:\n" + vereinsListe);
		// Wir entfernen das Mitglied mit der ID "2"
		vereinsListe.remove(2);
		// Die Vereinsliste wird in eine zweite Liste kopiert und diese
		// ausgegeben
		vereinsListeZwei = (MembershipList) vereinsListe.clone();
		System.out.println("Zweite Liste:\n" + vereinsListeZwei);
		// In die zweite Liste wird das neue Mitglied mit der ID "2" hinzugefügt
		vereinsListeZwei.put(lisaneu);
		// Die zweite Liste wird ausgegeben, dann das Mitglied mit der ID 2
		// (welches nicht vorhanden ist), dann das Mitglied mit der ID 2 in der
		// zweiten Liste
		System.out.println("Zweite Liste:\n" + vereinsListeZwei);
		System.out.println("Erste Liste - Mitglied mit Nummer 2: " + vereinsListe.get(2));
		System.out.println("Zweite Liste - Mitglied mit Nummer 2: " + vereinsListeZwei.get(2) + "\n");
		// Nun wird die erste Liste ausgegeben, danach das Mitglied mit der ID 5
		System.out.println("Erste Liste:\n" + vereinsListe);
		System.out.println("Erste Liste - Mitglied mit Nummer 5: " + vereinsListe.get(5));
		// Hier wird der Vorname des Mitglieds mit der ID 5 in der ersten Liste
		// geändert und das Mitglied danach ausgegeben
		vereinsListe.get(5).setVorname("Günter");
		System.out.println("Erste Liste - Mitglied mit Nummer 5: " + vereinsListe.get(5) + "\n");
		// Das Mitglied mit der ID 5 wird in der zweiten Liste gelöscht und
		// danach werden beide Listen ausgegeben
		vereinsListeZwei.remove(5);
		System.out.println("Erste Liste:\n" + vereinsListe + "\nZweite Liste:\n" + vereinsListeZwei);
		// Beide Listen werden geleert und danach die Länge der Liste ausgegeben
		// - Da die Listen leer sind wird 0 ausgegeben
		vereinsListe.clear();
		vereinsListeZwei.clear();
		System.out.println("Länge der ersten Liste: " + vereinsListe.size());
		System.out.println("Länge der zweiten Liste: " + vereinsListeZwei.size());

	}

}
