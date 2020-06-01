package me.kevincampos.githubkmp.model

interface DataRepository {

    val members: String?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()

}
