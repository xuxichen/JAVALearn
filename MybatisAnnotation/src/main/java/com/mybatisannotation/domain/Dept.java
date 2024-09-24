package com.mybatisannotation.domain;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {

    private Integer did;
    private String dname;
    private String dloc;

    private List<Empyee> empyees;

    public List<Empyee> getEmpyees() {
        return empyees;
    }

    public void setEmpyees(List<Empyee> empyees) {
        this.empyees = empyees;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dloc='" + dloc + '\'' +
                '}';
    }
}
