function valid(className){
	var inputName=$("."+className).val();
	if (inputName==""){
		$("."+className).css("border", "1px red solid");
		$("."+className+"Error").css("color", "red");
		$("."+className+"Error").html("Input! Please!");
		return false;
	}
	$("."+className).css("border", "");
	$("."+className+"Error").css("color", "");
	$("."+className+"Error").html("");
	return true;
}
function saveSubmit(listInput){
	var check=true;
	for(var i=0; i<listInput.length; i++){
		if(!valid(listInput[i])){
			check=false;
		}
	}
	return check;
}
