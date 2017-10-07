package com.example.android.myaddressbook;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Shami on 10/7/2017.
 */

public class Coctact_Loader extends AsyncTaskLoader<String> {

    Context mContext;

    public Coctact_Loader(Context context) {
        super(context);
        mContext=context;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Override
    public String loadInBackground() {

        String response=readContactJsonFile();
        return response;
    }

    public  String  readContactJsonFile() {
        String contactsString = null;
        try {
            InputStream inputStream = mContext.getAssets().open("mock_contacts.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            contactsString = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactsString;
    }


}
