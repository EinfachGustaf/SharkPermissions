package live.einfachgustaf.sharkpermissions.api

import live.einfachgustaf.sharkpermissions.api.player.IPlayerRepository

abstract class SharkPermissionsAPI {

    abstract fun getPlayerRepository(): IPlayerRepository

    companion object {
        private lateinit var instance: SharkPermissionsAPI

        fun getInstance(): SharkPermissionsAPI {
            return instance
        }
    }

    init {
        instance = this
    }
}