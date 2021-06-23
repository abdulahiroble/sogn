// Laver variabel som mapper til id i html
let dropdown = document.getElementById('standard-select');
dropdown.length = 0;

// Laver en varible som opretter option element og giver default tekst vælg kommune
let defaultOption = document.createElement('option');
defaultOption.text = 'Vælg kommune';

// TIlføjer default option til dropdown som har index 0
dropdown.add(defaultOption);
dropdown.selectedIndex = 0;

// Henter vores url som vi skal fetche fra
const url = 'http://localhost:8080/kommuner';

// fetcher url og tjekker først om respons status giver 200 som betyder grønt lys. 
fetch(url)
    .then(
        function (response) {
            if (response.status !== 200) {
                console.warn('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response  
            // Dernæst tager vi vores response og laver om til json og derefter laver en funktion hvor vi har sat data som parameter
            response.json().then(function (data) {
                // Laver en variabel hvor værdi ikke er sat til at starte med
                let option;

                console.log(data);

                // Lopper vi igennem vores data og henter kommunenavn som tekst og finder den tilsvarende kommuneid værdi og parser det til int
                for (let i = 0; i < data.length; i++) {
                    option = document.createElement('option');
                    option.text = data[i].kommunenavn;
                    option.value = data[i].kommuneid;
                    parseInt(dropdown.add(option));
                }
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });
