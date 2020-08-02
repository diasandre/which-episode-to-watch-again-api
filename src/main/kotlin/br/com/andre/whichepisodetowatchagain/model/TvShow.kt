package br.com.andre.whichepisodetowatchagain.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class TvShow(
        @Id
        val id: Long,
        val title: String
)