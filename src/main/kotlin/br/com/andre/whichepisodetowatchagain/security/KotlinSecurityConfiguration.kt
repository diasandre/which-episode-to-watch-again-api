package br.com.andre.whichepisodetowatchagain.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@EnableWebSecurity
class KotlinSecurityConfiguration(private val mongoUserDetailsService: MongoUserDetailsService) : WebSecurityConfigurerAdapter() {

    companion object {
        const val ROLE_ADMIN = "ROLE_ADMIN"
        const val ROLE_USER = "ROLE_USER"
    }

    override fun configure(http: HttpSecurity?) {
        http {
            httpBasic {}
            csrf { disable() }
            cors { disable() }
            authorizeRequests {
                authorize("/episodes/**", hasAuthority(ROLE_ADMIN))
                authorize("/tv-shows/**", hasAuthority(ROLE_ADMIN))
                authorize("/user/**", hasAuthority(ROLE_ADMIN))
                authorize("/**", permitAll)
            }
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(builder: AuthenticationManagerBuilder) {
        builder.userDetailsService(mongoUserDetailsService).passwordEncoder(passwordEncoder())
    }
}