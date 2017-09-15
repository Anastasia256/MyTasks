package jdbc.learn.entity;

public class Elephant {
    private Integer id;
    private Integer age;
    private String name;
    private Double weight;

    public Elephant() {
    }

    public Elephant(Integer id, Integer age, String name, Double weight) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

