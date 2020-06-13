/**
 * 
 */
function chkFirstName(){
	var firstname = document.customerForm.firstName.value;
	if(firstname==null || firstname.length<=0){
		alert("please enter First Name ")
		document.customerForm.firstName.focus();
		return false;
	}
	return true;
}

function chkLastName(){
	var lastname = document.customerForm.lastName.value;
	if(lastname==null || lastname.length<=0){
		alert("please enter last Name ")
		document.customerForm.lastName.focus();
		return false;
	}
	return true;
}

function chkDateOfBirth(){
	var dob = document.customerForm.dob.value;
	if(dob==null || dob.length<=0){
		alert("please enter First Name ")
		document.customerForm.dob.focus();
		return false;
	}
	return true;
}

function chkCity(){
	var city = document.customerForm.city.value;
	var letters = /^[A-Za-z]+$/;
	
	if(city!=null && city.length>0){
		if(city.match(letters)){
			return true;
		}
		else
			{
			alert("please enter alphabets only for city name");
			document.customerForm.city.focus();
			return false;
			}
	}
	else{
		alert("Please Enter cityname");
		document.customerForm.city.focus();
		return false;
	}
	
}

function checkCountrySelect(){
	
	if(document.getElementById('setCountry').value != ""){
		
		return true;
	}
	else{
		alert("please select country from list");
		document.getElementsById('selCountry').focus();
		return false;
	}
}

function chkEmail(){
	var email = document.customerForm.email.value;
	var letters = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	if(email!=null && email.length>0){
		if(letters.test(email)){
			return true;
		}
		else
			{
			alert("please enter invalid email address");
			document.customerForm.email.focus();
			return false;
			}
	}
	else{
		alert("Please Enter email id");
		document.customerForm.email.focus();
		return false;
	}
	
}

function chkSalary(){
	var salary = document.customerForm.salary.value;
	var letters = /^[0-9]+$/;
	
	if(salary!=null && salary.length>0){
		if(!letters.test(salary)){
			alert("please only enter numeric character only for salary");
			document.customerForm.salary.focus();
			return false;
		}
		else
			{
			alert("please enter salary");
			document.customerForm.salary.focus();
			return false;
			}
	}
	else{
		alert("Please Enter salary");
		document.customerForm.salary.focus();
		return false;
	}
	
}

