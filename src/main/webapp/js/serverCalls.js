$("button.createProduct").click(function() {
			var name = $("form.createProduct input.productName").val();
			var description = $("form.createProduct input.productDescription").val();
			var price = $("form.createProduct input.productPrice").val();
			

		/*	if (firstName == '' || lastName == '' || email == '' || password == '' || cpassword == '') {
				alert("Please fill all fields...!!!!!!");
			} else if ((password.length) < 2) {
				alert("Password should atleast 8 character in length...!!!!!!");
			} else if (!(password).match(cpassword)) {
				alert("Your passwords don't match. Try again?");

			} else {*/
			
			
			
				var product = {
					name : name,
					description : description,
					price : price
				};

				$.post("product", product,
					function(data) {
						console.log(data);
						if (data == 'Success') {
							alert('Success');
						}
					});
			/*}*/
});


$("button.buy-product").click(function() {
	var productId = jQuery(this).attr("product-id");
	

		$.post("bucket", {'productId':productId}, function(data) {		
			if (data == 'Success') {
				/*$('#buyProductModal').modal('hide');*/
				$("[data-dismiss=modal]").trigger({type:"click"});
				/*alert('Success');*/
			}
		});
});