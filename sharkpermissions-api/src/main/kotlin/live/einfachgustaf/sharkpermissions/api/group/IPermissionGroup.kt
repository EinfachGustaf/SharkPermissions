package live.einfachgustaf.sharkpermissions.api.group

import live.einfachgustaf.sharkpermissions.api.MultiplatformText

interface IPermissionGroup {

    fun getName(): String
    fun getPriority(): Int
    fun getPermissions(): HashMap<String, Boolean>
    fun setPermission(permission: String, enabled: Boolean)

    fun getPrefix(): String
    fun getSuffix(): String
}