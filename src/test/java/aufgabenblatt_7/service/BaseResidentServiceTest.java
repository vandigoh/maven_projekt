package aufgabenblatt_7.service;

import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import aufgabenblatt_7.domain.Resident;
import aufgabenblatt_7.repository.ResidentRepositoryStub;

public class BaseResidentServiceTest {

	@Test
	public void testFilteredResidents() throws ParseException {
		BaseResidentService baseRes = new BaseResidentService();
		DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
		Resident res = new Resident("vor*", "*", "*", "stadt", format.parse("2018.06.12"));
		ResidentRepositoryStub resStub = new ResidentRepositoryStub();
		baseRes.setResidentRepository(resStub);
		List<Resident> listErgebnis = new ArrayList<Resident>();
		listErgebnis.add(resStub.getResidents().get(0));
		
		// Erwartet der erster Eintrag der Liste aus Stub mit Format: siehe Zeile 22
		assertEquals(listErgebnis,baseRes.getFilteredResidentsList(res));
		
		// Erwartet: leeres ArrayList
		res = new Resident("vor*", "*", "*", "stadt", format.parse("2018.06.02"));
		assertEquals(0, baseRes.getFilteredResidentsList(res).size());
		
		// Test 3: Erwartet: dieselbe List, die im Stub erzeugt wurde
		res = new Resident("*", "*", "*", "*", null);
		assertEquals(resStub.getResidents(), baseRes.getFilteredResidentsList(res));
		
	}
	
	
	@Test
	public void testUniqueResident() throws ParseException {
		BaseResidentService baseRes = new BaseResidentService();
		DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
		Resident filter = new Resident("vorname1", "nachname1", "strasse", "stadt", format.parse("2018.06.12"));
		ResidentRepositoryStub resStub = new ResidentRepositoryStub();
		baseRes.setResidentRepository(resStub);
		
		// Normales Verhalten testen
		
		try {
			assertEquals(resStub.getResidents().get(0), baseRes.getUniqueResident(filter));
		} catch (ResidentServiceException e) { }
		
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testUniqueResWildcard() throws ParseException, ResidentServiceException {
		BaseResidentService baseRes = new BaseResidentService();
		DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
		Resident filter = new Resident("vor*", "nachname1", "strasse", "stadt", format.parse("2018.06.12"));
		ResidentRepositoryStub resStub = new ResidentRepositoryStub();
		baseRes.setResidentRepository(resStub);
		
		baseRes.getUniqueResident(filter);
		
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testUniqueResFalscheAnzahlEintraege() throws ParseException, ResidentServiceException {
		BaseResidentService baseRes = new BaseResidentService();
		DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
		Resident filter = new Resident("vor", "nachname1", "strasse", "stadt", format.parse("2018.06.12"));
		ResidentRepositoryStub resStub = new ResidentRepositoryStub();
		baseRes.setResidentRepository(resStub);
		
		baseRes.getUniqueResident(filter);
		
		filter = new Resident("vorname2", "nachname2", "strasse2", "stadt2", format.parse("2018.06.19"));
		baseRes.getUniqueResident(filter);
	}
	
}
