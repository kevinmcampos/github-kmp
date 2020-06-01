package me.kevincampos.githubkmp.model

import me.kevincampos.githubkmp.api.GitHubApi
import me.kevincampos.githubkmp.api.UpdateProblem

class MembersDataRepository (
    private val api: GitHubApi
): DataRepository {

    override var members: List<Member>? = null

    override var onRefreshListeners: List<() -> Unit> = emptyList()

    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        } catch (cause: Throwable) {
            println(cause.message)
            throw UpdateProblem()
        }

        if (newMembers != members) {
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners() {
        onRefreshListeners.forEach { it() }
    }

}
