package live.einfachgustaf.sharkpermissions.database

import live.einfachgustaf.sharkpermissions.database.player.IPlayerProvider

abstract class LocalDatabaseProvider {

    companion object {
        private lateinit var localDatabaseProvider: LocalDatabaseProvider

        fun getInstance(): LocalDatabaseProvider {
            return localDatabaseProvider
        }
    }

    abstract fun getPlayerProvider(): IPlayerProvider

    init {
        localDatabaseProvider = this
    }
}