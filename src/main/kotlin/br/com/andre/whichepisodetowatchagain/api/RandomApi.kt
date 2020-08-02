package br.com.andre.whichepisodetowatchagain.api

import br.com.andre.whichepisodetowatchagain.workers.RandomEpisodeWorker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/random")
class RandomApi(private val randomEpisodeWorker: RandomEpisodeWorker) {

    @GetMapping("/{tvShowId}")
    fun getRandomEpisode(@PathVariable tvShowId: Long) = randomEpisodeWorker.randomEpisode(tvShowId)

}