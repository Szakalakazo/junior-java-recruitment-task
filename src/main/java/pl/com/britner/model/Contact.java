package pl.com.britner.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private static final long serialVersionUID = 5429977054591803420L;

    private Long id;
    private Long customerId;
    private int type;
    private String contact;

    public static final class contactBuilder {

        private Long id;
        private Long customerId;
        private int type;
        private String contact;

        public contactBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public contactBuilder customerId(Long customerId) {
            this.customerId = customerId;
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

        public Contact build() {
            Contact contact = new Contact();
            contact.id = this.id;
            contact.customerId = this.customerId;
            contact.type = this.type;
            contact.contact = this.contact;
            return contact;
        }
    }
}