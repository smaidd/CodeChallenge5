package com.example.mgmcartofior.codechallenge5;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.logging.LoggingMXBean;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextURL;
    private EditText mEditTextLocation;
    private EditText mEditText;
    private EditText mEditTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditTextURL = findViewById(R.id.editText);
        mEditTextLocation = findViewById(R.id.editText2);
        mEditText = findViewById(R.id.editText3);
        mEditTextPhone = findViewById(R.id.editText4);
    }

    public void btnWebOpener(View view) {
        if (mEditTextURL != null) {
            String url = mEditTextURL.getText().toString();
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    public void btnLocation(View view) {
        if (mEditTextLocation != null) {
            String location = mEditTextLocation.getText().toString();
            Uri uri = Uri.parse("geo:0,0?q=" + location);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
    }

    public void btnShareText(View view) {
        if (mEditText != null) {
            String text = mEditText.getText().toString();
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle("share").setText(text).startChooser();
        }
    }

    public void btnCall(View view) {
        if (mEditTextPhone != null) {
            String phone = mEditTextPhone.getText().toString();
            Uri uri = Uri.parse("tel:" + phone);
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        }
    }
}
