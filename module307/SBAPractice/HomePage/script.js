const switchPeopleBtn = document.getElementById("switchPeopleBtn");
const switchJobBtn = document.getElementById("switchJobBtn");
const newPeopleBtn = document.getElementById("newPeopleBtn");
const newJobBtn = document.getElementById("newJobBtn");
const toggleBtn = document.getElementById("toggleBtn");

toggleBtn.addEventListener('click', function() {
    let left = document.getElementsByClassName('left-section').item(0);
    if (left.style.display === "block") {
        left.style.display = "none";
        toggleBtn.classList.replace("fa-circle-arrow-left","fa-bars");
    }
    else {
        left.style.display = "block";
        toggleBtn.classList.replace("fa-bars", "fa-circle-arrow-left");
    }
});

switchJobBtn.addEventListener('click', function() {
    if (switchJobBtn.classList.contains("active")) {
        // add a new toggling form appear to add new job posting.
    } else {
        switchPeopleBtn.classList.remove('active');
        document.querySelector('#newJobBtn').style.display = 'block';
        document.querySelector('#newPeopleBtn').style.display = 'none';
        displayJobPostings();
    }
});

switchPeopleBtn.addEventListener('click', function() {
    if (switchPeopleBtn.classList.contains("active")) {
        // add a new toggling form appear to add new job posting.
    } else {
        switchJobBtn.classList.remove('active');
        document.querySelector('#newPeopleBtn').style.display = 'block';
        document.querySelector('#newJobBtn').style.display = 'none';
        displayPeople();
    }
});

switchPeopleBtn.addEventListener('mouseover', function() {
    if (switchPeopleBtn.classList.contains("active")) {
        newPeopleBtn.style.backgroundColor = "hsl(180, 29%, 40%)";
    }
});

switchPeopleBtn.addEventListener('mouseout', function() {
    if (switchPeopleBtn.classList.contains("active")) {
        newPeopleBtn.style.backgroundColor = "hsl(180, 29%, 45%)";
    }
});

switchJobBtn.addEventListener('mouseover', function() {
    if (switchJobBtn.classList.contains("active")) {
        newJobBtn.style.backgroundColor = "hsl(180, 29%, 40%)";
    }
});

switchJobBtn.addEventListener('mouseout', function() {
    if (switchJobBtn.classList.contains("active")) {
        newJobBtn.style.backgroundColor = "hsl(180, 29%, 45%)";
    }
});

const jobsData = [
    {
        companyLogo: "./assets/company-logo/amazon.png",
        companyName: "Amazon",
        positionTitle: "Customer Support Lead",
        dateCreated: "05/10/2024",
        roleType: "Part-time",
        location: "Seattle",
        officeType: "Remote",
        moreDetailsUrl: "#",
    },
    {
        companyLogo: "./assets/company-logo/insure.svg",
        companyName: "Insure",
        positionTitle: "Junior Frontend Developer",
        dateCreated: "01/01/2024",
        roleType: "Full-time",
        location: "New York",
        officeType: "Hybrid",
        moreDetailsUrl: "#",
    },
    {
        companyLogo: "./assets/company-logo/eyecam-co.svg",
        companyName: "TechWave",
        positionTitle: "Junior Backend Developer",
        dateCreated: "01/15/2024",
        roleType: "Full-time",
        location: "New York",
        officeType: "Hybrid",
        moreDetailsUrl: "#",
    },
    {
        companyLogo: "./assets/company-logo/faceit.svg",
        companyName: "Global Solutions",
        positionTitle: "Product Manager",
        dateCreated: "02/01/2024",
        roleType: "Full-time",
        location: "Los Angeles",
        officeType: "Remote",
        moreDetailsUrl: "#",
    },
    {
        companyLogo: "./assets/company-logo/loop-studios.svg",
        companyName: "Bright Future Inc.",
        positionTitle: "DevOps Engineer",
        dateCreated: "02/10/2024",
        roleType: "Full-time",
        location: "San Francisco",
        officeType: "Hybrid",
        moreDetailsUrl: "#",
    },
    {
        companyLogo: "./assets/company-logo/photosnap.svg",
        companyName: "DataCorp",
        positionTitle: "Junior Data Scientist",
        dateCreated: "03/01/2024",
        roleType: "Intern",
        location: "Chicago",
        officeType: "Remote",
        moreDetailsUrl: "#",
    },
    {
        companyLogo: "./assets/company-logo/shortly.svg",
        companyName: "DesignPro",
        positionTitle: "UX/UI Designer",
        dateCreated: "03/10/2024",
        roleType: "Full-time",
        location: "Miami",
        officeType: "Hybrid",
        moreDetailsUrl: "#",
    },
];

// Function to create and insert job item HTML
// displayJobPostings();
function displayJobPostings() {
    const jobList = document.getElementById("right-section"); // Get the container
    document.getElementById("switchJobBtn").classList.add("active");
    jobList.innerHTML = '';
    jobsData.forEach(job => {
        const jobItem = document.createElement("li");
        jobItem.classList.add("job-item");

        jobItem.innerHTML = `
            <div class="company-logo">
                <img src="${job.companyLogo}" alt="Company Logo">
            </div>
            <ul class="job-details">
                <li class="company-name">${job.companyName}</li>
                <li class="position-title">${job.positionTitle}</li>
                <li class="additional-info">
                    <span class="date-created">${job.dateCreated}</span>
                    <span>•</span>
                    <span class="role-type">${job.roleType}</span>
                    <span>•</span>
                    <span class="location">${job.location}</span>
                    <span>•</span>
                    <span class="office-type">${job.officeType}</span>
                </li>
            </ul>
            <a class="more-details" href="${job.moreDetailsUrl}">
                <span>More Details</span>
                <span> &#9660; </span>
            </a>
        `;
        jobList.appendChild(jobItem);
    });
}

const peopleData = [
    {
        name: "John Smith",
        photo: "./assets/photos/john-smith.jpg",
        phone: "+1 (555) 123-4567",
        email: "john.smith@example.com",
        linkedin: "https://www.linkedin.com/in/john-smith",
        typeOfRelationship: "Recruiter"
    },
    {
        name: "Emily Johnson",
        photo: "./assets/photos/emily-johnson.jpg",
        phone: "+1 (555) 987-6543",
        email: "emily.johnson@example.com",
        linkedin: "https://www.linkedin.com/in/emily-johnson",
        typeOfRelationship: "Referral"
    },
    {
        name: "Michael Lee",
        photo: "./assets/photos/michael-lee.jpg",
        phone: "+1 (555) 567-8901",
        email: "michael.lee@example.com",
        linkedin: "https://www.linkedin.com/in/michael-lee",
        typeOfRelationship: "Friend"
    },
    {
        name: "Sarah Brown",
        photo: "./assets/photos/sarah-brown.jpg",
        phone: "+1 (555) 234-5678",
        email: "sarah.brown@example.com",
        linkedin: "https://www.linkedin.com/in/sarah-brown",
        typeOfRelationship: "Family"
    },
    {
        name: "David Wilson",
        photo: "./assets/photos/david-wilson.jpg",
        phone: "+1 (555) 345-6789",
        email: "david.wilson@example.com",
        linkedin: "https://www.linkedin.com/in/david-wilson",
        typeOfRelationship: "Mentor"
    },
    {
        name: "Sophia Martinez",
        photo: "./assets/photos/sophia-martinez.jpg",
        phone: "+1 (555) 456-7890",
        email: "sophia.martinez@example.com",
        linkedin: "https://www.linkedin.com/in/sophia-martinez",
        typeOfRelationship: "Colleague"
    },
    {
        name: "James Anderson",
        photo: "./assets/photos/james-anderson.jpg",
        phone: "+1 (555) 567-8901",
        email: "james.anderson@example.com",
        linkedin: "https://www.linkedin.com/in/james-anderson",
        typeOfRelationship: "Recruiter"
    },
    {
        name: "Linda Clark",
        photo: "./assets/photos/linda-clark.jpg",
        phone: "+1 (555) 678-9012",
        email: "linda.clark@example.com",
        linkedin: "https://www.linkedin.com/in/linda-clark",
        typeOfRelationship: "Referral"
    }
];
displayPeople();
document.querySelector('#newPeopleBtn').style.display = 'block';
document.querySelector('#newJobBtn').style.display = 'none';

function displayPeople() {
    const peopleList = document.getElementById("right-section");
    document.getElementById("switchPeopleBtn").classList.add("active");
    peopleList.innerHTML = '';
    peopleData.forEach(person => {
        const item = document.createElement("li");
        item.classList.add("job-item");

        item.innerHTML = `
            <div class="company-logo">
                <img src="${person.photo}" alt="Photo">
            </div>
            <ul class="job-details">
                <li class="company-name">${person.typeOfRelationship}</li>
                <li class="position-title">${person.name}</li>
                <li class="additional-info">
                    <a class="email" href="${person.phone}">${person.phone}</a>
                    <span>•</span>
                    <a class="email" href="${person.email}">
                        <span class="fa-solid fa-envelope"></span>/${person.email.split('@')[0]}
                    </a>
                    <span>•</span>
                    <a class="linkedin" href="${person.linkedin}">
                        <span class="fa-brands fa-linkedin"></span>/${person.linkedin.split('/').pop()}
                    </a>
                </li>
            </ul>
            <a class="more-details" href="${person.moreDetailsUrl}">
                <span>More Details</span>
                <span> &#9660; </span>
            </a>
        `;
        peopleList.appendChild(item);
    });
}