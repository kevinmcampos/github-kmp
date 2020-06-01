package me.kevincampos.githubkmp.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import me.kevincampos.githubkmp.model.Member

class GitHubApi {

    private val client = HttpClient()

    private val membersUrl = Url("https://api.github.com/orgs/raywenderlich/members")

    suspend fun getMembers():  List<Member> {
        val result: String = client.get {
            url(this@GitHubApi.membersUrl.toString())
        }

        val json = Json(JsonConfiguration.Stable.copy(ignoreUnknownKeys = true))
        return json.parse(Member.serializer().list, result)
    }

}
