package br.com.andre.whichepisodetowatchagain.api

import br.com.andre.whichepisodetowatchagain.workers.RandomEpisodeWorker
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/random")
class RandomApi(private val randomEpisodeWorker: RandomEpisodeWorker) {

    @GetMapping("/{tvShowId}")
    fun getRandomEpisode(@PathVariable tvShowId: Long) = randomEpisodeWorker.randomEpisode(tvShowId)

}