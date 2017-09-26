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
`/user/check` | 验证用户名是否存在| userName* | POST |
`/user/delete` | 删除用户账号 | userName* | POST |
`/user/changePass` | 修改密码 | userName*, newPass* | POST |
`/user/edit` | 编辑用户信息 | userName, userPass, realname, gender, phone, email, alipay, iconimg, info, createdTime, lastLogin, honesty, balance | POST |
`/user/getUser` | 返回某一用户的信息 | userName* | POST |

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

## Order
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/order/` | | | POST | 
`/order/` | | | POST |
`/order/` | | | POST |
`/order/` | | | POST |

## Image
请求 URL | 功能描述 | 请求参数 | 请求方式 | 返回结果
--- | --- | --- | --- | ---
`/image/upload` | 上传图片 | file* | POST | 
`/image/uploadMultipart` | 上传图片（多张） | file* | POST |
`/image/uploadWithDescription` | 上传图片（添加描述） | file*, description* | POST |