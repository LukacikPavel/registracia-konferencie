package sk.upjs.registracia_konferencie;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import sk.upjs.registracia_konferencie.entity.Companion;
import sk.upjs.registracia_konferencie.entity.CompanionCategory;
import sk.upjs.registracia_konferencie.entity.Tshirt;

class CompanionTest {

	
	
	@Test
	void testGetPrice1() {
		Companion c1 = new Companion();
		c1.setCategory(CompanionCategory.ADULT);
		c1.setStart(LocalDateTime.of(2019, 9, 21, 17, 0));
		c1.setEnd(LocalDateTime.of(2019, 9, 23, 10, 0));
		assertEquals(110, c1.getPrice());
	}
	
	@Test
	void testGetPrice2() {
		Companion c1 = new Companion();
		c1.setCategory(CompanionCategory.ADULT);
		c1.setStart(LocalDateTime.of(2019, 9, 22, 17, 0));
		c1.setEnd(LocalDateTime.of(2019, 9, 24, 10, 0));
		c1.setTshirt(Tshirt.M);
		assertEquals(135, c1.getPrice());
	}
	
}
