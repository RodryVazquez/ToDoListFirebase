package Models;

/**
 * Created by Rodrigo on 5/31/2016.
 */
public class ContactModel {

    String phone;
    String name;

    public ContactModel(){}

    public ContactModel(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
