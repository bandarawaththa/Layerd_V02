package tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String id;
    private String name;
    private int contact;
    private String address;
    private Button button;

    public CustomerTM() {
    }

    public CustomerTM(String id, String name, int contact, String address, Button button) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.button = button;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", address='" + address + '\'' +
                ", button=" + button +
                '}';
    }
}