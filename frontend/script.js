document.getElementById('voteCat').addEventListener('click', function() {
    vote('Cat');
});

document.getElementById('voteDog').addEventListener('click', function() {
    vote('Dog');
});

function vote(selection) {
    fetch('/vote', {
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
    fetch('/statistics')
    .then(response => response.json())
    .then(data => {
        document.getElementById('statistics').innerHTML = `<p>Cats: ${data.cats} | Dogs: ${data.dogs}</p>`;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

updateStatistics(); // Initial statistics update
