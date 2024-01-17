package live.einfachgustaf.sharkpermissions.database.mongodb.impl.player

import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import live.einfachgustaf.sharkpermissions.api.player.IPlayerRepository
import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import java.util.*

class PlayerRepositoryImpl: IPlayerRepository {

    override fun getPermissionPlayerByUUID(uuid: UUID): IPermissionPlayer? {
        return LocalDatabaseProvider.getInstance().getPlayerProvider().getPermissionPlayerByUUID(uuid)
    }

    override fun createPermissionPlayer(permissionPlayer: IPermissionPlayer) {
        LocalDatabaseProvider.getInstance().getPlayerProvider().insertPlayer(permissionPlayer)
    }
}