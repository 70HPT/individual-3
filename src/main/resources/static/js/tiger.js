const tigerList = document.getElementById('tiger-list');
const tigerForm = document.getElementById('tiger-form');

const fetchTigers = (query = '') => {
    fetch(`/tigers${query}`)
        .then(res => res.json())
        .then(tigers => {
            tigerList.innerHTML = '';
            tigers.forEach(tiger => {
                const div = document.createElement('div');
                div.innerHTML = `
                    <strong>${tiger.name}</strong> - ${tiger.subspecies} (${tiger.habitatRegion}) 
                    <br>${tiger.description}
                    <br>
                    <button onclick="deleteTiger(${tiger.tigerId})">Delete</button>
                    <button onclick='editTiger(${JSON.stringify(tiger)})'>Edit</button>
                    <hr>
                `;
                tigerList.appendChild(div);
            });
        });
};

const deleteTiger = (id) => {
    fetch(`/tigers/${id}`, { method: 'DELETE' })
        .then(() => fetchTigers());
};

tigerForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const id = document.getElementById('tiger-id').value;
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const subspecies = document.getElementById('subspecies').value;
    const habitatRegion = document.getElementById('habitatRegion').value;

    const tigerData = { name, description, subspecies, habitatRegion };

    const method = id ? 'PUT' : 'POST';
    const url = id ? `/tigers/${id}` : '/tigers';

    fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tigerData)
    }).then(() => {
        tigerForm.reset();
        document.getElementById('tiger-id').value = '';
        fetchTigers();
    });
});

const editTiger = (tiger) => {
    document.getElementById('tiger-id').value = tiger.tigerId;
    document.getElementById('name').value = tiger.name;
    document.getElementById('description').value = tiger.description;
    document.getElementById('subspecies').value = tiger.subspecies;
    document.getElementById('habitatRegion').value = tiger.habitatRegion;
};

const filterByName = () => {
    const key = document.getElementById('search-name').value;
    if (key) fetchTigers(`/name?key=${encodeURIComponent(key)}`);
    else fetchTigers();
};

// Initial load
fetchTigers();
