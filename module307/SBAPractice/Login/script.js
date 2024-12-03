document.addEventListener('DOMContentLoaded', function() {
    const submitButton = document.getElementById('signup-btn');
    submitButton.addEventListener('click', function(event) {
        event.preventDefault();

        const firstName = document.getElementById('first-name').value.trim();
        const lastName = document.getElementById('last-name').value.trim();
        const email = document.getElementById('email').value.trim();
        const password = document.getElementById('password').value.trim();
        const errorMessageSpan = document.getElementById('error-message');

        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;

        let errorMessage = '';

        // Validation checks
        if (!email || !emailPattern.test(email)) errorMessage += 'Enter a valid email address. ';
        else if (!password || !passwordPattern.test(password)) {
            errorMessage += 'Use 8+ characters with uppercase, lowercase, numbers, and symbols.';
        } else if (!firstName) errorMessage += 'First Name cannot be empty. ';
        else if (!lastName) errorMessage += 'Last Name cannot be empty. ';

        if (errorMessage) {
            console.log(errorMessage);
            // Display error message
            errorMessageSpan.textContent = errorMessage;
            errorMessageSpan.classList.remove('hidden');
        } else {
            // Hide error message and handle successful submission
            errorMessageSpan.classList.add('hidden');
            alert('Sign-up successful!');
            // Optionally handle further successful signup logic here
        }
    })
})