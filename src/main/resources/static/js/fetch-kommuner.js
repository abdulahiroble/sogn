// Henter vores url'er som vi skal fetche fra
const urls = [
    "http://localhost:8080/sogne",
    "http://localhost:8080/kommuner"
];

// Fetcher alle url og laver om til json
async function fetchAll() {
    const results = await Promise.all(urls.map((url) => fetch(url).then((r) => r.json())));

    // Laver tabel og tilføjer html ud fra id
    var table = document.createElement("table"), row, cellA, cellB, header
    document.getElementById("demoB").appendChild(table);

    // lopper igennem resutls og opretter row, header og celler
    for (let i = 0; i < 10; i++) {
        // (C2) ROWS & CELLS
        row = document.createElement("tr");
        header = document.createElement("th");
        cellA = document.createElement("td");
        cellB = document.createElement("td");

        // Indsætter vores data i cellerne 
        // Udregne et specifikt eksempel som viser sum af smittede fra en bestemt kommune
        // (C3) KEY & VALUE
        cellA.innerHTML = results[1][i].kommunenavn
        cellB.innerHTML = results[0][i].kommune.kommuneid == 1 ? results[0][0].smittetryk + results[0][1].smittetryk : null

        // Styling af tabel og rows
        // (C4) ATTACH ROW & CELLS
        table.appendChild(row).style.width = "500px"
        row.appendChild(cellA).style.width = "500px"
        row.appendChild(cellB).style.width = "500px"
    }
}

fetchAll();