package snow.iceos.powermenu

import android.annotation.SuppressLint
import android.content.Intent
import android.service.quicksettings.TileService
import android.util.Log

class PowerMenuTileService : TileService() {
    @SuppressLint("WrongConstant")
    override fun onClick() {
        super.onClick()
        val closeIntent = Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
        sendBroadcast(closeIntent)
        
        try {
            val service = getSystemService("statusbar")
            val statusBarManager = Class.forName("android.app.StatusBarManager")
            val method = statusBarManager.getMethod("showGlobalActions")
            method.invoke(service)
        } catch (e: Exception) {
            Log.e("PowerMenuApp", "Error: ${e.message}")
        }
    }
}
