$(document).ready(function(){
	
	makeCall(URLGetPosts, "GET").then(function(respJson){
	 $.each(respJson, function (index, post) {
           showPosts(post);
     })
	}, function(reason){
	 showError();
	});

	
	


});



function showPosts(post){
	var x = '<div class="py-5">'+
		    '<div class="container">'+
		      '<div class="row">'+
		        '<div class="col-md-5 order-2 order-md-1">'+
		          '<img class="img-fluid d-block" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg"> </div>'+
		        '<div class="col-md-7 order-1 order-md-2">'+
		          '<h3>'+ post.title +'</h3>'+
		          '<p class="my-3 w-100 h-25">'+ post.description +'</p>'+
		          '<div class="row">'+
		            '<div class="col-md-12">'+
		              '<a class="btn mx-auto pull-right btn-info" href="http://localhost:8080/post/'+ post.id +'">Detalji</a>'+
		            '</div>'+
		          '</div>'+
		        '</div>'+
		      '</div>'+
		    '</div>'+
		  '</div>';
	$('body').append(x);
}

