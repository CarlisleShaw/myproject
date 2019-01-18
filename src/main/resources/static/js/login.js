document.write("<script type='text/javascript' src='/js/alert.js'></script>");


function testValid(id,min,max){
	if($('#'+id)[0].value.length > max | $('#'+id)[0].value.length < min) {
		$('#'+id)[0].className = "form-control is-invalid";
		return true;
	}
	else {
		$('#'+id)[0].className = "form-control is-valid";
		return false;
	}
}

$(document).keyup(function() {

	if (!(testValid("Username",1,18)) & !(testValid("Password",8,20,testValid))) {
		$('#login')[0].disabled = false;
	}
	else {
		$('#login')[0].disabled = true;
	}

	if (!(testValid("UsernameSignup",1,18)) & !(testValid("PasswordSignup",8,20))) {
		$('#signup')[0].disabled = false;
	}
	else {
		$('#signup')[0].disabled = true;
	}

});

var deleteAllCookies = function() {

    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
};

var loginAjaxCall = function(){

	var alert = $('div.bg');
	var person = {
	    username:$("#Username").val(),
	    password:$("#Password").val()
	};
	deleteAllCookies();
	removeAllAlerts();
	addAlert(alert,"primary","loging...");

	var getUserAjax = {
		type: "post",
		url: "/login",
		cache: false,    
		data: JSON.stringify(person),
		// dataType: 'json',// satisfied response type
		contentType: "application/json",// request type
		success: function(response){
			console.log(response);
			// var obj = JSON.parse(response);
			// console.log(obj);
			var obj = response;
			if(response.constructor.name == "String") obj = JSON.parse(response);
			if(obj.result == "success") {
				removeAllAlerts();
			addAlert(alert,"success","login success!");
			window.location.href='/manage';
			}
			else {
				removeAllAlerts();
				var error = "username or password wrong!";
				addAlert(alert,"warning",error);
			}
		},
		error: function(){
			removeAllAlerts();
			addAlert(alert,"danger","login failed, please check your network!");
		}
	};
	$.ajax(getUserAjax);
};

var signupAjaxCall = function(){

	var alert = $('#alert_here');
	var person = {
	    username:$("#UsernameSignup").val(),
	    password:$("#PasswordSignup").val()
	};
	deleteAllCookies();
	removeAllAlerts();
	addAlert(alert,"primary","loging...");

	var getUserAjax = {
		type: "post",
		url: "/signup",
		cache: false,    
		data: JSON.stringify(person),
		// dataType: 'json',// satisfied response type
		contentType: "application/json",// request type
		success: function(response){
			console.log(response);
			// var obj = JSON.parse(response);
			// console.log(obj);
			var obj = response;
			if(response.constructor.name == "String") obj = JSON.parse(response);
			if(obj.result == "success") {
				removeAllAlerts();
				addAlert(alert,"success","sign up success!");
				window.location.href='/manage';
			}
			else {
				removeAllAlerts();
				var error = "username exist!";
				addAlert(alert,"warning",error);
			}
		},
		error: function(){
			removeAllAlerts();
			addAlert(alert,"danger","sign up failed, please check your network!");
		}
	};
	$.ajax(getUserAjax);
};
