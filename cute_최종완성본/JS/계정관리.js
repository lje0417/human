document.addEventListener("DOMContentLoaded", function () {
    const approveButton = document.querySelector(".btn");
    const cancelButton = document.querySelector(".btn1");
    
    approveButton.addEventListener("click", function () {
        handleApprovalOrCancellation("승인되었습니다");
    });

    cancelButton.addEventListener("click", function () {
        handleApprovalOrCancellation("취소되었습니다");
    });

    function handleApprovalOrCancellation(message) {
        const checkboxes = document.querySelectorAll(".chk");
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                const divToRemove = checkbox.closest(".flex");
                divToRemove.remove();
            }
        });
        alert(message);
    }
});
