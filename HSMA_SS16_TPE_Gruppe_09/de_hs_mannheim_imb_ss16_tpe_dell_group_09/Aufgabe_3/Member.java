package Aufgabe_3;

public class Member {

	private int mitgliedsID;
	private String vorname;
	private String nachname;
	private int anzahlJahre;

	public Member(int mitgliedsID, String vorname, String nachname) {
		this.mitgliedsID = mitgliedsID;
		this.vorname = vorname;
		this.nachname = nachname;
	}

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

	public boolean vergleicheID(int vergleichsID) {
		if (this.mitgliedsID == vergleichsID) {
			return true;
		} else {
			return false;
		}
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
		return mitgliedsID + vorname + nachname + anzahlJahre;
	}
}
