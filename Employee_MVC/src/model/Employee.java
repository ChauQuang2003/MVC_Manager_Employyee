package model;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private double isFullTime;
    private boolean isActive;

    public Employee(int id, String name, double salary, double isFullTime, boolean isActive) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.isFullTime = isFullTime;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getIsFullTime() {
        return isFullTime;
    }

    public void setIsFullTime(double isFullTime) {
        this.isFullTime = isFullTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", isFullTime=" + isFullTime +
                ", isActive=" + isActive +
                '}';
    }
}
