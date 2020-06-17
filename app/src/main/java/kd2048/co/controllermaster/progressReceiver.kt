package kd2048.co.controllermaster

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView

class progressReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // TODO("progressReceiver.onReceive() is not implemented")

        val count: String? = intent.getStringExtra("message")
        if (count != null){
            Log.d("kd>", "BroadcastReceiver ${count.toInt()}")
            if (context is MainActivity) {
                val text = context.findViewById<TextView>(R.id.countText)
                val progress = context.findViewById<ProgressBar>(R.id.progressBar)

                // 0%~100%表示 formatで書かないとエラーになる
                // %文字自体を表示するときは%%と表記しないと落ちる
                val percent = String.format("%s%%", (count.toInt() * 100) / context.getString(R.string.startupTime).toInt())
                text.setText(percent)
                progress?.setProgress(count.toInt())

                /**
                 * progress表示が100%になったらメイン画面にflagmentを入れ替える
                 */
                if (percent == "100%") {
                    // flagment1 表示
                    val flagment1 = pageSelectFragment()
                    val flagmentManager1 = context.supportFragmentManager
                    val fragmentTransaction1 = flagmentManager1.beginTransaction()
                    fragmentTransaction1.replace(R.id.container1, flagment1)
                    fragmentTransaction1.commit()

                    // flagment2 表示
                    val flagment2 = projectorVideoSelFragment()
                    val flagmentManager2 = context.supportFragmentManager
                    val fragmentTransaction2 = flagmentManager2.beginTransaction()
                    fragmentTransaction2.replace(R.id.container2, flagment2)
                    fragmentTransaction2.commit()
                }
            }
        }
    }
}
