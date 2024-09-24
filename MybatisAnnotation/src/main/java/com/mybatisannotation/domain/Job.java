package com.mybatisannotation.domain;

import java.io.Serializable;
import java.util.List;

public class Job implements Serializable  {
    private Integer id;
    private String jname;
    private String description;

    private List<Empyee> empyees;

    public List<Empyee> getEmpyees() {
        return empyees;
    }

    public void setEmpyees(List<Empyee> empyees) {
        this.empyees = empyees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jname='" + jname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
