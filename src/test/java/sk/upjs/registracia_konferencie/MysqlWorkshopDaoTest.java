package sk.upjs.registracia_konferencie;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.upjs.registracia_konferencie.entity.Companion;
import sk.upjs.registracia_konferencie.entity.CompanionCategory;
import sk.upjs.registracia_konferencie.entity.Participant;
import sk.upjs.registracia_konferencie.entity.WorkShop;
import sk.upjs.registracia_konferencie.persistent.DaoFactory;

class MysqlWorkshopDaoTest {

	@Test
	void testGetAll() {
		List<WorkShop> workshops = DaoFactory.INSTANCE.getWorkshopDao().getAll();
		assertNotNull(workshops);
		assertTrue(workshops.size() > 0);
	}

	@Test
	void testSave() {
		WorkShop cidmWorkshop = new WorkShop();
		cidmWorkshop = new WorkShop();
		cidmWorkshop.setPriceFull(355);
		cidmWorkshop.setPriceStudent(295);
		cidmWorkshop.setPriceFullLate(380);
		cidmWorkshop.setPriceStudentLate(320);
		// create
		DaoFactory.INSTANCE.getWorkshopDao().save(cidmWorkshop);
		assertNotNull(cidmWorkshop.getId());
		cidmWorkshop.setName("cidm-nove");
		// update
		DaoFactory.INSTANCE.getWorkshopDao().save(cidmWorkshop);
		List<WorkShop> all = DaoFactory.INSTANCE.getWorkshopDao().getAll();
		for (WorkShop w : all) {
			if (w.getId() == cidmWorkshop.getId()) {
				assertEquals("cidm-nove", w.getName());
				DaoFactory.INSTANCE.getWorkshopDao().delete(w.getId());
				return;
			}
		}
		assertTrue(false, "update sa nepodaril");
	}
	
	@Test
	void deleteTest() {
		WorkShop cidmWorkshop = new WorkShop();
		cidmWorkshop = new WorkShop();
		cidmWorkshop.setPriceFull(355);
		cidmWorkshop.setPriceStudent(295);
		cidmWorkshop.setPriceFullLate(380);
		cidmWorkshop.setPriceStudentLate(320);
		DaoFactory.INSTANCE.getWorkshopDao().save(cidmWorkshop);
		Long id = cidmWorkshop.getId();
		DaoFactory.INSTANCE.getWorkshopDao().delete(id);
		List<WorkShop> all = DaoFactory.INSTANCE.getWorkshopDao().getAll();
		for (WorkShop w : all) {
			assertNotEquals(id, w.getId());
		}
	}
}
