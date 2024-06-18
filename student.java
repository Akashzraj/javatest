package javatest;

public class Student {
    private int studentNumber;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private String province;
    private double averageGrade;
    private String major;

    public Student(int studentNumber, String firstName, String lastName, String telephone, String address, String province, double averageGrade, String major) {
        if (studentNumber <= 200034000) {
            throw new IllegalArgumentException("Invalid student number");
        }
        if (firstName.length() <= 1 || lastName.length() <= 1) {
            throw new IllegalArgumentException("Name must be more than 1 character");
        }
        if (!telephone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("Invalid telephone number");
        }
        if (address.length() <= 6) {
            throw new IllegalArgumentException("Address must be more than 6 characters");
        }
        if (!"AB,BC,MB,NB,NL,NS,NT,NU,ON,PE,QC,SK,YT".contains(province)) {
            throw new IllegalArgumentException("Invalid province");
        }
        if (averageGrade < 0 || averageGrade > 100) {
            throw new IllegalArgumentException("Invalid average grade");
        }
        if (major.length() <= 5) {
            throw new IllegalArgumentException("Major must be more than 5 characters");
        }

        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.province = province;
        this.averageGrade = averageGrade;
        this.major = major;
    }

    // Getters and Setters
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        if (studentNumber <= 200034000) {
            throw new IllegalArgumentException("Invalid student number");
        }
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() <= 1) {
            throw new IllegalArgumentException("Name must be more than 1 character");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() <= 1) {
            throw new IllegalArgumentException("Name must be more than 1 character");
        }
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (!telephone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("Invalid telephone number");
        }
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() <= 6) {
            throw new IllegalArgumentException("Address must be more than 6 characters");
        }
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        if (!"AB,BC,MB,NB,NL,NS,NT,NU,ON,PE,QC,SK,YT".contains(province)) {
            throw new IllegalArgumentException("Invalid province");
        }
        this.province = province;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        if (averageGrade < 0 || averageGrade > 100) {
            throw new IllegalArgumentException("Invalid average grade");
        }
        this.averageGrade = averageGrade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major.length() <= 5) {
            throw new IllegalArgumentException("Major must be more than 5 characters");
        }
        this.major = major;
    }
}
