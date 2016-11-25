package com.lee.leemvp.contracts;

import com.lee.leemvp.base.BasePresenter;
import com.lee.leemvp.base.BaseView;
import com.lee.leemvp.model.UserEntity;

/**
 * Created by android on 2016/11/25.
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void showProgress(boolean active);

        void setText(String text);

    }

    interface Presenter extends BasePresenter {

        void login(UserEntity userEntity) ;


    }
}
