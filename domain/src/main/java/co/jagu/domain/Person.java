package co.jagu.domain;

/**
 * Class that represent a person in the domain
 */
public class Person {

    /*--
    Fields
    --*/
    private long id;
    private String firstName;
    private String lastName;
    private String avatar;

    /*--
    Setters and getters
    --*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
