package br.com.andre.whichepisodetowatchagain.model.dto

import br.com.andre.whichepisodetowatchagain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserDetailsImpl(private val user: User) : UserDetails {
    override fun getAuthorities() = mutableListOf<GrantedAuthority>()
    override fun isEnabled() = true
    override fun getUsername(): String = user.email
    override fun isCredentialsNonExpired() = true
    override fun getPassword(): String = user.password
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
}