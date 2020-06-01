package me.kevincampos.githubkmp.model

interface DataRepository {

    val members: List<Member>?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()

}
