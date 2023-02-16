package com.hookmiui.browser

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hookmiui.browser.ui.theme.HookMiuiBrowserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HookMiuiBrowserTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun UaItem(tag: String) {
    val context = LocalContext.current

    val defaultUa = when (tag) {
        Type.PC -> PC_DEFAULT_UA
        Type.IPhone -> IPHONE_DEFAULT_UA
        Type.IPad -> IPAD_DEFAULT_UA
        else -> throw Error("Error")
    }

    var text by remember {
        mutableStateOf(
            SPUtils.getInstance(context, spFileName).getString(tag, defaultUa),
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(tag) },
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.wrapContentWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(onClick = {
                SPUtils.getInstance(context, spFileName).put(tag, defaultUa)
                text = defaultUa
                Toast.makeText(context, "已恢复默认ua", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "默认")
            }
            Button(onClick = {
                SPUtils.getInstance(context, spFileName).put(tag, text)
                Toast.makeText(context, "已保存", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "保存")
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxHeight().padding(all = 8.dp)) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceAround,
//        ) {
//            Button(onClick = { showLauncherIcon(context, false) }) {
//                Text(text = "隐藏界面")
//            }
//            Button(onClick = { showLauncherIcon(context, true) }) {
//                Text(text = "显示界面")
//            }
//        }
        Spacer(modifier = Modifier.height(16.dp))
        UaItem(Type.PC)
        Spacer(modifier = Modifier.height(16.dp))
        UaItem(Type.IPhone)
        Spacer(modifier = Modifier.height(16.dp))
        UaItem(Type.IPad)
    }
}

// private fun showLauncherIcon(context: Context, b: Boolean) {
//    val show =
//        if (b) PackageManager.COMPONENT_ENABLED_STATE_ENABLED else PackageManager.COMPONENT_ENABLED_STATE_DISABLED
//    context.packageManager.setComponentEnabledSetting(
//        getAliseComponentName(context),
//        show,
//        PackageManager.DONT_KILL_APP,
//    )
// }
//
// private fun getAliseComponentName(context: Context): ComponentName =
//    ComponentName(context, "com.hookmiui.browser.MainActivityAlias")

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HookMiuiBrowserTheme {
        Greeting()
    }
}
