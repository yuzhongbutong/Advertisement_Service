function doRows(tableID, flag, names) {
	var table = document.getElementById(tableID).childNodes[0];
	if (flag) {
		var nameArray = names.split("[~!@]");
		var newTR = table.insertRow(table.rows.length);
		newTR.align = "center";
		var length = table.childNodes[0].childNodes.length;
		for ( var i = 0; i < length; i++) {
			var newTD = newTR.insertCell(i);
			if (i == 0) {
				newTD.innerHTML = "<input type='checkbox'/>";
			} else if (i == 1) {
				newTD.innerHTML = "<input name='"
						+ nameArray[i]
						+ "' type='text' value='-' class='id_text_none_style' readonly />";
			} else {
				newTD.innerHTML = "<input name='" + nameArray[i]
						+ "' type='text' class='insert_text_style' />";
			}
		}
	} else {
		for (i = table.childNodes.length - 1; i >= 0; i--) {
			if (table.childNodes[i].childNodes[1].firstChild.value == "-"
					&& table.childNodes[i].childNodes[0].firstChild.checked) {
				table.deleteRow(i);
			}
		}
	}
}

function doCheckAll(obj) {
	var table = obj.parentNode.parentNode.parentNode;
	var length = table.childNodes.length;
	for ( var i = 1; i < length; i++) {
		var tr = table.childNodes[i];
		if (tr.childNodes[1].firstChild.value != "-") {
			var checkBox = tr.firstChild.firstChild;
			checkBox.checked = obj.checked;
			doCheck(checkBox);
		}
	}
}

function doCheck(obj) {
	var trCurrent = obj.parentNode.parentNode;
	var table = trCurrent.parentNode;
	var tdArray = trCurrent.childNodes;
	var length = tdArray.length;
	var strClass = "update_text_style";
	var flag = false;
	obj.parentNode.childNodes[1].value = "1";
	if (!obj.checked) {
		strClass = "update_text_none_style";
		flag = true;
		obj.parentNode.childNodes[1].value = "0";
		table.firstChild.firstChild.firstChild.checked = false;
	}
	for ( var i = 2; i < length; i++) {
		tdArray[i].firstChild.className = strClass;
		tdArray[i].firstChild.readOnly = flag;
	}

	var flag = true;
	length = table.childNodes.length;
	for ( var i = 1; i < length; i++) {
		var tr = table.childNodes[i];
		if (tr.childNodes[1].firstChild.value != "-"
				&& !tr.firstChild.firstChild.checked) {
			flag = false;
		}
	}
	if (flag) {
		table.firstChild.firstChild.firstChild.checked = true;
	}
}