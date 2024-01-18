package live.einfachgustaf.sharkpermissions.api.group

interface IGroupRepository {

    fun createGroup(group: IPermissionGroup): IPermissionGroup
    fun deleteGroup(group: IPermissionGroup)
    fun getGroup(name: String): IPermissionGroup
}