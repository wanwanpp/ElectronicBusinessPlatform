/*����֤��Ҫ���� formcheck.js
2012.05.03*/
//��֤һ�������valueֵ�Ƿ���Ч
function validate_value(target){
   if (target.value==null || target.value=="")
   {
	   return false;  //���ؼ�ֵ
   }else{
       return true;   //������ֵ
   }
}
//��֤�����ַ����Ƿ����
function validate_string_equal(str1,str2){
   if (str1==str2)
   {
       return true;   //������ֵ
   }else{
       return false;  //���ؼ�ֵ
   }
}
//��֤�ַ�ch�Ƿ��������ַ�
function validate_character(ch){
   if (ch>="0" && ch<="9")
   {
       return false;  //���ؼ�ֵ
   }else{
       return true;   //������ֵ
   }
}
//���������ַ��������Ƿ�����[min,max]֮��
function validate_string_length(str,min,max){
   if (str.length>=min  &&  str.length<=max)
   {
	   return true;   //������ֵ
   }else{
       return false;   //���ؼ�ֵ
   }
}
//����ʼ���ַ�Ƿ���ȷ,��ʽΪ��**@*.*������@��.֮��������һ���ַ�
function validate_email(email){
   var posa=email.indexOf("@");
   var posdot=email.lastIndexOf(".");
   if (posa!=-1 && posdot!=-1 && posdot-posa>2)
   {
	   return true;   //������ֵ
   }else{
       return false;   //������ֵ
   }
}
//�������������в���
