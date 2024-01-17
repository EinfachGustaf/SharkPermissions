package live.einfachgustaf.sharkpermissions.database.mongodb.db

import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import live.einfachgustaf.sharkpermissions.database.mongodb.db.player.PlayerProviderImpl
import live.einfachgustaf.sharkpermissions.database.player.IPlayerProvider

class LocalDatabaseProviderImpl: LocalDatabaseProvider() {

    companion object {
        val mongoAdapter = MongoAdapter()
    }

    override fun startup() {
        mongoAdapter.startup()
    }

    override fun shutdown() {
        mongoAdapter.shutdown()
    }

    override fun getPlayerProvider(): IPlayerProvider {
        return PlayerProviderImpl()
    }
}