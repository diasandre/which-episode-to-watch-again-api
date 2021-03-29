package br.com.andre.whichepisodetowatchagain.api

import br.com.andre.whichepisodetowatchagain.model.Episode
import br.com.andre.whichepisodetowatchagain.model.dto.EpisodeDTO
import br.com.andre.whichepisodetowatchagain.workers.EpisodesWorker
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/episodes")
class EpisodeApi(private val episodesWorker: EpisodesWorker) {

    @GetMapping("/{tvShowId}")
    fun listAll(@PathVariable tvShowId: Long): Flux<Episode> = episodesWorker.listAll(tvShowId)

    @PostMapping("/{tvShowId}")
    fun save(@PathVariable tvShowId: Long, @RequestBody episodes: List<EpisodeDTO>): Flux<Episode> = episodesWorker.mapAndThenSave(episodes, tvShowId)

}