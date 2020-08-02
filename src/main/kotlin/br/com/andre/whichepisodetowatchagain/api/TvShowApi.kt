package br.com.andre.whichepisodetowatchagain.api

import br.com.andre.whichepisodetowatchagain.model.TvShow
import br.com.andre.whichepisodetowatchagain.workers.TvShowsWorker
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tv-shows")
class TvShowApi(private val tvShowsWorker: TvShowsWorker) {

    @GetMapping("/")
    fun listAll(): List<TvShow> = tvShowsWorker.listAll()

    @PostMapping("/save")
    fun save(tvShow: TvShow) = tvShowsWorker.save(tvShow)

}