const quoteMeNav = document.getElementById('quote-me-nav');
// Close dropdown if clicked outside
document.addEventListener('click', (event) => {
    if (!event.target.closest('.me-nav')) {
        quoteMeNav.style.display = 'none';
    }
});

const quoteSection = document.getElementById('quote-section');
const buttons = document.querySelectorAll('.global-nav-item');

// Add event listener to each button
buttons.forEach(button => {
    button.addEventListener('click', () => {
        if (button.classList.contains('me-nav')) {
            const isVisible = quoteMeNav.style.display === 'block';
            quoteMeNav.style.display = isVisible ? 'none' : 'block';
        } else {

            // Remove the 'active' class from all buttons
            buttons.forEach(btn => btn.classList.remove('global-nav-item-active'));

            // Add the 'active' class to the clicked button
            button.classList.add('global-nav-item-active');

            // Navigate to the href in the data-href attribute
            // const href = button.getAttribute('data-href');
            // if (href) {
            //     window.location.href = href; // Redirect to the URL
            // }
        }
    });
});