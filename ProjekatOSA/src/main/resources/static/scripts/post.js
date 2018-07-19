$(document).ready(function(){
	
	var postId = getQueryVariable()
	var URLPost = URLGetPost(postId);
	var URlComments = URLGetPostComments(postId);
	var URLTags = URLGetPostTags(postId);
	


	makeCall(URLPost, "GET").then(function(respJson){
	
	 let naslov = respJson.title;
	 let opis = respJson.description;
	 let datum = respJson.date;
	 let broj_lajkova = respJson.likes;
	 let broj_dislajkova = respJson.dislikes;
	 fillPost(naslov, opis, datum, broj_lajkova, broj_dislajkova);
	  
	}, function(reason){
	 showError();
	});

	makeCall(URlComments, "GET").then(function(respJson){
	 let brojKomentara = respJson.length;
	 fillBrojKomentara(brojKomentara);
	 
	 $.each(respJson, function(index, value) {
		 fillComments(value);
	 })
	 }, function(reason){
		 showError();
	});
	
	
	makeCall(URLTags, "GET").then(function(respJson){
		 fillTags(respJson);
	}, function(reason){
	 showError();
	});
	
	
	
	
	
	

});

function fillPost(naslov, opis, datum, broj_lajkova, broj_dislajkova){
	$("#naslovPosta").html(naslov);
	$("#opisPosta").html(opis);
	$("#datumPostavljanja").append(datum);
  	$("#brojDislajkova").html(broj_dislajkova);
  	$("#brojLajkova").html(broj_lajkova);
}

function fillBrojKomentara(brojKomentara){
	$("#brojKomentara").html(brojKomentara);
}

function fillComments(comment){
	$("#komentari").append(
	'<div class="card-body">'+
	    '<small class="text-muted">'+ comment.date +'</small>'+
	    '<h4>'+ comment.title +'</h4>'+
	    '<p>'+ comment.description +'</p>'+
	    '<a class="btn pull-right btn-danger btn-lg" href="#">'+
	      '<i class="fa fa-thumbs-down"> </i> ' + comment.dislikes + ' </a>'+
	    '<a class="btn pull-right btn-success btn-lg" href="#">'+
	      '<i class="fa fa-thumbs-up"> </i> '+ comment.likes +' </a>'+
    '</div>'
    );


}

function fillTags(tags){
	$.each(tags, function(index, value){
		let tag = '<a class="btn pull-left btn-lg btn-info">' + value.name + '</a>';
		$("#postDetails").append(tag);
	})
	
}

function likePost(){
	
}

function dislikePost(){
	
}


