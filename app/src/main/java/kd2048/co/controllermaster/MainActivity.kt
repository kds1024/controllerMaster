package kd2048.co.controllermaster

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        /**
         * fragmentをlayout上で作成するときにはブランクで作成して
         * 利用するときは必要なflagmentに差し替えて使う
         * layout作成の時に、固定でflagmentを設定するとtransaction処理を
         * しても固定で設定したflagmentが表示されてしまう。
         * activity_main.xmlを参照。
         */
        val startFragment = startFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container2, startFragment)
        transaction.commit()
    }
}