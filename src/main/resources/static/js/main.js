document.addEventListener("DOMContentLoaded", function () {

    const searchInput = document.getElementById("searchInput");
    const statusFilter = document.getElementById("statusFilter");
    const rows = document.querySelectorAll("#complaintTable tbody tr");

    function getRowStatus(row) {
        const badge = row.querySelector(".badge");
        return badge ? badge.textContent.trim() : "";
    }

    function updateAnalytics() {
        let total = 0;
        let open = 0;
        let progress = 0;
        let resolved = 0;

        rows.forEach(row => {
            if (row.style.display === "none") return;

            total++;
            const status = getRowStatus(row);

            if (status === "OPEN") open++;
            else if (status === "IN PROGRESS") progress++;
            else if (status === "RESOLVED") resolved++;
        });

        document.getElementById("totalCount").innerText = total;
        document.getElementById("openCount").innerText = open;
        document.getElementById("progressCount").innerText = progress;
        document.getElementById("resolvedCount").innerText = resolved;
    }

    function filterTable() {
        const searchText = searchInput.value.toLowerCase();
        const selectedStatus = statusFilter.value;

        rows.forEach(row => {
            const rowText = row.textContent.toLowerCase();
            const rowStatus = getRowStatus(row);

            const matchesSearch = rowText.includes(searchText);
            const matchesStatus =
                selectedStatus === "ALL" || rowStatus === selectedStatus.replace("_", " ");

            if (matchesSearch && matchesStatus) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        });

        updateAnalytics();
    }

    if (searchInput && statusFilter) {
        searchInput.addEventListener("keyup", filterTable);
        statusFilter.addEventListener("change", filterTable);
    }
	
    // Initial count on page load
    updateAnalytics();
});

//Dark mode

const toggleBtn = document.getElementById("themeToggle");
   const body = document.body;

   // Load saved theme
   if (localStorage.getItem("theme") === "dark") {
       body.classList.add("dark-mode");
       toggleBtn.innerText = "☀️";
   }

   toggleBtn.addEventListener("click", () => {
       body.classList.toggle("dark-mode");

       if (body.classList.contains("dark-mode")) {
           localStorage.setItem("theme", "dark");
           toggleBtn.innerText = "☀️";
       } else {
           localStorage.setItem("theme", "light");
           toggleBtn.innerText = "🌙";
       }
   });
   
   
// chatbot

    const chatToggle = document.getElementById("chatbot-toggle");
    const chatBox = document.getElementById("chatbot-container");

    chatToggle.addEventListener("click", () => {
        chatBox.style.display =
            chatBox.style.display === "block" ? "none" : "block";
    });


