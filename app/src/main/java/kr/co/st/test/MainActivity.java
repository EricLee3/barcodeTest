package kr.co.st.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;

import org.w3c.dom.Text;


public class MainActivity extends FragmentActivity {

    private WebView mWebView;    // 웹뷰 선언
    public final int CALL_ZXING_RESULT = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "ALL");
        startActivityForResult(intent, CALL_ZXING_RESULT);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CALL_ZXING_RESULT) {

            if(resultCode == Activity.RESULT_OK)
            {
                String contents = data.getStringExtra("SCAN_RESULT");

                TextView tv = (TextView)findViewById(R.id.textView);

                tv.setText(contents);
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
