package basics;

import java.util.UUID;

final public class User {
    private final UUID id;  //id: UUID
    private final String name;  //userName: String
    private final String email;   //email: String

    private User (Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) { // java 17 fa il check del null automaticamente con instanceof. su J17 con instanceof potresti creare un variabile direttamtente dopo il check con il pattern Matching
            return false;
        }
        return id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        String maskedEmail = email.replaceAll("(.{2}).*(@.*)", "$1***$2"); // regex che oscura leggermente la email
        return "User{id=" + id + ", name=" + name + ", email=" + maskedEmail + "}";
    }

    public static User of(UUID id, String name, String email){
        return new Builder().id(id).name(name).email(email).build();
    }

    public static class Builder{
        private UUID id;
        private String name;
        private String email;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            if( this.id == null )
                throw new IllegalArgumentException("id cant be null");

            if (this.name == null || this.name.isBlank())
                throw new IllegalArgumentException("name cant be empty or null");

            if(this.email == null || this.email.isBlank())
                throw new IllegalArgumentException("email cant be empty or null");

            String emailPattern = "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$"; // regex presa dal web per fare il check dell'email senza usare classi aggiuntive, non valida perfettamente, per sempio permette email con 2 punti prima del dominio .
            if (!email.matches(emailPattern))
                throw new IllegalArgumentException("invalid email format");

            return new User(this);
        }
    }
}
