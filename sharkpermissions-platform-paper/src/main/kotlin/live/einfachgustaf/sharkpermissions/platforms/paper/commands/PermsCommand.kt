package live.einfachgustaf.sharkpermissions.platforms.paper.commands

import com.mojang.brigadier.arguments.BoolArgumentType
import com.mojang.brigadier.arguments.IntegerArgumentType
import com.mojang.brigadier.arguments.StringArgumentType
import live.einfachgustaf.sharkpermissions.api.SharkPermissionsAPI
import live.einfachgustaf.sharkpermissions.database.LocalDatabaseProvider
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.commands.*
import net.kyori.adventure.text.minimessage.MiniMessage

object PermsCommand {

    val permsCommand = command("perms") {

        literal("group") {
            requiresPermission("perms.group")
            argument<String>("group", StringArgumentType.string()) {
                literal("create") {

                }
                literal("delete") {

                }

                literal("set") {
                    literal("permission") {
                        argument<String>("permission", StringArgumentType.string()) {
                            argument<Boolean>("state", BoolArgumentType.bool()) {

                            }
                        }
                    }

                    literal("prefix") {
                        argument<String>("prefix", StringArgumentType.greedyString()) {}
                    }
                    literal("suffix") {
                        argument<String>("suffix", StringArgumentType.greedyString()) {}
                    }
                    literal("color") {
                        argument<String>("color", StringArgumentType.string()) {

                        }
                    }
                    literal("priority") {
                        argument<Int>("priority", IntegerArgumentType.integer()) {

                        }
                    }
                }
            }
        }

        literal("user") {
            requiresPermission("perms.user")
            argument<String>("user", StringArgumentType.string()) {

                runs {
                    with(SharkPermissionsAPI.getInstance().getPlayerRepository().getPermissionPlayerByUUID(player.uniqueId)) {
                        player.sendMessage(literalText {
                            text("uuid: ${this@with?.getUUID().toString()}") {  }
                            text("perms: ${this@with?.getPermissions().toString()}") {  }
                        })
                    }
                }

                literal("add") {
                    literal("group") {
                        runs {
                        }
                    }
                }
                literal("remove") {
                    literal("group") {}
                }
                literal("set") {
                    literal("permission") {
                        argument<String>("permission", StringArgumentType.string()) {
                            argument<Boolean>("state", BoolArgumentType.bool()) {}
                        }
                    }
                }
            }
        }

        runs {
            player.sendMessage(MiniMessage.miniMessage().deserialize(
                "<gradient:#00a5ff:#0077b7>SharkPerms</gradient>"
            ).append(literalText {
                text(" by ") { color = KColors.GREENYELLOW }
                text("DinoMarlir") { color = KColors.BLUEVIOLET }
            }))
        }
    }
}