/**
 * @apiDefine 4shopcart 4.0 购物车模块
 */



/**
 * @api {get} /rest/shopcartitem/list.htm 4.01 获取购物车里面的数据
 *
 * @apiVersion 0.0.1
 *
 * @apiName shopcartitem.list
 *
 * @apiGroup 4shopcart
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
 * @apiSuccess {int} list.id 购物车id
 *
 * @apiSuccess {int} list.product 商品id
 *
 * @apiSuccess {int} list.size 数量
 *
 * @apiSuccess {int} list.price 价格
 *
 * @apiSuccess {String} list.name 订货会名称
 *
 * @apiSuccess {String} list.logo 订货会图片
 *
 * @apiSuccess {String} list.trade 是否启用订货会商品
 * 
 *
 */


/**
* @api {get} /rest/shopcartitem/create.htm 4.02 添加商品到购物车中
*
* @apiVersion 0.0.1
*
* @apiName shopcartitem.create
*
* @apiGroup 4shopcart
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {int} product 产品id
*
* @apiParam {int} size 数量
* 
* 
* @apiPermission none
*
* @apiDescription 添加商品到购物车中
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
* @apiSuccess {String} name 产品名称
*
* @apiSuccess {float} logo 图片
*
* @apiSuccess {float} size 数量
*
*/



/**
* @api {get} /rest/orderdata/orderData.htm 4.03 下单传递json
*
* @apiVersion 0.0.1
*
* @apiName orderdata.orderData
*
* @apiGroup 4shopcart
*
* @apiParam {int} tenant 平台id(3)
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
* 
* 
* @apiPermission none
*
* @apiDescription 下单传递json
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
* @apiSuccess {String} name 产品名称
*
* @apiSuccess {float} logo 图片
*
* @apiSuccess {float} size 数量
*
*/



/**
* @api {get} /rest/orderdata/search.htm 4.04 订单列表
*
* @apiVersion 0.0.1
*
* @apiName orderdata.search
*
* @apiGroup 4shopcart
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* @apiParam {int} no 页码
*
* @apiParam {int} size 数量
* 
* @apiParam {String} payState 订单支付状态  wait等待支付 success 支付成功
*
* @apiPermission none
*
* @apiDescription 添加商品到购物车中
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
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
* @apiSuccess {Long} list.items.id 下单商品id
* @apiSuccess {String} list.items.name 商品名称
* @apiSuccess {String} list.items.logo 商品图片
* @apiSuccess {int} list.items.size 商品购买数量
* @apiSuccess {int} list.items.useNum 商品使用数量
* @apiSuccess {int} list.items.surplusNum 剩余数量
* @apiSuccess {int} list.items.returnNum 退货数量
*
*/



/**
* @api {get} /rest/orderdata/temps.htm 4.05 理货车中商品
*
* @apiVersion 0.0.1
*
* @apiName orderdata.temps
*
* @apiGroup 4shopcart
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
* 
*
* @apiPermission none
*
* @apiDescription 理货车中商品
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
* @apiSuccess {array} list 集合
*
* @apiSuccess {long} list.id 理货id
*
* @apiSuccess {String} list.name 商品名称
*
* @apiSuccess {float} list.logo 商品图片
*
* @apiSuccess {long} list.product 商品id
* @apiSuccess {float} list.price 商品价格
* @apiSuccess {int} list.num 商品购买数量
* @apiSuccess {int} list.surplusNum 商品剩余数量
* @apiSuccess {int} list.items.useNum 商品使用数量
*
*/





/**
* @api {get} /rest/ordertally/create.htm 4.06 理货车中理货传json
*
* @apiVersion 0.0.1
*
* @apiName ordertally.create
*
* @apiGroup 4shopcart
*
* @apiParam {int} tenant 平台id(3)
*
* @apiParam {String} userToken 用户令牌
*
*  @apiParamExample {json} Request-Example:
*     {
*       "items":{"id":15,"num":10}
*     }
*
*
* @apiPermission none
*
* @apiDescription 理货车中理货
*
* @apiSuccess {int} code 状态码
*
* @apiSuccess {String} msg 状态信息
*
*/
