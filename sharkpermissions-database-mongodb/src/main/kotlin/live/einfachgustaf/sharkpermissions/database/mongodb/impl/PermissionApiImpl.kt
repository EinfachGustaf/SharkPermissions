package live.einfachgustaf.sharkpermissions.database.mongodb.impl

import live.einfachgustaf.sharkpermissions.api.SharkPermissionsAPI
import live.einfachgustaf.sharkpermissions.api.player.IPlayerRepository
import live.einfachgustaf.sharkpermissions.database.mongodb.impl.player.PlayerRepositoryImpl

class PermissionApiImpl: SharkPermissionsAPI() {

    override fun getPlayerRepository(): IPlayerRepository {
        return PlayerRepositoryImpl()
    }
}