/**
 * @apiDefine 3promote 3.0 订货会模块
 */



/**
 * @api {get} /rest/promote/list.htm 3.01 获取进行中的订货会
 *
 * @apiVersion 0.0.1
 *
 * @apiName promote.list
 *
 * @apiGroup 3promote
 *
 * @apiParam {int} tenant 平台id(3)
 *
 * @apiParam {String} userToken 用户令牌
 *
 *
 * @apiPermission none
 *
 * @apiDescription 获取进行中的订货会
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态信息
 *
 * @apiSuccess {array} list 数据集合
 *
 * @apiSuccess {int} list.id 订货会id
 *
 * @apiSuccess {String} list.name 订货会名称
 *
 * @apiSuccess {String} list.logo 订货会图片
 *
 */


/**
* @api {get} /rest/promoteproduct/list.htm 3.02 某个订货会中的商品
*
* @apiVersion 0.0.1
*
* @apiName promoteproduct.list
*
* @apiGroup 3promote
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {int} promote 订货会id
*
* @apiPermission none
*
* @apiDescription 某个订货会中的商品
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
* @apiSuccess {int} mini 订货会起订量
*
* @apiSuccess {float} scale 付款比例
*
* @apiSuccess {array} list 产品集合
*
* @apiSuccess {int} list.id 产品id
*
* @apiSuccess {String} list.name 产品名称
*
* @apiSuccess {String} list.barCode 条形码
*
* @apiSuccess {String} list.catalog 分类名称
*
* @apiSuccess {float} list.salePrice 销售价格
*
* @apiSuccess {float} list.marketPrice 市场价
*
* @apiSuccess {float} list.marketPrice 市场价
*
* @apiSuccess {float} list.logo 图片
*
* @apiSuccess {float} list.unit 单位
*
*
*/


/**
* @api {get} /rest/ordertrade/order.htm 3.03 订货会下单接口传递json
*
* @apiVersion 0.0.1
*
* @apiName promoteproduct.order
*
* @apiGroup 3promote
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {array} items 商品数组
*
* @apiParam {Long} items.id 商品id
*
* @apiParam {int} items.num 购买数量
*
*  @apiParamExample {json} Request-Example:
*     {
*       "items":{"id":15,"num":10}
*     }
*
* @apiPermission none
*
* @apiDescription 订货会下单接口传递json
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
*/



/**
* @api {get} /rest/ordertrade/searchByUser.htm 3.04 订货会订单
*
* @apiVersion 0.0.1
*
* @apiName ordertrade.searchByUser
*
* @apiGroup 3promote
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {int} no 页码
*
* @apiParam {int} size 大小
*
* @apiParam {String} payState 订单支付状态  wait等待支付 success 支付成功
*
* @apiPermission none
*
* @apiDescription 订货会订单
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
*
* @apiSuccess {array} list 产品集合
*
* @apiSuccess {int} list.id 订单id
*
* @apiSuccess {String} list.no 订单编号
*
* @apiSuccess {String} list.promote 订货会名称
*
* @apiSuccess {String} list.payState 支付状态
*
* @apiSuccess {float} list.customer 下单人姓名
*
* @apiSuccess {float} list.money 订单总价
*
* @apiSuccess {float} list.payMoney 实际付款金额
*
* @apiSuccess {float} list.productCount 下单数量
* 
* @apiSuccess {array} list.items 下单商品
*
* @apiSuccess {array} list.items.id 下单商品id
* @apiSuccess {array} list.items.name 商品名称
* @apiSuccess {array} list.items.logo 商品图片
* @apiSuccess {array} list.items.size 商品购买数量
* @apiSuccess {array} list.items.useNum 商品使用数量
* @apiSuccess {array} list.items.price 商品锁定单价
*/



/**
* @api {get} /rest/ordertrade/rePay.htm 3.05 重新支付该订单
*
* @apiVersion 0.0.1
*
* @apiName promoteproduct.rePay
*
* @apiGroup 3promote
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {long} id 订单
*
* @apiParam {String} openId  微信openId
*
* @apiPermission none
*
* @apiDescription 重新支付该订单
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
*/

/**
* @api {get} /rest/ordertrade/delete.htm 3.06 取消订货单订单
*
* @apiVersion 0.0.1
*
* @apiName promoteproduct.delete
*
* @apiGroup 3promote
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {long} id 订单
*
* @apiPermission none
*
* @apiDescription 取消订货单订单
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
*/



