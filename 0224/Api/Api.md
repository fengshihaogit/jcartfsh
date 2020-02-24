
##########################################################################################################################################################
# Product
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| product_id  | int  | 主键 自增 | Id  |
| product_code | varchar(50)  | 非空，唯一索引 | 商品代码  |
| product_name | varchar(100)  | 非空 | 商品名称  |
| price  | double  | 非空 | 价格  |
| discount  | double  |  | 打折（0.01-0.99）  |
| quantity  | int  | 非空，默认0  | 库存数量  |
##########################################################################################################################################################

| status  | tinyint  | 非空 | 状态（0下架、1上架、2待审核）  |
| main_pic_url | varchar(100)  | 非空 | 主图  |
| reword_points  | int  |  | 积分  |

{
    total:10,
    pageNum:1,
    pageSize:2,
    list:[ 
        {
            "product_name": "面膜",
            "price": 100,
            "discount": 0.66,
            "quantity": 0,
            "status": 0,
            "main_pic_url": "aaa.png",
            "reword_points": 21
        },
        {
            "product_id":2,
            "product_code": "kld0002",
            "product_name": "口红",
            "price": 100,
            "discount": 0.99,
            "quantity": 0,
            "status": 0,
            "main_pic_url": "bbb.png",
            "reword_points": 33
        }
]
}

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| product_name | varchar(100)  | 商品名称  |
| product_code | varchar(50)  |  商品代码  |
| price  | double  | 价格  |
| quantity  | int  |  库存数量  |
| status  | tinyint  |  状态（0下架、1上架、2待审核）  |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| product_id  | int  | Id  |
| product_code | varchar(50)  | 商品代码  |
| product_name | varchar(100)  |  商品名称  |
| price  | double  |  价格  |
| discount  | double  |  打折（0.01-0.99）  |
| quantity  | int  |  库存数量  |
| status  | tinyint  | 状态（0下架、1上架、2待审核）  |
| main_pic_url | varchar(100)  |  主图  |
| reword_points  | int  | 积分  |

## 2.3 添加产品----------------------------------------------------------------------------------------------------------

URL: /product/create  
Method：POST  

RequestBody:  
```json
{
        "product_code": "kld0003",
        "product_name": "口红(lv)",
        "price": 100,
        "discount": 0.99,
        "quantity": 0,
        "status": 0,
        "main_pic_url": "ddd.png",
        "reword_points": 33
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| product_code | varchar(50)  | 商品代码  |
| product_name | varchar(100)  |  商品名称  |
| price  | double  |  价格  |
| discount  | double  |  打折（0.01-0.99）  |
| quantity  | int  |  库存数量  |
| status  | tinyint  | 状态（0下架、1上架、2待审核）  |
| main_pic_url | varchar(100)  |  主图  |
| reword_points  | int  | 积分  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|    | Integer   | Id    |

## 2.3 查看单条产品----------------------------------------------------------------------------------------------------------

URL: /product/findById
Method：GET  

RequestBody:  
```json
{
        "product_id": 2,
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| product_id  | int  | Id  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| product_id  | int  | Id  |
| product_code | varchar(50)  | 商品代码  |
| product_name | varchar(100)  |  商品名称  |
| price  | double  |  价格  |
| discount  | double  |  打折（0.01-0.99）  |
| quantity  | int  |  库存数量  |
| status  | tinyint  | 状态（0下架、1上架、2待审核）  |
| main_pic_url | varchar(100)  |  主图  |
| reword_points  | int  | 积分  |


## 2.4 修改产品----------------------------------------------------------------------------------------------------------

URL: /product/update  
Method：POST  

RequestBody:  
```json
{
        "product_id": 2,
        "product_code": "kld0002",
        "product_name": "口红",
        "price": 100,
        "discount": 0.99,
        "quantity": 100,
        "status": 1,
        "main_pic_url": "lll.png",
        "reword_points": 33
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| product_id  | int  | Id  |
| product_code | varchar(50)  | 商品代码  |
| product_name | varchar(100)  |  商品名称  |
| price  | double  |  价格  |
| discount  | double  |  打折（0.01-0.99）  |
| quantity  | int  |  库存数量  |
| status  | tinyint  | 状态（0下架、1上架、2待审核）  |
| main_pic_url | varchar(100)  |  主图  |
| reword_points  | int  | 积分  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|   | int  | 返回结果  |

##########################################################################################################################################################
# Customer
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| customer_id  | int  | 主键 自增 | Id  |
| username | varchar(30)  | 非空 | 用户名  |
| real_name | varchar(20)  | 非空 | 真实姓名  |
| avatar_url  | varchar(100)  |  | 头像  |
| encrypted_password  | varchar(100)  | 非空 | 加密密码  |
| mobile  | varchar(20)  | 唯一索引  | 手机  |
| mobile_verified  | bit  | 默认false | 验证手机  |
| email | varchar(100)  | 唯一索引 | 邮箱  |
| email_verified  | bit  | 默认false | 验证邮箱  |
| status  | tinyint  | 非空 | 状态（0禁用、1启用、2不安全）  |
| create_time  | datetime  | 非空，索引  | 创建时间  |
| news_subscribed  | bit  | 非空，默认false | 订阅新闻  |
| reword_points | int  | 非空，默认0 | 积分  |
| default_address_id  | int  | 外键 | 默认地址  |
##########################################################################################################################################################
## 3.1 查询客户列表 ----------------------------------------------------------------------------------------------------------
//确少一个customer_group（客户群体，默认Default）
URL: /customer/search?username={username}&email={email}&status={status}  
Method：GET

ResponseBody:  
```json
[
    {
        "customer_id": 1,
        "username": "ZHANGSAN",
        "real_name": "张三",
        "avatar_url": "aaa.jpg",
        "encrypted_password": "sa78a6a5wq9a43a44fa6f1a3",
        "mobile": "133333333333",
        "mobile_verified": false,
        "email": "133333333333@qq.com",
        "email_verified": false,
        "status": 1,
        "create_time": "2020-02-02",
        "news_subscribed": false,
        "reword_points": 11111,
        "default_address_id": 3
    },
    {
        "customer_id": 1,
        "username": "lisi",
        "real_name": "李四",
        "avatar_url": "sss.jpg",
        "encrypted_password": "65s45a4f3a3f45",
        "mobile": "144444444444",
        "mobile_verified": false,
        "email": "144444444444@qq.com",
        "email_verified": false,
        "status": 1,
        "create_time": "2020-02-02",
        "news_subscribed": false,
        "reword_points": 11111,
        "default_address_id": 4
    }
]

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username | varchar(30)  | 用户名  |
| email | varchar(100)  |  邮箱  |
| status  | tinyint  | 状态（0禁用、1启用、2不安全）  |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |
| username | varchar(30) | 用户名  |
| real_name | varchar(20)  | 真实姓名  |
| avatar_url  | varchar(100)  | 头像  |
| encrypted_password  | varchar(100) | 加密密码  |
| mobile  | varchar(20)  | 手机  |
| mobile_verified  | bit | 验证手机  |
| email | varchar(100)   | 邮箱  |
| email_verified  | bit   | 验证邮箱  |
| status  | tinyint  | 状态（0禁用、1启用、2不安全）  |
| create_time  | datetime | 创建时间  |
| news_subscribed  | bit  | 订阅新闻  |
| reword_points | int  | 积分  |
| default_address_id  | int  | 默认地址  |

## 3.2 添加产品----------------------------------------------------------------------------------------------------------

URL: /product/create  
Method：POST  

RequestBody:  
```json
{
        "username": "xiaowu",
        "real_name": "小吴",
        "avatar_url": "www.jpg",
        "encrypted_password": "65s45a4f3a3f45asda5asf",
        "mobile": "15555555555",
        "mobile_verified": false,
        "email": "15555555555@qq.com",
        "email_verified": false,
        "status": 1,
        "create_time": "2020-02-02",
        "news_subscribed": false,
        "reword_points": 11111,
        "default_address_id": 5
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username | varchar(30) | 用户名  |
| real_name | varchar(20)  | 真实姓名  |
| avatar_url  | varchar(100)  | 头像  |
| encrypted_password  | varchar(100) | 加密密码  |
| mobile  | varchar(20)  | 手机  |
| mobile_verified  | bit | 验证手机  |
| email | varchar(100)   | 邮箱  |
| email_verified  | bit   | 验证邮箱  |
| status  | tinyint  | 状态（0禁用、1启用、2不安全）  |
| create_time  | datetime | 创建时间  |
| news_subscribed  | bit  | 订阅新闻  |
| reword_points | int  | 积分  |
| default_address_id  | int  | 默认地址  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|    | Integer   | Id    |

## 3.3 查看单条客户信息----------------------------------------------------------------------------------------------------------

URL: /customer/findById  
Method：GET  

RequestBody:  
```json
{
        "customer_id": 2,
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |
| username | varchar(30) | 用户名  |
| real_name | varchar(20)  | 真实姓名  |
| avatar_url  | varchar(100)  | 头像  |
| encrypted_password  | varchar(100) | 加密密码  |
| mobile  | varchar(20)  | 手机  |
| mobile_verified  | bit | 验证手机  |
| email | varchar(100)   | 邮箱  |
| email_verified  | bit   | 验证邮箱  |
| status  | tinyint  | 状态（0禁用、1启用、2不安全）  |
| create_time  | datetime | 创建时间  |
| news_subscribed  | bit  | 订阅新闻  |
| reword_points | int  | 积分  |
| default_address_id  | int  | 默认地址  |

## 3.4 修改客户信息----------------------------------------------------------------------------------------------------------

URL: /customer/update  
Method：POST  

RequestBody:  
```json
{
        "customer_id": 1,
        "username": "lisi",
        "real_name": "李四",
        "avatar_url": "sss.jpg",
        "encrypted_password": "s565ad45a45f6a46f54a56",
        "mobile": "144444444444",
        "mobile_verified": false,
        "email": "144444444444@qq.com",
        "email_verified": false,
        "status": 1,
        "create_time": "2020-02-02",
        "news_subscribed": false,
        "reword_points": 11111,
        "default_address_id": 2
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |
| username | varchar(30) | 用户名  |
| real_name | varchar(20)  | 真实姓名  |
| avatar_url  | varchar(100)  | 头像  |
| encrypted_password  | varchar(100) | 加密密码  |
| mobile  | varchar(20)  | 手机  |
| mobile_verified  | bit | 验证手机  |
| email | varchar(100)   | 邮箱  |
| email_verified  | bit   | 验证邮箱  |
| status  | tinyint  | 状态（0禁用、1启用、2不安全）  |
| create_time  | datetime | 创建时间  |
| news_subscribed  | bit  | 订阅新闻  |
| reword_points | int  | 积分  |
| default_address_id  | int  | 默认地址  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|   | int  | 返回结果  |
##########################################################################################################################################################
# Address
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| address_id  | int  | 主键 自增 | Id  |
| customer_id | int  | 非空，索引，外键 | 客户Id  |
| receiver_name  | varchar(20)  | 非空 | 收货人  |
| content  | varchar(200)  | 非空 | 地址内容  |
| tag  | varchar(20)  | 非空  | 标签  |
##########################################################################################################################################################
## 4.1 查询产品列表 ----------------------------------------------------------------------------------------------------------
URL: /address/search?customer_id={customerId}
Method：GET

ResponseBody:  
```json
[
    {
        "address_id":1,
        "customer_id": 3,
        "receiver_name": "张三",
        "content": "河北省邯郸市**********",
        "tag": "标签"
    },
    {
        "address_id":2,
        "customer_id": 3,
        "receiver_name": "张三",
        "content": "北京市滨河区**********",
        "tag": "标签"
    }
]

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| address_id  | int | Id  |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| address_id  | int | Id  |
| customer_id | int | 客户Id  |
| receiver_name  | varchar(20)  | 收货人  |
| content  | varchar(200) | 地址内容  |
| tag  | varchar(20) | 标签  |

## 4.2 添加产品----------------------------------------------------------------------------------------------------------

URL: /address/create  
Method：POST  

RequestBody:  
```json
{
        "address_id":3,
        "customer_id": 4,
        "receiver_name": "李四",
        "content": "北京市滨河区**********",
        "tag": "标签"
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id | int | 客户Id  |
| receiver_name  | varchar(20)  | 收货人  |
| content  | varchar(200) | 地址内容  |
| tag  | varchar(20) | 标签  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|    | Integer   | Id    |

## 4.3 查看单条产品----------------------------------------------------------------------------------------------------------

URL: /customer/findById  
Method：GET  

RequestBody:  
```json
{
        "customer_id": 2,
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |
| customer_id | int | 客户Id  |
| receiver_name  | varchar(20)  | 收货人  |
| content  | varchar(200) | 地址内容  |
| tag  | varchar(20) | 标签  |


## 4.4 修改产品----------------------------------------------------------------------------------------------------------

URL: /product/update  
Method：POST  

RequestBody:  
```json
{
         "address_id":3,
        "customer_id": 4,
        "receiver_name": "李四",
        "content": "上海市**********",
        "tag": "标签"
}

```
Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customer_id  | int  | Id  |
| customer_id | int | 客户Id  |
| receiver_name  | varchar(20)  | 收货人  |
| content  | varchar(200) | 地址内容  |
| tag  | varchar(20) | 标签  |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
|   | int  | 返回结果  |



##########################################################################################################################################################
# Order
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_id  | bigint  | 主键 自增 | Id  |
| customer_id | int  | 非空，索引，外键 | 客户Id  |
| status | tinyint  | 非空 | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成）  |
| total_price  | double  | 非空 | 总价  |
| reword_points  | int  |  | 积分  |
| create_time  | datetime  | 非空  | 创建时间  |
| update_time  | datetime  | 非空 | 更新时间 |
##########################################################################################################################################################
## 5.1 查询订单列表 ----------------------------------------------------------------------------------------------------------
URL: /order/search?orderId={orderId}&customerName={customerName}&status={status}&totalPrice={totalPrice}&createTime={createTime}
Method：GET

ResponseBody:
```json
[
    {
        "order_id":1,
        "customer_id": 3,
        "customer_name": "ZHANGSAN",
        "status": 0,
        "total_price": 666.00,
        "reword_points": 99,
        "create_time": "2020-01-06",
        "update_time": "2020-01-06"
    },
    {
        "order_id":2,
        "customer_id": 3,
        "customer_name": "ZHANGSAN",
        "status": 0,
        "total_price": 777.00,
        "reword_points": 88,
        "create_time": "2020-01-06",
        "update_time": "2020-01-06"
    }
]

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| order_id  | bigint  | Id  |
| customer_id | int  | 非空，索引，外键 | 客户Id  |
| status | tinyint | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成）  |
| total_price  | double  | 总价  |
| create_time  | datetime  | 创建时间  |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| order_id  | bigint  | Id  |
| customer_id | int  | 客户Id  |
| customer_name | varchar  | 客户姓名  |
| status | tinyint  | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成）  |
| total_price  | double | 总价  |
| reword_points  | int  | 积分 |
| create_time  | datetime  | 创建时间  |
| update_time  | datetime | 更新时间 |


##########################################################################################################################################################
# OrderHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_history_id  | bigint  | 主键 自增 | Id  |
| order_id | int  | 非空，索引，外键 | 订单Id  |
| time | datetime  | 非空 | 时间  |
| order_status  | tinyint  | 非空 | 订单状态  |
| comment  | varchar(300)  |  | 备注  |
| customer_notified  | bit  | 非空  | 是否通知客户  |
##########################################################################################################################################################

## 6.1 查询订单列表 ----------------------------------------------------------------------------------------------------------
URL: /orderHistory/search
Method：GET

ResponseBody:
```json
[
    {
        "order_history_id":1,
        "order_id": 1,
        "time": "2020-01--06",
        "order_status": 0,
        "comment": "麻烦快一点哦",
        "customer_notified": true,
    },
    {
        "order_history_id":2,
        "order_id": 1,
        "time": "2020-01--06",
        "order_status": 1,
        "comment": "麻烦快一点哦",
        "customer_notified": true,
    }
]

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| order_history_id  | bigint | Id  |
| order_id | int  | 订单Id  |
| time | datetime   | 时间  |
| order_status  | tinyint  | 订单状态  |
| comment  | varchar(300) | 备注  |
| customer_notified  | bit  | 是否通知客户  |

##########################################################################################################################################################
# Return
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| return_id  | int  | 主键 自增 | Id  |
| order_id | bigint  | 非空、索引、外键 | 订单Id  |
| order_time | datetime  |  | 订单时间  |
| customer_name  | varchar(20)  | 非空 | 退货人  |
| mobile  | varchar(20)  | 非空 | 手机  |
| email  | varchar(100)  | 非空  | 邮箱  |
| status  | tinyint  | 非空 | 状态（0等待取货、1正在处理、完成）  |
| return_action | tinyint  |  | 处理方式（0退货、1换货、2修理）  |
| product_code  | varchar(50)  | 非空 | 商品代码  |
| product_name  | varchar(100)  | 非空 | 商品名称  |
| quantity  | int  | 非空 | 商品数量  |
| reason  | tinyint  | 非空 | 退货原因  |
| opened  | bit  | 非空 | 是否开封  |
| comment  | varchar(300)  |  | 备注  |
| create_time  | datetime  | 非空，索引 | 创建时间  |
| update_time  | datetime  | 非空 | 修改时间  |
##########################################################################################################################################################

## 6.1 查询订单列表 ----------------------------------------------------------------------------------------------------------
URL: /return/search
Method：GET

ResponseBody:
```json
[
    {
        "return_id":1,
        "order_id":1,
        "order_time":"2020-01-06",
        "customer_name":"ZHANGSAN",
        "mobile":"133333333333",
        "email":"133333333333@qq.com",
        "status":0,
        "return_action":,
        "product_code":"kid0002",
        "product_name":"口红",
        "quantity":1,
        "reason":0,
        "opened":0,
        "comment":"zheshizhangsanmaidekouhong",
        "create_time":"2020-01--06",
        "update_time":"2020-01--06",
    },
]

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| return_id  | int   | Id  |
| order_id | bigint   | 订单Id  |
| order_time | datetime   | 订单时间  |
| customer_name  | varchar(20)  | 退货人  |
| mobile  | varchar(20)  | 手机  |
| email  | varchar(100)  | 邮箱  |
| status  | tinyint   | 状态（0等待取货、1正在处理、完成）  |
| return_action | tinyint  | 处理方式（0退货、1换货、2修理）  |
| product_code  | varchar(50)  | 商品代码  |
| product_name  | varchar(100)   | 商品名称  |
| quantity  | int  | 商品数量  |
| reason  | tinyint  | 退货原因  |
| opened  | bit  | 是否开封  |
| comment  | varchar(300) | 备注  |
| create_time  | datetime  | 创建时间  |
| update_time  | datetime  | 修改时间  |


##########################################################################################################################################################
# ReturnHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| return_history_id  | int  | 主键 自增 | Id  |
| return_id | int  | 非空，索引，外键 | 退货Id  |
| time | datetime  | 非空 | 时间  |
| return_status  | tinyint  | 非空 | 退货状态  |
| comment  | varchar(300)  |  | 备注  |
| customer_notified  | bit  | 非空  | 是否通知客户  |
##########################################################################################################################################################

## 6.1 查询订单列表 ----------------------------------------------------------------------------------------------------------
URL: /returnHistory/search
Method：GET

ResponseBody:
```json
[
    {
        "return_history_id":1,
        "return_id": 1,
        "time": "2020-01--06",
        "return_status": 0,
        "comment": "麻烦快一点哦",
        "customer_notified": true,
    },
    {
       "return_history_id":2,
        "return_id": 1,
        "time": "2020-01--06",
        "return_status": 0,
        "comment": "麻烦快一点哦",
        "customer_notified": true,
    }
]

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |

Response Field  

# Product
| 字段  | 类型 |  说明 |
| :--------------: | :--------:| :------: |
| return_history_id  | int  | Id  |
| return_id | int   | 退货Id  |
| time | datetime   | 时间  |
| return_status  | tinyint  | 退货状态  |
| comment  | varchar(300)   | 备注  |
| customer_notified  | bit  | 是否通知客户  |
