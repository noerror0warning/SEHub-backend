package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements Serializable {

    private static final long serialVersionUID=2L;

    @Id
    @NotNull
    String studentNO;

    @Column(name = "`name`")
    @NotNull
    String name;

    @Enumerated(EnumType.STRING)
    Department department;

    @Enumerated(EnumType.STRING)
    Position position;

    @MapsId
    @OneToOne
    User user;

    @ManyToMany
    Set<PropagandaApplication> pendingApplications;
}
