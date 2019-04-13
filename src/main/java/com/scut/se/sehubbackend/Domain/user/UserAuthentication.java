package com.scut.se.sehubbackend.Domain.user;

import lombok.*;
import org.hibernate.annotations.SortComparator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
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
    Set<UserAuthorityRecord> authorityRecords;

    @Singular
    @OneToMany(
            mappedBy = "userAuthentication",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @SortComparator(value = UserHistoryComparator.class)
    @NotNull
    SortedSet<UserHistory> userHistories;

    public void setAuthorityRecords(Set<GrantedAuthority> grantedAuthorities){
        UserAuthorityRecord.toUserAuthorityRecords(this,grantedAuthorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return UserAuthorityRecord.toGrantedAuthorities(getAuthorityRecords());
    }

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
