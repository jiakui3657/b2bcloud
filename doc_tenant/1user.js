/**
 * @apiDefine 1user 1.0 用户模块
 */



/**
 * @api {get} /tenantRest/employee/create.htm 1.01 创建员工
 *
 * @apiVersion 0.0.1
 *
 * @apiName 1user.create
 *
 * @apiGroup 1user
 *
 *
 * @apiParam {String} no 登录账号
 *
 * @apiParam {String} password 密码
 * 
 * @apiParam {String} name 姓名
 * 
 * @apiParam {String} phone 手机号
 * 
 * @apiParam {String} email email
 * 
 * @apiParam {String} job 职务
 * 
 * @apiParam {String} sex 性别
 * 
 * @apiParam {int} department 部门id
 *
 *
 * @apiPermission none
 *
 * @apiDescription 创建员工
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


 /**
 * @api {get} /tenantRest/employee/update.htm 1.02 更新员工信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName 1user.update
 *
 * @apiGroup 1user
 *
 *
 * @apiParam {String} name 姓名
 * 
 * @apiParam {String} phone 手机号
 * 
 * @apiParam {String} email email
 * 
 * @apiParam {String} job 职务
 * 
 * @apiParam {String} sex 性别
 * 
 * @apiParam {int} department 部门id
 *
 *
 * @apiPermission none
 *
 * @apiDescription 更新员工信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */




 /**
 * @api {get} /tenantRest/employee/search.htm 1.03 员工搜索
 *
 * @apiVersion 0.0.1
 *
 * @apiName 1user.search
 *
 * @apiGroup 1user
 *
 *
 * @apiParam {String} name 姓名
 * 
 * @apiParam {String} phone 手机号
 * 
 * 
 * @apiParam {String} account 账号
 * 
 * @apiParam {int} department 部门id
 * 
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 分页大小
 *
 * @apiPermission none
 *
 * @apiDescription 更新员工信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


  /**
 * @api {get} /tenantRest/employee/delete.htm 1.04 删除员工
 *
 * @apiVersion 0.0.1
 *
 * @apiName 1user.delete
 *
 * @apiGroup 1user
 *
 * @apiParam {long}  id 员工id
 *
 * @apiPermission none
 *
 * @apiDescription 删除员工
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */