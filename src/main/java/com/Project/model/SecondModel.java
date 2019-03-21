package com.Project.model;

import java.util.List;

public class SecondModel {
    private List numbers;

    private String orders;

    public SecondModel(List numbers) {
        this.numbers = numbers;
    }

    public SecondModel(List numbers, String orders) {
        this.numbers = numbers;
        this.orders = orders;
    }

    public List getNumbers() {
        return numbers;
    }
}
