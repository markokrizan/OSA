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
	
	
	
	
	
	//Create post
	$("#btnCreatePost").click(function() {
		gatherAndSendPost();
	});
	
});



function gatherAndSendPost(){
	navigator.geolocation.getCurrentPosition(function(location) {
		var title = $("#postTitleInput").val();
		var desc = $("#postDescriptionInput").val();
		var img = $("#postTextInput").val();
		var date = new Date();
		var likes = 0;
		var dislikes = 0;
		var longitude = location.coords.longitude;
		var latitude = location.coords.latitude;
		var user = 1;

		var post = sendablePost(title, desc, img, date, likes, dislikes, longitude, latitude, user);

		sendData(URLCreatePost, "POST", post).then(function(respJson){
		 console.log(respJson)
		}, function(reason){
		 showError("Greska", reason.status);
		});
		
	}); 
}




/*
//position with promise:
var getPosition = function (options) {
  return new Promise(function (resolve, reject) {
    navigator.geolocation.getCurrentPosition(resolve, reject, options);
  });
}

getPosition()
  .then((position) => {
    //console.log(position);
    return position;
  })
  .catch((err) => {
    console.error(err.message);
  });

*/



