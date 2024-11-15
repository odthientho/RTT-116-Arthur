// JavaScript for switching between Sign In and Sign Up forms
document.getElementById('switch-to-signup').addEventListener('click', function() {
    document.getElementById('sign-in-form').classList.add('hidden');
    document.getElementById('sign-up-form').classList.remove('hidden');
});

document.getElementById('switch-to-signin').addEventListener('click', function() {
    document.getElementById('sign-in-form').classList.remove('hidden');
    document.getElementById('sign-up-form').classList.add('hidden');
});