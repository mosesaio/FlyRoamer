document.addEventListener("DOMContentLoaded", function() {
    const cityDropdown = document.querySelector("select[name='cityIds']");
    const activityContainer = document.querySelector("#activityContainer");

    if (cityDropdown) {
        cityDropdown.addEventListener("change", function() {
            updateActivities();
        });
    }

    function updateActivities() {
        activityContainer.innerHTML = ""; // Clear previous activities
    }

    // Prevent form submission if no city or activity is selected
    const tripForm = document.querySelector("form");
    if (tripForm) {
        tripForm.addEventListener("submit", function(event) {
            const selectedCities = cityDropdown.selectedOptions.length;
            const selectedActivities = document.querySelectorAll("input[name='activityIds']:checked").length;

            if (selectedCities === 0 || selectedActivities === 0) {
                event.preventDefault();
                alert("Please select at least one city and one activity before submitting.");
            }
        });
    }
});
