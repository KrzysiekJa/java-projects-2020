package com.company;

import com.company.Tables.CarShowroomTable;
import com.company.Classes.CarShowroom;
import com.company.Classes.E_ItemCondition;
import com.company.Classes.Vehicle;
import com.company.Tables.VehicleTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;


public class CarShowroomGUI extends JFrame {

    private JTable mainTable;
    private JTable secondTable;
    private JPanel rootPanel;
    private JButton addButton;
    private JButton removeButton;
    private JTextField showroomNameTextField;
    private JTextField showroomCapacityTextField;
    private JTextField carMarkTextField;
    private JTextField carModelTextField;
    private JComboBox<E_ItemCondition> conditionComboBox;
    private JTextField priceTextField;
    private JTextField productionYearTextField;
    private JTextField mileageTextField;
    private JTextField engineCapacityTextField;
    private JButton sortButton;
    private JComboBox<String> tableSelectionCombo;


    public CarShowroomGUI() throws HeadlessException {
        this.add(rootPanel);
        this.setTitle("Car showroom App");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(rootPanel);
        this.conditionComboBox.addItem(E_ItemCondition.NEW);
        this.conditionComboBox.addItem(E_ItemCondition.USED);
        this.conditionComboBox.addItem(E_ItemCondition.DAMAGED);
        this.tableSelectionCombo.addItem("Car showroom");
        this.tableSelectionCombo.addItem("Vehicles");


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


        List<CarShowroom> showrooms = new ArrayList<>(Arrays.asList(speed, american, newCar));
        mainTable.setModel(new CarShowroomTable(showrooms));
        List<Vehicle> vehiclesList = new ArrayList<>();
        int[] carShowroomFlag = {-1};


        ListSelectionModel selectionModel = mainTable.getSelectionModel();

        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                carShowroomFlag[0] = selectionModel.getMinSelectionIndex();

                if(carShowroomFlag[0] >= 0) {
                    vehiclesList.clear();
                    vehiclesList.addAll(showrooms.get(carShowroomFlag[0]).getVehicleMapSet());
                    secondTable.setModel(new VehicleTable(vehiclesList));
                }
            }
        });

        addButton.addActionListener(e -> {

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Car showroom")) {
                String name = showroomNameTextField.getText();
                int capacity = Integer.parseInt(showroomCapacityTextField.getText());

                showrooms.add(new CarShowroom(name, capacity));

                if (carShowroomFlag[0] >= 0) {
                    secondTable.setModel(new VehicleTable(vehiclesList));
                }
                mainTable.setModel(new CarShowroomTable(showrooms));
            }

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Vehicles")) {
                String mark = carMarkTextField.getText();
                String model = carModelTextField.getText();
                E_ItemCondition condition = (E_ItemCondition) conditionComboBox.getSelectedItem();
                double price = Double.parseDouble(priceTextField.getText());
                int productionYear = Integer.parseInt(productionYearTextField.getText());
                double mileage = Double.parseDouble(mileageTextField.getText());
                double capacity = Double.parseDouble(engineCapacityTextField.getText());

                Vehicle vehicle = new Vehicle(mark, model, condition, price, productionYear, mileage, capacity);
                if(carShowroomFlag[0] >= 0){
                    vehiclesList.add(vehicle);
                    showrooms.get(carShowroomFlag[0]).addProduct(vehicle);
                }

                secondTable.setModel(new VehicleTable(vehiclesList));
            }
        });

        removeButton.addActionListener(e -> {

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Car showroom")) {
                String name = showroomNameTextField.getText();

                showrooms.removeIf(t -> t.getName().equals(name));

                secondTable.clearSelection();
                mainTable.setModel(new CarShowroomTable(showrooms));
            }

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Vehicles")) {
                String model = carModelTextField.getText();

                if (vehiclesList.removeIf(t -> t.getModel().equals(model))) {
                    showrooms.get(carShowroomFlag[0]).removeProduct(model);
                }
                secondTable.setModel(new VehicleTable(vehiclesList));
            }
        });

        sortButton.addActionListener(e -> {
            showrooms.sort(Comparator.comparing(CarShowroom::getCapacity));

            mainTable.setModel(new CarShowroomTable(showrooms));
        });
    }
}
