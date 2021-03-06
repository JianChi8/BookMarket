let axios = require("axios");
let fs = require("fs");
let path = require("path");
let bodyParser = require("body-parser");
let config = require("./config");
let cookieParser = require("cookie-parser");
let ossClient = require("./oss");
let multer = require("./upload");
let AlipaySdk = require("alipay-sdk").default;

/**
 * 项目后台API axios 实例
 */
let axiosInstance = axios.create({
  baseURL:
    config.apiHost + ":" + config.apiPort + "/" + config.apiModuleName + "/",
  timeout: 3000,
});

/**
 * alipay 支付 sdk
 */
let alipaySdk = new AlipaySdk({
  appId: "2016102400752515",
  privateKey: fs.readFileSync(
    path.join(config.project_path, "pem", "private_key.pem"),
    "ascii"
  ),
  // alipayPublicKey: 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgvqFRD9lXTENYk0Dl/fcT+jnqBUUxpP3QieGfdA19Q8pGhscYQDPPAgHAgcXIJzKgvRhJpwFy5c3e+4c3BOQXS4BUaVKUosXAo4HqvEt0M+SivJn+YUTB6Ua4VUm92PEDHJcIvydycHglTk4kwjECXnzwpxfbclhLFqsPI20m/yZEO8lv7yCh8qgCoFC/fy+kv51OJeW0fjX4oi0qqUrRtt9OJp4tyrWZTkRbkswafUH8PcQRTxLOnSMezkzJlssqQjeK+gAKskusAKF3JISXWauP3CMFgMOTscHWm8lq8S1JCut6VJOqwuOl3gfwDg9GBZ/I4i0kNBQbwc4bnQhWQIDAQAB',
  alipayPublicKey: fs.readFileSync(
    path.join(config.project_path, "pem", "public_key.pem"),
    "ascii"
  ),

  gateway: "https://openapi.alipaydev.com/gateway.do",
  charset: "utf-8",
  version: "1.0",
  signType: "RSA2",
});

/**
 * 极速API axios 实例
 */
let jiSuApiAxiosInstance = axios.create({
  baseURL: config.jiSuApiBaseUrl,
  timeout: 1000,
});

/**
 * json 解析
 */
let jsonParser = bodyParser.json();

/**
 * url json解析
 */
let urlencoded = bodyParser.urlencoded({ extended: false });

/**
 * cookie 解析
 */
cookieParser = cookieParser();

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * 例子：
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).Format("yyyy-M-d h:m:s.S")   *    *    * ==> 2006-7-2 8:9:4.18
 * 调用：
 * var time1 = new Date().Format("yyyy-MM-dd");
 * var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss");
 */
Date.prototype.Format = function (fmt) {
  var o = {
    "M+": this.getMonth() + 1, //月份
    "d+": this.getDate(), //日
    "h+": this.getHours(), //小时
    "m+": this.getMinutes(), //分
    "s+": this.getSeconds(), //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    S: this.getMilliseconds(), //毫秒
  };
  if (/(y+)/.test(fmt))
    fmt = fmt.replace(
      RegExp.$1,
      (this.getFullYear() + "").substr(4 - RegExp.$1.length)
    );
  for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt))
      fmt = fmt.replace(
        RegExp.$1,
        RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length)
      );
  return fmt;
};

// 暴露对象
module.exports = {
  axios: axiosInstance,
  jiSuAxios: jiSuApiAxiosInstance,
  cookieParser: cookieParser,
  jsonParser: jsonParser,
  urlencoded: urlencoded,
  ossClient: ossClient,
  multer: multer,
  alipaySdk: alipaySdk,
};
