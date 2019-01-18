document.write("<script type='text/javascript' src='/js/alert.js'></script>");


var deleteAllCookies = function() {
    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
};

var alert = $('body');

var logout = function() {
	deleteAllCookies();
	window.location.href='/login';
};

function create() {

	window.location.href='/create/form';
}


var getFormAjax = {
	type: "GET",
	url: "/getForm",
	cache: false,
	// data: JSON.stringify(person),
	// dataType: 'json',// satisfied response type
	contentType: "application/json",// request type
	success: function(response){
		console.log(response);
		// var obj = JSON.parse(response);
		// console.log(obj);
		var listLength = response.length;
		if(listLength <= 0) {
			addAlert(alert,"warning","您尚未创建过问卷");
		}
		else {
			for(i = 0; i < listLength; i++) {
				$("#form-body").append(`
				<tr>
					<th scope="row">` + (i + 1) + `</th>
					<td><a href='/form/` + response[i].id + `' class="text-primary">` + response[i].formName + `</a></td>
					<td>` + response[i].id + `</td>
					<td>` + response[i].creationTime + `</td>
					<td><button type="button" class="btn btn-outline-success">发送问卷</button></td>
					<td><button type="button" class="btn btn-outline-danger">删除</button></td>
				</tr>
				`)
			}
			
		}
	},
	error: function(){
		
	}
};

$.ajax(getFormAjax);

