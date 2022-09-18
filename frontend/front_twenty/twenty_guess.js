var food_data = []; // api로 fetch받은 데이터
var question_length = []; // 질문마다 길이가 저장됨
var guess_start_check = 0;
var choose_record = [];
console.log("콘솔 시작");
function slide() {
  $(".slide").animate({ marginLeft: "-56.25rem" }, 400);
  $(".guess_slide").animate({ marginLeft: "-12.5rem" }, 400);
  $(".slide").animate({ marginLeft: "68.75rem" }, 0000, function () {
    next_guess();
  });
  $(".guess_slide").animate({ marginLeft: "56.25rem" }, 0000);
  $(".slide").animate({ marginLeft: "0rem" }, 400);
  $(".guess_slide").animate({ marginLeft: "0rem" }, 700);
}

//시간 지연을 위해 사용
function sleep(ms) {
  const wakeUpTime = Date.now() + ms;
  while (Date.now() < wakeUpTime) {}
}

//fetch 시작
async function getjson() {
  console.log("api 실행");
  const response = await fetch(`https://mwomeokji.shop/questions/dishes`);
  const data = await response.json();
  food_data = data;
  for (key in data) {
    question_length.push(data[key].question.length); // 문자열 뒤에 length를 붙이는 것만으로 길이 측정
  }

  if (guess_start_check == 0) {
    next_guess();
    guess_start_check = 1;
  }
  return data;
}

var rst = []; // 질문들이 랜덤하게 들어있고 안에 그 순서가 지정되있다
function getRandom(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

// 랜덤하게 추출 (array Ver)
function getRandomArray(min, max, count) {
  if (max - min + 1 < count) return;
  while (1) {
    var index = getRandom(min, max);
    // 중복 여부를 체크
    if (rst.indexOf(index) > -1) {
      continue;
    }
    rst.push(index);
    if (rst.length == count) {
      break;
    }
  }
}

getRandomArray(0, 44, 45);

var target = document.getElementById("guess_text");
var length = question_length[rst[guess_order]];

var guess_order = 0;
var clicked_count = 0;

function next_guess() {
  data = getjson();
  const guessElement = document.getElementById("guess_text");
  try {
    guessElement.innerText = food_data[rst[guess_order]].question;
  } catch {
    return 0;
  }

  if (food_data[rst[guess_order]].question.length > 20) {
    $("#background_changed_location").css({
      width: "25rem",
      left: "-7.5rem",
    });

    $("#guess_text").css({
      width: "25rem",
      left: "-0.625rem",
    });
    document.getElementById("background_changed").src =
      "./img_file_twenty/twenty_guess_guess_long.svg";
  } else {
    $("#background_changed_location").css({
      width: "6.25rem",
      left: "-11.25rem",
    });
    $("#guess_text").css({
      width: "18.75rem",
      right: "-1.25rem",
    });
    document.getElementById("background_changed").src =
      "./img_file_twenty/twenty_guess_guess_background.svg";
  }
}
var arr = {};
function make_arr() {
  for (var order = 1; order < 106; order++) {
    arr[order] = 0;
  }
}
make_arr();

function like() {
  guess_order = guess_order + 1;
  clicked_count += 1;
  if (clicked_count > 45) {
    choose();
  }
  bar_progress();

  for (smallkey in food_data[rst[guess_order - 1]].dishes) {
    arr[food_data[rst[guess_order - 1]].dishes[smallkey].id] += 1;
  }
  choose_record[guess_order] = 1;
}

function dislike() {
  guess_order = guess_order + 1;
  if (clicked_count > 45) {
    choose();
  }
  bar_progress();

  for (smallkey in food_data[rst[guess_order - 2]].dishes) {
    arr[food_data[rst[guess_order - 2]].dishes[smallkey].id] -= 1;
  }
  choose_record[guess_order] = -1;
}

function normal() {
  guess_order = guess_order + 1;
  if (clicked_count > 45) {
    choose();
  }
  bar_progress();

  choose_record[guess_order] = 0;
}

function guess_back() {
  if (food_data[rst[guess_order]].question.length > 20) {
    $("#background_changed_location").css({
      width: "25rem",
      left: "-7.5rem",
    });

    $("#guess_text").css({
      width: "25rem",
      left: "-0.625rem",
    });
    document.getElementById("background_changed").src =
      "./img_file_twenty/twenty_guess_guess_long.svg";
  } else {
    $("#background_changed_location").css({
      width: "6.25rem",
      left: "-11.25rem",
    });
    $("#guess_text").css({
      width: "18.75rem",
      right: "-1.25rem",
    });
    document.getElementById("background_changed").src =
      "./img_file_twenty/twenty_guess_guess_background.svg";
  }
  const guessElement = document.getElementById("guess_text");

  if (choose_record[guess_order] == 1) {
    for (smallkey in food_data[rst[guess_order - 1]].dishes) {
      arr[food_data[rst[guess_order - 1]].dishes[smallkey].id] -= 1;
    }
    guessElement.innerText = food_data[rst[guess_order - 1]].question;
    choose_record[guess_order] = 0;
    guess_order -= 1;
    bar_progress();
  } else if (choose_record[guess_order] == -1) {
    for (smallkey in food_data[rst[guess_order - 1]].dishes) {
      arr[food_data[rst[guess_order - 1]].dishes[smallkey].id] += 1;
    }
    guessElement.innerText = food_data[rst[guess_order - 1]].question;
    choose_record[guess_order] = 0;
    guess_order -= 1;
  } else if (choose_record[guess_order] == 2) {
    guessElement.innerText = food_data[rst[guess_order - 1]].question;
    choose_record[guess_order] = 0;
    guess_order -= 1;
  } else {
    // 둘다 아님 이 부분이 뜬다면 안됨
  }

  $(".slide").animate({ marginLeft: "-68.75rem" }, 0000);
  $(".guess_slide").animate({ marginLeft: "-56.25rem" }, 0000);

  $(".slide").animate({ marginLeft: "0rem" }, 400);
  $(".guess_slide").animate({ marginLeft: "0rem" }, 700);
}

function bar_progress() {
  document.getElementById("jb").value = guess_order;
}

next_guess();

let chose_food = 1;

function choose() {
  const resultElement = document.getElementById("guess_number");
  number = resultElement.innerText;

  if (number > 12) {
    let sorted = Object.entries(arr).sort((a, b) => b[1] - a[1]);
    var sorted_arr = [];
    var big_value = sorted[0][1];
    var big_value_arr = [];
    var length = 0;

    for (let element of sorted) {
      if (big_value == element[1]) {
        big_value_arr.push(element[0]);
        length += 1;
      }

      sorted_arr.push(element[0]);
    }

    var num = Math.random() * length; // Math 앞에 대문자
    var ball1 = parseInt(num); // parseInt 철자 주의
    var chose_food = parseInt(big_value_arr[ball1]);

    localStorage.setItem("food_code", chose_food);
    location.href = "./twenty_loading.html";
  } else if (number < 13) {
    window.alert("조금 더 진행해주시면 감사하겠습니다");
  }
}

function count(type) {
  // 결과를 표시할 element
  const resultElement = document.getElementById("guess_number");
  // 현재 화면에 표시된 값
  let number = resultElement.innerText;

  if (type === "plus") {
    number = parseInt(number) + 1;
  } else if (type === "minus") {
    number = parseInt(number) - 1;
    if (number === -1) {
      location.href = "./twenty_main.html";
    }
  }

  if (number > 13) {
    document.getElementById("skipd").src =
      "./img_file_twenty/twenty_guess_skip_guess.svg";
  } else {
    document.getElementById("skipd").src =
      "./img_file_twenty/twenty_guess_choose_more.svg";
  }

  // 결과 출력
  if (number < 10) {
    resultElement.innerText = "0" + number + ".";
  } else {
    resultElement.innerText = number + ".";
  }
}
