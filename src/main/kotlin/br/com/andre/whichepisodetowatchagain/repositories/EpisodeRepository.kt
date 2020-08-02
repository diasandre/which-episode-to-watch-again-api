package br.com.andre.whichepisodetowatchagain.repositories

import br.com.andre.whichepisodetowatchagain.model.Episode
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EpisodeRepository : MongoRepository<Episode, String> {

    fun findByTvShow(tvShow: Long?): List<Episode?>?

    fun findOneByTvShow(tvShow: Long?): Episode?

    fun findOneById(id: Long): Episode
}