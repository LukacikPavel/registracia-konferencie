package sk.upjs.registracia_konferencie;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.upjs.registracia_konferencie.entity.Companion;
import sk.upjs.registracia_konferencie.entity.CompanionCategory;
import sk.upjs.registracia_konferencie.entity.Participant;
import sk.upjs.registracia_konferencie.entity.Workshop;

class ParticipantTest {

	Workshop cidmWorkshop;
	Workshop slonlpWorkshop;

	@BeforeEach
	public void setBefore() {
		cidmWorkshop = new Workshop();
		cidmWorkshop.setPriceFull(355);
		cidmWorkshop.setPriceStudent(295);
		cidmWorkshop.setPriceFullLate(380);
		cidmWorkshop.setPriceStudentLate(320);
		slonlpWorkshop = new Workshop();
		slonlpWorkshop.setPriceFull(245);
		slonlpWorkshop.setPriceStudent(195);
		slonlpWorkshop.setPriceFullLate(265);
		slonlpWorkshop.setPriceStudentLate(210);
	}

	@Test
	void testFinalPrice1() {
		Participant participant = new Participant();
		participant.setEarly(true);
		participant.setWorkshop(cidmWorkshop);
		participant.setStudent(false);
		participant.setSingleRoom(false);
		participant.setCash(false);
		assertEquals(355.0, participant.finalPrice());
	}

	@Test
	void testFinalPrice2() {
		Participant participant = new Participant();
		participant.setEarly(false);
		participant.setWorkshop(cidmWorkshop);
		participant.setStudent(false);
		participant.setSingleRoom(false);
		participant.setCash(false);
		assertEquals(380.0, participant.finalPrice());
	}

	@Test
	void testFinalPrice3() {
		Participant participant = new Participant();
		participant.setEarly(true);
		participant.setWorkshop(slonlpWorkshop);
		participant.setStudent(false);
		participant.setSingleRoom(false);
		participant.setCash(false);
		List<Companion> companions = new ArrayList<>();
		Companion c1 = new Companion();
		c1.setCategory(CompanionCategory.ADULT);
		c1.setStart(LocalDateTime.of(2019, 9, 21, 17, 0));
		c1.setEnd(LocalDateTime.of(2019, 9, 23, 10, 0));
		companions.add(c1);
		participant.setCompanions(companions);
		assertEquals(245 + 110, participant.finalPrice());
	}

}
