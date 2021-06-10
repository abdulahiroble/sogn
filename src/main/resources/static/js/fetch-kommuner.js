const urls = [
    "http://localhost:8080/sogne",
    "http://localhost:8080/kommuner"
];

async function fetchAll() {
    const results = await Promise.all(urls.map((url) => fetch(url).then((r) => r.json())));

    // results.map((test) => console.log(test.map((test2) => test2.reptime || test2.repname)))

    // console.log(JSON.stringify(results, null, 10));

    var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, cellE, header, cellF, cellG, cellH
    document.getElementById("demoB").appendChild(table);

    for (let i = 0; i < 10; i++) {
        // (C2) ROWS & CELLS
        row = document.createElement("tr");
        header = document.createElement("th");
        cellA = document.createElement("td");
        cellB = document.createElement("td");

        // (C3) KEY & VALUE
        cellA.innerHTML = results[1][i].kommunenavn
        cellB.innerHTML = results[0][i].kommune.kommuneid == 1 ? results[0][0].smittetryk + results[0][1].smittetryk : null

        // (C4) ATTACH ROW & CELLS
        table.appendChild(row).style.width = "500px"
        row.appendChild(cellA).style.width = "500px"
        row.appendChild(cellB).style.width = "500px"
    }
}

fetchAll();