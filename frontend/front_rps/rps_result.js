window.onload = function () {
  if (localStorage.getItem("src")) {
    var rps = localStorage.getItem("src");
    document.getElementById("rps").src = rps;
  }

  var menuImg = localStorage.getItem("menuUrl");
  console.log(menuImg);

  if (menuImg === undefined || menuImg == null || menuImg == "undefined") {
    console.log(menuImg);
    document.getElementById("menu_img").src = "./img_rps/rps_default_img.svg";
  } else {
    console.log(menuImg);
    var menuUrl = menuImg;
    document.getElementById("menu_img").src = menuUrl;
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
};
