var value = 2;
var winner_name;
var winner_menu;
var winner_src;
localStorage.clear();

function addItem() {
  offStartButton();

  const arr = Array.from(Array(value), () => Array(2).fill(null));

  for (var i = 0; i < value; i++) {
    if (document.getElementsByClassName("rps_input_name")[i].readOnly == true) {
      var nameVal = document.getElementsByClassName("rps_input_name")[i].value;
      var menuVal = document.getElementsByClassName("rps_input_menu")[i].value;
      arr[i][0] = nameVal;
      arr[i][1] = menuVal;
    }
  }

  value++;
  var num = document.getElementById("rps_input_num");
  num.textContent = String(value);

  const par = document.getElementById("rps_input_inputItem");
  var id = "item" + String(value);

  let rand_rps_num = Math.floor(Math.random() * 3);
  let imgName = ["r", "s", "p"];

  par.innerHTML += `<div class="rps_input_item_box" id=${id}>
  <div class="rps_input_item_container">
    <img class="rps_input_rps_img" src="./img_rps/img_${imgName[rand_rps_num]}_gray.svg" width="60px" />
    <input class="rps_input_name" placeholder="이름 입력" />
    <input class="rps_input_menu" placeholder="메뉴 입력" />
    <button type="button" class="image">
      <img
        class="rps_input_edit_img"
        src="./img_rps/edit_button.svg"
        alt="수정버튼"
        width="35px"
        onClick="editValue(${value})"
      />
    </button>
  </div>
  <img class="rps_input_check_img" src="./img_rps/img_check.svg" alt="저장버튼" width="80px" onClick="saveValue(${value})"/>
</div>`;

  for (var i = 0; i < value - 1; i++) {
    var item_rps_name = document.getElementsByClassName("rps_input_name")[i];
    var item_rps_menu = document.getElementsByClassName("rps_input_menu")[i];
    if (item_rps_name.readOnly == true) {
      item_rps_name.readOnly = true;
      item_rps_menu.readOnly = true;
      item_rps_name.value = arr[i][0];
      item_rps_menu.value = arr[i][1];
    }
  }
}

function removeItem() {
  if (value < 3) {
    alert("최소 2개부터 설정해주세요.");
  } else {
    let child_element = document.getElementById("item" + value);
    let parent_element = child_element.parentElement;
    parent_element.removeChild(child_element);

    value--;
    var num = document.getElementById("rps_input_num");
    num.textContent = String(value);
  }
  blockNext();
}

function saveValue(itemNum) {
  var id = Number(itemNum) - 1;
  var item_rps_name = document.getElementsByClassName("rps_input_name")[id];
  var item_rps_menu = document.getElementsByClassName("rps_input_menu")[id];
  var nameVal = item_rps_name.value;
  var menuVal = document.getElementsByClassName("rps_input_menu")[id].value;
  if (menuVal == "") {
    alert("메뉴를 입력해주세요.");
  } else {
    item_rps_name.readOnly = true;
    item_rps_menu.readOnly = true;
    item_rps_name.value = nameVal;
    item_rps_menu.value = menuVal;
    document.getElementsByClassName("rps_input_item_container")[
      id
    ].style.backgroundColor = "#f9f8ec";
    item_rps_menu.style.backgroundColor = "#ebeb99";
    document.getElementsByClassName("rps_input_item_container")[
      id
    ].style.border = "none";
    var rps_src = document.getElementsByClassName("rps_input_rps_img")[id].src;
    rps_src = String(rps_src).slice(0, -9);
    document.getElementsByClassName("rps_input_rps_img")[id].src =
      rps_src + ".svg";
    document.getElementsByClassName("rps_input_check_img")[
      id
    ].style.visibility = "hidden";
    document.getElementsByClassName("rps_input_edit_img")[id].style.visibility =
      "visible";
    item_rps_name.style.borderBottom = "none";
  }
  finishPage();
}

function blockNext() {
  var block = 0;
  for (var i = 0; i < value; i++) {
    if (
      document.getElementsByClassName("rps_input_name")[i].readOnly == false
    ) {
      block = 1;
    }
  }

  if (block == 1) {
    offStartButton();
  } else {
    finishPage();
  }
}

function editValue(itemNum) {
  itemNum = itemNum - 1;
  var rps_src =
    document.getElementsByClassName("rps_input_rps_img")[itemNum].src;

  document.getElementsByClassName("rps_input_name")[itemNum].readOnly = false;
  document.getElementsByClassName("rps_input_menu")[itemNum].readOnly = false;
  document.getElementsByClassName("rps_input_item_container")[
    itemNum
  ].style.backgroundColor = "#FFFEFB";
  document.getElementsByClassName("rps_input_menu")[
    itemNum
  ].style.backgroundColor = "#f9f8ec";
  document.getElementsByClassName("rps_input_edit_img")[
    itemNum
  ].style.visibility = "hidden";
  rps_src = String(rps_src).slice(0, -4);
  document.getElementsByClassName("rps_input_rps_img")[itemNum].src =
    rps_src + "_gray.svg";
  document.getElementsByClassName("rps_input_check_img")[
    itemNum
  ].style.visibility = "visible";
  document.getElementsByClassName("rps_input_item_container")[
    itemNum
  ].style.border = "1px solid #9B9B9B";
  document.getElementsByClassName("rps_input_name")[
    itemNum
  ].style.borderBottom = "1px solid #ccc";
  blockNext();
}

function finishPage() {
  var finish = 1;
  for (var i = 0; i < value; i++) {
    if (
      document.getElementsByClassName("rps_input_menu")[i].readOnly == false
    ) {
      finish = 0;
      break;
    }
  }
  if (finish == 1) {
    document
      .querySelector("#next_img")
      .setAttribute("src", "./img_rps/next_button.svg");
    document.getElementById("next_img").setAttribute("onClick", "hrefLink();");
    $("#next_img").css("cursor", "pointer");
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
  pickWinner();
  connect_server();
}

function offStartButton() {
  document
    .querySelector("#next_img")
    .setAttribute("src", "./img_rps/next_button_gray.svg");
  document.getElementById("next_img").removeAttribute("onClick");
  $("#next_img").css("cursor", "default");
}

function pickWinner() {
  let rand_num = Math.floor(Math.random() * value);
  winner_name =
    document.getElementsByClassName("rps_input_name")[rand_num].value;
  winner_menu =
    document.getElementsByClassName("rps_input_menu")[rand_num].value;
  winner_src =
    document.getElementsByClassName("rps_input_rps_img")[rand_num].src;
  winner_src = String(winner_src).slice(0, -4);
  winner_src = winner_src + "_sign.svg";
  if (winner_name == "") {
    winner_name = winner_menu + " 먹고 싶은 사람";
  }
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
