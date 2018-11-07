package sk.upjs.registracia_konferencie;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sk.upjs.registracia_konferencie.entity.WorkShop;

public class WorkshopFxModel {
	private Long id;
	private StringProperty name = new SimpleStringProperty();
	private LocalDate start;
	private LocalDate end;
	private DoubleProperty priceFull = new SimpleDoubleProperty();
	private DoubleProperty priceStudent = new SimpleDoubleProperty();
	private DoubleProperty priceFullLate = new SimpleDoubleProperty();
	private DoubleProperty priceStudentLate = new SimpleDoubleProperty();

	public void setWorkshop(WorkShop w) {
		setId(w.getId());
		setName(w.getName());
		setStart(w.getStart());
		setEnd(w.getEnd());
		setPriceFull(w.getPriceFull());
		setPriceStudent(w.getPriceStudent());
		setPriceFullLate(w.getPriceFullLate());
		setPriceStudentLate(w.getPriceStudentLate());
	}

	public WorkShop getWorkshop() {
		WorkShop w = new WorkShop();
		w.setId(id);
		w.setName(getName());
		w.setStart(start);
		w.setEnd(end);
		w.setPriceFull(getPriceFull());
		w.setPriceStudent(getPriceStudent());
		w.setPriceFullLate(w.getPriceFullLate());
		w.setPriceStudentLate(w.getPriceStudentLate());
		return w;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Double getPriceFull() {
		return priceFull.get();
	}

	public void setPriceFull(Double priceFull) {
		this.priceFull.set(priceFull);
	}

	public DoubleProperty priceFullProperty() {
		return priceFull;
	}

	public Double getPriceStudent() {
		return priceStudent.get();
	}

	public void setPriceStudent(Double priceStudent) {
		this.priceStudent.set(priceStudent);
		;
	}

	public DoubleProperty priceStudentProperty() {
		return priceStudent;
	}

	public Double getPriceFullLate() {
		return priceFullLate.get();
	}

	public void setPriceFullLate(Double priceFullLate) {
		this.priceFullLate.set(priceFullLate);
	}

	public DoubleProperty priceFullLateProperty() {
		return priceFullLate;
	}

	public Double getPriceStudentLate() {
		return priceStudentLate.get();
	}

	public void setPriceStudentLate(Double priceStudentLate) {
		this.priceStudentLate.set(priceStudentLate);
	}

	public DoubleProperty priceStudentLateProperty() {
		return priceStudentLate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}