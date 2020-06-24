/**
 * @apiDefine 3product 3.0 商品模块
 */



 /**
 * @api {get} /rest/productSpec/list.htm 3.01 获取商品规格
 *
 * @apiVersion 0.0.1
 *
 * @apiName 3product.list
 *
 * @apiGroup 3product
 *
 * @apiParam {int} tenant 平台id(3)
 *
 * @apiParam {int} size 数据量
 *
 * @apiPermission none
 *
 * @apiDescription 获取商品规格
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 *
 * @apiSuccess {array} list 数据集合
 *
 * @apiSuccess {long} list.id id 任务id
 *
 * @apiSuccess {String} list.label 规格名称
 *
 * @apiSuccess {array} list.items 规格值集合
 *
 * @apiSuccess {int} list.items.id 规格值id
 * 
 * @apiSuccess {String} list.items.name 规格值
 */


/**
 * @api {get} /rest/productSpec/add.htm 3.02 对某个规格添加规格值
 *
 * @apiVersion 0.0.1
 *
 * @apiName 3product.add
 *
 * @apiGroup 3product
 *
 *  @apiParam {int} id 规格id
 *
 * @apiParam {String} name 规格值
 *
 *
 * @apiPermission none
 *
 * @apiDescription 对某个规格添加规格值
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 *
 */



 
/**
 * @api {get} /tenantRest/product/create.htm 3.03 创建商品
 *
 * @apiVersion 0.0.1
 *
 * @apiName product.create
 *
 * @apiGroup 3product
 *
 * @apiParam {String} name 商品名称
 * 
 * @apiParam {int} brand 品牌
 * 
 * @apiParam {int} catalog 分类
 * 
 * @apiParam {long} label 标签id
 * 
 * @apiParam {String} code 编码
 * 
 * @apiPermission none
 *
 * @apiDescription 创建商品
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


 /**
 * @api {get} /tenantRest/product/update.htm 3.04 更新商品信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName product.update
 *
 * @apiGroup 3product
 *
 *
 * @apiParam {String} name 商品名称
 * 
 * @apiParam {int} brand 品牌
 * 
 * @apiParam {int} catalog 分类
 * 
 * @apiParam {long} label 标签id
 * 
 * @apiParam {String} code 编码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 更新商品信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */




 /**
 * @api {get} /tenantRest/product/search.htm 3.05 商品搜索
 *
 * @apiVersion 0.0.1
 *
 * @apiName product.search
 *
 * @apiGroup 3product
 *
 *
 * @apiParam {String} name 商品名称
 * 
 * 
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 分页大小
 *
 * @apiPermission none
 *
 * @apiDescription 更新商品信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


  /**
 * @api {get} /tenantRest/product/delete.htm 3.06 删除商品
 *
 * @apiVersion 0.0.1
 *
 * @apiName product.delete
 *
 * @apiGroup 3product
 *
 * @apiParam {long}  id 商品id
 *
 * @apiPermission none
 *
 * @apiDescription 删除商品
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */

