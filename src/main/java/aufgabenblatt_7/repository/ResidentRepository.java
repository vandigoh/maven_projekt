package aufgabenblatt_7.repository;

import java.util.List;

import aufgabenblatt_7.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}