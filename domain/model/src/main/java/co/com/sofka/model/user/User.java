package co.com.sofka.model.user;
import co.com.sofka.model.user.values.Description;
import co.com.sofka.model.user.values.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {
    private String id;
    private Email email;
    private Description description;

    public User() {
    }

    public User(String id, Email email, Description description) {
        this.id = id;
        this.email = email;
        this.description = description;
    }

    public User(Email email, Description description) {
        this.email = email;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
