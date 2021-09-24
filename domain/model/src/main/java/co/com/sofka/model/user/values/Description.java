package co.com.sofka.model.user.values;

import java.util.Objects;

public class Description {
    private final String value;

    public Description(String value) {
        Objects.requireNonNull(value, "La descripcion es obligatorio");
        if (value.isEmpty()){
            throw new IllegalArgumentException("La descripcion no puede estar vacio");
        }
        if(value.length()<20){
            throw  new IllegalArgumentException("La descripcion debe tener mas de 20 caracteres");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Description of(String value){
        return new Description(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
