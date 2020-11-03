package net.asianPay.springboot.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class EmployeeAsiaPay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private long age;

    @Column(name = "company")
    private String company;

    @Column(name = "branch")
    private String branch;

    @Column(name = "createAt")
    private Date createAt;

    public EmployeeAsiaPay() {

    }

    public EmployeeAsiaPay(String name, long age, String company,String branch,Date createAt) {
        super();
        this.name = name;
        this.age = age;
        this.company = company;
        this.branch = branch;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public EmployeeAsiaPay setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeAsiaPay setName(String name) {
        this.name = name;
        return this;
    }

    public long getAge() {
        return age;
    }

    public EmployeeAsiaPay setAge(long age) {
        this.age = age;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public EmployeeAsiaPay setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public EmployeeAsiaPay setBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getCreateAt(String format) {
        return createAt;
    }

    public EmployeeAsiaPay setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }
}
