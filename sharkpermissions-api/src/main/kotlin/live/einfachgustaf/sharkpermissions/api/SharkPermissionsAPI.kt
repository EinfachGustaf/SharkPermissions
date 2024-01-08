package live.einfachgustaf.sharkpermissions.api

import live.einfachgustaf.sharkpermissions.api.player.IPlayerRepository

abstract class SharkPermissionsAPI() {

    private lateinit var instance: SharkPermissionsAPI

    abstract fun getPlayerRepository(): IPlayerRepository

    fun getInstance(): SharkPermissionsAPI {
        return instance
    }

    init {
        instance = this
    }
}