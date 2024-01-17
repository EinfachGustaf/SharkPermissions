package live.einfachgustaf.sharkpermissions.database.mongodb.db

import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import live.einfachgustaf.sharkpermissions.database.mongodb.db.player.PlayerProviderImpl
import live.einfachgustaf.sharkpermissions.database.player.IPlayerProvider

class LocalDatabaseProviderImpl: LocalDatabaseProvider() {
    override fun startup() {
        TODO("Not yet implemented")
    }

    override fun shutdown() {
        TODO("Not yet implemented")
    }

    override fun getPlayerProvider(): IPlayerProvider {
        return PlayerProviderImpl()
    }
}