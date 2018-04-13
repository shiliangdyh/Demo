package com.stone.base

/**
 * @package: com.stone.base
 * @fileName: IPresenter
 * @data: 2018/4/2 9:32
 * @author: ShiLiang
 * @describe:
 */
interface IPresenter<V:IView> {
    fun attach(view: V?)
    fun detach()
}