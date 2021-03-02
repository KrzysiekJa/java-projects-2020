package com.company;

import com.company.Classes.CarShowroom;
import com.company.Classes.Vehicle;
import com.company.DAO.CarShowroomDAO;
import com.company.DAO.DAO;
import com.company.DAO.VehicleDAO;
import com.company.Exceptetions.WorkOnFileException;
import com.company.Tables.CarShowroomTable;
import com.company.Tables.VehicleTable;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;




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
    private JTextField priceTextField;
    private JTextField productionYearTextField;
    private JTextField mileageTextField;
    private JTextField engineCapacityTextField;
    private JButton sortButton;
    private JComboBox<String> tableSelectionCombo;
    private JButton exportButton;
    private JLabel AmountField;

    final static DAO<CarShowroom> carShowroomDAO = new CarShowroomDAO();
    final static DAO<Vehicle> vehicleDAO = new VehicleDAO();


    public CarShowroomGUI() throws HeadlessException {
        this.add(rootPanel);
        this.setTitle("Car showroom App");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(rootPanel);
        this.tableSelectionCombo.addItem("Car showroom");
        this.tableSelectionCombo.addItem("Vehicles");
        AmountField.setText("0");



        AtomicReference<List<CarShowroom>> showrooms = new AtomicReference<>(carShowroomDAO.getAll());
        mainTable.setModel(new CarShowroomTable(showrooms.get()));
        ListSelectionModel selectionModel = mainTable.getSelectionModel();
        long[] carShowroomFlag = {0};


        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (!selectionModel.isSelectionEmpty()) {
                    carShowroomFlag[0] = showrooms.get().get(selectionModel.getMinSelectionIndex()).getId();
                }

                if (carShowroomFlag[0] >= 0) {
                    secondTable.setModel(new VehicleTable(vehicleDAO.getAllparam(carShowroomFlag[0])));
                    AmountField.setText(Double.toString(carShowroomDAO.showAmount(carShowroomFlag[0])));
                }
            }
        });

        addButton.addActionListener(e -> {

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Car showroom")) {
                String name = showroomNameTextField.getText();
                int capacity = Integer.parseInt(showroomCapacityTextField.getText());

                carShowroomDAO.save(new CarShowroom(name, capacity));
                showrooms.set(carShowroomDAO.getAll());
                mainTable.setModel(new CarShowroomTable(showrooms.get()));
            }

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Vehicles") && !selectionModel.isSelectionEmpty()) {
                String mark = carMarkTextField.getText();
                String model = carModelTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int productionYear = Integer.parseInt(productionYearTextField.getText());
                double mileage = Double.parseDouble(mileageTextField.getText());
                double capacity = Double.parseDouble(engineCapacityTextField.getText());

                if (carShowroomFlag[0] >= 0) {
                    Vehicle vehicle = new Vehicle(mark, model, price, productionYear, mileage, capacity, carShowroomFlag[0]);
                    vehicleDAO.save(vehicle);
                    secondTable.setModel(new VehicleTable(vehicleDAO.getAllparam(carShowroomFlag[0])));
                }
            }
        });

        removeButton.addActionListener(e -> {

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Car showroom")) {
                String name = showroomNameTextField.getText();

                carShowroomDAO.delete(showrooms.get().stream().filter(x -> x.getName().equals(name)).findFirst().get());
                showrooms.set(carShowroomDAO.getAll());
                secondTable.clearSelection();
                mainTable.setModel(new CarShowroomTable(showrooms.get()));
            }

            if (Objects.equals(tableSelectionCombo.getSelectedItem(), "Vehicles") && !selectionModel.isSelectionEmpty()) {
                String model = carModelTextField.getText();

                vehicleDAO.deleteByModel(model);
                if (carShowroomFlag[0] >= 0) {
                    secondTable.setModel(new VehicleTable(vehicleDAO.getAllparam(carShowroomFlag[0])));
                }
            }
        });

        sortButton.addActionListener(e -> {
            showrooms.get().sort(Comparator.comparing(CarShowroom::getCapacity));

            secondTable.clearSelection();
            mainTable.setModel(new CarShowroomTable(showrooms.get()));
        });


        exportButton.addActionListener(e -> {
            String filename = "iocsv.csv";
            StringBuilder result = new StringBuilder();
            List<Vehicle> vehicleList = vehicleDAO.getAll();

            try {
                PrintWriter writer = new PrintWriter(filename);
                writer.close();
                FileWriter file = new FileWriter(filename, true);
                BufferedWriter buffer = new BufferedWriter(file);
                writer = new PrintWriter(buffer);

                for (Vehicle veh : vehicleList) {

                    result.append(veh.getId()).append(",");
                    result.append(veh.getMark()).append(",");
                    result.append(veh.getModel()).append(",");
                    result.append(veh.getPrice()).append(",");
                    result.append(veh.getProductionYear()).append(",");
                    result.append(veh.getMileage()).append(",");
                    result.append(veh.getEngineCapacity()).append(",");
                    result.append(veh.getShowroom()).append(",");

                    if (!Objects.equals(result.toString(), "")) {
                        result.deleteCharAt(result.length() - 1);
                        writer.println(result.toString());
                        result = new StringBuilder();
                    }
                }

                writer.flush();
                writer.close();
                file.close();

            } catch (IOException exception) {
                exception.getStackTrace();
                try {
                    throw new WorkOnFileException("Problems with saving to the file " + filename);
                } catch (WorkOnFileException workOnFileException) {
                    workOnFileException.printStackTrace();
                }
            }

        });
    }
}

