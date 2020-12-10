package creational;

import java.util.Arrays;

public class BuilderTest {

    public static void main(String[] args) {
        Programmer programmer = new Programmer.ProgrammerBuilder()
                .setFirstName("F").setLastName("L")
                .setCity("City").setZipCode("0000A").setAddress("Street 39")
                .setLanguages(new String[] {"bash", "Perl"})
                .setProjects(new String[] {"Linux kernel"}).build();
        System.out.println(programmer.toString());

    }
}

class Programmer {
    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String city;
    private String[] languages;
    private String[] projects;

    private Programmer(String firstName, String lastName, String address, String zipCode, String city, String[] languages, String[] projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.languages = languages;
        this.projects = projects;
    }

    public static class ProgrammerBuilder{
        private String firstName;
        private String lastName;
        private String address;
        private String zipCode;
        private String city;
        private String[] languages;
        private String[] projects;

        public ProgrammerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProgrammerBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProgrammerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ProgrammerBuilder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public ProgrammerBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public ProgrammerBuilder setLanguages(String[] languages) {
            this.languages = languages;
            return this;
        }

        public ProgrammerBuilder setProjects(String[] projects) {
            this.projects = projects;
            return this;
        }

        public Programmer build() {
            return new Programmer(firstName, lastName, address, zipCode, city, languages, projects);
        }

    }

    @Override
    public String toString() {
        return "Programmer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", projects=" + Arrays.toString(projects) +
                '}';
    }
}

