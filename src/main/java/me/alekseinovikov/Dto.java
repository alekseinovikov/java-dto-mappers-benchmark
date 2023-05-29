package me.alekseinovikov;

import java.util.Objects;

public class Dto {
    private Long id;
    private String name;
    private String description;
    private Integer number;
    private Boolean flag;
    private Double price;

    public Dto(final Long id, final String name, final String description, final Integer number, final Boolean flag, final Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.number = number;
        this.flag = flag;
        this.price = price;
    }

    public Dto() {
    }

    public Long getId() {
        return id;
    }

    public Dto setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dto setName(final String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Dto setDescription(final String description) {
        this.description = description;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Dto setNumber(final Integer number) {
        this.number = number;
        return this;
    }

    public Boolean getFlag() {
        return flag;
    }

    public Dto setFlag(final Boolean flag) {
        this.flag = flag;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Dto setPrice(final Double price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Dto entity)) {
            return false;
        }
        return Objects.equals(id, entity.id) && Objects.equals(name, entity.name) && Objects.equals(description, entity.description) && Objects.equals(number, entity.number) && Objects.equals(flag, entity.flag) && Objects.equals(price, entity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, number, flag, price);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", number=" + number +
                ", flag=" + flag +
                ", price=" + price +
                '}';
    }
}
