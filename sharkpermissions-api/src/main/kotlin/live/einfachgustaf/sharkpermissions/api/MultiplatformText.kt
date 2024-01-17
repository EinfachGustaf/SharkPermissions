package live.einfachgustaf.sharkpermissions.api

class MultiplatformText(private val javaText: String, private val bedrockText: String) {

    fun getJavaText(): String = javaText
    fun getBedrockText(): String = bedrockText

}
