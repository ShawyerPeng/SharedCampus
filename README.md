# SharedCampus
共享校园 APP 后端

# 全局状态码
状态码 | 状态码解释
--- | ---
200 | 请求成功
300 | 重定向
400 | 客户端错误
401 | 身份验证错误
403 | 禁止访问
404 | 无法找到资源
500 | 服务器错误
1001 | 接口认证失败
1002 | 授权过期
1003 | 缺失参数

# 接口说明
## User
请求 URL | 功能描述 | 请求参数（`*`为必填项） | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/user/register` | 用户注册 | userName*, userPass* | POST |
`/user/login` | 用户登录 | userName*, userPass* | POST |
`/user/check` | 验证用户名是否存在| userName* | GET |
`/user/delete` | 删除用户账号 | userName* | POST |
`/user/changePass` | 修改密码 | userName*, newPass* | POST |
`/user/edit` | 编辑用户信息 | userName, userPass, realname, gender, phone, email, alipay, iconimg, info, createdTime, lastLogin, honesty, balance | POST |
`/user/getUser` | 返回某一用户的信息 | userName* | GET |

### register
http://118.89.142.148:8080/user/register
```json
{
	"userName":"admin",
	"userPass":"123456"
}
```
### login
http://118.89.142.148:8080/user/login
```json
{
	"userName":"admin",
	"userPass":"123456"
}
```
### check
http://118.89.142.148:8080/user/check
```json
{
	"userName":"admin"
}
```
### delete
```json
{
	"userName":"admin",
	"userPass":"123456"
}
```
### changePass
http://118.89.142.148:8080/user/changePass
```json
{
	"userName":"admin",
	"newPass":"123"
}
```
### edit
http://118.89.142.148:8080/user/edit
性别 - 0：未知，1：男，2：女
```json
{
	"userName":"admin",
	"realname":"这是真实姓名",
	"gender":1,
	"phone":"这是手机号",
	"email":"这是邮箱地址",
	"alipay":"这是支付宝账号",
	"iconimg":"这是头像地址",
	"info":"这是自我介绍"
}
```
### getUser
http://118.89.142.148:8080/user/getUser
```json
{
	"userName":"admin"
}
```


## Task
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/task/insert` | 新增任务 | publisherId, title, description, category, price, counts, starttime, endtime | POST | 
`/task/insertWithPic` | 新增任务（带图片） | publisherId, title, description, category, price, counts, starttime, endtime, pic_url | POST | 
`/task/edit` | 修改任务信息 | taskId, publisherId, title, description, category, price, counts, starttime, endtime | POST |
`/task/delete` | 删除任务 | taskId* | POST |
`/task/getAllTasks` | 获取用户的所有任务 | publisherId* | GET |
`/task/getUncompletedTasks` | 获取用户所有未完成任务 | publisherId* | GET | 
`/task/getCompletedTasks` | 获取用户所有已完成任务 | publisherId* | GET |
`/task/searchTaskByTitle` | 根据关键词搜索任务 | title* | GET |
`/task/searchTaskByCategory` | 根据分类搜索任务 | category* | GET |
### insert
http://118.89.142.148:8080/task/insert
```json
{
	"publisherId":1,
	"title":"这是任务标题",
	"description":"这是任务描述",
	"category":2,
	"price":998,
	"counts":2,
	"starttime":"2017-05-20 12:00:00",
	"endtime":"2017-05-22 12:00:00"
}
```
### insertWithPic
http://118.89.142.148:8080/task/insertWithPic
```json
{
	"publisherId":1,
	"title":"这是任务标题",
	"description":"这是任务描述",
	"category":2,
	"price":998,
	"counts":2,
	"starttime":"2017-05-20 12:00:00",
	"endtime":"2017-05-22 12:00:00",
	"pic":"这是任务图片地址"
}
```
### edit
http://118.89.142.148:8080/task/edit
```json
{
	"taskId":8,
	"publisherId":8,
	"title":"修改标题",
	"description":"修改描述",
	"category":4,
	"price":188.8,
	"counts":1,
	"starttime":"2017-05-20 10:30:00",
	"endtime":"2017-05-22 10:30:00"
}
```
### delete
http://118.89.142.148:8080/task/delete
```json
{
	"taskId":8
}
```
### getAllTasks
http://118.89.142.148:8080/task/getAllTasks
```json
{
	"publisherId":1
}
```
### getUncompletedTasks
http://118.89.142.148:8080/task/getUncompletedTasks
```json
{
	"publisherId":1
}
```
### getCompletedTasks
http://118.89.142.148:8080/task/getCompletedTasks
```json
{
	"publisherId":1
}
```
### searchTaskByTitle
http://118.89.142.148:8080/task/searchTaskByTitle
```json
{
	"title":"这是任务标题"
}

```
### searchTaskByCategory
http://118.89.142.148:8080/task/searchTaskByCategory
```json
{
	"category":"这是任务分类"
}
```


## Order
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/order/` | | | POST | 
`/order/` | | | POST |
`/order/` | | | POST |
`/order/` | | | POST |

## Image
非JSON格式！！！请用form-data格式传输！！！  
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/image/upload` | 上传图片 | file* | POST | 
`/image/uploadMultipart` | 上传图片（多张） | file* | POST |
`/image/uploadWithDescription` | 上传图片（添加描述） | file*, description* | POST |
### upload
http://118.89.142.148:8080/image/upload
### uploadMultipart
http://118.89.142.148:8080/image/uploadMultipart
### uploadWithDescription
http://118.89.142.148:8080/image/uploadWithDescription