package com.fooddiaryexample.fooddiaryexample.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fooddiaryexample.fooddiaryexample.utils.enums.Role;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user",schema = "public")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override //kullanıcının aldığı rolleri listeleyen method
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Role.USER.name()));
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override //kullanıcının hesap süresi
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //kullanıcının hesabının kilitli olup olmadığı
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //kullanıcının devre dışı olup olmadığını gösterir
    public boolean isEnabled() {
        return true;
    }
}
