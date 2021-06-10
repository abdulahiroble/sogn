const urls = [
    "http://localhost:8080/sogne",
    "http://localhost:8080/kommuner"
];

async function fetchAll() {
    const results = await Promise.all(urls.map((url) => fetch(url).then((r) => r.json())));

    // results.map((test) => console.log(test.map((test2) => test2.reptime || test2.repname)))

    // console.log(JSON.stringify(results, null, 10));

    var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, cellE, header, cellF
    document.getElementById("demoB").appendChild(table);

    for (let i = 0; i < 10; i++) {
        // (C2) ROWS & CELLS
        row = document.createElement("tr");
        header = document.createElement("th");
        cellA = document.createElement("td");
        cellB = document.createElement("td");
        cellC = document.createElement("td");
        // cellD = document.createElement("td")
        cellE = document.createElement("td")
        cellF = document.createElement("td")

        // (C3) KEY & VALUE
        cellA.innerHTML = results[0][i].navn
        cellB.innerHTML = results[0][i].smittetryk
        cellC.innerHTML = results[0][i].sognkode
        // cellD.innerHTML = results[1][i].kommunenavn
        cellE.innerHTML = `<a href="http://localhost:8080/sognUpdate/${results[0][i].sognid}" class="btn btn-primary">Update</a>`
        cellF.innerHTML = `<a href="http://localhost:8080/sognDelete/${results[0][i].sognid}" class="btn btn-danger">Delete</a>`

        // (C4) ATTACH ROW & CELLS
        table.appendChild(row).style.width = "500px"
        row.appendChild(cellA).style.width = "500px"
        row.appendChild(cellB).style.width = "500px"
        row.appendChild(cellC).style.width = "500px"
        // row.appendChild(cellD).style.width = "500px"
        row.appendChild(cellE).style.width = "500px"
        row.appendChild(cellF).style.width = "500px"
    }
}

fetchAll();