function checkNationalCode(nationalCode) {
    var code;
    code = nationalCode.value;
    if (code.length  ==  10) {
        return true;
    }else {
        alert("کد ملی باید ده رقمی باشد. ");
        return false;
    }
}
