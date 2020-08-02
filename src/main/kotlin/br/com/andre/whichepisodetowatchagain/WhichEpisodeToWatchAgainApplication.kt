package br.com.andre.whichepisodetowatchagain

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WhichEpisodeToWatchAgainApplication

fun main(args: Array<String>) {
    runApplication<WhichEpisodeToWatchAgainApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
