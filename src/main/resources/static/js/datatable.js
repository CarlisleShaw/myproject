var recv;
var jqxhr = $.ajax({
      type: "GET",
      url: "/employees",
      dataType: "html"
}).done(function (data) {
	$('#employeesTable').text($('#employeesTable').val() + '\n' + data);
	recv = data;
}).fail(function (xhr, status) {
    ajaxLog('失败: ' + xhr.status + ', 原因: ' + status);
}).always(function () {
    $('#employeesTable').text($('#employeesTable').val() + '\n' + 'always here');
    var ul = $('body');
ul.prepend('<h2>Insert ' + recv + '</h2>');
});

