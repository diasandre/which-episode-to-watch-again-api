package br.com.andre.whichepisodetowatchagain.model

import br.com.andre.whichepisodetowatchagain.model.dto.EpisodeDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Episode(@Id val id: Long, val tvShow: Long, val title: String?) {
    constructor(tvShow: Long, dto: EpisodeDTO) : this(
            dto.id,
            tvShow,
            dto.title
    )
}