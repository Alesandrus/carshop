function getAccountAds() {
    var request = new XMLHttpRequest();
    request.open("POST", "account", true);
    function process() {
        if (request.readyState === 4 && request.status === 200) {
            var adlist = JSON.parse(request.responseText);
            var table = document.getElementById("adtable");
            /*for (var i = 0; i < adlist.length; i++) {
                var ad = adlist[i];
                var fotolist = ad.images;
                var mainfoto = fotolist[0];
                var row = table.insertRow(i + 1);

                var fotocell = row.insertCell(0);
                var foto = document.createElement("img");
                if (mainfoto !== undefined) {
                    foto.src = "images/small/" + mainfoto;
                } else {
                    foto.src = "images/small/nofoto.jpg"
                }
                fotocell.appendChild(foto);

                var textcell = row.insertCell(1);
                var modelhref = document.createElement("a");
                modelhref.href = "getad?id=" + ad.id;
                modelhref.innerHTML = ad.model.brand.name + " " + ad.model.name + " " + ad.yearOfManufacture;
                textcell.appendChild(modelhref);
                var p1 = document.createElement("p");
                p1.innerHTML = ad.price + "&#160;&#8381;";
                textcell.appendChild(p1);
                var br = document.createElement("br");
                p1.appendChild(br);
                var creationTime = new Date(ad.created);
                p1.append(creationTime.toDateString() + " " + creationTime.getHours() + ":"
                    + creationTime.getMinutes());*/

            for (var i = 0; i < adlist.length; i++) {
                var ad = adlist[i];
                var fotolist = ad.images;
                var mainfoto = fotolist[0];
                var row = document.createElement("div");
                row.className += " row bottomborder justify-content-center";
                table.appendChild(row);

                var fotocell = document.createElement("div");
                fotocell.className += " col-12 col-sm-5 text-center";
                var foto = document.createElement("img");
                if (mainfoto !== undefined) {
                    foto.src = "images/small/" + mainfoto;
                } else {
                    foto.src = "images/small/nofoto.jpg"
                }
                foto.className += " rounded img-fluid";
                fotocell.appendChild(foto);
                row.appendChild(fotocell);

                var textcell = document.createElement("div");
                textcell.className += " col-12 col-sm-5 text-center text-sm-left align-self-center";
                var modelhref = document.createElement("a");
                modelhref.href = "getad?id=" + ad.id;
                modelhref.innerHTML = ad.model.brand.name + " " + ad.model.name + " " + ad.yearOfManufacture;
                textcell.appendChild(modelhref);
                var p1 = document.createElement("p");
                p1.innerHTML = ad.price + "&#160;&#8381";
                textcell.appendChild(p1);
                var br = document.createElement("br");
                p1.appendChild(br);
                var creationTime = new Date(ad.created);
                p1.append(creationTime.toDateString() + " " + creationTime.getHours() + ":"
                    + creationTime.getMinutes());
                row.appendChild(textcell);

                var statusCell = document.createElement("div");
                statusCell.className += " col-sm-2 col-auto text-center align-self-center";
                var form = document.createElement("form");
                var check = document.createElement("input");
                check.type = "checkbox";
                check.name = "soldCheck";
                check.id = ad.id;
                check.value = "isSale";
                check.checked = ad.status;
                check.className += " custom-control-input";
                var divCheck = document.createElement("div");
                divCheck.className += " custom-control custom-checkbox text-info";
                var labelCheck = document.createElement("label");
                labelCheck.className += " custom-control-label";
                labelCheck.htmlFor = ad.id;
                labelCheck.innerText = "Продано";
                divCheck.appendChild(labelCheck);
                divCheck.insertBefore(check, labelCheck);

                function setSale(eventObj) {
                    var item = {id: eventObj.target.id, status: eventObj.target.checked};
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "setsale");
                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    xhr.send("param=" + JSON.stringify(item));
                }

                check.onchange = setSale;
                form.appendChild(divCheck);
                statusCell.appendChild(form);
                row.appendChild(statusCell);
            }
        }
    }
    request.onreadystatechange = process;
    request.send(null);
}

window.onload = getAccountAds;