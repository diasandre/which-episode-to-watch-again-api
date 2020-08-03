package br.com.andre.whichepisodetowatchagain.model

import org.springframework.data.annotation.Id

class User(@Id val id: String, val email: String, var password: String, val role: String) {
}