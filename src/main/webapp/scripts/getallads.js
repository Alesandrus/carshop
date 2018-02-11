function addAllAds() {
    var request = new XMLHttpRequest();
    request.open("POST", "getallads", true);
    function process() {
        if (request.readyState === 4 && request.status === 200) {
            var adlist = JSON.parse(request.responseText);
            var table = document.getElementById("ads");
            for (var i = 0; i < adlist.length; i++) {
                var ad = adlist[i];
                var fotolist = ad.images;
                var mainfoto = fotolist[0];
                var row = table.insertRow(i);

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
                var p2 = document.createElement("p");
                var creationTime = new Date(ad.created);
                p2.innerHTML = creationTime.toDateString() + " " + creationTime.getHours() + ":"
                    + creationTime.getMinutes();
                textcell.appendChild(p2);
            }
        }
    }
    request.onreadystatechange = process;
    request.send(null);
}

window.onload = addAllAds;