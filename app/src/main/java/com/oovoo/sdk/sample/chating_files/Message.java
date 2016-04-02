package com.oovoo.sdk.sample.chating_files;

import android.graphics.Bitmap;

/**
 * Created by muhammed on 11/29/15.
 */
public class Message {

    public  static final  int TYPE_MESSAGE =0;
    public static final int TYPE_LOG =1;
    public static final int TYPE_ACTION =2;

    private int mType;
    private String mMessage;
    private Bitmap mImage;

    public Message() {
    }


    public int getType() {
        return mType;
    }


    public String getMessage() {
        return mMessage;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public static class Builder{

        private final int mType;
        private String mMessage;
        private Bitmap mImage;


        public Builder(int Type) {
            this.mType = Type;
        }

        public Builder message(String message) {
            this.mMessage = message;
            return this;
        }

        public Builder image(Bitmap image) {
            this.mImage = image;
            return this;
        }

        public Message build() {
        Message message = new Message();
            message.mType = mType;
            message.mImage = mImage;
            message.mMessage = mMessage;
            return message;

        }
    }




}
