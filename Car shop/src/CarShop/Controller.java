package CarShop;

import CarShop.Classes.CarShowroom;
import CarShop.Classes.E_ItemCondition;
import CarShop.Classes.Vehicle;
import CarShop.Exceptions.WorkOnFileException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Controller {

    public Tooltip upperTooltip;
    public Tooltip lowerTooltip;
    private List<CarShowroom> showroomsList;
    private List<Vehicle> reservations;
    private List<Vehicle> soldVehicles = new ArrayList<>();
    @FXML
    public TextField modelTextField;
    @FXML
    private TableView<Vehicle> upperTable;
    @FXML
    private TableView<Vehicle> lowerTable;
    @FXML
    private TableColumn<Vehicle, String> showroomUpper;
    @FXML
    private TableColumn<Vehicle, String> markUpper;
    @FXML
    private TableColumn<Vehicle, String> modelUpper;
    @FXML
    private TableColumn<Vehicle, Double> priceUpper;
    @FXML
    private TableColumn<Vehicle, Integer> productionYearUpper;
    @FXML
    private TableColumn<Vehicle, String> showroomLower;
    @FXML
    private TableColumn<Vehicle, String> markLower;
    @FXML
    private TableColumn<Vehicle, String> modelLower;
    @FXML
    private TableColumn<Vehicle, Double> priceLower;
    @FXML
    private TableColumn<Vehicle, Integer> productionYearLower;
    @FXML
    private ComboBox<String> showroomComboBox;
    @FXML
    private ComboBox<String> sortComboBox;
    @FXML
    private ComboBox<String> IOComboBox;


    public void onActionShowroomComboBox(ActionEvent actionEvent) {
        upperTable.getItems().clear();
        String text = showroomComboBox.getValue();

        for (CarShowroom showroom : showroomsList) {
            if (Objects.equals(text, "Default")) {
                for (Vehicle veh : showroom.getVehicleMapSet()) {
                    upperTable.getItems().add(veh);
                }
            }
            if (Objects.equals(text, showroom.getName())) {
                for (Vehicle veh : showroom.getVehicleMapSet()) {
                    upperTable.getItems().add(veh);
                }
                break;
            }
        }
    }

    public void searchButtonOnClicked(MouseEvent mouseEvent) {
        lowerTable.getItems().clear();
        String text = modelTextField.getText();

        for (CarShowroom showroom : showroomsList) {
            for (Vehicle veh : showroom.getVehicleMapSet()) {
                if (Objects.equals(text, veh.getModel())) {
                    lowerTable.getItems().add(veh);
                }
            }
        }
    }

    public void sortButtonOnClicked(MouseEvent mouseEvent) {
        upperTable.getSortOrder().clear();
        String text = sortComboBox.getValue();

        if (Objects.equals(text, "Model")) {
            modelUpper.setSortType(TableColumn.SortType.ASCENDING);
            upperTable.getSortOrder().add(modelUpper);
            upperTable.sort();
        }
        if (Objects.equals(text, "Price")) {
            priceUpper.setSortType(TableColumn.SortType.ASCENDING);
            upperTable.getSortOrder().add(priceUpper);
            upperTable.sort();
        }
        if (Objects.equals(text, "Production year")) {
            productionYearUpper.setSortType(TableColumn.SortType.ASCENDING);
            upperTable.getSortOrder().add(productionYearUpper);
            upperTable.sort();
        }
    }

    public void buyButtonOnClicked(MouseEvent mouseEvent) {
        String text = modelTextField.getText();

        for (CarShowroom showroom : showroomsList) {
            for (Vehicle veh : showroom.getVehicleMapSet()) {
                if (Objects.equals(text, veh.getModel()) && !reservations.contains(veh)) {
                    //soldVehicles.add(veh);
                    showroom.removeProduct(veh.getModel());
                    break;
                }
            }
        }
    }

    public void reservationButtonOnClicked(MouseEvent mouseEvent) {
        String text = modelTextField.getText();

        for (CarShowroom showroom : showroomsList) {
            for (Vehicle veh : showroom.getVehicleMapSet()) {
                if (Objects.equals(text, veh.getModel())) {
                    reservations.add(veh);
                    break;
                }
            }
        }
    }


    public void onClickedSaveButton(MouseEvent mouseEvent) throws WorkOnFileException {
        String text = IOComboBox.getValue();
        String filename = "iofile.txt";

        if (Objects.equals(text, "Bought") && !soldVehicles.isEmpty()) {
            try {
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(soldVehicles);

                out.close();
                file.close();

            } catch (IOException exception) {
                exception.getStackTrace();
                throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
            }
        }
        for (CarShowroom showroom : showroomsList) {
            if (Objects.equals(text, showroom.getName())) {
                try {
                    FileOutputStream file = new FileOutputStream(filename);
                    ObjectOutputStream out = new ObjectOutputStream(file);

                    out.writeObject(showroom);

                    out.close();
                    file.close();

                } catch (IOException exception) {
                    exception.getStackTrace();
                    throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
                }
                break;
            }
        }
    }

    public void onClickedReadButton(MouseEvent mouseEvent) throws WorkOnFileException {
        String text = IOComboBox.getValue();
        String filename = "iofile.txt";

        if (Objects.equals(text, "Bought") && !soldVehicles.isEmpty()) {
            List<Vehicle> vehiclesList;
            try {
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                vehiclesList = (List<Vehicle>) in.readObject();

                in.close();
                file.close();

            } catch (IOException | ClassNotFoundException exception) {
                exception.getStackTrace();
                throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
            }
        }
        for (CarShowroom showroom : showroomsList) {
            if (Objects.equals(text, showroom.getName())) {
                try {
                    FileInputStream file = new FileInputStream(filename);
                    ObjectInputStream in = new ObjectInputStream(file);

                    showroom = (CarShowroom) in.readObject();

                    in.close();
                    file.close();

                } catch (IOException | ClassNotFoundException exception) {
                    exception.getStackTrace();
                    throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
                }
                break;
            }
        }
    }

    public void onClickedExportButton(MouseEvent mouseEvent) {
    }

    public void onClickedImportButton(MouseEvent mouseEvent) {
    }


    @FXML
    public void initialize() {
        /* objects */
        Vehicle car1 = new Vehicle("Opel", "Corsa", E_ItemCondition.USED, 20000, 2007, 350000., 40.0);
        Vehicle car2 = new Vehicle("Opel", "Corsa", E_ItemCondition.USED, 27000, 2015, 200000, 35.3);
        Vehicle car3 = new Vehicle("Mercedes", "A3", E_ItemCondition.USED, 35000, 2010, 250000.4, 38.2);
        Vehicle car4 = new Vehicle("BMW", "Seria 3", E_ItemCondition.USED, 40000, 2016, 300000.8, 42.0);
        Vehicle car5 = new Vehicle("BMW", "Seria 7", E_ItemCondition.USED, 55000, 2013, 400000, 38.5);
        CarShowroom speed = new CarShowroom("SpeedDe", 8);
        speed.addProduct(car1);
        speed.addProduct(car2);
        speed.addProduct(car3);
        speed.addProduct(car4);
        speed.addProduct(car5);
        speed.addProduct(car3);
        Vehicle car11 = new Vehicle("Ford", "Mondeo", E_ItemCondition.NEW, 100000, 2019, 1200.0, 35.0);
        Vehicle car12 = new Vehicle("Ford", "Focus 1.6", E_ItemCondition.NEW, 120000, 2019, 2000, 35.3);
        Vehicle car13 = new Vehicle("Ford", "Fiesta", E_ItemCondition.NEW, 115000, 2020, 2500.1, 36.2);
        Vehicle car14 = new Vehicle("Ford", "Fiesta 1.5", E_ItemCondition.NEW, 150000, 2019, 1300.5, 40.1);
        Vehicle car15 = new Vehicle("Hammer", "Hammve", E_ItemCondition.NEW, 300000, 2018, 1500, 45.5);
        CarShowroom american = new CarShowroom("AmericanCar", 16);
        american.addProduct(car11);
        american.addProduct(car12);
        american.addProduct(car12);
        american.addProduct(car12);
        american.addProduct(car13);
        american.addProduct(car13);
        american.addProduct(car14);
        american.addProduct(car14);
        american.addProduct(car15);
        Vehicle maluch = new Vehicle("Fiat", "Maluch", E_ItemCondition.DAMAGED, 1000, 1988, 550000, 31.5);
        Vehicle panda = new Vehicle("Fiat", "Panda", E_ItemCondition.USED, 1000, 2008, 250000, 41.5);
        CarShowroom newCar = new CarShowroom("New Car", 25);
        newCar.addProduct(maluch);
        newCar.addProduct(maluch);
        newCar.addProduct(panda);

        /* for tooltip */
        upperTable.setRowFactory(tableview -> {
            final TableRow<Vehicle> row = new TableRow<>();

            row.hoverProperty().addListener((observable -> {
                final Vehicle veh = row.getItem();

                if(row.isHover() && veh != null){
                    upperTooltip.setText(veh.getMark() + " " + veh.getModel() + " " + veh.getState() + " " + veh.getMileage() + " " + veh.getEngineCapacity());
                }
            }));
            return row;
        });

        lowerTable.setRowFactory(tv -> new TableRow<Vehicle>() {

            @Override
            public void updateItem(Vehicle veh, boolean empty) {
                super.updateItem(veh, empty);
                if (veh == null) {
                    setTooltip(null);
                } else {
                    lowerTooltip.setText(veh.getMark() + " " + veh.getModel() + " " + veh.getState() + " " + veh.getMileage() + " " + veh.getEngineCapacity());
                    setTooltip(lowerTooltip);
                }
            }
        });

        showroomsList = new ArrayList<>(Arrays.asList(speed, american, newCar));
        reservations = new ArrayList<>();

        /* combo boxes */
        ObservableList observableList = FXCollections.observableList(Arrays.asList("Default", speed.getName(), american.getName(), newCar.getName()));
        showroomComboBox.getItems().clear();
        showroomComboBox.setItems(observableList);
        observableList = FXCollections.observableList(Arrays.asList("Model", "Price", "Production year"));
        sortComboBox.getItems().clear();
        sortComboBox.setItems(observableList);
        observableList = FXCollections.observableList(Arrays.asList("Bought", speed.getName(), american.getName(), newCar.getName()));
        IOComboBox.getItems().clear();
        IOComboBox.setItems(observableList);

        /* table columns */
        showroomUpper.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("carShowroom"));
        markUpper.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("mark"));
        modelUpper.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
        priceUpper.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("price"));
        productionYearUpper.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("productionYear"));
        showroomLower.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("carShowroom"));
        markLower.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("mark"));
        modelLower.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
        priceLower.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("price"));
        productionYearLower.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("productionYear"));

    }

}
