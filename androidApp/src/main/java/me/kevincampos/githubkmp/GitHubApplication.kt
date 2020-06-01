package me.kevincampos.githubkmp

import android.app.Application
import me.kevincampos.githubkmp.api.GitHubApi
import me.kevincampos.githubkmp.model.DataRepository
import me.kevincampos.githubkmp.model.MembersDataRepository

class GitHubApplication : Application() {

    val dataRepository: DataRepository by lazy {
        MembersDataRepository(GitHubApi())
    }

}
