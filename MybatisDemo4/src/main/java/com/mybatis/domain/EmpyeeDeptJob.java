package com.mybatis.domain;

public class EmpyeeDeptJob extends Empyee {
    private String dname;
    private String loc;
    private String jname;
    private String description;

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
        return super.toString() + "    EmpyeeDeptJob{" +
                "dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", jname='" + jname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
