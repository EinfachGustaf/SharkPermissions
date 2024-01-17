package live.einfachgustaf.sharkpermissions.api.group

import live.einfachgustaf.sharkpermissions.api.MultiplatformText

interface IPermissionGroup {

    fun getName(): String
    fun getPriority(): Int
    fun getPermissions(): HashMap<String, Boolean>

    fun getPrefix(): MultiplatformText
    fun getSuffix(): MultiplatformText
}