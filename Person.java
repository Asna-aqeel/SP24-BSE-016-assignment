package com.company.demo2;

public class Person {
    private String name;
    private String fathername;
    private String CNIC;
    private String date;
    private String Persongender;
    private String  Personcity;

    public Person(String name, String fathername, String CNIC, String date, String Persongender, String Personcity) {
        this.name = name;
        this.fathername = fathername;
        this.CNIC = CNIC;
        this.date = date;
        this.Persongender = Persongender;
        this.Personcity = Personcity;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fathername;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getDate() {
        return date;
    }

    public String getGender() {
        return Persongender;
    }

    public String getCity() {
        return Personcity;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", fatherName='" + fathername + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + Persongender + '\'' +
                ", city='" + Personcity + '\'' +
                '}';
    }
}