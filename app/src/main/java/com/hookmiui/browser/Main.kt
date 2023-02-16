package com.hookmiui.browser

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

/**
 * @Author yikwing
 * @Date 15/2/2023-10:35
 * @Description:
 */
class Main : IXposedHookLoadPackage {

    private val hookPackName = "com.android.browser"

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam?.packageName != hookPackName) return

        val uaPC = Settings.getModulePreferencesString(Type.PC, PC_DEFAULT_UA)
        val uaIphone = Settings.getModulePreferencesString(Type.IPhone, IPHONE_DEFAULT_UA)
        val uaIpad = Settings.getModulePreferencesString(Type.IPad, IPAD_DEFAULT_UA)

        val clazz = XposedHelpers.findClass(
            "b.c.a.pl.g3",
            lpparam.classLoader,
        )

        XposedHelpers.setStaticObjectField(
            clazz,
            "d",
            arrayOf(
                null,
                uaPC,
                uaIphone,
                uaIpad,
                "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
                "Mozilla/5.0 (Linux; U; Android 3.1; en-us; Xoom Build/HMJ25) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13",
                "Mozilla/5.0 (Linux; U; Android 4.0.1; zh-cn; MI-ONE Plus Build/ITL41D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
            ),
        )
    }
}
