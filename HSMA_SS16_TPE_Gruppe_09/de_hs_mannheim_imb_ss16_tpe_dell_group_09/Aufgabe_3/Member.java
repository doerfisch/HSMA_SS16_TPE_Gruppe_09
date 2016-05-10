package Aufgabe_3;

/**
 * @author Melissa Zindl, Sebastian Schuler
 *
 */
public class Member {

	/**
	 * Klassenvariable eindeutigeID legt die eindeutigeID fest
	 */
	public static int eindeutigeID = 1;

	/**
	 * Instanzvariablen mitgliedsID ist die ID des Mitglieds - wird im
	 * Normalfall durch eindeutigeID bestimmt, kann im Spezialfall auch
	 * mitgegeben werden, sollte aber nur f�r Demozwecke verwendet werden!
	 * vorname - der Vorname des Mitglieds nachname - der Nachname des Mitglieds
	 * anzahlJahr - die Anzahl der Jahre, die das Mitglied bereits im Verein
	 * ist, Standard ist 0
	 */
	public int mitgliedsID;
	private String vorname;
	private String nachname;
	private int anzahlJahre;

	/**
	 * Wird keine mitgliedsID mitgegeben (Standardfall), so wird die
	 * Klassenvariable eindeutigeID genutzt und danach erh�ht Dies sorgt f�r
	 * eine eindeutige ID!
	 * 
	 * @param vorname
	 *            übergibt den Vornamen eines Mitglieds an den Konstruktor
	 * @param nachname
	 *            übergibt den Nachnamen eines Mitglieds an den Konstruktor
	 */
	public Member(String vorname, String nachname) {
		this.mitgliedsID = eindeutigeID++;
		this.vorname = vorname;
		this.nachname = nachname;
		this.anzahlJahre = 0;
	}

	/**
	 * Wird keine mitgliedsID mitgegeben (Standardfall), so wird die
	 * Klassenvariable eindeutigeID genutzt und danach erh�ht Dies sorgt f�r
	 * eine eindeutige ID!
	 * 
	 * @param vorname
	 *            übergibt den Vornamen eines Mitglieds an den Konstruktor
	 * @param nachname
	 *            übergibt den Nachnamen eines Mitglieds an den Konstruktor
	 * @param anzahlJahre
	 *            übergibt die Mitgliedsjahre eins Members an den Konstruktor
	 */
	public Member(String vorname, String nachname, int anzahlJahre) {
		this.mitgliedsID = eindeutigeID++;
		this.vorname = vorname;
		this.nachname = nachname;
		this.anzahlJahre = anzahlJahre;
	}

	/**
	 * @param mitgliedsID
	 *            übergibt MemberID an den Konstruktor
	 * @param vorname
	 *            übergibt den Vornamen eines Mitglieds an den Konstruktor
	 * @param nachname
	 *            übergibt den Nachnamen eines Mitglieds an den Konstruktor
	 */
	public Member(int mitgliedsID, String vorname, String nachname) {
		this.mitgliedsID = mitgliedsID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.anzahlJahre = 0;
	}

	/**
	 * @param mitgliedsID
	 *            übergibt MemberID an den Konstruktor
	 * @param vorname
	 *            übergibt den Vornamen eines Mitglieds an den Kosntruktor
	 * @param nachname
	 *            übergibt den Nachnamen eines Mitlgieds an den Konstruktor
	 * @param anzahlJahre
	 *            übergibt die Mitgliedsjahre eins Members an den Konstruktor
	 */
	public Member(int mitgliedsID, String vorname, String nachname, int anzahlJahre) {
		this.mitgliedsID = mitgliedsID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.anzahlJahre = anzahlJahre;
	}

	// Getter und Setter Methoden
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getAnzahlJahre() {
		return anzahlJahre;
	}

	public void setAnzahlJahre(int anzahlJahre) {
		this.anzahlJahre = anzahlJahre;
	}

	public int getMitgliedsID() {
		return mitgliedsID;
	}

	/**
	 * Prüft die ID zweier Mitglieder auf Gleichheit
	 * 
	 * @param member
	 * @return true/false
	 */
	public boolean compareTo(Member member) {
		if (this.getMitgliedsID() == member.getMitgliedsID()) {
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahlJahre;
		result = prime * result + mitgliedsID;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (anzahlJahre != other.anzahlJahre)
			return false;
		if (mitgliedsID != other.mitgliedsID)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MitgliedsID: " + mitgliedsID + "\n" + vorname + " " + nachname + "\nMitgliedsjahre: " + anzahlJahre;
	}
}
