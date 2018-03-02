function getAccountAds() {
    var request = new XMLHttpRequest();
    request.open("POST", "account", true);
    function process() {
        if (request.readyState === 4 && request.status === 200) {
            var adlist = JSON.parse(request.responseText);
            var table = document.getElementById("adtable");
            for (var i = 0; i < adlist.length; i++) {
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
                p1.innerHTML = ad.price + " руб.";
                textcell.appendChild(p1);
                var br = document.createElement("br");
                p1.appendChild(br);
                var creationTime = new Date(ad.created);
                p1.append(creationTime.toDateString() + " " + creationTime.getHours() + ":"
                    + creationTime.getMinutes());

                var statusCell = row.insertCell(2);
                var form = document.createElement("form");
                var check = document.createElement("input");
                check.type = "checkbox";
                check.name = "soldCheck";
                check.id = ad.id;
                check.value = "isSale";
                check.checked = ad.status;

                function setSale(eventObj) {
                    var item = {id: eventObj.target.id, status: eventObj.target.checked};
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "setsale");
                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                    xhr.send("param=" + JSON.stringify(item));
                }

                check.onchange = setSale;
                form.appendChild(check);
                statusCell.appendChild(form);
            }
        }
    }
    request.onreadystatechange = process;
    request.send(null);
}

window.onload = getAccountAds;