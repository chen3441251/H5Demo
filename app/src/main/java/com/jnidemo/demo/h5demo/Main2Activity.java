package com.jnidemo.demo.h5demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mWebView = (WebView) findViewById(R.id.webview);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://blog.csdn.net/wskinght/article/details/46049965");
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xxx","onResume");

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Log.d("xxx","onNewIntent");
        processData();
    }

    private void processData() {
        boolean isMain3 = getIntent().getBooleanExtra("isMain3", false);
        Log.d("xxx","isMain3=="+isMain3);
        if (isMain3) {
            isMain3=false;
            mWebView.stopLoading();
            mWebView.loadUrl("https://www.baidu.com");
        }
    }
}
