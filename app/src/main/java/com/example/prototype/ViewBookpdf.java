package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ViewBookpdf extends AppCompatActivity {

    WebView pdfView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookpdf);
        pdfView=findViewById(R.id.booksWebView);
        progressBar=findViewById(R.id.pdfProgessBar);
        progressBar.setVisibility(View.VISIBLE);

        Intent intent=getIntent();
        String url=intent.getStringExtra("bookUrl");

        pdfView.getSettings().setJavaScriptEnabled(true);
        pdfView.getSettings().setBuiltInZoomControls(true);
        pdfView.getSettings().setDisplayZoomControls(true);
        pdfView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress==100)
                {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });


        pdfView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {
               pdfView.loadUrl("javascript:(function() { "+"document.querySelector('[role=\"toolbar\"]').remove();})()");
               progressBar.setVisibility(View.GONE);
            }
        });

        pdfView.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);
    }
}
