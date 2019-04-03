package com.scut.se.sehubbackend.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthentication implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    String studentNO;

//    @ColumnTransformer(
//            read = "",
//            write = ""
//    )
    String password;



//    @ElementCollection
//    @Singular
//    Set<GrantedAuthority> grantedAuthorities;

    @NotNull
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    UserInformation userInformation;

    @OneToMany(
            mappedBy = "userAuthentication",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<UserHistory> userHistories;

}
