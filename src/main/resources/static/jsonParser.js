d3.json("risultati.json", function(data){
	function parse(data){


		var wrapper = document.getElementById("wrapper");

//		Get json-data by javascript-object

		var data2 = data
//		or from a string by JSON.parse(str) method
		
		try {
			var data2 = JSON.parse(data);
		} catch (e) {}

//		Create json-tree
		var tree = jsonTree.create(data2, wrapper);

//		Expand all (or selected) child nodes of root (optional)
		tree.expand(function(node) {
			return node.childNodes.length < 2 || node.label === 'status';
		}) 
	





};
parse(data);



});



















