package br.com.andre.whichepisodetowatchagain.workers

import br.com.andre.whichepisodetowatchagain.model.TvShow
import br.com.andre.whichepisodetowatchagain.repositories.TvShowRepository
import org.springframework.stereotype.Service

@Service
class TvShowsWorker(private val tvShowRepository: TvShowRepository) {
    fun listAll(): List<TvShow> = tvShowRepository.findAll()

    fun save(tvShow: TvShow) = tvShowRepository.save(tvShow)
}