package DataSource.jdbctemplate;

import java.util.Date;

public class empyee {
    public int id;
    public String ename;
    public String jname;
    public String description;
    public String mgr_name;
    public Date joindate;
    public Double salary;
    public Double bonus;
    public String dname;
    public String loc;
    public int grade;

    public String getMgr_name() {
        return mgr_name;
    }

    public void setMgr_name(String mgr_name) {
        this.mgr_name = mgr_name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public empyee() {
    }

    public empyee(int id, String ename, String jname, String description,
                  String mgr_name, Date joindate, Double salary,
                  Double bonus, String dname, String loc, int grade) {
        this.id = id;
        this.ename = ename;
        this.jname = jname;
        this.description = description;
        this.mgr_name = mgr_name;
        this.joindate = joindate;
        this.salary = salary;
        this.bonus = bonus;
        this.dname = dname;
        this.loc = loc;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
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
        return "empyee{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", jname='" + jname + '\'' +
                ", description='" + description + '\'' +
                ", mgr_name=" + mgr_name +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
