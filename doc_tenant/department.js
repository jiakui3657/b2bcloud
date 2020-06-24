/**
 * @apiDefine department 10.0 部门管理
 */



/**
 * @api {post} /tenantRest/department/create.htm 10.01 创建部门
 *
 * @apiVersion 0.0.1
 *
 * @apiName create
 *
 * @apiGroup department
 *
 *
 * @apiParam {String} name 部门名称
 *
 * @apiParam {int} parent 父部门id，没有不需要添加
 *
 *
 * @apiPermission none
 *
 * @apiDescription 创建部门
 *
 * @apiSuccess {int} id 部门id
 * 
 * @apiSuccess {String} name 部门名称
 * 
 */

/**
 * @api {post} /tenantRest/department/update.htm 10.02 更新部门信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName update
 *
 * @apiGroup department
 *
 *
 * @apiParam {int} id 部门id
 *
 * @apiParam {String} name 部门名称
 *
 *
 * @apiPermission none
 *
 * @apiDescription 更新部门信息
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


 /**
 * @api {post} /tenantRest/department/delete.htm 10.03 删除部门
 *
 * @apiVersion 0.0.1
 *
 * @apiName delete
 *
 * @apiGroup department
 *
 *
 * @apiParam {int} id 部门id
 *
 *
 * @apiPermission none
 *
 * @apiDescription 删除部门
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


  /**
 * @api {post} /tenantRest/department/list.htm 10.04 部门列表
 *
 * @apiVersion 0.0.1
 *
 * @apiName list
 *
 * @apiGroup department
 *
 *
 * @apiParam {int} parent 父部门id，没有可以不传
 *
 *
 * @apiPermission none
 *
 * @apiDescription 删除部门
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


 /**
 * 
 * @api {post} /tenantRest/department/search.htm 10.05 部门搜索
 *
 * @apiVersion 0.0.1
 *
 * @apiName search
 *
 * @apiGroup department
 *
 * @apiParam {String} name 部门名称
 *
 * @apiPermission none
 *
 * @apiDescription 部门搜索
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 * 
 */

  /**
  *
  * @api {post} /tenantRest/department/company.htm 10.06 获取公司部门以及下级的所有部门
  *
  * @apiVersion 0.0.1
  *
  * @apiName company
  *
  * @apiGroup department
  *
  * @apiParam {String} name 部门名称
  *
  * @apiPermission none
  *
  * @apiDescription 获取公司部门以及下级的所有部门
  *
  * @apiSuccess {int} code 状态码
  *
  * @apiSuccess {String} msg 状态消息
  *
  */