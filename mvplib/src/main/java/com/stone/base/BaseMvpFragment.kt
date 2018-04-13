package com.stone.base

/**
 * @package: com.stone.base
 * @fileName: BaseMvpFragment
 * @data: 2018/4/2 10:34
 * @author: ShiLiang
 * @describe: MVP Fragment
 */
abstract class BaseMvpFragment<V : IView, out P : IPresenter<V>> :SimpleFragment() {

    abstract val presenter:P

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}