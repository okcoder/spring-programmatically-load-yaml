package org.okcoder.sample.spring_programmatically_load_yaml;

public class TestConfig {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "TestConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
