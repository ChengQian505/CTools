package xyz.cq.ctools.base

import android.os.Environment
import android.support.multidex.MultiDexApplication
import xyz.cq.clog.BuildConfig
import xyz.cq.clog.CLog


/**
 * @author 程前 created on 2018/12/19.
 * blog: https://blog.csdn.net/ch1406285246
 * content:
 * modifyNote:
 */
class APP : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        lateinit var app: APP
    }
}