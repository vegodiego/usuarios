package co.com.sofka.model.user.values;

import java.util.Objects;

public class Email {
    private final String value;

    public Email(String value) {
        Objects.requireNonNull(value, "El email es obligatorio");
        if (value.isEmpty()){
            throw new IllegalArgumentException("El email no puede estar vacio");
        }
        if(!value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("Email no valido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Email of(String value){
        return new Email(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
