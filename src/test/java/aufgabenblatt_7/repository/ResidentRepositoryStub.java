package aufgabenblatt_7.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import aufgabenblatt_7.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {
	private DateFormat format; 
	private Resident r1;
	private Resident r2;
	private Resident r3;
	
	public ResidentRepositoryStub() {
		try {
			format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
			r1 = new Resident("vorname1", "nachname1", "strasse", "stadt", format.parse("2018.06.12"));
			r2 = new Resident("vorname2", "nachname2", "strasse2", "stadt2", format.parse("2018.06.19"));
			r3 = new Resident("vorname2", "nachname2", "strasse2", "stadt2", format.parse("2018.06.19"));
		} catch(Exception exp) { }
	}

	public List<Resident> getResidents() {
		List<Resident> arrayList = new ArrayList<Resident>();
		arrayList.add(r1);
		arrayList.add(r2);
		arrayList.add(r3);
		return arrayList;
	}
	
}
