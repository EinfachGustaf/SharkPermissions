package live.einfachgustaf.sharkpermissions.database.mongodb.impl.group

import kotlinx.serialization.Serializable
import live.einfachgustaf.sharkpermissions.api.MultiplatformText
import live.einfachgustaf.sharkpermissions.api.group.IPermissionGroup

@Serializable
class PermissionGroupImpl(
    private val name: String,
    private var priority: Int,
    private val permissions: HashMap<String, Boolean>,
    private var prefix: String,
    private var suffix: String
): IPermissionGroup {

    override fun getName(): String {
        return name;
    }

    override fun getPriority(): Int {
        return priority
    }

    override fun getPermissions(): HashMap<String, Boolean> {
        return permissions
    }

    override fun setPermission(permission: String, enabled: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getPrefix(): String {
        return prefix
    }

    override fun getSuffix(): String {
        return suffix
    }
}