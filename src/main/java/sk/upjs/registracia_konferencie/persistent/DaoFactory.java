package sk.upjs.registracia_konferencie.persistent;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum DaoFactory {
	INSTANCE;

	private ParticipantDao participantDao;
	private JdbcTemplate jdbcTemplate;
	private WorkshopDao workshopDao;
	
	public WorkshopDao getWorkshopDao() {
		if(workshopDao == null) {
			workshopDao = new MysqlWorkshopDao(jdbcTemplate);
		}
		return workshopDao;
	}
	
	public ParticipantDao getParticipantDao() {
		if (participantDao == null) {
			participantDao = new MemoryParticipantDao();
		}
		return participantDao;
	}

	private JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("registracia_itat");
			dataSource.setPassword("paz1c");
			dataSource.setDatabaseName("registracia_itat");
			dataSource.setUrl("jdbc:mysql://localhost/registracia_itat?serverTimezone=Europe/Bratislava");
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}
}
