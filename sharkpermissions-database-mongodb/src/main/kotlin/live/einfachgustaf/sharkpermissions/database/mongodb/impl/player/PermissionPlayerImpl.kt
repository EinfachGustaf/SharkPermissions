package live.einfachgustaf.sharkpermissions.database.mongodb.impl.player

import kotlinx.serialization.Serializable
import live.einfachgustaf.sharkpermissions.api.group.IPermissionGroup
import live.einfachgustaf.sharkpermissions.api.player.IPermissionPlayer
import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import live.einfachgustaf.sharkpermissions.database.mongodb.serializer.DateSerializer
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@Serializable
class PermissionPlayerImpl(
    @get:JvmName("getUuidA") val uuid: String,
    @get:JvmName("getPermissionsA") val permissions: List<String>,
    @get:JvmName("getGroupsA") val groups: HashMap<IPermissionGroup, @Serializable(with = DateSerializer::class) LocalDate>
): IPermissionPlayer {
    override fun getUUID(): UUID {
        return UUID.fromString(uuid)
    }

    override fun getPermissions(): ArrayList<String> {
        return LocalDatabaseProvider.getInstance().getPlayerProvider().getPermissionPlayerByUUID(getUUID())?.getPermissions() ?: return arrayListOf()
    }

    override fun addPermission(permission: String) {
        LocalDatabaseProvider.getInstance().getPlayerProvider().addPermission(getUUID(), permission)
    }

    override fun removePermission(permission: String) {
        LocalDatabaseProvider.getInstance().getPlayerProvider().removePermission(getUUID(), permission)
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