package br.com.andre.whichepisodetowatchagain.api

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelpAPI : ErrorController {

    @GetMapping("/")
    fun help() = label()

    @GetMapping("/error")
    fun error() = label()

    override fun getErrorPath(): String = "error"
}

private fun label() = "Hi. Welcome to WETWA API. If you want more information access: https://github.com/diasandre/which-episode-to-watch-again-api"