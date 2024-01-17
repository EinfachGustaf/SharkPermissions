package live.einfachgustaf.sharkpermissions.database.mongodb.db.config
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class MongoDbConfig(
    val host: String,
    val port: Int,
    val database: String,
    val user: String,
    val password: String
)

//lateinit var dataPath: String

fun getMongoDbConfig(): MongoDbConfig {
    return getJsonConfig<MongoDbConfig>(
        defaultConfig = MongoDbConfig(
            "127.0.0.1", 27017, "dinoperms", "", ""
        ),
        filePath = "config/sharkperms/mongodb.json"
    )
}

inline fun <reified T> getJsonConfig(defaultConfig: T, filePath: String): T {
    val file = File(filePath)
    val json = Json {
        prettyPrint = true
    }

    if (file.parentFile != null) if (!file.parentFile.exists()) file.parentFile.mkdir()
    if (!file.exists()) {
        file.createNewFile()
        file.writeText(json.encodeToString<T>(defaultConfig))
    }

    return json.decodeFromString(file.readText())
}