package br.com.andre.whichepisodetowatchagain.workers

import br.com.andre.whichepisodetowatchagain.model.Episode
import br.com.andre.whichepisodetowatchagain.repositories.EpisodeRepository
import org.springframework.stereotype.Service

@Service
class RandomEpisodeWorker(private val episodeRepository: EpisodeRepository) {

    //TODO use aggregate to get random document from mongo
    fun randomEpisode(id: Long): Episode? = episodeRepository.findByTvShow(id)?.shuffled()?.take(1)?.firstOrNull()
}