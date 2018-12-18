function checkUser(){
	var userName = $("#userName").val();
	var flag=1;
	 $.ajax({
			url : "/ssmdemo/user/queryByUser.do",
			type : "post",
			data : {
				"userName" : userName
			},
			dataType : "json",
			success : function(data) {
				if (data != null) {
					flag=1;
					 var us=document.getElementById('us');
					 us.innerHTML='用户名  '+userName+'  已存在';
					  str1.style.backgroundPosition='5px -5px';
				        str1.style.display='inline-block';
				        us.style.color='red';us.style.font.size='12px';
					$("#userName").val('');
				} else if (data == null && userName != '') {
					$("#userSpan").text("");	
				}
			}

		});
	 if(flag==1){
		 var user = document.logForm.userName.value;
		    var us=document.getElementById('us');
		    var str1=document.getElementById('str1');
		    if( user.length<4){
		        us.innerHTML='用户名不得少于4个字符';
		        str1.style.backgroundPosition='3px -3px';
		        str1.style.display='inline-block';
		        us.style.color='red';return false;
		    }else if(user.length >20){
		        us.innerHTML='用户名不得多于20个字符';
		        str1.style.backgroundPosition='3px -3px';
		        str1.style.display='inline-block';
		        us.style.color='red';return false;
		    }else if(!isNaN(user)){
		        us.innerHTML='用户名不能全为数字！';
		        str1.style.backgroundPosition='3px -3px';
		        str1.style.display='inline-block';
		        us.style.color='red';return false;
		    }else {
		        us.innerHTML='输入正确！';
		        str1.style.backgroundPosition='3px 30px';
		        str1.style.display='inline-block';
		        us.style.color="green";
		        
		        return true;
		    }
	 }

}




function checkPass(){
	
    var pwd = document.logForm.userPwd.value;
    var pa = document.getElementById('pa');
    var str2 = document.getElementById('str2');
    if(pwd.length <6){
        pa.innerHTML='密码不得小于6位！';
        str2.style.backgroundPosition='3px -3px';
        str2.style.display='inline-block';
        pa.style.color='red';  $("#userPwd").val('');
        return false;
    }else if(pwd.length >20){
        str2.style.backgroundPosition='3px -3px';
        str2.style.display='inline-block';
        pa.innerHTML='密码不得大于20位！';
        pa.style.color='red';  $("#userPwd").val('');
        return false;
    }
    else if(!isNaN(pwd)){
        str2.style.backgroundPosition='3px -3px';
        str2.style.display='inline-block';
        pa.innerHTML='密码太弱：试试数字、字母混合！';
        pa.style.color='red';  $("#userPwd").val('');
        return false;
    }else{
        str2.style.backgroundPosition='3px 30px';
        str2.style.display='inline-block';
        pa.innerHTML='输入正确！';
        pa.style.color="green";  
        return true;
    }
}
function checkRepass(){
    var pwd = document.logForm.userPwd.value;
    var repa = document.getElementById('repa');
    var repwd = document.logForm.repwd.value;
    var str3 = document.getElementById('str3');
    if(repwd != pwd){
        str3.style.backgroundPosition='3px -3px';
        str3.style.display='inline-block';
        repa.innerHTML='两次密码不一致！';
        repa.style.color='red';$("#repa1").val('');
        return false;
    }else{
        str3.style.backgroundPosition='3px 30px';
        str3.style.display='inline-block';
        repa.innerHTML='输入正确！';
        repa.style.color="green";
        return true;
    }
}
function checkPhone(){
    var phone =document.logForm.userTel.value;
    var tel = document.getElementById('tel');
    var str4=document.getElementById('str4');
    if(phone.match(/^1[3|4|5|7|8]\d{9}$/)==null){
        str4.style.backgroundPosition='3px -3px';
        str4.style.display='inline-block';
        tel.innerHTML='手机号码格式错误！';
        tel.style.color='red';$("#userTel").val('');
        return false;
    }else{
        str4.style.backgroundPosition='3px 30px';
        str4.style.display='inline-block';
        tel.innerHTML='输入正确！';
        tel.style.color='green';
        return true;
    }
}
function checkForm(){
	
    return checkUser() && checkPass() && checkRepass() && checkPhone();
}




//自动获取文件名
function checkfileName() {
	var file = document.getElementById("file").files;
    var fileSize = file[0].size;
   if(fileSize>104857600){
	   alert("文件大小不能超过100M哦");
	   $("#file").val('');

   }else{
	   var file = $("#file").val();
		var pos = file.lastIndexOf(".");
		var pos1 = file.lastIndexOf("\\");
		var tureFileName = file.substring(pos1+1,pos);
		document.getElementById('tureFileName').value=tureFileName;
		return false;
   }	
}




//删除资料
function deletefile(fileuserName,id,userName,isAdmin) {
	
	if((userName == fileuserName)||(isAdmin==1)){
	if(confirm('确定要删除该资料吗?')) {
		$.post("/ssmdemo/files/delete.do",{"id":id},function(data){
			alert("恭喜你删除资料成功！");
			window.location.reload();
		});
	}
	}else {
		alert("对不起,您没有该资料删除权限！");
	}
}


//删除用户
function deleteUser(id,isAdmin) {
	if(isAdmin==1){
	if(confirm('确定要删除该用户吗?')) {
		$.post("/ssmdemo/files/deleteUser.do",{"id":id},function(data){
			alert("恭喜你删除用户成功！");
			window.location.reload();
		});
	}
	}
}

//
