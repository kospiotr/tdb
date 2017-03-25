package pl.xperios.tdb.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "name"})
@Entity
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(unique = true)
    private String name;

    @JsonManagedReference
    @ManyToMany
    private List<User> user;

    @OneToMany
    private List<Permission> permission = new ArrayList<>();

    public UserGroup(String name) {
        this.name = name;
    }

}
