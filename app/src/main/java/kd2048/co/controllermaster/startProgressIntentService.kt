package kd2048.co.controllermaster

import android.app.Activity
import android.app.Application
import android.app.IntentService
import android.content.Intent
import android.util.Log
import android.widget.ProgressBar

class startProgressIntentService : IntentService("startProgressIntentService") {

    /**
     * システム起動カウント
     */
    override fun onHandleIntent(intent: Intent?) {

        Log.d("debug", "onHandleIntent")

        /**
         * システム起動時間を設定して
         * progress barの最大値を設定する
         */
        val count: Int? = intent?.getStringExtra("count")?.toInt()

        // countはnullチェックしないとcountが使えなくてIDE上でエラーになる
        if (count != null) {
            try {
                for (i in 0..count) {
                    //Log.d("kd>", "startProgressIntentService: $i")

                    val updateIntent = Intent("PROGRESS_UPDATE")
                    updateIntent.putExtra("message", i.toString())
                    sendBroadcast(updateIntent)

                    Thread.sleep(1000)
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
    }
}
