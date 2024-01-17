package live.einfachgustaf.sharkpermissions.api.player

import live.einfachgustaf.sharkpermissions.api.group.IPermissionGroup
import java.time.LocalDateTime
import java.util.UUID

interface IPermissionPlayer {

    fun getUUID(): UUID
    fun getPermissions(): List<String>
    fun addPermission(permission: String)
    fun removePermission(permission: String)

    fun getGroups(): HashMap<IPermissionGroup, LocalDateTime>
    fun addGroup(group: IPermissionGroup)
    fun removeGroup(group: String)
}