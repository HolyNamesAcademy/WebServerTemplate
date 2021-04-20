package service;

import java.util.ArrayList;

public class Recommendations {//class for Recommendations
    private String teacherName;
    private String name;
    private int classYear;
    private String recommendation;
    private String why;
    private Recommendations studentRecommendation;

    public Recommendations(String t, String n, int i, String r, String w)
    {
        teacherName = t;
        name = n;
        classYear = i;
        recommendation = r;
        why = w;
    }

    public String getTeacherName()
    {
        return teacherName;
    }
    public String getStudentName()
    {
        return name;
    }
    public int getClassYear()
    {
        return classYear;
    }
    public String getRecommendation()
    {
        return recommendation;
    }
    public String getWhy()
    {
        return why;
    }

    public void setTeacherName(String t)
    {
        teacherName = t;
    }
    public void setStudentName(String n)
    {
        name = n;
    }
    public void setClassYear(int i)
    {
        classYear = i;
    }
    public void setRecommendation(String r)
    {
        recommendation = r;
    }
    public void setWhy(String w)
    {
        why = w;
    }
}
