package sk.upjs.registracia_konferencie;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sk.upjs.registracia_konferencie.entity.WorkShop;
import sk.upjs.registracia_konferencie.persistent.DaoFactory;
import sk.upjs.registracia_konferencie.persistent.WorkshopDao;

public class WorkshopEditController {

	private WorkshopDao workshopDao;
	private WorkshopFxModel workshopModel;

	@FXML
	private ComboBox<WorkShop> workshopComboBox;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField priceFullTextField;

	@FXML
	private TextField priceStudentTextField;

	@FXML
	private TextField priceFullLateTextField;

	@FXML
	private TextField priceStudentLateTextField;

	@FXML
	private DatePicker startDatePicker;

	@FXML
	private DatePicker endDatePicker;

	@FXML
	private Button saveButton;

	public WorkshopEditController() {
		workshopDao = DaoFactory.INSTANCE.getWorkshopDao();
		workshopModel = new WorkshopFxModel();
	}

	@FXML
	void initialize() {
		workshopComboBox.setItems(FXCollections.observableList(workshopDao.getAll()));
		nameTextField.textProperty().bindBidirectional(workshopModel.nameProperty());
	}
}
