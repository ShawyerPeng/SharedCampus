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
`/task/getTasks` | 分页获取任务 | pageNo*,pageSize* | GET |
`/task/getTaskByTaskId` | 获取单个任务信息 | taskId* | GET |
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
### getTasks
http://118.89.142.148:8080/task/getTasks
```json
{
	"pageNo":1,
	"pageSize":20
}
```
### getTaskByTaskId
http://118.89.142.148:8080/task/getTaskByTaskId
```json
{
	"taskId":1
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

## Comment
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/comment/insert` | 新增评论 | taskId*, fromUid*, toUid, content* | POST |
`/comment/delete` | 删除评论 | commentId* | POST |
`/comment/getAllComments` | 获取某用户的所有评论 | fromUid* | POST |
`/comment/getTaskComments` | 获取某个任务下的所有评论 | taskId* | POST |

### insert
http://118.89.142.148:8080/comment/insert

留言：
```json
{
	"taskId":1,
	"fromUid":1,
	"toUid":null,
	"content":"200元"
}
```
回复留言：
```json
{
	"taskId":1,
	"fromUid":1,
	"toUid":2,
	"content":"200元"
}
```
### delete
http://118.89.142.148:8080/comment/delete
```json
{
	"commentId":1
}
```
### getAllComments
http://118.89.142.148:8080/comment/getAllComments
```json
{
	"fromUid":1
}
```

### getTaskComments
http://118.89.142.148:8080/comment/getTaskComments
```json
{
	"taskId":1
}
```

## Collect
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/collect/insert` | 添加任务收藏 | collectorId*, taskId* | POST |
`/collect/delete` | 删除任务收藏 | collectId* | POST |
`/collect/getAllCollects` | 获取所有收藏 | pageNo*, pageSize* | GET |
### insert
http://118.89.142.148:8080/collect/insert
```json
{
	"collectorId":1,
	"taskId":2
}
```
### delete
http://118.89.142.148:8080/collect/delete
```json
{
	"collectId":1
}
```
### getAllCollects
http://localhost:8080/collect/getAllCollects?pageNo=1&pageSize=20

## Follow
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/follow/insert` | 添加任务关注 | followerId*, followedId* | POST | 
`/follow/delete` | 删除任务关注 | followId* | POST |
`/follow/getAllCollects` | 获取所有关注 | pageNo*, pageSize* | GET | 
### insert
http://118.89.142.148:8080/follow/insert
```json
{
	"followerId":1,
	"followedId":2
}
```
### delete
http://118.89.142.148:8080/follow/delete
```json
{
	"followId":1
}
```
### getAllCollects
http://localhost:8080/follow/getAllCollects?pageNo=1&pageSize=20


## Order
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/order/insert` | | | POST | 
`/order/getPublishedOrders` | 获取所有发出任务的订单 | | POST |
`/order/getReceivedOrders` | 获取所有接受任务的订单 | | POST |
`/order/getCompletedPublishedOrders` | 获取已完成的所有发出任务的订单 | | POST |
`/order/getCompletedReceivedOrders` | 获取已完成的所有接受任务的订单 | | POST |

### insert
http://118.89.142.148:8080/order/insert
```json
{
	"taskId":1,
	"receiverId":2,
	"price":998
}
```
### queryPublishedOrders
http://118.89.142.148:8080/order/queryPublishedOrders?pageNo=1&pageSize=20
```json
{
	"receiverId":2,
	"orderStatus":1
}
```
### queryReceivedOrders
http://118.89.142.148:8080/order/queryReceivedOrders?pageNo=1&pageSize=20
```json
{
	"publisherId":2,
	"orderStatus":1
}
```
### 
http://118.89.142.148:8080/order/getCompletedPublishedOrders
```json

```
### 
http://118.89.142.148:8080/order/getCompletedReceivedOrders
```json

```

## Image
非JSON格式！！！请用form-data格式传输！！！  

上传后真实图片URL地址为：http://118.89.142.148:8080/images/xxx.jpg

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




# 数据库字段表
## User
```
+--------------+------------------+------+-----+---------------------+-----------------------------+
| Field        | Type             | Null | Key | Default             | Extra                       |
+--------------+------------------+------+-----+---------------------+-----------------------------+
| user_id      | int(11) unsigned | NO   | PRI | NULL                | auto_increment              |
| user_name    | varchar(32)      | NO   | UNI |                     |                             |
| user_pass    | varchar(32)      | NO   |     |                     |                             |
| realname     | varchar(16)      | YES  |     |                     |                             |
| gender       | tinyint(4)       | YES  |     | 0                   |                             |
| phone        | varchar(11)      | YES  |     |                     |                             |
| email        | varchar(100)     | YES  |     |                     |                             |
| alipay       | varchar(100)     | YES  |     |                     |                             |
| iconimg      | varchar(120)     | YES  |     |                     |                             |
| info         | varchar(255)     | YES  |     |                     |                             |
| created_time | timestamp        | NO   |     | CURRENT_TIMESTAMP   |                             |
| last_login   | timestamp        | NO   |     | 1970-01-02 00:00:00 | on update CURRENT_TIMESTAMP |
| honesty      | int(4)           | NO   |     | 100                 |                             |
| balance      | double           | YES  |     | 0                   |                             |
+--------------+------------------+------+-----+---------------------+-----------------------------+
```
## Task
```
+--------------+------------------+------+-----+---------------------+----------------+
| Field        | Type             | Null | Key | Default             | Extra          |
+--------------+------------------+------+-----+---------------------+----------------+
| task_id      | int(11) unsigned | NO   | PRI | NULL                | auto_increment |
| publisher_id | int(11) unsigned | NO   | MUL | NULL                |                |
| title        | varchar(32)      | NO   |     |                     |                |
| description  | varchar(255)     | NO   |     |                     |                |
| category     | mediumint(8)     | NO   |     | 0                   |                |
| price        | double           | NO   |     | 0                   |                |
| counts       | mediumint(8)     | NO   |     | 0                   |                |
| starttime    | timestamp        | NO   |     | 1970-01-02 00:00:00 |                |
| endtime      | timestamp        | NO   |     | 1970-01-02 00:00:00 |                |
| pic          | varchar(127)     | YES  |     |                     |                |
| pubtime      | timestamp        | NO   |     | CURRENT_TIMESTAMP   |                |
| is_finished  | tinyint(4)       | NO   |     | 0                   |                |
+--------------+------------------+------+-----+---------------------+----------------+
```
## Comment
```
+------------+------------------+------+-----+-------------------+----------------+
| Field      | Type             | Null | Key | Default           | Extra          |
+------------+------------------+------+-----+-------------------+----------------+
| comment_id | int(11) unsigned | NO   | PRI | NULL              | auto_increment |
| task_id    | int(11) unsigned | NO   |     | NULL              |                |
| from_uid   | int(11) unsigned | NO   |     | NULL              |                |
| to_uid     | int(11) unsigned | YES  |     | NULL              |                |
| content    | varchar(255)     | NO   |     | NULL              |                |
| send_time  | timestamp        | NO   |     | CURRENT_TIMESTAMP |                |
+------------+------------------+------+-----+-------------------+----------------+
```
## Collect
```
+--------------+------------------+------+-----+-------------------+----------------+
| Field        | Type             | Null | Key | Default           | Extra          |
+--------------+------------------+------+-----+-------------------+----------------+
| collect_id   | int(11) unsigned | NO   | PRI | NULL              | auto_increment |
| collector_id | int(11) unsigned | NO   | MUL | NULL              |                |
| task_id      | int(11) unsigned | NO   | MUL | NULL              |                |
| collect_time | timestamp        | NO   |     | CURRENT_TIMESTAMP |                |
+--------------+------------------+------+-----+-------------------+----------------+
```
## Follow
```
+-------------+------------------+------+-----+-------------------+----------------+
| Field       | Type             | Null | Key | Default           | Extra          |
+-------------+------------------+------+-----+-------------------+----------------+
| follow_id   | int(11) unsigned | NO   | PRI | NULL              | auto_increment |
| follower_id | int(11) unsigned | NO   |     | NULL              |                |
| followed_id | int(11) unsigned | NO   |     | NULL              |                |
| follow_time | timestamp        | NO   |     | CURRENT_TIMESTAMP |                |
+-------------+------------------+------+-----+-------------------+----------------+
```
## Order
```
+----------------+------------------+------+-----+-------------------+----------------+
| Field          | Type             | Null | Key | Default           | Extra          |
+----------------+------------------+------+-----+-------------------+----------------+
| order_id       | int(11) unsigned | NO   | PRI | NULL              | auto_increment |
| task_id        | int(11) unsigned | YES  | MUL | NULL              |                |
| receiver_id    | int(11) unsigned | YES  | MUL | NULL              |                |
| price          | double           | YES  |     | NULL              |                |
| order_status   | tinyint(4)       | YES  |     | 1                 |                |
| comment_status | tinyint(4)       | YES  |     | NULL              |                |
| comment_buyer  | varchar(255)     | YES  |     | NULL              |                |
| comment_seller | varchar(255)     | YES  |     | NULL              |                |
| rate_status    | tinyint(4)       | YES  |     | 0                 |                |
| rate_buyer     | tinyint(4)       | YES  |     | NULL              |                |
| rate_seller    | tinyint(4)       | YES  |     | NULL              |                |
| order_time     | timestamp        | NO   |     | CURRENT_TIMESTAMP |                |
+----------------+------------------+------+-----+-------------------+----------------+
```
## Image
```
+-------------+------------------+------+-----+---------+----------------+
| Field       | Type             | Null | Key | Default | Extra          |
+-------------+------------------+------+-----+---------+----------------+
| image_id    | int(11) unsigned | NO   | PRI | NULL    | auto_increment |
| filename    | varchar(255)     | NO   |     |         |                |
| pic_url     | varchar(255)     | NO   |     |         |                |
| description | varchar(255)     | YES  |     |         |                |
+-------------+------------------+------+-----+---------+----------------+
```