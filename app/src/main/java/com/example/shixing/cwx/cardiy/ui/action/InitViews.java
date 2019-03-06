package com.example.shixing.cwx.cardiy.ui.action;

/**
 * 提供给activity或者Fragment或者自定义Layout初始化控件的接口
 * Created by 刘 on 2016/11/18.
 */
public interface InitViews {

    /**
     * 给控件绑定事件
     */
    public void bindListener();

    /**
     * 给控件初始化数据
     */
    public void initData();

    /**
     * layout id
     * @return
     */
    public int getLayoutId();
}
