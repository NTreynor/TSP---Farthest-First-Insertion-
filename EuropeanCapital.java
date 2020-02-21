package hw20_treynor;

public class EuropeanCapital {

	private String country;
	private String capital;
	private double latitude;
	private double longitude;

    public EuropeanCapital(String country, String capital, double latitude, double longitude) {
		this.country = country;
		this.capital = capital;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String country() { return this.country; }
	public String capital() { return this.capital; }
	public double latitude() { return this.latitude; }
	public double longitude() { return this .longitude; }

	public double distance(EuropeanCapital to) {
	    double deltaLongitude = this.longitude - to.longitude;
		double deltaLatitude = this.latitude - to.latitude;
		return Math.sqrt(deltaLongitude*deltaLongitude + deltaLatitude*deltaLatitude);
	}

	@Override
	public String toString() {
		return this.country;
	}


	public static EuropeanCapital Albania       = new EuropeanCapital ("Albania",        "Tirane",           41.18,  19.49);
	public static EuropeanCapital Andorra       = new EuropeanCapital ("Andorra",        "Andorra la Vella", 42.31,  01.32);
	public static EuropeanCapital Austria       = new EuropeanCapital ("Austria",        "Vienna",           48.12,  16.22);
	public static EuropeanCapital Belarus       = new EuropeanCapital ("Belarus",        "Minsk",            53.52,  27.30);
	public static EuropeanCapital Belgium       = new EuropeanCapital ("Belgium",        "Brussels",         50.51,  04.21);
	public static EuropeanCapital Bosnia        = new EuropeanCapital ("Bosnia",         "Sarajevo",         43.52,  18.26);
	public static EuropeanCapital Bulgaria      = new EuropeanCapital ("Bulgaria",       "Sofia",            42.45,  23.20);
	public static EuropeanCapital Croatia       = new EuropeanCapital ("Croatia",        "Zagreb",           45.50,  15.58);
	public static EuropeanCapital Cyprus        = new EuropeanCapital ("Cyprus",         "Nicosia",          35.10,  33.25);
	public static EuropeanCapital CzechRepublic = new EuropeanCapital ("Czech Republic", "Prague",           50.05,  14.22);
	public static EuropeanCapital Denmark       = new EuropeanCapital ("Denmark",        "Copenhagen",       55.41,  12.34);
	public static EuropeanCapital Estonia       = new EuropeanCapital ("Estonia",        "Tallinn",          59.22,  24.48);
	public static EuropeanCapital Finland       = new EuropeanCapital ("Finland",        "Helsinki",         60.15,  25.03);
	public static EuropeanCapital France        = new EuropeanCapital ("France",         "Paris",            48.50,  02.20);
	public static EuropeanCapital Georgia       = new EuropeanCapital ("Georgia",        "T'bilisi",         41.43,  44.50);
	public static EuropeanCapital Germany       = new EuropeanCapital ("Germany",        "Berlin",           52.30,  13.25);
	public static EuropeanCapital Greece        = new EuropeanCapital ("Greece",         "Athens",           37.58,  23.46);
	public static EuropeanCapital Hungary       = new EuropeanCapital ("Hungary",        "Budapest",         47.29,  19.05);
	public static EuropeanCapital Ireland       = new EuropeanCapital ("Ireland",        "Dublin",           53.21, -06.15);
	public static EuropeanCapital Italy         = new EuropeanCapital ("Italy",          "Rome",             41.54,  12.29);
	public static EuropeanCapital Latvia        = new EuropeanCapital ("Latvia",         "Riga",             56.53,  24.08);
	public static EuropeanCapital Liechtenstein = new EuropeanCapital ("Liechtenstein",  "Vaduz",            47.08,  09.31);
	public static EuropeanCapital Lithuania     = new EuropeanCapital ("Lithuania",      "Vilnius",          54.38,  25.19);
	public static EuropeanCapital Luxembourg    = new EuropeanCapital ("Luxembourg",     "Luxembourg",       49.37,  06.09);
	public static EuropeanCapital Macedonia     = new EuropeanCapital ("Macedonia",      "Skopje",           42.01,  21.26);
	public static EuropeanCapital Moldova       = new EuropeanCapital ("Moldova",        "Chisinau",         47.02,  28.50);
	public static EuropeanCapital Netherlands   = new EuropeanCapital ("Netherlands",    "Amsterdam",        52.23,  04.54);
	public static EuropeanCapital Norway        = new EuropeanCapital ("Norway",         "Oslo",             59.55,  10.45);
	public static EuropeanCapital Poland        = new EuropeanCapital ("Poland",         "Warsaw",           52.13,  21.00);
	public static EuropeanCapital Portuagal     = new EuropeanCapital ("Portugal",       "Lisbon",           38.42, -09.10);
	public static EuropeanCapital Romania       = new EuropeanCapital ("Romania",        "Bucuresti",        44.27,  26.10);
	public static EuropeanCapital Russia        = new EuropeanCapital ("Russia",         "Moskva",           55.45,  37.35);
	public static EuropeanCapital Slovakia      = new EuropeanCapital ("Slovakia",       "Bratislava",       48.10,  17.07);
	public static EuropeanCapital Slovenia      = new EuropeanCapital ("Slovenia",       "Ljubljana",        46.04,  14.33);
	public static EuropeanCapital Spain         = new EuropeanCapital ("Spain",          "Madrid",           40.25, -03.45);
	public static EuropeanCapital Sweden        = new EuropeanCapital ("Sweden",         "Stockholm",        59.20,  18.03);
	public static EuropeanCapital Switzerland   = new EuropeanCapital ("Switzerland",    "Bern",             46.57,  07.28);
	public static EuropeanCapital Turkey        = new EuropeanCapital ("Turkey",         "Ankara",           39.57,  32.54);
	public static EuropeanCapital Ukraine       = new EuropeanCapital ("Ukraine",        "Kiev",             50.30,  30.28);
	public static EuropeanCapital UnitedKingdom = new EuropeanCapital ("United Kingdom", "London",           51.36, -00.05);
	public static EuropeanCapital Yugoslavia    = new EuropeanCapital ("Yugoslavia",     "Belgrade",         44.50,  20.37);

	public static EuropeanCapital[] capitals = {
		Albania,
		Andorra,
		Austria,
		Belarus,
		Belgium,
		Bosnia,
		Bulgaria,
		Croatia,
		Cyprus,
		CzechRepublic,
		Denmark,
		Estonia,
		Finland,
		France,
		Georgia,
		Germany,
		Greece,
		Hungary,
		Ireland,
		Italy,
		Latvia,
		Liechtenstein,
		Lithuania,
		Luxembourg,
		Macedonia,
		Moldova,
		Netherlands,
		Norway,
		Poland,
		Portuagal,
		Romania,
		Russia,
		Slovakia,
		Slovenia,
		Spain,
		Sweden,
		Switzerland,
		Turkey,
		Ukraine,
		UnitedKingdom,
		Yugoslavia,
	};
}
