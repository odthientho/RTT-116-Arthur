const cheerio = require('cheerio');

async function main(url) {
    if (!url) {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });

        url = await new Promise(resolve => readline.question("url: ", resolve));
        readline.close();
    }

    try {
        const response = await fetch(url);
        if (response.ok) {
            const text = await response.text();
            const $ = cheerio.load(text);

            const table = $('#contents table');
            const rows = [];
            table.find('tbody tr').each((rowIndex, rowElement) => {
                const row = [];
                $(rowElement)
                    .find('td')
                    .each((colIndex, colElement) => {
                    row.push($(colElement).text().trim());
                    });
                rows.push(row);
            });

            
            rows.shift();


            // Determine the grid dimensions
            let maxX = 0, maxY = 0;
            rows.forEach(([x, _, y]) => {
            if (x > maxX) maxX = x;
            if (y > maxY) maxY = y;
            });

            // Initialize a 2D array (grid) filled with spaces
            let grid = [];
            for (let i = 0; i < Number(maxY)+1; i++) {
                grid.push(Array(Number(maxX)+1).fill(' '));
            }
            // Populate the grid with characters
            rows.forEach(([x, char, y]) => {
                grid[y][x] = char;
            });

            // Print the grid
            grid.forEach(row => {
            console.log(row.join(''));
            });
        } else {
            console.error("Error: Failed to fetch the URL, status:", response.status);
        }
    } catch (error) {
        console.error("Error fetching or processing the URL:", error.message);
    }
}

// Use the provided URL or prompt for one
const url = 'https://docs.google.com/document/d/e/2PACX-1vQGUck9HIFCyezsrBSnmENk5ieJuYwpt7YHYEzeNJkIb9OSDdx-ov2nRNReKQyey-cwJOoEKUhLmN9z/pub';
main(url);