package com.company.Tables;

import com.company.Classes.CarShowroom;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CarShowroomTable extends AbstractTableModel {

    private final String[] columnNames = new String[]{"Name", "Capacity"};
    private List<CarShowroom> data;


    public CarShowroomTable(List<CarShowroom> data) {
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
        CarShowroom carShowroom = data.get(row);

        switch (col) {
            case 0:
                return carShowroom.getName();
            case 1:
                return carShowroom.getCapacity();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        CarShowroom carShowroom = data.get(row);

        switch (col) {
            case 0:
                carShowroom.setName(value.toString());
                break;
            case 1:
                if (value instanceof Integer) {
                    carShowroom.setCapacity((Integer) value);
                }
                break;
        }
        fireTableRowsUpdated(row, col);
    }
}
