package live.einfachgustaf.sharkpermissions.api.player

import java.util.UUID

interface IPermissionPlayer {

    fun getUUID(): UUID
    fun getPermissions(): List<String>
    fun addPermission(permission: String)
    fun removePermission(permission: String)

    //TODO: groups
}