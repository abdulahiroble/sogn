// Henter vores url'er som vi skal fetche fra
const urls = [
    "http://localhost:8080/sogne",
    "http://localhost:8080/kommuner"
];

// Fetcher alle url og laver om til json
async function fetchAll() {
    const results = await Promise.all(urls.map((url) => fetch(url).then((r) => r.json())));

    // Laver tabel og tilføjer html ud fra id
    var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, cellE, header, cellF, cellG, cellH
    document.getElementById("demoB").appendChild(table);

    // lopper igennem resutls og opretter row, header og celler
    for (let i = 0; i < 100; i++) {
        // (C2) ROWS & CELLS
        row = document.createElement("tr");
        header = document.createElement("th");
        cellA = document.createElement("td");
        cellB = document.createElement("td");
        cellC = document.createElement("td");
        cellD = document.createElement("td")
        cellE = document.createElement("td")
        cellF = document.createElement("td")
        cellG = document.createElement("td")
        cellH = document.createElement("td")

        // Indsætter vores data i cellerne 
        // Udregne et specifikt eksempel som viser sum af smittede fra en bestemt kommune
        // Tilføjer update og delete knap hvor id er taget ud fra en specifik sogn
        // (C3) KEY & VALUE
        cellA.innerHTML = results[0][i].navn
        cellB.innerHTML = results[0][i].smittetryk
        cellC.innerHTML = results[0][i].sognkode
        cellD.innerHTML = results[1].map((test) => {
            return test.kommunenavn
        });
        cellE.innerHTML = results[0][i].lukdato
        cellF.innerHTML = results[0][i].lukket
        cellG.innerHTML = `<a href="http://localhost:8080/sognUpdate/${results[0][i].sognid}" class="btn btn-primary">Update</a>`
        cellH.innerHTML = `<a href="http://localhost:8080/sognDelete/${results[0][i].sognid}" class="btn btn-danger">Delete</a>`

        // Styling af tabel og rows
        // (C4) ATTACH ROW & CELLS
        table.appendChild(row).style.width = "500px"
        row.appendChild(cellA).style.width = "500px"
        row.appendChild(cellB).style.width = "500px"
        row.appendChild(cellC).style.width = "500px"
        row.appendChild(cellD).style.width = "500px"
        row.appendChild(cellE).style.width = "500px"
        row.appendChild(cellF).style.width = "500px"
        row.appendChild(cellG).style.width = "500px"
        row.appendChild(cellH).style.width = "500px"
    }
}

fetchAll();