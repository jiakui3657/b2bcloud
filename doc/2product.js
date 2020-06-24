/**
 * @apiDefine 2product 2.0 产品模块
 */



/**
 * @api {get} /rest/productcatalog/list.htm 2.01 获取产品的所有分类
 *
 * @apiVersion 0.0.1
 *
 * @apiName productcatalog.list
 *
 * @apiGroup 2product
 *
 * @apiParam {int} tenant 平台id(3)
 *
 * @apiParam {String} userToken 用户令牌
 *
 *
 * @apiPermission none
 *
 * @apiDescription 登录接口
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态信息
 * 
 * @apiSuccess {array} list 数据集合
 * 
 * @apiSuccess {int} list.id 分类id
 * 
 * @apiSuccess {String} list.name 分类名称
 * 
 * @apiSuccess {array} list.children 子分类集合
 * 
 */


 /**
 * @api {get} /rest/product/search.htm 2.02 产品搜索功能
 *
 * @apiVersion 0.0.1
 *
 * @apiName product.search
 *
 * @apiGroup 2product
 *
 * @apiParam {int} tenant 平台id(3)
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 大小
 * 
 * @apiParam {long} brand 品牌id
 * 
 * @apiParam {long} catalog 分类id
 * 
 * @apiParam {long} label 标签id
 * 
 * @apiParam {String} name 商品名称
 *
 *
 * @apiPermission none
 *
 * @apiDescription 产品搜索功能
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态信息
 * 
 * @apiSuccess {array} list 数据集合
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
