package live.einfachgustaf.sharkpermissions.api.player

import java.util.UUID

interface IPlayerRepository {

    fun getPermissionPlayerByUUID(uuid: UUID): IPermissionPlayer
    fun createPermissionPlayer(permissionPlayer: IPermissionPlayer)
}