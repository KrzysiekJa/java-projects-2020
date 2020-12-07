package com.company.Tables;

import com.company.Classes.Vehicle;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VehicleTable extends AbstractTableModel {

    private final String[] columnNames = new String[]{"Mark", "Model", "Price", "Production year", "Mileage", "Engine capacity"};
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
            case 0:
                return vehicle.getMark();
            case 1:
                return vehicle.getModel();
            case 2:
                return vehicle.getPrice();
            case 3:
                return vehicle.getProductionYear();
            case 4:
                return vehicle.getMileage();
            case 5:
                return vehicle.getEngineCapacity();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Vehicle vehicle = data.get(row);

            switch (col) {
                case 0:
                    vehicle.setMark(value.toString());
                    break;
                case 1:
                    vehicle.setModel(value.toString());
                    break;
                case 2:
                    if (value instanceof Double) {
                        vehicle.setPrice((Double) value);
                    }
                    break;
                case 3:
                    if (value instanceof Integer) {
                        vehicle.setProductionYear((Integer) value);
                    }
                    break;
                case 4:
                    if (value instanceof Double) {
                        vehicle.setMileage((Double) value);
                    }
                    break;
                case 5:
                    if (value instanceof Double) {
                        vehicle.setEngineCapacity((Double) value);
                    }
                    break;
            }
            fireTableRowsUpdated(row, col);
        }
    }
