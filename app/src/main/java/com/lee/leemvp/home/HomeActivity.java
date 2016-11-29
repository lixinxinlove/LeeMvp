package com.lee.leemvp.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lee.leemvp.presenter.HomePresenter;
import com.lee.leemvp.R;
import com.lee.leemvp.base.BaseActivity;
import com.lee.leemvp.contracts.HomeContract;
import com.lee.leemvp.model.UserEntity;

public class HomeActivity extends BaseActivity implements HomeContract.View {


    private ProgressBar progressBar;
    private EditText edUserName;
    private EditText edPassword;

    private Button loginBtn;

    private TextView tv1;
    private TextView tv2;


    private HomeContract.Presenter mPresenter;

    @Override
    public int LayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void findView() {
        tv1 = (TextView) findViewById(R.id.text_view1);
        tv2 = (TextView) findViewById(R.id.text_view2);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        edUserName = (EditText) findViewById(R.id.username);
        edPassword = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login_btn);
    }

    @Override
    public void setListener4View() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_view1:
                setText("12334566");
                break;
            case R.id.text_view2:

                break;
            case R.id.login_btn:

                UserEntity userEntity = new UserEntity(edUserName.getText().toString(),
                        edPassword.getText().toString());
                mPresenter.login(userEntity);
                break;
        }
    }

    @Override
    public void showProgress(boolean f) {
        if (f) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setText(String text) {
        tv1.setText(text);
    }


}
