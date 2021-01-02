package com.gymsystem.model;

public class Over60Member extends DefaultMember {       //Implemetation of the Over60 member class

    private int age;                //declaring private variables to hold values
    private String memberDisability;

                //Constructor
    public Over60Member(String membership_number, String member_name,String memberGender, String memberWeight,String memberType,
                        String memberCity, String memberContactNo, String membership_start_date, int age, String memberDisability) {

        super(membership_number, member_name,memberGender,memberWeight,memberType,memberCity,memberContactNo, membership_start_date);

        this.age = age;
        this.memberDisability = memberDisability;
    }

    public Over60Member() {
        super();
    }       //relative Get set methods

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMemberDisability() {
        return memberDisability;
    }

    public void setMemberDisability(String memberDisability) {
        this.memberDisability = memberDisability;
    }

    @Override
    public String toString() {                          //setting toString method to get the string object
        return "com.gymsystem.model.Over60Member{" +
                "age=" + age +
                ", memberDisability='" + memberDisability + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {        //comparing objects equality
        if (this == o) return true;
        if (!(o instanceof Over60Member)) return false;
        if (!super.equals(o)) return false;

        Over60Member that = (Over60Member) o;

        if (age != that.age) return false;
        return memberDisability.equals(that.memberDisability);
    }

    @Override
    public int hashCode() {               //returns a Integer of a hashcode value
        int result = super.hashCode();
        result = 31 * result + age;
        result = 31 * result + memberDisability.hashCode();
        return result;
    }
}
