var ws;

function connect() {
	ws = new WebSocket('ws://localhost:8080/data');
	ws.onmessage = function(data) {
		processMessage(data.data);
	}
}

function disconnect() {
	if (ws != null) {
		ws.close();
	}
}

function sendData() {
	var data = JSON.stringify({
		'url' : $("#url").val(),
		'maxThreadNum' : $("#maxThreadNum").val(),
		'searchText' : $("#searchText").val(),
		'maxUrlNum' : $("#maxUrlNum").val()
	})
	ws.send(data);
}

function processMessage(message) {
	var data = JSON.parse(message);
	if (!data.errorMessage || 0 === data.errorMessage.length) {
		$("#response").append("<tr><td> " + data.id + "</td><td width='120%'> " + data.url + "</td>" +
			"<td> " + data.status + "</td><td> " + data.processed + "</td></tr>");
	} else {
		$("#response").append("<tr><td> " + "" + "</td><td width='120%'> " + data.errorMessage + "</td>" +
			"<td> " + "" + "</td><td> " + "" + "</td></tr>");
	}
}

$(function() {
	$("form").on('submit', function(e) {
		console.log(e)
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#send").click(function() {
		sendData();
	});
});
