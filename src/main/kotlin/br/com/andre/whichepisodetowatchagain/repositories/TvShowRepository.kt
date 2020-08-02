package br.com.andre.whichepisodetowatchagain.repositories

import br.com.andre.whichepisodetowatchagain.model.TvShow
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TvShowRepository : MongoRepository<TvShow, String> {
    fun findOneById(id: Long): TvShow
}