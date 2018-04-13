package com.stone.base

/**
 * @package: com.stone.base
 * @fileName: RxPresenter
 * @data: 2018/4/2 9:37
 * @author: ShiLiang
 * @describe:
 */
open class RxPresenter<V: IView>(protected var view: V?): IPresenter<V> {

    init {
        attach(view)
    }

    final override fun attach(view: V?) {

    }

    override fun detach() {
        view = null
    }
}