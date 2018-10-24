package sk.upjs.registracia_konferencie.persistent;

import java.util.ArrayList;
import java.util.List;

import sk.upjs.registracia_konferencie.entity.Participant;

public class MemoryParticipantDao implements ParticipantDao {

	private List<Participant> participants = new ArrayList<>();
	private long lastId = 0;

	public MemoryParticipantDao() {
		// TODO pre testovacie ucely - potom zmazat

		Participant p = new Participant();
		p.setName("Andrej");
		p.setSurname("Kiska");
		p.setEmail("prezident@prezident.sk");
		this.add(p);

		Participant p2 = new Participant();
		p2.setName("Mária");
		p2.setSurname("Trošková");
		this.add(p2);
	}

	@Override
	public void add(Participant participant) {
		participant.setId(++lastId);
		participants.add(participant);
	}

	@Override
	public List<Participant> getAll() {
		return participants;
	}

	@Override
	public void save(Participant participant) {
		if (participant != null) {
			if (participant.getId() == null) {
				add(participant);
			} else {
				for (int i = 0; i < participants.size(); i++) {
					if (participants.get(i).getId().equals(participant.getId())) {
						participants.set(i, participant);
						break;
					}
				}
			}
		}
	}

}
