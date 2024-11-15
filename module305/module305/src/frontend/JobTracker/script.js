document.addEventListener('DOMContentLoaded', () => {
    const jobData = [
        { title: "Software Engineer", company: "Tech Solutions", location: "Remote", salary: "$100,000", description: "Develop and maintain software applications.", stage: "Applied", roleType: "Full-time" },
        { title: "Data Scientist", company: "DataCorp", location: "Hybrid", salary: "$120,000", description: "Analyze and interpret complex data.", stage: "Interview", roleType: "Full-time" },
        { title: "Product Manager", company: "Innovative Co", location: "On-Site", salary: "$110,000", description: "Oversee product development lifecycle.", stage: "Phone Screen", roleType: "Part-time" },
        { title: "UX Designer", company: "DesignWorks", location: "Remote", salary: "$90,000", description: "Design user-centric interfaces.", stage: "Offer", roleType: "Contract" },
        { title: "Marketing Specialist", company: "MarketX", location: "Hybrid", salary: "$80,000", description: "Develop and implement marketing strategies.", stage: "Negotiation", roleType: "Part-time" },
        { title: "Front-End Developer", company: "Webify", location: "On-Site", salary: "$95,000", description: "Build and optimize user interfaces.", stage: "Rejected", roleType: "Contract" },
        { title: "Back-End Developer", company: "DevSquad", location: "Remote", salary: "$105,000", description: "Develop server-side logic and database integration.", stage: "Created", roleType: "Full-time" },
        { title: "QA Engineer", company: "Testify", location: "On-Site", salary: "$85,000", description: "Ensure software quality through testing.", stage: "Technical Interview", roleType: "Contract" },
        { title: "DevOps Engineer", company: "Cloudify", location: "Hybrid", salary: "$115,000", description: "Automate and optimize deployment pipelines.", stage: "Applied", roleType: "Full-time" },
        { title: "Business Analyst", company: "DataWorks", location: "Remote", salary: "$75,000", description: "Analyze and improve business processes.", stage: "Offer", roleType: "Part-time" },
        // Add more fake job data as needed
    ];

    let filteredJobs = jobData;

    // Function to display jobs in the left column
    function displayJobList() {
        const jobList = document.getElementById("jobList");
        jobList.innerHTML = "";

        filteredJobs.forEach(job => {
            const jobCard = document.createElement("div");
            jobCard.classList.add("list-group-item", "list-group-item-action", "shadow-sm", "p-4", "mb-2");
            jobCard.innerHTML = `
                <h5 class="mb-2">${job.title}</h5>
                <p class="text-muted mb-1">${job.company} | ${job.location}</p>
                <p class="text-muted">${job.salary}</p>
            `;
            jobCard.addEventListener("click", () => displayJobDetails(job));
            jobList.appendChild(jobCard);
        });
    }

    // Function to display job details in the right column
    function displayJobDetails(job) {
        const jobDetails = document.getElementById("jobDetails");
        jobDetails.innerHTML = `
            <h5 class="card-title">${job.title}</h5>
            <p><strong>Company:</strong> ${job.company}</p>
            <p><strong>Location:</strong> ${job.location}</p>
            <p><strong>Salary:</strong> ${job.salary}</p>
            <p><strong>Description:</strong> ${job.description}</p>
            <p><strong>Role Type:</strong> ${job.roleType}</p>
        `;
    }

    // Tab click event to filter jobs by stage
    document.getElementById("jobStagesTab").addEventListener("click", (e) => {
        const selectedStage = e.target.getAttribute("aria-controls");
        if (selectedStage) {
            if (selectedStage === "all") filteredJobs = jobData;
            else filteredJobs = jobData.filter(job => job.stage.toLowerCase() === selectedStage.toLowerCase());
            displayJobList();
        }
    });

    // Filter jobs based on search, role, or location
    document.getElementById("searchInput").addEventListener("input", filterJobs);
    document.getElementById("roleFilter").addEventListener("change", filterJobs);
    document.getElementById("locationFilter").addEventListener("change", filterJobs);

    function filterJobs() {
        const searchQuery = document.getElementById("searchInput").value.toLowerCase();
        const roleFilter = document.getElementById("roleFilter").value;
        const locationFilter = document.getElementById("locationFilter").value;

        filteredJobs = jobData.filter(job => {
            return (
                    job.title.toLowerCase().includes(searchQuery) ||
                    job.company.toLowerCase().includes(searchQuery) ||
                    job.description.toLowerCase().includes(searchQuery)
                ) &&
                (roleFilter ? job.roleType.toLowerCase() === roleFilter.toLowerCase() : true) &&
                (locationFilter ? job.location.toLowerCase() === locationFilter.toLowerCase() : true);
        });

        displayJobList();
    }

    // Initial display of job list
    displayJobList();
});