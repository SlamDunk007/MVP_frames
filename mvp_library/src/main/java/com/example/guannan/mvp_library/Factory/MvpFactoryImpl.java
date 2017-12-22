package com.example.guannan.mvp_library.Factory;

import com.example.guannan.mvp_library.Inject.ViewConfig;
import com.example.guannan.mvp_library.Presenter.BasePresenter;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/21 16:38
 * @des presenter工厂创建的具体实现
 */

public class MvpFactoryImpl<V extends BaseViewInterface, P extends BasePresenter<V>> implements MvpFactoryInterface<V, P> {

    private Class<?> mClass;

    /**
     * 通过注解获取并创建Presenter
     * @param viewClass
     * @param <V>
     * @param <P>
     * @return
     */
    public static <V extends BaseViewInterface, P extends BasePresenter<V>> MvpFactoryImpl<V, P> createFactory(Class<?> viewClass) {

        if (viewClass != null) {
            ViewConfig viewConfig = viewClass.getAnnotation(ViewConfig.class);
            Class<P> aClass = null;
            if (viewConfig.value() != null) {
                aClass = (Class<P>) viewConfig.value();
            }
            return aClass == null ? null : new MvpFactoryImpl<V, P>(aClass);
        }
        return null;
    }

    public MvpFactoryImpl(Class<?> aClass) {
        this.mClass = aClass;
    }

    /**
     * 实际的创建Presenter的方式
     * @return
     */
    @Override
    public P createPresenter() {
        try {
            if (mClass != null) {
                return (P) mClass.newInstance();    //创建Presenter对象
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
