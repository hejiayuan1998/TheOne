package com.smashing.theone.business.common;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.base.BasePresenter;
import com.smashing.theone.common.widget.TitleBar;

import butterknife.Bind;

/**
 * author: chensen
 * date: 2017年04月05日9:11
 * desc: 显示一个网页
 */

public class HtmlActivity extends BaseActivity {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.web_view)
    WebView webView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_html;
    }

    @Override
    protected void initView() {
        titleBar.showRightIcon(false);
        titleBar.setTitle("网页");
        titleBar.setOnLeftIconClickListener(new TitleBar.onLeftIconClickListener() {
            @Override
            public void onLeftIconClick(View v) {
                finish();
            }
        });


        String url = getIntent().getStringExtra("url");
        if (url == null || url.equals("")) {
            Toast.makeText(mContext, "传入的url为空", 0).show();
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    webView.loadUrl(url);
                    return true;
                }


            });

            webView.loadUrl(url);


        }


    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }


}
