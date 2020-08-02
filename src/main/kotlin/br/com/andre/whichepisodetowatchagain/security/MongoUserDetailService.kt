package br.com.andre.whichepisodetowatchagain.security

import arrow.syntax.function.pipe
import br.com.andre.whichepisodetowatchagain.model.dto.UserDetailsImpl
import br.com.andre.whichepisodetowatchagain.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class MongoUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails =
            username?.let { userRepository.findOneByEmail(username) pipe ::UserDetailsImpl } ?: throw Exception()
}