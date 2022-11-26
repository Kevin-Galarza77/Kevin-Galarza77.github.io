
const consultarPokemon = (id, number) => {
    fetch(`https://pokeapi.co/api/v2/pokemon/${id}`)
        .then(response => {
            return response.json();
        }).then(data => {
            pintarPokemon(data, number);
        }).catch(error => {
            console.log(error);
        });
}

const btnSeleccionar = () => {
    let primerPokemon = Math.round(Math.random() * 150);
    let segundoPokemon = Math.round(Math.random() * 150);
    consultarPokemon(primerPokemon, 1);
    consultarPokemon(segundoPokemon, 2);
}

btnSeleccionar();

const d = document;
const lista = d.getElementById("listarpokemon");



const pintarPokemon = (data, id) => {

    let $item = lista.querySelector(`#pok-${id}`);
    $item.getElementsByTagName("img")[0].setAttribute("src", data.sprites.front_default);
    $item.getElementsByTagName("p")[0].innerHTML = data.name.toUpperCase();

    let skills = ``
    for (let index = 0; index < data.abilities.length; index++) {
        skills += `<li>${data.abilities[index].ability.name} </li>`
    }
    $item.getElementsByTagName("ol")[0].innerHTML = skills;
    pintarModalPokemon(data, id);
}

const modals = d.getElementById("modals");

const pintarModalPokemon = (data, id) => {

    const $modal = modals.querySelector(`#modal-pok-${id}`);
    const $modalBody = $modal.getElementsByClassName("modal-body")[0];
    $modalBody.innerHTML='';
    $modal.getElementsByTagName("h2")[0].innerHTML = data.name.toUpperCase();

    const $contenedorImagenes = d.createElement("div");

    for (const property in data.sprites) {
        if (data.sprites[property] && typeof (data.sprites[property]) === "string") {
            const $imagen = new Image();
            $imagen.src = data.sprites[property];
            $contenedorImagenes.appendChild($imagen);
        }
    }

    addElemento($modalBody,$contenedorImagenes);

    const detalles = ["Experiencia Base", data.base_experience, "Altura (Decímetros)", data.height, "Peso (Hectogramos)", data.weight, "Especie", data.species.name];

    for (let index = 0; index < detalles.length; index += 2) {
        const $contenedorDescripciones = d.createElement("div");
        $contenedorDescripciones.className = "d-flex justify-content-between align-items-center";
        const $descripcion = `<h6 class="text-primary fs-6">${detalles[index]}</h6> <p class="text-dark fs-6">${detalles[index + 1]}</p>`;
        $contenedorDescripciones.innerHTML = $descripcion;

        addElemento($modalBody,$contenedorDescripciones);
    
    }

    const $divIndices = d.createElement("div");
    $divIndices.className = "d-flex justify-content-between align-items-start";

    let game_indices = "<h6 class='text-primary fs-6'>Slot y Tipos</h6><ol class='list-group list-group-numbered'>";
    for (let index = 0; index < data.types.length; index++) {
        game_indices += `<li class='text-end'>${data.types[index].slot} ${data.types[index].type.name}</li>`
    }
    game_indices += "</ol>";
    $divIndices.innerHTML = game_indices;

    addElemento($modalBody,$divIndices);

    const divElementos = d.createElement("div");
    divElementos.className = "d-flex justify-content-between align-items-start";
    
    let elementos = "<h6 class='text-primary fs-6'>Lista de Elementos</h6><ul class='list-group list-group-numbered'>";

    if (!data.held_items.length) {
        elementos += "Ninguno";
    } else {
        for (let index = 0; index < data.held_items.length; index++) {
            elementos += `<li class='text-end'>${data.held_items[index].item.name}</li>`
        }
    }
    elementos += "</ul>"
    divElementos.innerHTML = elementos;

    addElemento($modalBody,divElementos);

}

const addElemento=($modal,$elemento)=>{
    $modal.appendChild($elemento);
    $modal.appendChild(d.createElement("hr"));
}