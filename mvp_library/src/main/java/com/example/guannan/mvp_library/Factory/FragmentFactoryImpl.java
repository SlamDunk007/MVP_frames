package com.example.guannan.mvp_library.Factory;

import com.example.guannan.mvp_library.Inject.ViewConfig;
import com.example.guannan.mvp_library.Presenter.FragmentPresenter;
import com.example.guannan.mvp_library.View.BaseViewInterface;

/**
 * @author guannan
 * @date 2017/12/25 17:02
 * fragment的presenter工厂创建的具体实现
 */

public class FragmentFactoryImpl<V extends BaseViewInterface,P extends FragmentPresenter<V>> implements MvpFactoryInterface<V,P>{

    private Class<P> mClass;

    public static <V extends BaseViewInterface,P extends FragmentPresenter<V>> FragmentFactoryImpl<V,P> createFactory(Class<?> viewClass){
        if (viewClass != null) {
            ViewConfig viewConfig = viewClass.getAnnotation(ViewConfig.class);
            Class<P> aClass = null;
            if (viewConfig.value() != null) {
                aClass = (Class<P>) viewConfig.value();
            }
            return aClass == null ? null : new FragmentFactoryImpl<V, P>(aClass);
        }
        return null;
    }

    public FragmentFactoryImpl(Class<P> aClass){
        this.mClass = aClass;
    }

    @Override
    public P createPresenter() {
        try {
            if(mClass!=null){
                P instance = mClass.newInstance();
                return instance;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
