import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Illegal age");
        else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null || name.isEmpty()) throw new IllegalStateException("name is Empty");
        if (surname == null || surname.isEmpty()) throw new IllegalStateException("surname is Empty");
        if (!OptionalInt.of(age).isEmpty()) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (address != null && !address.isEmpty()) person.setAddress(address);
        return person;
    }
}
