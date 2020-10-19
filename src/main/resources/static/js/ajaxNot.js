$(document).ready(function(){

	document.getElementById("ekleButon").addEventListener("click", notEkleme);
	
	document.querySelector("ul").addEventListener("click", function(arg){
		if(arg.target.tagName === 'LI')
		{
			var id = arg.target.lastChild.attributes.id.value;
			id = id.substring(4, id.length);
			
			var reqDurum = $.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/api/v1/not/durum",
				data : id
			});
			
			reqDurum.done(function( msg ){
				notEkranaListele();
			});
			
			reqDurum.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
				  console.log(jqXHR);
				  console.log(textStatus);
			});
			
			//arg.target.classList.toggle('checked');
		}
		else if(arg.target.tagName === 'SPAN')
		{
			var id = arg.target.attributes.id.value;
			id = id.substring(4, id.length);
			
			var reqSil = $.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/api/v1/not/sil",
				data : id
			});
			
			reqSil.done(function( msg ){
				notEkranaListele();
			});
			
			reqSil.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
				  console.log(jqXHR);
				  console.log(textStatus);
			});
			
			//alert(id);
		}
	});
	
	function notEkranaListele()
	{
		
		$('#notInput').val("");
		$('#myUL').html("");
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/v1/not/liste",
			dataType : "JSON",
			timeout:6000,
			success : function(data)
			{
				var icerik;
				
				$.each(data, function(i, val) {
				  
					$('#myUL').append('<li class="'+(val.durum ? '':'checked')+'" title="'+new Date(val.tarih).toLocaleDateString()+'">'+val.icerik+'<span id="not_'+val.id+'" class="close '+(val.durum ? '':'d-block')+'" >×</span></li>');
				});
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});

	}
	
	
	function notEkleme() 
	{
		var metin = document.getElementById("notInput").value;
		
		if(metin.trim().length < 3 )
		{
			alert("en az 3 karakter girilmeli...");
			return ;
		}
		
		var not = {
			icerik:metin.trim()
		}
	  
		var request = $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/v1/not/ekle",
			data : JSON.stringify(not),
			//dataType : "text/plain",
		});
	  
		request.done(function( msg ){
			notEkranaListele();
		});
		 
		request.fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
		  console.log(jqXHR);
		  console.log(textStatus);
		});
	  
	}
	
	
	notEkranaListele();
	
});




