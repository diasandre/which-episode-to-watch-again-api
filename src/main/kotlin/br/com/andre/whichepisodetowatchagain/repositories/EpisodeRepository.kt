package br.com.andre.whichepisodetowatchagain.repositories

import br.com.andre.whichepisodetowatchagain.model.Episode
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface EpisodeRepository : ReactiveMongoRepository<Episode, String> {

    fun findByTvShow(tvShow: Long?): Flux<Episode>
}