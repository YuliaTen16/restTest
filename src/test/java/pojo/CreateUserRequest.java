package pojo;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest {
    private  String email;
    private  String name;
    private  String hobby;
    private  String phone;
    private  String inn;
    private List<Integer> companies;
    private  List<Integer> tasks;

    public List<Integer> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Integer> companies) {
        this.companies = companies;
    }

    public List<Integer> getTasks() {
        return tasks;
    }

    public void setTasks(List<Integer> tasks) {
        this.tasks = tasks;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }


}
