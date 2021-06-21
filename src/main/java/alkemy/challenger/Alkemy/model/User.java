package alkemy.challenger.Alkemy.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NonNull
    @Column(nullable = false)
    private String lastName;

    @NonNull
    @Column(nullable = false)
    private String email;


    @NonNull
    @Column(nullable = false)
    private Integer age;

    @NonNull
    @Column(nullable = false)
    private String password ;

    private String photo;

    private Boolean deleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date create_at_register;


}
