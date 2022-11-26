let url = 'https://jsonplaceholder.typicode.com/users';

const obtenerUsuarios = async () => {
    try {
        let response = await fetch(url);
        if (!response.ok) {
            throw new Error("Ocurrio un error al realizar la petición!")
        } else {

            let data = await response.json();
            pintarUsuarios(data);
        }

    } catch (error) {
        console.log(error);
    }
}

const pintarUsuarios = (data) => {
    let body="";
    for (let index = 0; index < data.length; index++) {
        body+=
        `<tr>
            <td> ${data[index].id} </td>
            <td> ${data[index].name} </td>
            <td> ${data[index].email} </td>
        </tr>`
    }
    document.getElementById("data").innerHTML=body;
}
 

obtenerUsuarios()

 