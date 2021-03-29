package br.com.andre.whichepisodetowatchagain.workers

import br.com.andre.whichepisodetowatchagain.model.Episode
import br.com.andre.whichepisodetowatchagain.model.dto.EpisodeDTO
import br.com.andre.whichepisodetowatchagain.repositories.EpisodeRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class EpisodesWorker(private val episodeRepository: EpisodeRepository) {
    fun listAll(id: Long): Flux<Episode> = episodeRepository.findByTvShow(id)

    fun mapAndThenSave(episodes: List<EpisodeDTO>, tvShow: Long): Flux<Episode> = episodes.map { episode -> Episode(tvShow, episode) }.save()

    private fun List<Episode>.save(): Flux<Episode> = episodeRepository.saveAll(this)
}