package com.example.android.myaddressbook

import android.content.AsyncTaskLoader
import android.content.Context
import java.io.IOException

/**
 * Created by Shami on 10/7/2017.
 */

class Coctact_Loader(internal var mContext: Context) : AsyncTaskLoader<String>(mContext) {

    override fun onStartLoading() {
        super.onStartLoading()

        forceLoad()
    }

    override fun loadInBackground(): String? {

        return readContactJsonFile()
    }

    fun readContactJsonFile(): String? {
        var contactsString: String? = null
        try {
            val inputStream = mContext.assets.open("mock_contacts.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }


}
