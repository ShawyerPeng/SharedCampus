# SharedCampus
共享校园 APP 后端

# 全局状态码
状态码 | 状态码解释
--- | ---
200 | 请求成功
201 | 数据创建、修改成功（POST 方法成功新建资源）
202 | 服务器已接受请求，但尚未处理（需要的资源无法及时建立，如异步操作）
204 | 数据删除成功，没有 response body
206 | GET 请求成功, 但是只返回一部分
300 | 重定向
304 | Not Modified - 用于 HTTP 缓存机制
400 | 客户端错误（参数错误，请求格式不对，比如 body 无法解析）。通常在请求参数不合法或格式错误的时候可以返回这个状态码。
401 | 身份验证错误（未授权）。通常在没有登录的状态下访问一些受保护的 API 时会用到这个状态码。
403 | 禁止访问，用户没有权限。通常在没有权限操作资源时 (如修改 / 删除一个不属于该用户的资源时) 会用到这个状态码。
404 | 无法找到资源。通常在找不到资源时返回这个状态码。
405 | 用户无权使用该方法
406 | 用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
410 | 资源已不存在，适用于响应老版本 API 的调用
415 | Unsupported Media Type错误
422 | 验证错误。请求被服务器正确解析，但是包含无效字段
429 | 请求过于频繁，可以用在客户端调用过于频繁的情况。
500 | 服务器错误
1000 | 通用参数错误
1001 | 接口认证失败
1002 | 授权过期
1003 | 缺失参数
1004 | 尝试非法操作（自己的令牌操作其他人的数据）

# 接口说明
## User
请求 URL | 功能描述 | 请求参数（`*`为必填项） | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/user/register` | 用户注册 | userName*, userPass* | POST |
`/user/login` | 用户登录 | userName*, userPass* | POST |
`/user/delete` | 删除用户账号 | userName* | POST |
`/user/changePass` | 修改密码 | userName*, newPass* | POST |
`/user/check` | 验证用户名是否存在| userName* | GET |
`/user/info` | 返回某一用户的信息 | userName* | GET |
`/user/infoById` | 返回某一用户的信息 | userId* | GET |
`/user/edit` | 编辑用户信息 | userName, userPass, realname, gender, phone, email, alipay, iconimg, info, createdTime, lastLogin, honesty, balance | POST |

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
注意：上传用户头像时，先调用`/image/upload`接口上传图片，然后获取图片的URL，最后把获取的URL作为参数同其他信息一起POST。  

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
### info
http://118.89.142.148:8080/user/info
```json
{
	"userName":"admin"
}
```


## Pocket
请求 URL | 功能描述 | 请求参数（`*`为必填项） | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/pocket/balance` | 查看钱包余额 | userName*, userPass* | POST |
`/pocket/update` | 用户登录 | userName*, userPass* | POST |

### balance
http://118.89.142.148:8080/pocket/balance
```json
{
	"userId":2
}
```
### update
http://118.89.142.148:8080/pocket/update
```json
{
	"userId":1,
	"amount":5
}
```
### balance
http://118.89.142.148:8080/pocket/
```json

```
### balance
http://118.89.142.148:8080/pocket/
```json

```



## Task
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/task/insert` | 新增任务 | publisherId, title, description, category, price, counts, starttime, endtime | POST | 
`/task/insertWithPic` | 新增任务（带图片） | publisherId, title, description, category, price, counts, starttime, endtime, pic | POST | 
`/task/edit` | 修改任务信息 | taskId, publisherId, title, description, category, price, counts, starttime, endtime | POST |
`/task/delete` | 删除任务 | taskId* | POST |
`/task/getTaskByTaskId` | 获取单个任务信息 | taskId* | GET |
`/task/getTasks?pageNo={1}&pageSize={20}` | 获取所有用户的任务（首页） | | GET |
`/task/getAllTasks?pageNo={1}&pageSize={20}` | 获取用户的所有任务 | publisherId* | GET |
`/task/getUncompletedTasks?pageNo={1}&pageSize={20}` | 获取用户所有未完成任务 | publisherId* | GET | 
`/task/getCompletedTasks?pageNo={1}&pageSize={20}` | 获取用户所有已完成任务 | publisherId* | GET |
`/task/searchTaskByTitle?pageNo={1}&pageSize={20}` | 根据关键词搜索任务 | title* | GET |
`/task/searchTaskByCategory?category={1}&pageNo={1}&pageSize={20}` | 根据分类搜索任务 | category* | GET |
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
### getTaskByTaskId
http://118.89.142.148:8080/task/getTaskByTaskId
```json
{
	"taskId":1
}
```
### getTasks
http://118.89.142.148:8080/task/getTasks?pageNo={1}&pageSize={20}
### getAllTasks
http://118.89.142.148:8080/task/getAllTasks?pageNo={1}&pageSize={20}
```json
{
	"publisherId":1
}
```
### getUncompletedTasks
http://118.89.142.148:8080/task/getUncompletedTasks?pageNo={1}&pageSize={20}
```json
{
	"publisherId":1
}
```
### getCompletedTasks
http://118.89.142.148:8080/task/getCompletedTasks?pageNo={1}&pageSize={20}
```json
{
	"publisherId":1
}
```
### searchTaskByTitle
http://118.89.142.148:8080/task/searchTaskByTitle?pageNo={1}&pageSize={20}
```json
{
	"title":"这是任务标题"
}

```
### searchTaskByCategory
直接带参数GET：http://118.89.142.148:8080/task/searchTaskByCategory?category={1}&pageNo={1}&pageSize={20}

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
http://118.89.142.148:8080/collect/getAllCollects?pageNo=1&pageSize=20

## Follow
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/follow/insert` | 添加任务关注 | followerId*, followedId* | POST | 
`/follow/delete` | 删除任务关注 | followId* | POST |
`/follow/getFolloweds` | 获取所有被followerId关注了的人 | followerId*, pageNo*, pageSize* | GET | 
`/follow/getFollowers` | 获取所有关注了某用户followedId的人 | followedId*, pageNo*, pageSize* | GET | 
`/follow/getAllFollows` | 获取所有关注（废弃） | pageNo*, pageSize* | GET | 

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
### getFolloweds
直接带参数GET: http://118.89.142.148:8080/follow/getFolloweds?followerId=10000&pageNo=1&pageSize=10
### getFollowers
直接带参数GET: http://118.89.142.148:8080/follow/getFollowers?followedId=10000&pageNo=1&pageSize=10
### getAllFollows
http://118.89.142.148:8080/follow/getAllCollects?pageNo=1&pageSize=20


## Order
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/order/insert` | 新增订单 | taskId*, receiverId*, price* | POST | 
`/order/getPublishOrdersByType` | 根据订单类型及订单状态查询所有发出的订单 | publisherId*, orderType*, orderStatus* | GET |
`/order/getReceiveOrdersByType` | 根据订单类型及订单状态查询所有接受的订单 | receiverId*, orderType*, orderStatus* | GET |
`/order/queryPublishedOrders` | 根据订单状态查询所有发出任务的订单（废弃） | receiverId*, orderStatus* | GET |
`/order/queryReceivedOrders` | 根据订单状态查询所有接受任务的订单（废弃） | publisherId* | GET |
`/order/updateOrderStatus` | 修改订单状态 | orderId*, orderStatus* | POST |

### insert
http://118.89.142.148:8080/order/insert
如果是大咖任务,则taskId=0
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
### updateOrderStatus
http://118.89.142.148:8080/order/updateOrderStatus
```json
{
	"orderId":2,
	"orderStatus":3
}
```
### getPublishOrdersByType
直接带参数GET：http://118.89.142.148:8080/order/getPublishOrdersByType?publisherId=1&orderType=1&orderStatus=1&pageNo=1&pageSize=10
### getReceiveOrdersByType
直接带参数GET：http://118.89.142.148:8080/order/getReceiveOrdersByType?receiverId=1&orderType=1&orderStatus=1&pageNo=1&pageSize=10

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

## Daka
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/daka/insert` | 新增大咖 | userId*, info, honor, achievement | POST | 
`/daka/delete` | 删除大咖 | dakaId* | POST |
`/daka/update` | 更新大咖信息 | dakaId*, info, honor, achievement | POST |
`/daka/info` | 获取大咖信息 | dakaId* | GET |

## DakaFollow
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/dakaFollow/follow` | 关注大咖 | dakaId*, followerId* | POST | 
`/dakaFollow/unfollow` | 取消关注大咖 | dakaId*, followerId* | POST |
`/dakaFollow/getFollowerCount` | 获取大咖的被关注数 | dakaId* | POST |
`/dakaFollow/getAllDakaFollows` | 获取大咖的所有关注者 | pageNo*, pageSize* | GET | 

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