package com.mybatis.domain;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {

    private Integer id;
    private String dname;
    private String loc;

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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
