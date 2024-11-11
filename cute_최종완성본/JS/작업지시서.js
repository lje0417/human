let work = document.querySelector(".work")

work.addEventListener("change", function () {
    if (work.value == "work1") {
        work.parentNode.style.backgroundColor = "lightblue";
    } else if(work.value == "work2"){
        work.parentNode.style.backgroundColor = "lightgreen";
    } else if(work.value == "work3"){
        work.parentNode.style.backgroundColor = "yellow";
    } else if(work.value == "work4"){
        work.parentNode.style.backgroundColor = "red";
    } else{
        work.parentNode.style.backgroundColor = " ";
    }
});