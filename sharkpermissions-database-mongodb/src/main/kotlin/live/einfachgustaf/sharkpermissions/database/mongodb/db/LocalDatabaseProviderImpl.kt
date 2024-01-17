package live.einfachgustaf.sharkpermissions.database.mongodb.db

import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import live.einfachgustaf.sharkpermissions.database.mongodb.db.player.PlayerProviderImpl
import live.einfachgustaf.sharkpermissions.database.player.IPlayerProvider

class LocalDatabaseProviderImpl(
    private val dataPath: String
): LocalDatabaseProvider() {

    companion object {
        val mongoAdapter = MongoAdapter()
    }

    override fun startup() {
        //live.einfachgustaf.sharkpermissions.database.mongodb.db.config.dataPath = dataPath
        mongoAdapter.startup()
    }

    override fun shutdown() {
        mongoAdapter.shutdown()
    }

    override fun getPlayerProvider(): IPlayerProvider {
        return PlayerProviderImpl()
    }
}