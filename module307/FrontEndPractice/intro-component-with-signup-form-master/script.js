document.addEventListener('DOMContentLoaded', function() {
  console.log("Logged");
  const submitButton = document.getElementById('submit-btn');
  submitButton.addEventListener('click', function(event) {
    event.preventDefault();
    console.log('here');

    const firstName = document.getElementById('first-name').value.trim();
    const lastName = document.getElementById('last-name').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const errorMessageSpan = document.getElementById('error-message');

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;

    let errorMessage = '';

    // Validation checks
    if (!firstName) errorMessage += 'First Name cannot be empty. ';
    if (!lastName) errorMessage += 'Last Name cannot be empty. ';
    if (!email || !emailPattern.test(email)) errorMessage += 'Enter a valid email address. ';
    if (!password || !passwordPattern.test(password)) {
      errorMessage += 'Password must be at least 8 characters, include lowercase, uppercase, a number, and a special character.';
    }

    if (errorMessage) {
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