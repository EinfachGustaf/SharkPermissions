package live.einfachgustaf.sharkpermissions.database.player

import live.einfachgustaf.sharkpermissions.api.group.IPermissionGroup
import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import java.time.LocalDateTime
import java.util.*

interface IPlayerProvider {
    fun getPermissionPlayerByUUID(uuid: UUID): IPermissionPlayer?
    fun doesPlayerExist(uuid: UUID): Boolean
    fun insertPlayer(player: IPermissionPlayer): IPermissionPlayer
    fun updatePlayer(player: IPermissionPlayer): IPermissionPlayer

    fun getPermissions(uuid: UUID): List<String>?
    fun addPermission(uuid: UUID, permission: String)
    fun removePermission(uuid: UUID, permission: String)

    fun getGroups(uuid: UUID): HashMap<IPermissionGroup, LocalDateTime>
    fun addGroup(uuid: UUID, group: IPermissionGroup)
    fun removeGroup(uuid: UUID, group: String)
}