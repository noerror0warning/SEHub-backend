package com.scut.se.sehubbackend.Domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    String studentNO;



//    @ColumnTransformer(
//            read = "",
//            write = ""
//    )
    String password;

    @ElementCollection
    @Singular
    Set<GrantedAuthority> grantedAuthorities;
}
