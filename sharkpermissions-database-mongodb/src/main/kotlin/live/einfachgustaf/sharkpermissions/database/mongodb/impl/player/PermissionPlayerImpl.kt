package live.einfachgustaf.sharkpermissions.database.mongodb.impl.player

import live.einfachgustaf.sharkpermissions.api.group.IPermissionGroup
import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

class PermissionPlayerImpl(
    @get:JvmName("getUuidA") val uuid: String,
    @get:JvmName("getPermissionsA") val permissions: List<String>,
    @get:JvmName("getGroupsA") val groups: HashMap<IPermissionGroup, LocalDateTime>
): IPermissionPlayer {
    override fun getUUID(): UUID {
        return UUID.fromString(uuid)
    }

    override fun getPermissions(): List<String> {
        return LocalDatabaseProvider.getInstance().getPlayerProvider().getPermissionPlayerByUUID(getUUID())?.getPermissions() ?: return emptyList()
    }

    override fun addPermission(permission: String) {
        TODO("Not yet implemented")
    }

    override fun removePermission(permission: String) {
        TODO("Not yet implemented")
    }

    override fun getGroups(): HashMap<IPermissionGroup, LocalDateTime> {
        return LocalDatabaseProvider.getInstance().getPlayerProvider().getPermissionPlayerByUUID(getUUID())?.getGroups() ?: return hashMapOf()
    }

    override fun addGroup(group: IPermissionGroup) {
        TODO("Not yet implemented")
    }

    override fun removeGroup(group: String) {
        TODO("Not yet implemented")
    }
}