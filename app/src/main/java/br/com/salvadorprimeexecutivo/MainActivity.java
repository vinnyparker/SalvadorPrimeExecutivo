package br.com.salvadorprimeexecutivo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        myWebView.setWebViewClient(webViewClient);

        myWebView.loadUrl("https://salvadorprimeexecutivo.com.br");

        //habilita JS
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()){
            myWebView.canGoBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
