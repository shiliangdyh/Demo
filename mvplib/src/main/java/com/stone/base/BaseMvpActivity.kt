package com.stone.base

/**
 * @package: com.stone.base
 * @fileName: BaseMvpActivity
 * @data: 2018/4/2 9:39
 * @author: ShiLiang
 * @describe: MVP activity
 */

abstract class BaseMvpActivity<V : IView, out P : IPresenter<V>> : SimpleActivity(){

    abstract val presenter:P

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

}
