package com.gymsystem.model;

public class StudentMember extends DefaultMember {      //Implemetation of the Student class

    private String schoolName;      //declaring private variables to hold values
    private String memberGrade;
    private String memberParentName;

        //constructor
    public StudentMember(String membership_number, String member_name,String memberGender, String membership_start_date,
                         String memberWeight , String memberType,String memberCity,String memberContactNo, String schoolName,
                         String memberGrade,String memberParentName) {

        super(membership_number, member_name,memberGender, memberWeight, memberType,memberCity,memberContactNo, membership_start_date);

        this.schoolName = schoolName;
        this.memberGrade = memberGrade;
        this.memberParentName = memberParentName;
    }

    public StudentMember() {
        super();
    }               //relative Get set methods

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(String memberGrade) {
        this.memberGrade = memberGrade;
    }

    public String getMemberParentName() {
        return memberParentName;
    }

    public void setMemberParentName(String memberParentName) {
        this.memberParentName = memberParentName;
    }

    @Override
    public String toString() {               //setting toString method to get the string object
        return "com.gymsystem.model.StudentMember{" +
                "schoolName='" + schoolName + '\'' +
                ", memberGrade='" + memberGrade + '\'' +
                ", memberParentName='" + memberParentName + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {            //comparing objects equality
        if (this == o) return true;
        if (!(o instanceof StudentMember)) return false;
        if (!super.equals(o)) return false;

        StudentMember that = (StudentMember) o;

        if (!schoolName.equals(that.schoolName)) return false;
        if (!memberGrade.equals(that.memberGrade)) return false;
        return memberParentName.equals(that.memberParentName);
    }

    @Override
    public int hashCode() {                 //returns a Integer of a hashcode value
        int result = super.hashCode();
        result = 31 * result + schoolName.hashCode();
        result = 31 * result + memberGrade.hashCode();
        result = 31 * result + memberParentName.hashCode();
        return result;
    }
}
