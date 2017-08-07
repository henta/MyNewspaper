package my.hhx.com.newpager.modules.zhihu.mvp;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import my.hhx.com.newpager.R;
import my.hhx.com.newpager.util.WebUtil;

public class ZhihuArticleActivity extends AppCompatActivity implements ZhihuArticleContract.View {


    @BindView(R.id.article_toolbar)
    Toolbar articleToolbar;
//    @BindView(R.id.article_toolbar_layout)
//    CollapsingToolbarLayout articleToolbarLayout;
//    @BindView(R.id.article_app_bar)
    AppBarLayout articleAppBar;
    @BindView(R.id.article_web)
    WebView articleWeb;
    @BindView(R.id.article_iv)
    ImageView articleIv;
    private ZhihuArticlePresenter zhihuArticlePresenter = new ZhihuArticlePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        setSupportActionBar(articleToolbar);
        loadArticle();
    }

    private void loadArticle() {
        ZhihuDaily.StoriesBean storiesBean = (ZhihuDaily.StoriesBean) getIntent().getSerializableExtra("article");
        zhihuArticlePresenter.loadArticle(storiesBean);
    }


    @Override
    public void loadFail() {

    }

    @Override
    public void loadSucess(ZhihuArticle zhihuArticle) {
        Glide.with(this)
                .load(zhihuArticle.getImage())
                .into(articleIv);
        String body= WebUtil.buildHtmlWithCss(zhihuArticle.getBody(),zhihuArticle.getCss(),false);
        articleWeb.loadDataWithBaseURL(WebUtil.BASE_URL, body, WebUtil.MIME_TYPE, WebUtil.ENCODING, WebUtil.FAIL_URL);

    }
}
