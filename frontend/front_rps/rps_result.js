window.onload = function () {
  if (localStorage.getItem("src")) {
    var rps = localStorage.getItem("src");
    document.getElementById("rps").src = rps;
  }

  if (localStorage.getItem("menu")) {
    var menu = localStorage.getItem("menu");
    document.getElementById("menu").innerHTML = menu;
  }

  if (localStorage.getItem("name")) {
    var people = localStorage.getItem("name");
    document.getElementById(
      "name"
    ).innerHTML = `<div id="name">'${people}' <span>승!</span></div>`;
  }

  if (localStorage.getItem("menuUrl") != null) {
    var menuUrl = localStorage.getItem("menuUrl");
    document.getElementById("menu_img").src = menuUrl;
  }
};
