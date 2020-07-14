package data.entities;

@Entity(name="USER")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    Private String email;
    Private String password;

    public UserEntity(Long id, String name, String lastName, Private string, Private string1) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        String = string;
        String = string1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Private getString() {
        return String;
    }

    public void setString(Private string) {
        String = string;
    }
}
