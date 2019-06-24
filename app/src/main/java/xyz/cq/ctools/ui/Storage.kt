package xyz.cq.ctools.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_storage.*
import xyz.cq.ctools.R

/**
 * @author 程前 created on 2018/12/19.
 * blog: https://blog.csdn.net/ch1406285246
 * content:
 * modifyNote:
 */
class Storage : Activity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "内部存储/外部存储"
        setContentView(R.layout.activity_storage)
        storage_tv1.text = "context.filesDir:\n" + filesDir.absolutePath +
                "\ncontext.cacheDir:\n" + cacheDir.absolutePath +
                "\ncontext.obbDir:\n" + obbDir.absolutePath +
                "\ncontext.externalCacheDir:\n" + externalCacheDir?.absolutePath +
                "\nEnvironment.getExternalStorageDirectory():\n" + Environment.getExternalStorageDirectory().absolutePath +
                "\nEnvironment.getDownloadCacheDirectory():\n" + Environment.getDownloadCacheDirectory().absolutePath +
                "\nEnvironment.getExternalStorageDirectory():\n" + Environment.getExternalStorageDirectory().absolutePath +
                "\nEnvironment.getDataDirectory():\n" + Environment.getDataDirectory().absolutePath +
                "\nEnvironment.getRootDirectory():\n" + Environment.getRootDirectory().absolutePath
    }

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, Storage::class.java))
        }
    }


}