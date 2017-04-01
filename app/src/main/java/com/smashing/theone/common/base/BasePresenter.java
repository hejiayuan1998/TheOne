package com.smashing.theone.common.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * author: chensen
 * date: 2017年03月23日9:19
 * desc:
 */

public abstract class BasePresenter<T extends BaseView, M extends BaseModel> {
    public T mView;
    public M mModel;

    protected CompositeSubscription compositeSubscription;


    public BasePresenter(T mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }


    public void onDestory() {
        unSubscribe();
        mView = null;
    }

    /**
     * 用于解除订阅
     *
     * @param subscription
     */
    public void addSubscribe(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription != null)
            compositeSubscription.clear();
    }
}
