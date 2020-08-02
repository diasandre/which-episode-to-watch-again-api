package br.com.andre.whichepisodetowatchagain.workers

import arrow.syntax.function.pipe
import br.com.andre.whichepisodetowatchagain.model.User
import br.com.andre.whichepisodetowatchagain.repositories.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserWorker(private val userRepository: UserRepository, private val bCryptPasswordEncoder: PasswordEncoder) {

    fun save(user: User) = user.apply { password = bCryptPasswordEncoder.encode(password) } pipe userRepository::save
}