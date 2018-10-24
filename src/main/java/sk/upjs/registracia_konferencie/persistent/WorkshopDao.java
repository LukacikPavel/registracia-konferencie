package sk.upjs.registracia_konferencie.persistent;

import java.util.List;

import sk.upjs.registracia_konferencie.entity.WorkShop;

public interface WorkshopDao {

	List<WorkShop> getAll();

}