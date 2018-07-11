$(document).ready(function(){
	console.log(getQueryVariable());
});

function getQueryVariable()
{
       var query = window.location.search.substring(1);
       var vars = query.split("/");
       return vars[vars.length-1];
}