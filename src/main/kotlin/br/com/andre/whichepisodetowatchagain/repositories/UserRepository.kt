package br.com.andre.whichepisodetowatchagain.repositories

import br.com.andre.whichepisodetowatchagain.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findOneByEmail(name: String): User
}