package com.ascii274.csvtojson.model;

import java.util.List;

public class CSVColumn {

    List<Integer> columns;

    public List<Integer> getColumns() {
        return columns;
    }

    public void setColumns(List<Integer> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "CSVColumn{" +
                "columns=" + columns +
                '}';
    }
}
