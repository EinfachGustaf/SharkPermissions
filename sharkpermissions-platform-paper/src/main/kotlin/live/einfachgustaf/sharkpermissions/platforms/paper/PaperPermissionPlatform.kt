package live.einfachgustaf.sharkpermissions.platforms.paper

import live.einfachgustaf.sharkpermissions.api.SharkPermissionsAPI
import live.einfachgustaf.sharkpermissions.database.mongodb.db.LocalDatabaseProviderImpl
import live.einfachgustaf.sharkpermissions.platforms.paper.commands.PermsCommand
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.commands.register
import net.axay.kspigot.extensions.console
import net.axay.kspigot.main.KSpigot
import org.bukkit.Bukkit

class PaperPermissionPlatform: KSpigot() {
    private val localDatabaseProvider = LocalDatabaseProviderImpl("plugins/sharkperms")

    companion object {
        private lateinit var instance: PaperPermissionPlatform

        fun getInstance(): PaperPermissionPlatform {
            return instance
        }
    }

    override fun load() {
        instance = this
    }

    override fun startup() {
        localDatabaseProvider.startup()
        PermsCommand.permsCommand.register()
    }

    override fun shutdown() {
        localDatabaseProvider.shutdown()
    }
}