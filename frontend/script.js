function setLoading(isLoading) {
    // Disable or enable buttons based on isLoading status
    document.getElementById('voteCat').disabled = isLoading;
    document.getElementById('voteDog').disabled = isLoading;
}

function showConfirmation(message) {
    // Display a temporary message for user feedback
    const confirmationBox = document.getElementById('confirmation');
    confirmationBox.innerText = message;
    setTimeout(() => {
        confirmationBox.innerText = '';  // Clear message after 3 seconds
    }, 3000);
}

function vote(selection) {
    console.log('Voting for:', selection);  // Debug log
    setLoading(true);  // Disable buttons during the request
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
        updateStatistics();  // Update the statistics on the same page
        showConfirmation(`Your vote for '${selection}' was recorded!`);  // Show confirmation
    })
    .catch((error) => {
        console.error('Error:', error);
        showConfirmation('Error in voting! Please try again.');  // Show error message
    })
    .finally(() => {
        setLoading(false);  // Re-enable buttons once processing is complete
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
