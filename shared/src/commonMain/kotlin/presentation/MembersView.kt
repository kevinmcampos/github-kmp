package me.kevincampos.githubkmp.presentation

import me.kevincampos.githubkmp.model.Member

interface MembersView : BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: List<Member>)
}
