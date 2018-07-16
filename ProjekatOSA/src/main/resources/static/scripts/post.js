$(document).ready(function(){
	
	var URLPost = URLGetPost(getQueryVariable());
	var URlComments = URLGetPostComments(getQueryVariable());
	


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
		  let naslov = value.title;
		  let tekst = value.description;
		  let datum = value.date;
		  let dislajkova = value.dislikes;
		  let lajkova = value.likes;
		  fillComments(naslov, tekst, datum, dislajkova, lajkova);
	});
	 
	 
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

function fillComments(naslov, tekst, datum, dislajkova, lajkova){
	$("#komentari").append(
	'<div class="card-body">'+
	    '<small class="text-muted">'+ datum +'</small>'+
	    '<h4>'+ naslov +'</h4>'+
	    '<p>'+ tekst +'</p>'+
	    '<a class="btn pull-right btn-danger btn-lg" href="#">'+
	      '<i class="fa fa-thumbs-down"> </i> ' + dislajkova + ' </a>'+
	    '<a class="btn pull-right btn-success btn-lg" href="#">'+
	      '<i class="fa fa-thumbs-up"> </i> '+ lajkova +' </a>'+
    '</div>'
    );


}


