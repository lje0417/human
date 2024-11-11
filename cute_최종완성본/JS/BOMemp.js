document.addEventListener("DOMContentLoaded", function() {
    const recipeSelect = document.getElementById("recipeSelect");
    const kimchiTable = document.querySelector(".kimchi");
    const meatTable = document.querySelector(".meat");

    recipeSelect.addEventListener("change", function() {
        if (recipeSelect.value === "kimchi") {
            kimchiTable.style.display = "table";
            meatTable.style.display = "none";
        } else {
            kimchiTable.style.display = "none";
            meatTable.style.display = "table";
        }
    });

    kimchiTable.style.display = "table";
    meatTable.style.display = "none";
});
