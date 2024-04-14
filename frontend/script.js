function vote(selection) {
    console.log('Voting for:', selection);  // Debug log
    fetch('/vote', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ selection: selection }),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Vote response:', data);  // Debug log
        updateStatistics();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function updateStatistics() {
    console.log('Updating statistics');  // Debug log
    fetch('/statistics')
    .then(response => response.json())
    .then(data => {
        console.log('Statistics data:', data);  // Debug log
        document.getElementById('statistics').innerHTML = `<p>Cats: ${data.cats} | Dogs: ${data.dogs}</p>`;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('voteCat').addEventListener('click', function() {
        vote('Cat');
    });

    document.getElementById('voteDog').addEventListener('click', function() {
        vote('Dog');
    });

    updateStatistics(); // Initial call to load statistics when the page loads
});
