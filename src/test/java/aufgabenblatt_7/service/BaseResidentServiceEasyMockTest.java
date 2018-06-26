package aufgabenblatt_7.service;

import static org.junit.Assert.*;

import static org.easymock.EasyMock.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import aufgabenblatt_7.domain.Resident;
import aufgabenblatt_7.repository.ResidentRepository;

public class BaseResidentServiceEasyMockTest {
	private DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
	private Resident r1;
	private Resident r2;
	private Resident r3;
	List<Resident> arrayList;
	
	public BaseResidentServiceEasyMockTest() {
		try {
			arrayList = new ArrayList<Resident>();
			r1 = new Resident("vorname1", "nachname1", "strasse", "stadt", format.parse("2018.06.12"));
			r2 = new Resident("vorname2", "nachname2", "strasse2", "stadt2", format.parse("2018.06.19"));
			r3 = new Resident("vorname2", "nachname2", "strasse2", "stadt2", format.parse("2018.06.19"));
		} catch(Exception exp) { }
		arrayList.add(r1);
		arrayList.add(r2);
		arrayList.add(r3);
	}

	@Test
	public void test() throws ParseException {
		BaseResidentService baseResService = new BaseResidentService();
		DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);
		
		ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
		
		expect(residentRepositoryMock.getResidents()).andReturn(arrayList);
		expect(residentRepositoryMock.getResidents()).andReturn(arrayList);
		expect(residentRepositoryMock.getResidents()).andReturn(arrayList);
		expect(residentRepositoryMock.getResidents()).andReturn(arrayList);
		
		replay(residentRepositoryMock);
		
		baseResService.setResidentRepository(residentRepositoryMock);
		
		List<Resident> expectedResidentList = new ArrayList<Resident>();
		expectedResidentList.add(arrayList.get(0));
		
		// Format des Residents, den ich suche
		Resident resGesucht = new Resident("vor*", "*", "*", "stadt", format.parse("2018.06.12"));
		
		// Beliebiger Resident mit Format res rausfiltern
		// Test 1: Erwartet der erste Eintrag der Liste aus Stub mit Format: siehe Zeile 59
		assertEquals(arrayList.get(0),baseResService.getFilteredResidentsList(resGesucht).get(0));
		
		// Test 2: Erwartet: leeres ArrayList
		resGesucht = new Resident("vor*", "*", "*", "stadt", format.parse("2018.06.02"));
		assertEquals(0, baseResService.getFilteredResidentsList(resGesucht).size());
		
		// Test 3: Erwartet: dieselbe List, die im Stub erzeugt wurde
		resGesucht = new Resident("*", "*", "*", "*", null);
		assertEquals(residentRepositoryMock.getResidents(), baseResService.getFilteredResidentsList(resGesucht));
	
	
	}

}
