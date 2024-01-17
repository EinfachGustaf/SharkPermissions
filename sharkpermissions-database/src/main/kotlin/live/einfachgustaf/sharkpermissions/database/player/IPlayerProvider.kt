package live.einfachgustaf.sharkpermissions.database.player

import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import java.util.*

interface IPlayerProvider {
    fun getPermissionPlayerByUUID(uuid: UUID): IPermissionPlayer

    fun insertPlayer(player: IPermissionPlayer): IPermissionPlayer
}