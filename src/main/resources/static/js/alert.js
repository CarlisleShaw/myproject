var removeAllAlerts = function() {

	$(document).find('.alert').remove();
};

var addAlert = function(position,color,str){

	position.prepend(`
		<div class="alert alert-` + color + ` role="alert">
			` + str + `
		</div>
	`);
};