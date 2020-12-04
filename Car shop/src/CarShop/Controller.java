package CarShop;

import CarShop.Classes.CarShowroom;
import CarShop.Classes.E_ItemCondition;
import CarShop.Classes.Vehicle;
import CarShop.Exceptions.WorkOnFileException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Controller {

    public Tooltip upperTooltip;
    public Tooltip lowerTooltip;
    private final List<CarShowroom> showroomsList = new ArrayList<>();
    private final List<Vehicle> reservations = new ArrayList<>();
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


    public void onActionShowroomComboBox() {
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

    public void searchButtonOnClicked() {
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

    public void sortButtonOnClicked() {
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

    public void buyButtonOnClicked() {
        String text = modelTextField.getText();

        for (CarShowroom showroom : showroomsList) {
            for (Vehicle veh : showroom.getVehicleMapSet()) {
                if (Objects.equals(text, veh.getModel()) && !reservations.contains(veh)) {
                    soldVehicles.add(veh);
                    showroom.removeProduct(veh.getModel());
                    break;
                }
            }
        }
        onActionShowroomComboBox();
    }

    public void reservationButtonOnClicked() {
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


    public void onClickedSaveButton() throws WorkOnFileException {
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
                    throw new WorkOnFileException("Problems with loading the file " + filename, exception);
                }
                break;
            }
        }
    }

    public void onClickedReadButton() throws WorkOnFileException {
        String text = IOComboBox.getValue();
        String filename = "iofile.txt";

        if (Objects.equals(text, "Bought") && !soldVehicles.isEmpty()) {
            try {
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                soldVehicles = (List) in.readObject();

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

                    showroomsList.remove(showroom);
                    showroom = (CarShowroom) in.readObject();
                    showroomsList.add(showroom);

                    in.close();
                    file.close();

                } catch (IOException | ClassNotFoundException exception) {
                    exception.getStackTrace();
                    throw new WorkOnFileException("Problems with loading the file " + filename, exception);
                }
                break;
            }
        }
    }

    public void onClickedExportButton() throws WorkOnFileException {
        String text = IOComboBox.getValue();
        String filename = "iocsv.csv";
        String carShowroom, mark, model, price, productionYear, mileage, engineCapacity;

        if (Objects.equals(text, "Bought") && !soldVehicles.isEmpty()) {
            try {
                PrintWriter writer = new PrintWriter(filename);
                writer.close();
                FileWriter file = new FileWriter(filename, true);
                BufferedWriter buffer = new BufferedWriter(file);
                writer = new PrintWriter(buffer);

                for (Vehicle veh : soldVehicles) {
                    carShowroom = veh.getCarShowroom();
                    mark = veh.getMark();
                    model = veh.getModel();
                    price = Double.toString(veh.getPrice());
                    productionYear = Integer.toString(veh.getProductionYear());
                    mileage = Double.toString(veh.getMileage());
                    engineCapacity = Double.toString(veh.getEngineCapacity());

                    writer.println("0," + carShowroom + "," + mark + "," + model + "," + price + "," + productionYear + "," + mileage + "," + engineCapacity);
                }

                writer.flush();
                writer.close();
                file.close();

            } catch (IOException exception) {
                exception.getStackTrace();
                throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
            }
        }
        for (CarShowroom showroom : showroomsList) {
            if (Objects.equals(text, showroom.getName())) {
                try {
                    PrintWriter writer = new PrintWriter(filename);
                    writer.close();
                    FileWriter file = new FileWriter(filename, true);
                    BufferedWriter buffer = new BufferedWriter(file);
                    writer = new PrintWriter(buffer);

                    for (Vehicle veh : showroom.getVehicleMapSet()) {
                        carShowroom = veh.getCarShowroom();
                        mark = veh.getMark();
                        model = veh.getModel();
                        price = Double.toString(veh.getPrice());
                        productionYear = Integer.toString(veh.getProductionYear());
                        mileage = Double.toString(veh.getMileage());
                        engineCapacity = Double.toString(veh.getEngineCapacity());

                        writer.println(showroom.getVehicleAmount(veh) + "," + carShowroom + "," + mark + "," + model + "," + price + "," + productionYear + "," + mileage + "," + engineCapacity);
                    }

                    writer.flush();
                    writer.close();
                    file.close();

                } catch (IOException exception) {
                    exception.getStackTrace();
                    throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
                }
                break;
            }
        }
    }

    public void onClickedImportButton() throws WorkOnFileException {
        String text = IOComboBox.getValue();
        String filename = "iocsv.csv";
        String line;
        Vehicle veh;

        if (Objects.equals(text, "Bought") && !soldVehicles.isEmpty()) {
            try {
                soldVehicles.clear();

                FileReader file = new FileReader(filename);
                BufferedReader reader = new BufferedReader(file);

                while ((line = reader.readLine()) != null) {
                    String[] row = line.split(",");

                    veh = new Vehicle(row[2], row[3], E_ItemCondition.NEW, Double.parseDouble(row[4]), Integer.parseInt(row[5]), Double.parseDouble(row[6]), Double.parseDouble(row[7]));
                    veh.setCarShowroom(row[1]);
                    soldVehicles.add(veh);
                }

                reader.close();
                file.close();

            } catch (IOException exception) {
                exception.getStackTrace();
                throw new WorkOnFileException("Problems with loading the file " + filename, exception);
            }
        }
        for (CarShowroom showroom : showroomsList) {
            if (Objects.equals(text, showroom.getName())) {
                try {
                    for (Vehicle deleted : showroom.getVehicleMapSet()) {
                        showroom.removeProduct(deleted.getModel());
                    }

                    FileReader file = new FileReader(filename);
                    BufferedReader reader = new BufferedReader(file);

                    while ((line = reader.readLine()) != null) {
                        String[] row = line.split(",");

                        for (int i = 0; i < Integer.parseInt(row[0]); ++i) {
                            veh = new Vehicle(row[2], row[3], E_ItemCondition.NEW, Double.parseDouble(row[4]), Integer.parseInt(row[5]), Double.parseDouble(row[6]), Double.parseDouble(row[7]));
                            veh.setCarShowroom(row[1]);
                            showroom.addProduct(veh);
                        }
                    }

                    reader.close();
                    file.close();

                } catch (IOException exception) {
                    exception.getStackTrace();
                    throw new WorkOnFileException("Problems with loading the file " + filename, exception);
                }
                break;
            }
        }
    }

    public void closeProgram() throws WorkOnFileException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to save ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            String filename = "close.csv";
            String carShowroom, mark, model, price, productionYear, mileage, engineCapacity;

            for (CarShowroom showroom : showroomsList) {
                try {
                    FileWriter file = new FileWriter(filename, true);
                    BufferedWriter buffer = new BufferedWriter(file);
                    PrintWriter writer = new PrintWriter(buffer);

                    for (Vehicle veh : showroom.getVehicleMapSet()) {
                        carShowroom = veh.getCarShowroom();
                        mark = veh.getMark();
                        model = veh.getModel();
                        price = Double.toString(veh.getPrice());
                        productionYear = Integer.toString(veh.getProductionYear());
                        mileage = Double.toString(veh.getMileage());
                        engineCapacity = Double.toString(veh.getEngineCapacity());

                        writer.println(showroom.getVehicleAmount(veh) + "," + carShowroom + "," + mark + "," + model + "," + price + "," + productionYear + "," + mileage + "," + engineCapacity);
                    }

                    writer.flush();
                    writer.close();
                    file.close();

                } catch (IOException exception) {
                    exception.getStackTrace();
                    throw new WorkOnFileException("Problems with saving to the file " + filename, exception);
                }
            }
        }
    }




    @FXML
    public void initialize() throws WorkOnFileException {
        String filename = "init.csv";
        String line, showroomName = "";
        String[] row;
        Vehicle veh;
        CarShowroom showroom = null;

        /* objects */
        try {
            FileReader file = new FileReader(filename);
            BufferedReader reader = new BufferedReader(file);

            if ((line = reader.readLine()) != null) {
                row = line.split(",");
                showroomName = row[1];
                showroom = new CarShowroom(showroomName, 25);

                for (int i = 0; i < Integer.parseInt(row[0]); ++i) {
                    veh = new Vehicle(row[2], row[3], E_ItemCondition.NEW, Double.parseDouble(row[4]), Integer.parseInt(row[5]), Double.parseDouble(row[6]), Double.parseDouble(row[7]));
                    veh.setCarShowroom(row[1]);
                    showroom.addProduct(veh);
                }
            }

            while ((line = reader.readLine()) != null) {
                row = line.split(",");

                if (!Objects.equals(row[1], showroomName)) {
                    showroomsList.add(showroom);
                    showroomName = row[1];
                    showroom = new CarShowroom(showroomName, 20);
                }

                for (int i = 0; i < Integer.parseInt(row[0]); ++i) {
                    veh = new Vehicle(row[2], row[3], E_ItemCondition.NEW, Double.parseDouble(row[4]), Integer.parseInt(row[5]), Double.parseDouble(row[6]), Double.parseDouble(row[7]));
                    veh.setCarShowroom(showroomName);
                    assert showroom != null;
                    showroom.addProduct(veh);
                }
            }
            showroomsList.add(showroom);

            reader.close();
            file.close();

        } catch (IOException exception) {
            exception.getStackTrace();
            throw new WorkOnFileException("Problems with loading the file " + filename, exception);
        }


        /* for tooltip */
        upperTable.setRowFactory(tableview -> {
            final TableRow<Vehicle> rowT = new TableRow<>();

            rowT.hoverProperty().addListener((observable -> {
                final Vehicle vehT = rowT.getItem();

                if (rowT.isHover() && vehT != null) {
                    upperTooltip.setText(vehT.getMark() + " " + vehT.getModel() + " " + vehT.getState() + " Mileage: " + vehT.getMileage() + " Capacity: " + vehT.getEngineCapacity());
                }
            }));
            return rowT;
        });

        lowerTable.setRowFactory(tv -> new TableRow<>() {

            @Override
            public void updateItem(Vehicle veh, boolean empty) {
                super.updateItem(veh, empty);
                if (veh == null) {
                    setTooltip(null);
                } else {
                    lowerTooltip.setText(veh.getMark() + " " + veh.getModel() + " " + veh.getState() + " Mileage: " + veh.getMileage() + " Capacity: " + veh.getEngineCapacity());
                    setTooltip(lowerTooltip);
                }
            }
        });


        /* combo boxes */
        ObservableList observableList = FXCollections.observableList(Arrays.asList("Default", showroomsList.get(0).getName(), showroomsList.get(1).getName(), showroomsList.get(2).getName()));
        showroomComboBox.getItems().clear();
        showroomComboBox.setItems(observableList);
        observableList = FXCollections.observableList(Arrays.asList("Model", "Price", "Production year"));
        sortComboBox.getItems().clear();
        sortComboBox.setItems(observableList);
        observableList = FXCollections.observableList(Arrays.asList("Bought", showroomsList.get(0).getName(), showroomsList.get(1).getName(), showroomsList.get(2).getName()));
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
