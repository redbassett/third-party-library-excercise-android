package io.intrepid.thirdpartylibraryexcercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

class DownloadCatImageTask extends AsyncTask<String, Void, Bitmap> {

    private Callback callback;

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        String url = params[0];

        try {
            InputStream inputStream = new BufferedInputStream(new URL(url).openStream());
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            Log.e(this.getClass().getSimpleName(), e.toString());
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (callback != null) {
            callback.onImageResult(bitmap);
        }
    }

    void setCallback(Callback callback) {
        this.callback = callback;
    }

    interface Callback {
        void onImageResult(Bitmap bitmap);
    }
}
