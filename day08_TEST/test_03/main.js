const buttons = document.querySelectorAll(".tab-button");
const contentList = document.getElementById("content-list");

async function fetchAndDisplayData(apiUrl) {
  contentList.innerHTML = "<li>Loading...</li>";

  try {
    const response = await fetch(apiUrl);
    const data = await response.json();
    const randomItems = data
      .sort(() => 0.5 - Math.random()) 
      .slice(0, 5); 

    contentList.innerHTML = randomItems
      .map((item) => `<li>${item.title || item.name}</li>`) 
      .join("");
  } catch (error) {
    contentList.innerHTML = "<li>Error loading data.</li>";
  }
}

buttons.forEach((button) => {
  button.addEventListener("click", () => {  
    buttons.forEach((btn) => btn.classList.remove("active"));  
    button.classList.add("active");   
    const apiUrl = button.getAttribute("data-api");
    fetchAndDisplayData(apiUrl);
  });
});


const initialApi = document
  .querySelector(".tab-button.active")
  .getAttribute("data-api");
fetchAndDisplayData(initialApi);
