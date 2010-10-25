dojo.addOnLoad(function(){
	console.log("pcshop.js:dojo.addOnLoad(): ");
	
	getAvailableProducts(availableTypesCallBack);

	
});

function availableTypesCallBack(types){

	console.log("pcshop.js:rdfClassesCallBack(): ");
	
	var availableProductsDiv = dojo.create("div", { class: "available-products" }, "pending-concepts");

}
