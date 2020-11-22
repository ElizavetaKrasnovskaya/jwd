package com.epam.jwd.model;

import java.util.Objects;

public class Town {
    private String name;
    private double area;
    private int yearOfFoundation;
    private int population;
    private String state;

    public Town(){}

    public Town(String name, double area, int yearOfFoundation, int population, String state) {
        this.name = name;
        this.area = area;
        this.yearOfFoundation = yearOfFoundation;
        this.population = population;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town)) return false;
        Town town = (Town) o;
        return Double.compare(town.getArea(), getArea()) == 0 &&
                getYearOfFoundation() == town.getYearOfFoundation() &&
                getPopulation() == town.getPopulation() &&
                getName().equals(town.getName()) &&
                getState().equals(town.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getArea(), getYearOfFoundation(), getPopulation(), getState());
    }

    @Override
    public String toString() {
        return "Town" +
                "name=" + name +
                ", area=" + area +
                ", yearOfFoundation=" + yearOfFoundation +
                ", population=" + population +
                ", state=" + state;
    }
}
