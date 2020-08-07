package br.com.andre.whichepisodetowatchagain.workers

import br.com.andre.whichepisodetowatchagain.exceptions.TvShowNotFoundException
import br.com.andre.whichepisodetowatchagain.model.Episode
import br.com.andre.whichepisodetowatchagain.repositories.EpisodeRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RandomEpisodesWorkerTest {

    private val episodeRepository: EpisodeRepository = mock()

    private val randomEpisodeWorker: RandomEpisodeWorker = RandomEpisodeWorker(episodeRepository)

    @Test
    fun `get random episode`() {
        whenever(episodeRepository.findByTvShow(any())) doReturn
                listOf(
                        Episode(1, 1, "TEST 1"),
                        Episode(2, 2, "TEST 2"))

        val randomEpisode = randomEpisodeWorker.randomEpisode(1L)
        assertThat(randomEpisode).isNotNull
        assertThat(listOf(1L, 2L)).contains(randomEpisode.id)
    }

    @Test
    fun `should return empty list when tv show dont have episodes`() {
        whenever(episodeRepository.findByTvShow(any())) doReturn emptyList()
        val exception = Assertions.assertThrows(TvShowNotFoundException::class.java) {
            randomEpisodeWorker.randomEpisode(1L)
        }

        assertThat(exception.value).isEqualTo("Tv show not found")
    }
}