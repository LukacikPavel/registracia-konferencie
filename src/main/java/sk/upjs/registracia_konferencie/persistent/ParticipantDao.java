package sk.upjs.registracia_konferencie.persistent;

import java.util.List;

import sk.upjs.registracia_konferencie.entity.Participant;

public interface ParticipantDao {

	void add(Participant participant);

	List<Participant> getAll();
	
	void save(Participant participant);

}