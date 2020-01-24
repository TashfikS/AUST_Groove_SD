package com.example.user.austgroove;

public class UserDetails {

    private String Name,Email,Section,YearSemester,Password;

    public UserDetails(String name, String email, String section, String yearSemester, String password) {
        Name = name;
        Email = email;
        Section = section;
        YearSemester = yearSemester;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getYearSemester() {
        return YearSemester;
    }

    public void setYearSemester(String yearSemester) {
        YearSemester = yearSemester;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
