function vote(selection) {
    fetch('http://localhost:8081/vote', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ selection: selection }),
    })
    .then(response => response.json())
    .then(data => {
        updateStatistics();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function updateStatistics() {
    fetch('http://localhost:8081/statistics')
    .then(response => response.json())
    .then(data => {
        document.getElementById('statistics').innerHTML = `<p>Cats: ${data.cats} | Dogs: ${data.dogs}</p>`;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
