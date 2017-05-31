package me.aliberti.luca.barcodegenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.editText);
        mImageView = (ImageView) findViewById(R.id.barcode);
//        ImageView barCode = (ImageView) findViewById(R.id.barCode);
//
//        Code128Writer writer = new Code128Writer();
//        try {
//            int width = barCode.getLayoutParams().width;
//            int height = barCode.getLayoutParams().height;
//            BitMatrix bitMatrix = writer.encode("1224235454363635", BarcodeFormat.CODE_128, width, height);
//            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//            for (int i = 0; i < width; i++) {
//                for (int j = 0; j < height; j++) {
//                    bitmap.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK: Color.WHITE);
//                }
//            }
//            barCode.setImageBitmap(bitmap);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }

    }

    public void onClick(View v) {

        String content = mEditText.getText().toString();
        Code128Writer write = new Code128Writer();
        try {
            int width = mImageView.getWidth();
            int height = mImageView.getHeight();
            BitMatrix bitMatrix = write.encode(content, BarcodeFormat.CODE_128, width, height);
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    bitmap.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK: Color.WHITE);
                }
            }
            mImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
