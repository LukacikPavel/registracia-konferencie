package sk.upjs.registracia_konferencie;

public enum ParticipantDaoFactory {
	INSTANCE;
	
	private ParticipantDao participantDao;
	
	public ParticipantDao getParticipantDao() {
		if (participantDao == null) {
			participantDao = new MemoryParticipantDao();
		}
		return participantDao;
	}
}
