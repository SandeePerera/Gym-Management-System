package com.gymsystem.model;

public class DefaultMember {        //implementation of the parent class

    private String membership_number;   //declaring private variables to hold values
    private String member_name;
    private String memberGender;
    private String memberWeight;
    private String memberType;
    private String memberCity;
    private String memberContactNo;
    private String membership_start_date;

    public DefaultMember(String membership_number, String member_name,String memberGender, String memberWeight,String memberType,
                         String memberCity,String memberContactNo, String membership_start_date){
        this.membership_number = membership_number;
        this.member_name = member_name;                         //creation of the constructor
        this.memberGender = memberGender;
        this.memberWeight = memberWeight;
        this.memberType = memberType;
        this.memberCity = memberCity;
        this.memberContactNo = memberContactNo;
        this.membership_start_date = membership_start_date;

    }

    public DefaultMember() {

    }

        public String getMembership_number() {     //setting up public getters and setters to set and get values from variables
            return membership_number;
        }

        public void setMembership_number(String membership_number) {

        this.membership_number = membership_number;
        }

        public String getMember_name() {
            return member_name;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }

        public String getMembership_start_date() {
            return membership_start_date;
        }

        public String getMemberWeight() {
        return memberWeight;
        }

        public void setMemberWeight(String memberWeight) {
        this.memberWeight = memberWeight;
        }

        public String getMemberType() {
        return memberType;
        }

        public void setMemberType(String memberType) {
        this.memberType = memberType;
        }

        void setMembership_start_date(String membership_start_date) {
            this.membership_start_date = membership_start_date;
        }

        public String getMemberGender() {
        return memberGender;
        }

        public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
        }

        public String getMemberCity() {
        return memberCity;
        }

        public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
        }

        public String getMemberContactNo() {
        return memberContactNo;
        }

        public void setMemberContactNo(String memberContactNo) {
        this.memberContactNo = memberContactNo;
        }

    @Override
    public String toString() {                          //setting toString method to get the string object
        return "com.gymsystem.model.DefaultMember{" +
                "membership_number='" + membership_number + '\'' +
                ", member_name='" + member_name + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberWeight='" + memberWeight + '\'' +
                ", memberType='" + memberType + '\'' +
                ", memberCity='" + memberCity + '\'' +
                ", memberContactNo='" + memberContactNo + '\'' +
                ", membership_start_date='" + membership_start_date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {       //comparing objects equality
        if (this == o) return true;
        if (!(o instanceof DefaultMember)) return false;

        DefaultMember that = (DefaultMember) o;

        if (!membership_number.equals(that.membership_number)) return false;
        if (!member_name.equals(that.member_name)) return false;
        if (!memberGender.equals(that.memberGender)) return false;
        if (!memberWeight.equals(that.memberWeight)) return false;
        if (!memberType.equals(that.memberType)) return false;
        if (!memberCity.equals(that.memberCity)) return false;
        if (!memberContactNo.equals(that.memberContactNo)) return false;
        return membership_start_date.equals(that.membership_start_date);
    }

    @Override
    public int hashCode() {                         //returns a Integer of a hashcode value
        int result = membership_number.hashCode();
        result = 31 * result + member_name.hashCode();
        result = 31 * result + memberGender.hashCode();
        result = 31 * result + memberWeight.hashCode();
        result = 31 * result + memberType.hashCode();
        result = 31 * result + memberCity.hashCode();
        result = 31 * result + memberContactNo.hashCode();
        result = 31 * result + membership_start_date.hashCode();
        return result;
    }
}
