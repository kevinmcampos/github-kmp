package me.kevincampos.githubkmp.presentation

interface MembersView : BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: String)
}
