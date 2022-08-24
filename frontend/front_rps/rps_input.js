var value = 2;
var winner_name;
var winner_menu;
var winner_src;
localStorage.clear();

function addItem() {
  document
    .querySelector("#next_img")
    .setAttribute("src", "./img_rps/next_button_gray.svg");
  document.getElementById("next_img").removeAttribute("onClick");
  document.getElementById("next_img").removeAttribute("onClick");
  $("#next_img").css("cursor", "default");

  const arr = Array.from(Array(value), () => Array(2).fill(null));

  for (var i = 0; i < value; i++) {
    if (document.getElementsByClassName("rps_name")[i].readOnly == true) {
      var nameVal = document.getElementsByClassName("rps_name")[i].value;
      var menuVal = document.getElementsByClassName("rps_menu")[i].value;
      arr[i][0] = nameVal;
      arr[i][1] = menuVal;
    }
  }

  value++;
  var num = document.getElementById("num");
  num.textContent = String(value);

  const par = document.getElementById("inputItem");
  var id = "item" + String(value);

  let randomNumber = Math.floor(Math.random() * 3);
  let imgName = ["r", "s", "p"];

  par.innerHTML += `<div class="item_box" id=${id}>
  <div class="item_container">
    <img class="rps_img" src="./img_rps/img_${imgName[randomNumber]}_gray.svg" width="60px" />
    <input class="rps_name" placeholder="이름 입력" />
    <input class="rps_menu" placeholder="메뉴 입력" />
    <button type="button" class="image">
      <img
        class="edit_img"
        src="./img_rps/edit_button.svg"
        width="35px"
        onClick="editValue(${value})"
      />
    </button>
  </div>
  <img class="check_img" src="./img_rps/img_check.svg" width="80px" onClick="saveValue(${value})"/>
</div>`;

  for (var i = 0; i < value - 1; i++) {
    if (document.getElementsByClassName("rps_name")[i].readOnly == true) {
      document.getElementsByClassName("rps_name")[i].readOnly = true;
      document.getElementsByClassName("rps_menu")[i].readOnly = true;
      document.getElementsByClassName("rps_name")[i].value = arr[i][0];
      document.getElementsByClassName("rps_menu")[i].value = arr[i][1];
    }
  }
}

function removeItem() {
  if (value < 3) {
    alert("최소 2개부터 설정해주세요.");
  } else {
    let chi = document.getElementById("item" + value);
    let chio = chi.parentElement;
    chio.removeChild(chi);

    value--;
    var num = document.getElementById("num");
    num.textContent = String(value);
  }
  blockNext();
}

function saveValue(itemNum) {
  var id = Number(itemNum) - 1;
  var nameVal = document.getElementsByClassName("rps_name")[id].value;
  var menuVal = document.getElementsByClassName("rps_menu")[id].value;
  if (menuVal == "") {
    alert("메뉴를 입력해주세요.");
  } else {
    document.getElementsByClassName("rps_name")[id].readOnly = true;
    document.getElementsByClassName("rps_menu")[id].readOnly = true;
    document.getElementsByClassName("rps_name")[id].value = nameVal;
    document.getElementsByClassName("rps_menu")[id].value = menuVal;
    document.getElementsByClassName("item_container")[
      id
    ].style.backgroundColor = "#f9f8ec";
    document.getElementsByClassName("rps_menu")[id].style.backgroundColor =
      "#ebeb99";
    document.getElementsByClassName("item_container")[id].style.border = "none";
    var rps = document.getElementsByClassName("rps_img")[id].src;
    rps = String(rps).slice(0, -9);
    document.getElementsByClassName("rps_img")[id].src = rps + ".svg";
    document.getElementsByClassName("check_img")[id].style.visibility =
      "hidden";
    document.getElementsByClassName("edit_img")[id].style.visibility =
      "visible";
    document.getElementsByClassName("rps_name")[id].style.borderBottom = "none";
  }
  finishPage();
}

function blockNext() {
  var block = 0;
  for (var i = 0; i < value; i++) {
    if (document.getElementsByClassName("rps_name")[i].readOnly == false) {
      block = 1;
    }
  }

  if (block == 1) {
    document
      .querySelector("#next_img")
      .setAttribute("src", "./img_rps/next_button_gray.svg");
    document.getElementById("next_img").removeAttribute("onClick");
    $("#next_img").css("cursor", "default");
  } else {
    finishPage();
  }
}

function editValue(itemNum) {
  itemNum = itemNum - 1;
  var rps = document.getElementsByClassName("rps_img")[itemNum].src;

  document.getElementsByClassName("rps_name")[itemNum].readOnly = false;
  document.getElementsByClassName("rps_menu")[itemNum].readOnly = false;
  document.getElementsByClassName("item_container")[
    itemNum
  ].style.backgroundColor = "#FFFEFB";
  document.getElementsByClassName("rps_menu")[itemNum].style.backgroundColor =
    "#f9f8ec";
  document.getElementsByClassName("edit_img")[itemNum].style.visibility =
    "hidden";
  rps = String(rps).slice(0, -4);
  document.getElementsByClassName("rps_img")[itemNum].src = rps + "_gray.svg";
  document.getElementsByClassName("check_img")[itemNum].style.visibility =
    "visible";
  document.getElementsByClassName("item_container")[itemNum].style.border =
    "1px solid #9B9B9B";
  document.getElementsByClassName("rps_name")[itemNum].style.borderBottom =
    "1px solid #ccc";
  blockNext();
}

function finishPage() {
  var finish = 1;
  for (var i = 0; i < value; i++) {
    if (document.getElementsByClassName("rps_menu")[i].readOnly == false) {
      finish = 0;
      break;
    }
  }
  if (finish == 1) {
    document
      .querySelector("#next_img")
      .setAttribute("src", "./img_rps/next_button.svg");
    document
      .getElementById("next_img")
      .setAttribute("onClick", "connect_server();");
    $("#next_img").css("cursor", "pointer");
    let randNum = Math.floor(Math.random() * value);
    winner_name = document.getElementsByClassName("rps_name")[randNum].value;
    winner_menu = document.getElementsByClassName("rps_menu")[randNum].value;
    winner_src = document.getElementsByClassName("rps_img")[randNum].src;
    winner_src = String(winner_src).slice(0, -4);
    winner_src = winner_src + "_sign.svg";
    if (winner_name == "") {
      winner_name = winner_menu + " 먹고 싶은 사람";
    }
  }
}

async function connect_server() {
  // 서버 연결
  let params = {
    name: winner_menu,
  };

  let query = Object.keys(params).map(
    (k) => encodeURIComponent(k) + "=" + encodeURIComponent(params[k])
  );

  let url = "https://mwomeokji.shop/dishes?" + query;

  const response = await fetch(url);
  const data = await response.json();

  console.log(data);
  localStorage.setItem("menuUrl", data.imageUrl);
  localStorage.setItem("name", winner_name);
  localStorage.setItem("menu", winner_menu);
  localStorage.setItem("src", winner_src);

  location.href = "./rps_loading.html";
}

function hrefLink() {
  connect_server();
}

$(function () {
  $(window).scroll(function () {
    if ($(this).scrollTop() > 250) {
      console.log($(this).scrollTop());
      $("#top_button").fadeIn();
    } else {
      $("#top_button").fadeOut();
    }
  });
  $("#top_button").click(function () {
    $("html, body").animate(
      {
        scrollTop: 0,
      },
      400
    );
    return false;
  });
});
