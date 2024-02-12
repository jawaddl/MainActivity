package com.example.mainactivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button startButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        urlEditText = findViewById(R.id.urlEditText);
        startButton = findViewById(R.id.startButton);
        webView = findViewById(R.id.webView);

        // Set WebViewClient to open the website in the same WebView
        webView.setWebViewClient(new WebViewClient());
        // Open a special window for viewing browser content
        webView.setWebChromeClient(new WebChromeClient());

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlEditText.getText().toString();
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                webView.loadUrl(url);
            }
        });
    }
}