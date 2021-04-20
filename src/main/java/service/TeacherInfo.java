package service;

import java.util.ArrayList;

public class TeacherInfo {//class for information on Teachers
    private String teacherName;
    private String title;
    private String department;
    private String education;
    private String email;
    private TeacherInfo studentRecommendation;

    public TeacherInfo(String n, String t, String d, String e, String m)
    {
        teacherName = n;
        title = t;
        department = d;
        education = e;
        email = m;
    }

    public String getTeacherName()
    {
        return teacherName;
    }
    public String getTitle()
    {
        return title;
    }
    public String getDepartment()
    {
        return department;
    }
    public String getEducation()
    {
        return education;
    }
    public String getEmail()
    {
        return email;
    }

    public void setTeacherName(String t)
    {
        teacherName = t;
    }
    public void setTitle(String n)
    {
        title = n;
    }
    public void setDepartment(String d)
    {
        department = d;
    }
    public void setEducation(String e)
    {
        education = e;
    }
    public void setEmail(String m)
    {
        email = m;
    }
}

