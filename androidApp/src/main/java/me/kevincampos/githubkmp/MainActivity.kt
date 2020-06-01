package me.kevincampos.githubkmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.kevincampos.githubkmp.api.UpdateProblem
import me.kevincampos.githubkmp.presentation.MembersPresenter
import me.kevincampos.githubkmp.presentation.MembersView

class MainActivity : AppCompatActivity(), MembersView {

    private val dataRepository by lazy {
        (application as GitHubApplication).dataRepository
    }
    private val presenter by lazy {
        MembersPresenter(this, dataRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greeting.text = Greeting().greeting()

        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onCreate()
    }

    override var isUpdating: Boolean = false

    override fun onUpdate(members: String) {
        runOnUiThread {
            Toast.makeText(this, members, Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(error: Throwable) {
        val errorMessage = when (error) {
            is UpdateProblem -> getString(R.string.error_connection)
            else -> getString(R.string.error_unknown)
        }
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}
