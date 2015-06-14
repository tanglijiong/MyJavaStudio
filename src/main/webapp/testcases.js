//测试用例列表：

/*
 * 按模块编号：
 * 0、用Map接收不同参数的方法
 * 1、本地缓存测试
 * 
 */
var testCases = [
	{	title : "0.1 用Map接收前端提交的Form Data或Query String",
		url : "/mapParameter/map",
		requestBody : "authCode=123456&accountName=15888888888&password=888962&password=666566"
	},
	{	title : "0.2 用MultiValueMap接收前端提交的Form Data或Query String",
		url : "/mapParameter/multiValueMap",
		requestBody : "authCode=123456&phone=15888888888&verifyType=0&verifyType=1"
	},
	{	title : "0.3 用Map接收前端提交的json格式的Request Payload",
		url : "/mapParameter/jsonParams",
		requestBody : '{"authCode":"123456","phone":"15888888888","code":0,"code":1}',
		contentType : "application/json;charset=utf-8"
	},
	{	title : "1.1 测试Guava缓存AreaIdToArea",
		url : "/cache/test/getArea",
		requestBody : "areaId=4401"
	}
];
