package com.example.lab5

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import me.dm7.barcodescanner.zxing.ZXingScannerView

class Main2 : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private var mScannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
    }

    fun bscanner(v: View) {
        mScannerView = ZXingScannerView(this)
        setContentView(mScannerView)
        mScannerView!!.setResultHandler(this)
        mScannerView!!.startCamera()
    }

    fun handleResult(result: Result) {
        Log.v("HandleResult", result.getText())
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Resultado del scan")
        builder.setMessage(result.getText())
        val alertDialog = builder.create()
        alertDialog.show()

        mScannerView!!.resumeCameraPreview(this)
    }
}
