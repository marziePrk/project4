function showTable() {
    var grantName = document.getElementById("grantName");
    var minDuration = document.getElementById("minDuration");
    var maxDuration = document.getElementById("maxDuration");
    var minAmount = document.getElementById("minAmount");
    var maxAmount = document.getElementById("maxAmount");

    var table = document.getElementById("grantTableId");
    var rowNumber = table.rows.length;
    if (rowNumber == 0) {
        var headerRow = table.insertRow(rowNumber);
        var headerCell = document.createElement("th");
        headerCell.innerHTML = "ردیف";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("th");
        headerCell.innerHTML = "نام شرط";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("th");
        headerCell.innerHTML = "حداقل مدت قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("th");
        headerCell.innerHTML = "حداکثرمدت قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("th");
        headerCell.innerHTML = "حداقل مبلغ قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("th");
        headerCell.innerHTML = "حداکثرمبلغ قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("th");
    }

    var x = parseFloat(minAmount.value);
    var y = parseFloat(maxAmount.value);
    var a = parseFloat(minDuration.value);
    var b = parseFloat(maxDuration.value);
    if (x >= y) {
        alert("مقدار حداقل باید کوچکتر از حداکثر باشد.");
    } else if (a >= b) {
        alert("مقدار حداقل باید کوچکتر از حداکثر باشد.");
    } else {

        if (grantName.value != "" && minAmount.value != "" && maxAmount.value != "" && minDuration.value != "" && maxDuration.value != "") {
            rowNumber = table.rows.length;
            var row = table.insertRow(rowNumber);
            row.insertCell(0).innerHTML = rowNumber.toString();
            row.insertCell(1).innerHTML = grantName.value + '<input type="hidden" name="grantName' + rowNumber + '" value="' + grantName.value + '">';
            row.insertCell(2).innerHTML = minAmount.value + '<input type="hidden" name="minDuration' + rowNumber + '" value="' + minDuration.value + '" >';
            row.insertCell(3).innerHTML = maxAmount.value + '<input type="hidden" name="maxDuration' + rowNumber + '" value="' + maxDuration.value + '" >';
            row.insertCell(4).innerHTML = minDuration.value + '<input type="hidden" name="minAmount' + rowNumber + '" value="' + minAmount.value + '" >';
            row.insertCell(5).innerHTML = maxDuration.value + '<input type="hidden" name="maxAmount' + rowNumber + '" value="' + maxAmount.value + '" >';
        } else {
            alert("پر کردن تمامی فیلد ها الزامی است.")
        }
        document.getElementById("rowNumber").value = rowNumber;
    }
}

