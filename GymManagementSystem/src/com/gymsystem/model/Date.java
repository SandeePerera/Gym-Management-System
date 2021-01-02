package com.gymsystem.model;

public class Date {      //class for getting the date manually from the user

    private int year;       //declaring variables seperately
    private int month;
    private int day;

    public Date(int year, int month, int day){      //building constructor
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }           //relative get set methods

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {

        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDate() {      //this method used for getting the date in a specific format

        String date = getYear() +"-"+ getMonth() +"-"+ getDay();

        return date;
    }

    @Override
    public String toString() {             //toString method
        return "com.gymsystem.model.Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        if (year != date.year) return false;
        if (month != date.month) return false;
        return day == date.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }
}
