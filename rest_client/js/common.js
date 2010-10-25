
var serverUri = "http://localhost:8182/pcshop"
var seconds = 300000000;

function getAvailableProducts(handler){
	
	dojo.xhrGet({
	    url 		: serverUri + "/products",
	    handleAs		: "json-comment-optional",
	    timeout		: seconds,
	    load		: function(data){  handler(data);   },
	    error 		: function(err) {  	    }
	});
}
