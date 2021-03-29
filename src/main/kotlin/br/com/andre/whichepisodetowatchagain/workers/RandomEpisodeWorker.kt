package br.com.andre.whichepisodetowatchagain.workers

import br.com.andre.whichepisodetowatchagain.model.Episode
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.MatchOperation
import org.springframework.data.mongodb.core.aggregation.SampleOperation
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
class RandomEpisodeWorker(private val mongoTemplate: ReactiveMongoTemplate) {

    fun randomEpisode(id: Long): Flux<Episode> {
        val match: MatchOperation = Aggregation.match(where("tvShow").`is`(id))
        val sample: SampleOperation = Aggregation.sample(1)
        val aggregation: Aggregation = Aggregation.newAggregation(match, sample)
        return mongoTemplate.aggregate(aggregation, "episode", Episode::class.java)
    }
}