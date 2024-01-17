package live.einfachgustaf.sharkpermissions.database.mongodb.db.player

import live.einfachgustaf.sharkpermissions.api.group.IPermissionGroup
import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import live.einfachgustaf.sharkpermissions.database.mongodb.db.LocalDatabaseProviderImpl
import live.einfachgustaf.sharkpermissions.database.mongodb.impl.player.PermissionPlayerImpl
import live.einfachgustaf.sharkpermissions.database.player.IPlayerProvider
import org.litote.kmongo.*
import java.time.LocalDateTime
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
            playerCollection.insertOne(PermissionPlayerImpl(player.getUUID().toString(), emptyList(), hashMapOf()))
        }
        return playerCollection.findOne(PermissionPlayerImpl::uuid eq player.getUUID().toString())!!
    }

    override fun updatePlayer(player: IPermissionPlayer): IPermissionPlayer {
        playerCollection.updateOne(PermissionPlayerImpl::uuid eq player.getUUID().toString(), player)
        return player
    }

    override fun getPermissions(uuid: UUID): List<String>? {
        return playerCollection.findOne(PermissionPlayerImpl::uuid eq uuid.toString())?.getPermissions()
    }

    override fun addPermission(uuid: UUID, permission: String) {
        playerCollection.updateOne(PermissionPlayerImpl::uuid eq uuid.toString(), PermissionPlayerImpl::permissions addToSet permission)
    }

    override fun removePermission(uuid: UUID, permission: String) {
        TODO("Not yet implemented")
    }

    override fun getGroups(uuid: UUID): HashMap<IPermissionGroup, LocalDateTime> {
        TODO("Not yet implemented")
    }

    override fun addGroup(uuid: UUID, group: IPermissionGroup) {
        TODO("Not yet implemented")
    }

    override fun removeGroup(uuid: UUID, group: String) {
        TODO("Not yet implemented")
    }
}