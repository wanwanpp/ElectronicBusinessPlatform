/*表单验证主要函数 formcheck.js
2012.05.03*/
//验证一个对象的value值是否有效
function validate_value(target){
   if (target.value==null || target.value=="")
   {
	   return false;  //返回假值
   }else{
       return true;   //返回真值
   }
}
//验证两个字符串是否相等
function validate_string_equal(str1,str2){
   if (str1==str2)
   {
       return true;   //返回真值
   }else{
       return false;  //返回假值
   }
}
//验证字符ch是否不是数字字符
function validate_character(ch){
   if (ch>="0" && ch<="9")
   {
       return false;  //返回假值
   }else{
       return true;   //返回真值
   }
}
//检查给定的字符串长度是否区间[min,max]之间
function validate_string_length(str,min,max){
   if (str.length>=min  &&  str.length<=max)
   {
	   return true;   //返回真值
   }else{
       return false;   //返回假值
   }
}
//检查邮件地址是否正确,形式为“**@*.*，其中@与.之间至少有一个字符
function validate_email(email){
   var posa=email.indexOf("@");
   var posdot=email.lastIndexOf(".");
   if (posa!=-1 && posdot!=-1 && posdot-posa>2)
   {
	   return true;   //返回真值
   }else{
       return false;   //返回真值
   }
}
//其它功能请自行补充
