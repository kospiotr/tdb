package pl.xperios.tdb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "username"})
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Status status;

    @JsonBackReference
    @OneToMany
    private List<Permission> permission = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "user")
    private List<UserGroup> userGroup = new ArrayList<>();

    @Version
    private Long version;

    public User(String username) {
        this.username = username;
    }
}
