package json.serialization.entity;

import json.serialization.serializer.Ignore;
import json.serialization.adapter.UseDataAdapter;
import json.serialization.adapter.impl.CollectionAdapter;
import json.serialization.adapter.impl.ColorAdapter;
import json.serialization.adapter.impl.LocalDateAdapter;
import json.serialization.adapter.impl.MapAdapter;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**
 * Simple Cat that will be used for testing JSON serialization
 */
public class Cat {
    private int age;
    private String name;

    @Ignore
    private Cat mySelf;

    @UseDataAdapter(LocalDateAdapter.class)
    private LocalDate birthDay;

    @UseDataAdapter(ColorAdapter.class)
    private Color color;

    @UseDataAdapter(CollectionAdapter.class)
    private List<Integer> whiskers = new ArrayList<>();

    @UseDataAdapter(MapAdapter.class)
    private Map<String, Paw> paws = new HashMap<>();


    public Cat() {
        mySelf = this;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getMySelf() {
        return mySelf;
    }

    public void setMySelf(Cat mySelf) {
        this.mySelf = mySelf;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Integer> getWhiskers() {
        return whiskers;
    }

    public void setWhiskers(List<Integer> whiskers) {
        this.whiskers = whiskers;
    }

    public Map<String, Paw> getPaws() {
        return paws;
    }

    public void setPaws(Map<String, Paw> paws) {
        this.paws = paws;
    }
}
