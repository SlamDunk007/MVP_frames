package com.example.guannan.mvp_frames;

import android.app.Activity;

import com.example.guannan.mvp_frames.Inject.InjectValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author guannan
 * @date 2017/12/20 10:25
 */

public class BindView {

    public static void bind(Activity activity){
        try {

            Class<? extends Activity> aClass = activity.getClass();
            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                InjectValue annotation = field.getAnnotation(InjectValue.class);
                if(annotation!=null){
                    int value = annotation.value();
                    if(value!=-1){
                        Method method = aClass.getMethod("findViewById", int.class);
                        Object resView = method.invoke(activity, value);
                        field.setAccessible(true);
                        field.set(activity,resView);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

