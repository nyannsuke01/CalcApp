package jp.techacademy.shingo.kobayashi.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var errorTitle = ""
    var errorMessage = ""
    var result = 0.0
    val inputText1 = textNumber1.text.toString().toDouble()
    val inputText2 = textNumber2.text.toString().toDouble()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        multiplyButton.setOnClickListener(this)
        divButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        //validate
        if (textNumber1.text.toString() == "" || textNumber2.text.toString() == "" ){
            showAlertDialog(0)
            return
        }
        //div 0
        if (v.id==R.id.divButton && textNumber2.text.toString() == "0"){
            showAlertDialog(1)
            return
        }
        //calculate
        when(v.id){
            R.id.addButton -> result = inputText1 + inputText2
            R.id.minusButton ->result = inputText1 - inputText2
            R.id.multiplyButton -> result = inputText1 * inputText2
            R.id.divButton -> result = inputText1 / inputText2
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("RESULT", result)
        startActivity(intent)
    }

    private fun showAlertDialog(tag: Int) {
        val alertDialogBuilder = AlertDialog.Builder(this)

        if (tag == 0) {
            errorTitle = getString(R.string.lack_error_message_title)
            errorMessage = getString(R.string.lack_error_message)
        } else if (tag == 1) {
            errorTitle = getString(R.string.div0_error_message_title)
            errorMessage = getString(R.string.div0_error_message)
        }
        alertDialogBuilder.setTitle(errorTitle)
        alertDialogBuilder.setMessage(errorMessage)

        alertDialogBuilder.setPositiveButton("OK"){dialog, which ->
            Log.d("UI_PARTS", "OKボタン")
        }
        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}