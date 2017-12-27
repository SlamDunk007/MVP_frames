# MVP_Frames

MVP_frames是一套封装完整的MVP框架（解决了MVP存在的内存泄露，采用注解，工厂模式和代理模式对代码进行封装）.

  - 定义了onAttachView和onDetachView方法，在页面创建成功和销毁的时候进行绑定和解绑，解决内存些空间的问题
  - 采用注解方式简化代码
  - 给Presenter添加Activity和Fragment的生命周期，将一些复杂的操作在Presenter层进行处理，和View层进行解耦

# 使用方式

  - 直接依赖mvp_library的module
  - Activity的话直接继承BaseActivity,在我们的Activity上面通过注解声明我们的Presenter:@ViewConfig(RequestPresenter.class)
  - Fragment直接继承BaseFragment,同样在类上面@ViewConfig(RequestPresenter.class)
  - 在Activity和Activity中通过getPresenter()方法获取我们的Presenter对象

详情可以查看源代码: