package br.com.andre.whichepisodetowatchagain.workers

import br.com.andre.whichepisodetowatchagain.model.Episode
import br.com.andre.whichepisodetowatchagain.model.dto.EpisodeDTO
import br.com.andre.whichepisodetowatchagain.repositories.EpisodeRepository
import org.springframework.stereotype.Service

@Service
class EpisodesWorker(private val episodeRepository: EpisodeRepository) {
    fun listAll(id: Long) = episodeRepository.findByTvShow(id)

    fun mapAndThenSave(episodes: List<EpisodeDTO>, tvShow: Long) = episodes.map { episode -> Episode(tvShow, episode) }.save()

    private fun List<Episode>.save(): MutableList<Episode> = episodeRepository.saveAll(this)
}