const jobTodoList = [
    { finished: false, dueDate: "2024-12-11", title: "Update Resume", details: "Revise and tailor the resume for the software engineering position." },
    { finished: true, dueDate: "2024-12-09", title: "Research Companies", details: "Look into companies hiring for roles in software engineering and data analysis." },
    { finished: false, dueDate: "2024-12-15", title: "Write Cover Letter", details: "Draft a personalized cover letter for the Experient Group application." },
    { finished: false, dueDate: "2024-12-18", title: "Prepare for Interviews", details: "Practice common interview questions and behavioral responses." },
    { finished: true, dueDate: "2024-12-08", title: "LinkedIn Updates", details: "Ensure the LinkedIn profile is up-to-date with skills and projects." },
    { finished: false, dueDate: "2024-12-20", title: "Apply to Jobs", details: "Submit applications to at least 5 targeted job positions." },
    { finished: true, dueDate: "2024-12-06", title: "Connect with Referrals", details: "Reach out to connections for potential referrals at target companies." },
    { finished: false, dueDate: "2024-12-17", title: "Follow Up on Applications", details: "Send follow-up emails for applications submitted earlier this month." },
    { finished: false, dueDate: "2024-12-22", title: "Portfolio Update", details: "Add recent projects to the portfolio website for potential employers." },
    { finished: true, dueDate: "2024-12-05", title: "Attend Networking Event", details: "Participate in the virtual tech networking event." }
];


// Populate the table with data
const tableBody = document.getElementById('todo-table-body');
const searchInput = document.getElementById('todo-search-input');
const addTaskBtn = document.getElementById('add-task-btn');
const modal = document.getElementById('add-task-modal');
const modalOverlay = document.getElementById('modal-overlay');
const addTaskForm = document.getElementById('add-task-form');
const taskTitleInput = document.getElementById('task-title');
const taskDueDateInput = document.getElementById('task-due-date');
const taskDetailsInput = document.getElementById('task-details');
const closeModalBtn = document.getElementById('close-modal-btn');
const dueDateHeader = document.getElementById('due-date-header');
let sortAscending = true;


// Initialize the table with all tasks
populateTable(jobTodoList);
function populateTable(data) {
    tableBody.innerHTML = "";
    data.forEach((task, index) => {
        const row = document.createElement('tr');
        // Add 'finished' class for completed tasks
        if (task.finished) {
            row.classList.add('finished');
        }
        row.innerHTML = `
                    <td class="finished-cell" data-index="${index}">
                        <input type="checkbox" ${task.finished ? "checked" : ""}>
                    </td>
                    <td>${task.dueDate}</td>
                    <td>${task.title}</td>
                    <td>${task.details}</td>
                `;
        tableBody.appendChild(row);
    });
}

// Event listener to toggle the "Finished" status
tableBody.addEventListener('click', function(event) {
    if (event.target.type === 'checkbox') {
        const index = event.target.closest('td').getAttribute('data-index');
        const task = jobTodoList[index];
        task.finished = event.target.checked; // Update finished status based on checkbox
        populateTable(jobTodoList);
    }
});

searchInput.addEventListener('input', () => {
    const keyword = searchInput.value.toLowerCase();

    const filteredTasks = jobTodoList.filter(task =>
        task.title.toLowerCase().includes(keyword) ||
        task.details.toLowerCase().includes(keyword)
    );

    populateTable(filteredTasks);
});

// Add Task functionality
addTaskBtn.addEventListener('click', () => {
    modal.classList.add('show');
    modalOverlay.classList.add('show');
});

addTaskForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const newTask = {
        finished: false,
        dueDate: taskDueDateInput.value,
        title: taskTitleInput.value,
        details: taskDetailsInput.value
    };
    jobTodoList.push(newTask);
    populateTable(jobTodoList);
    modal.classList.remove('show');
    modalOverlay.classList.remove('show');
    addTaskForm.reset();
});

// Close Modal
closeModalBtn.addEventListener('click', () => {
    modal.classList.remove('show');
    modalOverlay.classList.remove('show');
});

modalOverlay.addEventListener('click', () => {
    modal.classList.remove('show');
    modalOverlay.classList.remove('show');
});

dueDateHeader.addEventListener('click', () => {
    sortAscending = !sortAscending;
    const sortedData = [...jobTodoList].sort((a, b) => {
        const dateA = new Date(a.dueDate);
        const dateB = new Date(b.dueDate);
        return sortAscending ? dateA - dateB : dateB - dateA;
    });
    populateTable(sortedData);

    // Update header style
    dueDateHeader.classList.toggle('sort-asc', sortAscending);
    dueDateHeader.classList.toggle('sort-desc', !sortAscending);
});

const radioButtons = document.querySelectorAll('input[name="filter"]');

// Add event listeners to radio buttons
radioButtons.forEach(radio => {
    radio.addEventListener('change', (event) => {
        filterTasks(event.target.value);
    });
});

// Filter the data based on selected view
function filterTasks(filter) {
    if (filter === 'all') {
        filteredData = jobTodoList;
    } else if (filter === 'active') {
        filteredData = jobTodoList.filter(task => !task.finished);
    } else if (filter === 'completed') {
        filteredData = jobTodoList.filter(task => task.finished);
    }
    populateTable(filteredData);
}