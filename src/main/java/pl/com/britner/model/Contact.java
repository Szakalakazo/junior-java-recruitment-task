package pl.com.britner.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Contact implements Serializable {

    @Getter
    private static final long serialVersionUID = 5429977054591803420L;

    private Long id;
    private int type;
    private String contact;

    public static final class contactBuilder {

        private Long id;
        private int type;
        private String contact;

        public contactBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public contactBuilder type(int type) {
            this.type = type;
            return this;
        }

        public contactBuilder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public Contact buildContact() {
            Contact contact = new Contact();
            contact.id = this.id;
            contact.type = this.type;
            contact.contact = this.contact;
            return contact;
        }
    }
}