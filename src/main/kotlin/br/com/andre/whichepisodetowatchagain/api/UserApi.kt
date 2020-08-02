package br.com.andre.whichepisodetowatchagain.api

import br.com.andre.whichepisodetowatchagain.model.User
import br.com.andre.whichepisodetowatchagain.model.dto.EpisodeDTO
import br.com.andre.whichepisodetowatchagain.workers.EpisodesWorker
import br.com.andre.whichepisodetowatchagain.workers.UserWorker
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserApi(private val userWorker: UserWorker) {

    @PostMapping("/")
    fun save(@RequestBody user: User) = userWorker.save(user)

}