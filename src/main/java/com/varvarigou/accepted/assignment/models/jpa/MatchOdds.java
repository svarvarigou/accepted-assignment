package com.varvarigou.accepted.assignment.models.jpa;

import com.varvarigou.accepted.assignment.enums.SpecifierEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "match_odds",
        indexes = {
                @Index(name = "IDX_SPECIFIER", columnList = "specifier")
        }
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchOdds implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

/*    @Column(name = "match_id",  insertable=false, updatable=false)
    private Long match_id;*/

    @Column(name="specifier", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private SpecifierEnum specifier;

    @Column(name="odd", nullable = false)
    private Double odd;

    @ManyToOne(optional = false)
    private Match match;
}
