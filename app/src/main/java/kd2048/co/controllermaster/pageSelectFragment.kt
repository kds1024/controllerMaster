package kd2048.co.controllermaster

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [pageSelectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class pageSelectFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * pageSelectFragmentのボタンを押下したらflagment2の画面表示を切り替える
         */
        val view = inflater.inflate(R.layout.fragment_page_select, container, false)

        /**
         * プロジェクタ映像選択ボタン押下 flagment切り替え
         */
        val selectBtn1 = view.findViewById<Button>(R.id.selectBtn1)
        selectBtn1.setOnClickListener {
            /**
             * projectorVideoSelFragment 表示
             */
            val flagment = projectorVideoSelFragment()

            // flagmentにはActivityが無いのでactivityを使ってMainactivityの
            // contextを取得する(thisは使えない)
            val flagmentManager = activity?.supportFragmentManager
            val fragmentTransaction = flagmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container2, flagment)
            fragmentTransaction?.commit()

        }

        /**
         * モニタ映像選択ボタン押下 flagment切り替え
         */
        val selectBtn2 = view.findViewById<Button>(R.id.selectBtn2)
        selectBtn2.setOnClickListener {
            /**
             * monitorVideoSelFragment 表示
             */
            val flagment = monitorVideoSelFragment()

            // flagmentにはActivityが無いのでactivityを使ってMainactivityの
            // contextを取得する(thisは使えない)
            val flagmentManager = activity?.supportFragmentManager
            val fragmentTransaction = flagmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container2, flagment)
            fragmentTransaction?.commit()

        }

        /**
         * プロジェクタ操作ボタン押下 flagment切り替え
         */
        val selectBtn5 = view.findViewById<Button>(R.id.selectBtn5)
        selectBtn5.setOnClickListener {
            /**
             * projectorContFragment 表示
             */
            val flagment = projectorContFragment()

            // flagmentにはActivityが無いのでactivityを使ってMainactivityの
            // contextを取得する(thisは使えない)
            val flagmentManager = activity?.supportFragmentManager
            val fragmentTransaction = flagmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container2, flagment)
            fragmentTransaction?.commit()

        }

        /**
         * スクリーン操作ボタン押下 flagment切り替え
         */
        val selectBtn6 = view.findViewById<Button>(R.id.selectBtn6)
        selectBtn6.setOnClickListener {
            /**
             * screenContFragment 表示
             */
            val flagment = screenContFragment()

            // flagmentにはActivityが無いのでactivityを使ってMainactivityの
            // contextを取得する(thisは使えない)
            val flagmentManager = activity?.supportFragmentManager
            val fragmentTransaction = flagmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container2, flagment)
            fragmentTransaction?.commit()

        }

        /**
         * 照明操作ボタン押下 flagment切り替え
         */
        val selectBtn7 = view.findViewById<Button>(R.id.selectBtn7)
        selectBtn7.setOnClickListener {
            /**
             * lightContFlagment 表示
             */
            val flagment = lightContFragment()

            // flagmentにはActivityが無いのでactivityを使ってMainactivityの
            // contextを取得する(thisは使えない)
            val flagmentManager = activity?.supportFragmentManager
            val fragmentTransaction = flagmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.container2, flagment)
            fragmentTransaction?.commit()

        }

        return view
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_page_select, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment pageSelectFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            pageSelectFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}