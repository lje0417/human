let approval = document.querySelector(".btn");


approval.addEventListener('click', function() {
    let checkboxes = document.querySelectorAll('.chk:checked');
    checkboxes.forEach(function(checkbox) {
        let parentDiv = checkbox.closest('.round');
        alert("출하되었습니다")
        if (parentDiv) {
            parentDiv.remove();
        }
    });
});

