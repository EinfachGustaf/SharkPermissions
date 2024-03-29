package live.einfachgustaf.sharkpermissions.database.mongodb.db

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import live.einfachgustaf.sharkpermissions.database.mongodb.db.config.getMongoDbConfig
import org.litote.kmongo.KMongo
import org.litote.kmongo.serialization.SerializationClassMappingTypeService

class MongoAdapter {

    private lateinit var client: MongoClient
    lateinit var database: MongoDatabase
    private val mongoConfig = getMongoDbConfig()

    fun startup() {
        System.setProperty(
            "org.litote.mongo.mapping.service",
            SerializationClassMappingTypeService::class.qualifiedName!!
        )
        val authString: String = if (mongoConfig.user != "") {
            if (mongoConfig.password != "")
                "${mongoConfig.user}:${mongoConfig.password}@"
            else
                "${mongoConfig.user}@"
        } else
            ""

        val authMethod = if (authString != "")
            "?authMechanism=DEFAULT"
        else ""
        client = KMongo.createClient("mongodb://$authString${mongoConfig.host}:${mongoConfig.port}/$authMethod")
        database = client.getDatabase(mongoConfig.database)
    }

    fun shutdown() {
        client.close()
    }
}