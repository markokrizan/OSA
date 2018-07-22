

function sortirajDatum(kolekcija, kriterijum){
	kolekcija.sort(function(a, b){
		if(kriterijum === "silazno") {return new Date(b.date) > new Date(a.date);}
		if(kriterijum === "uzlazno") {return new Date(a.date) > new Date(b.date);}
	});	
	
}
/*
 * when passing as param
 * 
 * myObj.propName
	// is equivalent to
	myObj["propName"]
 * 
 * 
 */

function sortirajNumericko(kolekcija, kriterijum, obelezje){

	kolekcija.sort(function(a, b){
		if(kriterijum === "silazno") {return b[obelezje] - a[obelezje];}
		if(kriterijum === "uzlazno") {return a[obelezje] - b[obelezje];}
	});
	
}

function provera(kolekcija, obelezje){
	$.each(kolekcija, function(index, value){
		console.log(value[obelezje]);
	})
}