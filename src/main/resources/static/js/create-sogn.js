const out = function (str) { console.log(str); };

const sov = (ms) => {
    const prom = new Promise(dummyFunction => setTimeout(dummyFunction, ms));
    return prom;
}

// first get our form
const personForm = document.getElementById("personform");
out(personForm);

// normal submitForm
function submitForm(ae) {
    out("submit form");
    out(personForm);
    out(ae);
}

async function submitFormAsync(mouseEvent) {

    //prevent form from beeing cleared when executing submit
    mouseEvent.preventDefault();
    // and also important. prevent action from beeing executed, meaning sending form to server (url in action=)

    out("submit form async");
    out(personForm);
    out(mouseEvent);

    const form1 = mouseEvent.currentTarget;
    out("Form1 ="); //form1 is the object that caused the event. In this case same as personForm
    out(form1);
    const url = form1.action; // hvis action i jeres form header så er den her, og bliver ikke udført hvis preventDefault() er kaldt
    out(url);

    const formData = new FormData(form1);

    out(formData);

    out(formData.entries());

    const plainFormData = Object.fromEntries(formData.entries());
    out(plainFormData); // nu har vi object med alle data fra skærmen

    try {
        // vi gør som i artikel
        const responseData = await postFormDataAsJson({ url, formData });

        //responseData er et json object
        // nu skal vi finde ud af hvad vi gør med svaret fra server, som jo er det nye indsatte objekt
        console.log(responseData);
        //window.name.minNyePerson = responseData;  det virker ikke
        //window.name = {"json": responseData};
        // window.localStorage.setItem("json1", { responseData }); //virker ikke , localStorage tager kun stringe i setItem (string,string)
        // localStorage.setItem("nameKurt", "Kurt Larsen"); // window er global så vi kan nøjes med at skrive localStorage
        localStorage.setItem("hihi", responseData.genreid);
        // localStorage.setItem("location", responseData.location);
        // localStorage.setItem("birthDate", responseData.birthDate);

    } catch (error) {
        console.error(error);
    }

}

//bemærk tager 1 parameter. Et object med url og formData.
//Betyder at rækkefølgen af url,formdata er ligegyldig, man kunne også skrive formData,url og det vil stadig virke
async function postFormDataAsJson({ url, formData }) {

    const plainFormData = Object.fromEntries(formData.entries());

    const formDataJsonString = JSON.stringify(plainFormData);
    out(plainFormData);
    out(formDataJsonString); // this is the string that we will send to the server
    out("Done postformdata");

    const requestOptions = {
        'content-type': 'application/json',
        method: 'POST',
        redirect: 'follow',
        headers: {
            'Content-Type': 'application/json',
        },
        body: formDataJsonString
    };

    //vi kunne også få vores url fra action attribut i form
    const posturl = "http://localhost:8080/newsognjs";

    //fordi vi er indeni en function prefixed med async, så kan vi kalde fetch med await, så bliver stående til færdig.
    //Det jeg kalder for et synkront kald
    const responseData = await fetch(posturl, requestOptions);

    out("responseData=");

    out(responseData);

    const responseJson = await responseData.json();

    out("responseJson");
    out(responseJson);
    return responseJson;

}

personForm.addEventListener('submit', submitFormAsync);

// submit action blanker form ud. så prøv den her
const pbNewPerson = document.getElementById("pbNewPerson");

pbNewPerson.addEventListener("click", submitFormAsync);



