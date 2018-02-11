function addCountriesAndBrands() {
    var request = new XMLHttpRequest();
    request.open("POST", "getcountries", true);
    function process() {
        if (request.readyState === 4 && request.status === 200) {
            var countries = JSON.parse(request.responseText);
            var sel = document.getElementById("country");
            for (var i = 0; i < countries.length; i++) {
                var option = document.createElement("option");
                option.value = countries[i].id;
                option.text = countries[i].name;
                sel.add(option);
            }
        }
    }
    request.onreadystatechange = process;
    request.send(null);

    var requestBrand = new XMLHttpRequest();
    requestBrand.open("POST", "getbrands", true);
    function processBrand() {
        if (requestBrand.readyState === 4 && requestBrand.status === 200) {
            var brands = JSON.parse(requestBrand.responseText);
            var sel = document.getElementById("brand");
            for (var i = 0; i < brands.length; i++) {
                var option = document.createElement("option");
                option.value = brands[i].id;
                option.text = brands[i].name;
                sel.add(option);
            }
        }
    }
    requestBrand.onreadystatechange = processBrand;
    requestBrand.send(null);
}

window.onload = addCountriesAndBrands;

var countrySelect = document.getElementById("country");
countrySelect.onchange = handleSelect;
var brandSelect = document.getElementById("brand");
brandSelect.onchange = handleSelectModel;

function handleSelect() {
    var countryElem = countrySelect.options[countrySelect.selectedIndex];
    var countryID = countryElem.value;
    var req = new XMLHttpRequest();
    req.open("POST", "getcities", true);
    var body = "country=" + countryID;
    function proc() {
        if (req.readyState === 4 && req.status === 200) {
            var cities = JSON.parse(req.responseText);
            var sel = document.getElementById("city");
            while (sel.options.length > 0) {
                sel.options[sel.options.length - 1] = null;
            }
            var option = document.createElement("option");
            option.text = " -- select -- ";
            option.disabled = true;
            option.selected = true;
            sel.add(option);
            for (var i = 0; i < cities.length; i++) {
                option = document.createElement("option");
                option.value = cities[i].id;
                option.text = cities[i].name;
                sel.add(option);
            }
        }
    }
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send(body);
    req.onreadystatechange = proc;
}

function handleSelectModel() {
    var brandElem = brandSelect.options[brandSelect.selectedIndex];
    var brandID = brandElem.value;
    var req = new XMLHttpRequest();
    req.open("POST", "getmodels", true);
    var body = "brand=" + brandID;
    function proc() {
        if (req.readyState === 4 && req.status === 200) {
            var models = JSON.parse(req.responseText);
            var sel = document.getElementById("model");
            while (sel.options.length > 0) {
                sel.options[sel.options.length - 1] = null;
            }
            var option = document.createElement("option");
            option.text = " -- select -- ";
            option.disabled = true;
            option.selected = true;
            sel.add(option);
            for (var i = 0; i < models.length; i++) {
                option = document.createElement("option");
                option.value = models[i].id;
                option.text = models[i].name;
                sel.add(option);
            }
        }
    }
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send(body);
    req.onreadystatechange = proc;
}
