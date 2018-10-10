package sk.upjs.registracia_konferencie;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDao {

	private List<Participant> participants = new ArrayList<>();
	private long lastId = 0;

	public ParticipantDao() {
		// TODO pre testovacie ucely - potom zmazat

		Participant participant = new Participant();
		participant.setName("Andrej");
		participant.setSurname("Kiska");
		participant.setEmail("prezident@prezident.sk");
		this.add(participant);
	}

	public void add(Participant participant) {
		participant.setId(++lastId);
		participants.add(participant);
	}

	public List<Participant> getAll() {
		return participants;
	}

}
