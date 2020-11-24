package com.company.Tables;

import com.company.Classes.Vehicle;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VehicleTable extends AbstractTableModel {

    private final String[] columnNames = new String[]{"Mark", "Model", "Condition", "Price", "Production year", "Mileage", "Engine capacity"};
    private List<Vehicle> data;


    public VehicleTable(List<Vehicle> data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Vehicle vehicle = data.get(row);

        switch (col) {
            case 0: return vehicle.getMark();
            case 1: return vehicle.getModel();
            case 2: return vehicle.getState();
            case 3: return vehicle.getPrice();
            case 4: return vehicle.getProductionYear();
            case 5: return vehicle.getMileage();
            case 6: return vehicle.getEngineCapacity();
            default: return null;
        }
    }
}
