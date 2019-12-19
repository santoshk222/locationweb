/**
 * 
 */
function validateForm() {
	var radios = document.getElementsByName("type");
	var radioChecked = false;
	if (document.frm.name.value == "") {
		alert("name cannot be blank!!");
		return false;
	} else if (document.frm.code.value == "") {
		alert("code cannot be blank!!");
		return false;
	} else if (radios.length > 1) {
		var i = 0;
		while (!radioChecked && i < radios.length) {
			if (radios[i].checked) {
				radioChecked = true;
			}
			i++;
		}
		if (!radioChecked) {
			alert("type cannot be blank!!");
		}
	}
	return radioChecked;
}