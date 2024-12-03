
// Toggle password visibility
const passwordInput = document.getElementById('password');
const togglePassword = document.getElementById('togglePassword');

togglePassword.addEventListener('click', () => {
    const type = passwordInput.type === 'password' ? 'text' : 'password';
    passwordInput.type = type;

    // Change the eye icon
    togglePassword.textContent = type === 'password' ? '\u{1F441}' : '\u{1F441}\u{FE0E}';
});