package com.scut.se.sehubbackend.Domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthentication implements Serializable, UserDetails {

    private static final long serialVersionUID=1L;

    @Id
    @NotNull
    String studentNO;

//    @ColumnTransformer(
//            read = "",
//            write = ""
//    )
    String password;

    @NotNull
    @OneToOne(
            mappedBy = "userAuthentication",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    UserInformation userInformation;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<UserAuthorityRecord> authorities;
    
    @OneToMany(
            mappedBy = "userAuthentication",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @NotNull
    SortedSet<UserHistory> userHistories;

    @Override
    public String getUsername() {
        return studentNO;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
