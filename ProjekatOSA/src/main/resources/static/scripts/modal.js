//Modals

$(document).ready(function(){
	//otvaranja
	$("#homeBtn").click(function() {
		window.location.href = "http://localhost:8080";
	});
		
	//loginModal
	$("#loginBtn").click(function() {
		$('#loginModal').modal('show');
	});
	
	//registerModal
	$("#registerBtn").click(function() {
		$('#registerModal').modal('show');
	});
	
	//modal post
	$("#postBtn").click(function() {
		$('#createPostModal').modal('show');
	});
	
	//modal komentara
	$("#komentarisiBtn").click(function() {
		$('#komentarisiModal').modal('show');
	});
	
	

	
	//Submits:
	
	//Create post
	$("#btnCreatePost").click(function() {
		var title = $("#postTitleInput").val();
		var desc = $("#postDescriptionInput").val();
		var img = $("#postTextInput").val();

		if(title === "" || desc ==="" || img === ""){
			$('#nekompletniPodaciModal').modal('show');
		}else{
			gatherAndSendPost(title, desc, img);
		}
		
		
	});
	
	//Create comment
	$("#btnKomentarisi").click(function() {
		var title = $("#commentTitleInput").val();
		var desc = $("#commentDescriptionInput").val();
		
		if(title === "" || desc ===""){
			$('#nekompletniPodaciModal').modal('show');
		}else{
			gatherAndSendComment(title, desc);
		}
		
	});
	
});



function gatherAndSendPost(title, desc, img){
	
	navigator.geolocation.getCurrentPosition(function(location) {
		let date = new Date();
		let likes = 0;
		let dislikes = 0;
		let longitude = location.coords.longitude;
		let latitude = location.coords.latitude;
		//kasnije iz neke sesije
		let user = 1;

		let post = sendablePost(title, desc, img, date, likes, dislikes, longitude, latitude, user);
		
		sendData(URLCreatePost, "POST", post).then(function(respJson){
		 //console.log(respJson)
		 $('#createPostModal').modal('hide');
		 showPosts(respJson);
		}, function(reason){
		 showError("Greska", reason.status);
		});
		
	}); 
	
}

function gatherAndSendComment(title, desc){
	
	let date = new Date();
	let likes = 0;
	let dislikes = 0;
	let post = getQueryVariable();
	//session
	let user = 1;
	
	
	let comment = sendableComment(title, desc, date, likes, dislikes, post, user);
	
	
	
	sendData(URLCreateComment, "POST", comment).then(function(respJson){
		 //console.log(respJson)
		 $('#komentarisiModal').modal('hide');
		 fillComments(respJson);
		 let brojKomentaraUpdate = parseInt($("#brojKomentara").text()) + 1;
		 fillBrojKomentara(brojKomentaraUpdate);
		}, function(reason){
		 showError("Greska", reason.status);
	});
	
}







