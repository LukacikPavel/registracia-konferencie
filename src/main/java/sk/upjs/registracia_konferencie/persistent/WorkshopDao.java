package sk.upjs.registracia_konferencie.persistent;

import java.util.List;

import sk.upjs.registracia_konferencie.entity.Workshop;

public interface WorkshopDao {

	List<Workshop> getAll();
	
	Workshop save(Workshop workshop);
	
	void delete(long id);
}