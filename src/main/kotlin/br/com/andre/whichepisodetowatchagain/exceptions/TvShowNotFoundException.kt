package br.com.andre.whichepisodetowatchagain.exceptions

data class TvShowNotFoundException(val value: String = "Tv show not found") : Exception(value) {
}