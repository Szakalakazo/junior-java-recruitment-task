package pl.com.britner.model;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

    private static final long serialVersionUID = 8197289559272978540L;

    private Long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private List<Contact> contactList;

    public static final class customerBuilder {

        private int age;
        private Long id;
        private String name;
        private String surname;
        private String city;
        private List<Contact> contactList;

        public customerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public customerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public customerBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public customerBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public customerBuilder city(String city) {
            this.city = city;
            return this;
        }

        public customerBuilder contactList(List<Contact> contactList) {
            this.contactList = contactList;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.id = this.id;
            customer.age = this.age;
            customer.city = this.city;
            customer.name = this.name;
            customer.surname = this.surname;
            customer.contactList = this.contactList;
            return customer;
        }
    }
}