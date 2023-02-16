package com.hookmiui.browser

/**
 * @Author yikwing
 * @Date 14/2/2023-15:45
 * @Description:
 */

// 定义dataStore
const val spFileName = "preferences"

const val PC_DEFAULT_UA =
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/89.0.4389.116 Safari/534.24"
const val IPHONE_DEFAULT_UA =
    "Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en-us) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3"
const val IPAD_DEFAULT_UA =
    "Mozilla/5.0 (Linux; U; Android 12; zh-cn) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.116 Mobile Safari/537.36 SearchCraft/3.9.2 (Baidu; P1 11)"

object Type {
    const val PC = "PC"
    const val IPhone = "IPhone"
    const val IPad = "IPad"
}
