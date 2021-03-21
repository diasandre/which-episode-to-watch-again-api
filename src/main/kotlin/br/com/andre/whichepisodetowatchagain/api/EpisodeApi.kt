package br.com.andre.whichepisodetowatchagain.api

import br.com.andre.whichepisodetowatchagain.model.dto.EpisodeDTO
import br.com.andre.whichepisodetowatchagain.workers.EpisodesWorker
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/episodes")
class EpisodeApi(private val episodesWorker: EpisodesWorker) {

    @GetMapping("/{tvShowId}")
    fun listAll(@PathVariable tvShowId: Long) = episodesWorker.listAll(tvShowId)

    @PostMapping("/{tvShowId}")
    fun save(@PathVariable tvShowId: Long, @RequestBody episodes: List<EpisodeDTO>) = episodesWorker.mapAndThenSave(episodes, tvShowId)

}