package com.neusoft.backend.Model;

import java.io.Serializable;

//redis 需要 implement
public class Teacher implements Serializable {
    private String t_id;
    private String t_password;
    private String t_name;
    private String t_gender;
    private String t_duty;
    private String t_research;
    private String t_university;
    private String t_specialty;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_gender() {
        return t_gender;
    }

    public void setT_gender(String t_gender) {
        this.t_gender = t_gender;
    }

    public String getT_duty() {
        return t_duty;
    }

    public void setT_duty(String t_duty) {
        this.t_duty = t_duty;
    }

    public String getT_research() {
        return t_research;
    }

    public void setT_research(String t_research) {
        this.t_research = t_research;
    }

    public String getT_university() {
        return t_university;
    }

    public void setT_university(String t_university) {
        this.t_university = t_university;
    }

    public String getT_specialty() {
        return t_specialty;
    }

    public void setT_specialty(String t_specialty) {
        this.t_specialty = t_specialty;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id='" + t_id + '\'' +
                ", t_password='" + t_password + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_gender='" + t_gender + '\'' +
                ", t_duty='" + t_duty + '\'' +
                ", t_research='" + t_research + '\'' +
                ", t_university='" + t_university + '\'' +
                ", t_specialty='" + t_specialty + '\'' +
                '}';
    }
}
