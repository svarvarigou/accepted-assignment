package com.varvarigou.accepted.assignment.models.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.varvarigou.accepted.assignment.enums.SpecifierEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "match_odds",
        indexes = {
                @Index(name = "IDX_SPECIFIER", columnList = "specifier")
        },
        uniqueConstraints={@UniqueConstraint(columnNames = {"match_id" , "specifier"})}
)
@Entity
@Data
@NoArgsConstructor
@ToString
public class MatchOdds implements Serializable {

    public MatchOdds(Long id, SpecifierEnum specifierValue, Double odd) {
        this.id = id;
        this.specifierValue = specifierValue;
        this.specifier = this.specifierValue.getType();
        this.odd = odd;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "specifier", nullable = false)
    private String specifier;

    @JsonIgnore
    @Transient
    private SpecifierEnum specifierValue;

    @Column(name="odd", nullable = false)
    private Double odd;

    @JsonIgnore
    @ManyToOne
    private Match match;
}
