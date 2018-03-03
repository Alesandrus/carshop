function call() {
    var msg = $('#formx').serialize();
    $.ajax({
        type: 'GET',
        url: 'getallads',
        data: msg,
        success: function(data) {
            var adlist = data;
            var table = document.getElementById("ads");
            while (table.firstChild) {
                table.removeChild(table.firstChild);
            }
            for (var i = 0; i < adlist.length; i++) {
                var ad = adlist[i];
                var fotolist = ad.images;
                var mainfoto = fotolist[0];
                var row = document.createElement("div");
                row.className += " row bottomborder";
                table.appendChild(row);

                var fotocell = document.createElement("div");
                fotocell.className += " col-12 col-sm";
                var foto = document.createElement("img");
                if (mainfoto !== undefined) {
                    foto.src = "images/small/" + mainfoto;
                } else {
                    foto.src = "images/small/nofoto.jpg"
                }
                fotocell.appendChild(foto);
                row.appendChild(fotocell);

                var textcell = document.createElement("div");
                textcell.className += " col-12 col-sm";
                var modelhref = document.createElement("a");
                modelhref.href = "getad?id=" + ad.id;
                modelhref.innerHTML = ad.model.brand.name + " " + ad.model.name + " " + ad.yearOfManufacture;
                textcell.appendChild(modelhref);
                var p1 = document.createElement("p");
                p1.innerHTML = ad.price + " руб.";
                textcell.appendChild(p1);
                var br = document.createElement("br");
                p1.appendChild(br);
                var creationTime = new Date(ad.created);
                p1.append(creationTime.toDateString() + " " + creationTime.getHours() + ":"
                    + creationTime.getMinutes());
                row.appendChild(textcell);
            }
        }
    });
}


function addAllAds() {
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

    var request = new XMLHttpRequest();
    request.open("GET", "getallads", true);
    function process() {
        if (request.readyState === 4 && request.status === 200) {
            var adlist = JSON.parse(request.responseText);
            var table = document.getElementById("ads");
            for (var i = 0; i < adlist.length; i++) {
                var ad = adlist[i];
                var fotolist = ad.images;
                var mainfoto = fotolist[0];
                var row = document.createElement("div");
                row.className += " row bottomborder";
                table.appendChild(row);

                var fotocell = document.createElement("div");
                fotocell.className += " col-12 col-sm";
                var foto = document.createElement("img");
                if (mainfoto !== undefined) {
                    foto.src = "images/small/" + mainfoto;
                } else {
                    foto.src = "images/small/nofoto.jpg"
                }
                fotocell.appendChild(foto);
                row.appendChild(fotocell);

                var textcell = document.createElement("div");
                textcell.className += " col-12 col-sm";
                var modelhref = document.createElement("a");
                modelhref.href = "getad?id=" + ad.id;
                modelhref.innerHTML = ad.model.brand.name + " " + ad.model.name + " " + ad.yearOfManufacture;
                textcell.appendChild(modelhref);
                var p1 = document.createElement("p");
                p1.innerHTML = ad.price + " руб.";
                textcell.appendChild(p1);
                var br = document.createElement("br");
                p1.appendChild(br);
                var creationTime = new Date(ad.created);
                p1.append(creationTime.toDateString() + " " + creationTime.getHours() + ":"
                    + creationTime.getMinutes());
                row.appendChild(textcell);
            }
        }
    }
    request.onreadystatechange = process;
    request.send(null);
}

window.onload = addAllAds;

var brandSelect = document.getElementById("brand");
brandSelect.onchange = handleSelectModel;

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
            option.value = "0";
            option.text = " -- select -- ";
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