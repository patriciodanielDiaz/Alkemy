package alkemy.challenger.Alkemy.model;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Builder
@ToString
//si queremos un borrado logico
@SQLUpdate( sql="UPDATE category SET deleted = true WHERE id=?")
@SQLDelete(sql = "DELETE FROM category where id=?")
@Where(clause = "deleted=false")
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String images;

    @CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Book> books;

}