package live.einfachgustaf.sharkpermissions.database.mongodb.db.player

import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import live.einfachgustaf.sharkpermissions.database.mongodb.db.LocalDatabaseProviderImpl
import live.einfachgustaf.sharkpermissions.database.mongodb.impl.player.PermissionPlayerImpl
import live.einfachgustaf.sharkpermissions.database.player.IPlayerProvider
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.updateOne
import java.util.*

class PlayerProviderImpl: IPlayerProvider {
    private val playerCollection = LocalDatabaseProviderImpl.mongoAdapter.database.getCollection<PermissionPlayerImpl>("players")

    override fun getPermissionPlayerByUUID(uuid: UUID): IPermissionPlayer? {
        return playerCollection.findOne(PermissionPlayerImpl::uuid eq uuid.toString())
    }

    override fun doesPlayerExist(uuid: UUID): Boolean {
        return playerCollection.findOne(PermissionPlayerImpl::uuid eq uuid.toString()) != null
    }

    override fun insertPlayer(player: IPermissionPlayer): IPermissionPlayer {
        if (!doesPlayerExist(player.getUUID())) {
            playerCollection.insertOne(PermissionPlayerImpl(player.getUUID().toString()))
        }
        return playerCollection.findOne(PermissionPlayerImpl::uuid eq player.getUUID().toString())!!
    }

    override fun updatePlayer(player: IPermissionPlayer): IPermissionPlayer {
        playerCollection.updateOne(PermissionPlayerImpl::uuid eq player.getUUID().toString(), player)
        return player
    }
}