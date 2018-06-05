public class Util {

	public static boolean istErstesHalbjahr(int monat){
		if ((monat < 1) || (monat > 12)) throw new IllegalArgumentException();
		// Falsche Version auskommentiert
		//if(monat <= 7 ) return true;
		
		if(monat < 7) return true;
		
		return false;
		
		
	}

}
