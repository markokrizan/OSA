var liked = 0;
var disliked = 0;


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
	
	
	//like/dislike
	
	$("#dislajkujBtn").click(function() {
		dislikePost();
	});
	
	$("#lajkujBtn").click(function() {
		likePost();
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

function fillPostBrojLajkova(brojLajkova){
	$("#brojLajkova").html(brojLajkova);
}

function fillPostBrojDislajkova(brojDislajkova){
	$("#brojDislajkova").html(brojDislajkova);
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
	if(liked === 0){
		let url = URLLikePost(getQueryVariable());
		makeCallNoJSON(url, "PUT").then(function(respJson){
			let brojLajkovaUpdate = parseInt($("#brojLajkova").text()) + 1;
			fillPostBrojLajkova(brojLajkovaUpdate);
			liked += 1;
			//$("#lajkujBtn").addClass("disabled");
		}, function(reason){
			showError();
		});
	}else if(liked === 1){
		let url = URLUnlikePost(getQueryVariable());
		makeCallNoJSON(url, "PUT").then(function(respJson){
			let brojLajkovaUpdate = parseInt($("#brojLajkova").text()) - 1;
			fillPostBrojLajkova(brojLajkovaUpdate);
			liked -= 1;
		}, function(reason){
			showError();
		});
	}
	
	
	
	
}

function dislikePost(){
	if(disliked === 0){
		let url = URLDislikePost(getQueryVariable());
		makeCallNoJSON(url, "PUT").then(function(respJson){
			let brojDislajkovaUpdate = parseInt($("#brojDislajkova").text()) + 1;
			fillPostBrojDislajkova(brojDislajkovaUpdate);
			disliked += 1;
			//$("#lajkujBtn").addClass("disabled");
		}, function(reason){
			showError();
		});
	}else if(disliked === 1){
		let url = URLUndislikePost(getQueryVariable());
		makeCallNoJSON(url, "PUT").then(function(respJson){
			let brojDislajkovaUpdate = parseInt($("#brojDislajkova").text()) - 1;
			fillPostBrojDislajkova(brojDislajkovaUpdate);
			disliked -= 1;
		}, function(reason){
			showError();
		});
	}
}

function likeComment(){
	
}

function dislikeComment(){
	
}


