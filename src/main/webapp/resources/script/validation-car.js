const local1 = document.getElementById('local-detail1');
const local2 = document.getElementById('local-detail2');
const local3 = document.getElementById('local-detail3');
const local4 = document.getElementById('local-detail4');
const local5 = document.getElementById('local-detail5');
const local6 = document.getElementById('local-detail6');

const foreign1 = document.getElementById('foreign-detail1');
const foreign2 = document.getElementById('foreign-detail2');
const foreign3 = document.getElementById('foreign-detail3');
const foreign4 = document.getElementById('foreign-detail4');
const foreign5 = document.getElementById('foreign-detail5');
const foreign6 = document.getElementById('foreign-detail6');


local1.style.display = 'none';
local2.style.display = 'none';
local3.style.display = 'none';
local4.style.display = 'none';
local5.style.display = 'none';
local6.style.display = 'none';

foreign1.style.display = 'none';
foreign2.style.display = 'none';
foreign3.style.display = 'none';
foreign4.style.display = 'none';
foreign5.style.display = 'none';
foreign6.style.display = 'none';

document.getElementById('local').addEventListener('click', function() {
	foreign1.style.display = 'none';
	foreign2.style.display = 'none';
	foreign3.style.display = 'none';
	foreign4.style.display = 'none';
	foreign5.style.display = 'none';
	foreign6.style.display = 'none';

	local1.style.display = 'block';
	local2.style.display = 'block';
	local3.style.display = 'block';
	local4.style.display = 'block';
	local5.style.display = 'block';
	local6.style.display = 'block';

});


document.getElementById('foreign').addEventListener('click', function() {
	local1.style.display = 'none';
	local2.style.display = 'none';
	local3.style.display = 'none';
	local4.style.display = 'none';
	local5.style.display = 'none';
	local6.style.display = 'none';

	foreign1.style.display = 'block';
	foreign2.style.display = 'block';
	foreign3.style.display = 'block';
	foreign4.style.display = 'block';
	foreign5.style.display = 'block';
	foreign6.style.display = 'block';

});


function calculateDate(price) {
	let startDate = new Date(document.getElementById("start").value);
	let endDate = new Date(document.getElementById("end").value);

	// 두 날짜 간의 차이를 계산합니다.
	let timeDifference = endDate.getTime() - startDate.getTime();

	// 날짜를 밀리초로 나타내므로, 일로 변환합니다.
	let dayDifference = Math.ceil(timeDifference / (1000 * 60 * 60 * 24));

	// 결과를 <p> 태그에 표시합니다.
	document.getElementById("period").innerHTML = "대여기간 | " + dayDifference + "일";
	document.getElementById("price").innerHTML = "대여가격 | " + (dayDifference * price) + "원";
}

const modal = document.querySelector('.modal');
const btnOpenModal = document.querySelector('.open-modal');

btnOpenModal.addEventListener("click", () => {
	modal.style.display = "flex";
});


// 수정하기

function toggleReservationForm(buttonIndex) {
	// 버튼을 클릭한 인덱스에 해당하는 수정 폼을 가져옴
	var form = document.getElementById("reservationForm" + buttonIndex);
	// 폼을 토글하여 보이거나 숨김
	form.style.display = (form.style.display === "none") ? "block" : "none";

	let start = document.getElementById('start' + buttonIndex);
	let end = document.getElementById('end' + buttonIndex);

	let today = new Date().toISOString().split('T')[0];
	start.setAttribute('min', today);
	end.setAttribute('min', today);

	/*let price = $('#price').text();
	let price2 = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	$('#price').text(price2);*/


	// 대여일(input id="start")의 변경 이벤트 리스너 추가
	start.addEventListener('change', function() {
		// 대여일
		let startDate = new Date(start.value);
		// 반납일
		let endDate = new Date(end.value);

		// 대여일 이후의 날짜만 선택 가능하도록 반납일 설정
		if (startDate > endDate) {
			end.value = start.value;
		}
		// 반납일의 최소값을 대여일로 설정
		end.min = start.value;
	});

	// 반납일(input id="end")의 변경 이벤트 리스너 추가
	end.addEventListener('change', function() {
		// 대여일
		let startDate = new Date(start.value);
		// 반납일
		let endDate = new Date(end.value);

		// 반납일 이전의 날짜가 선택되었다면, 대여일로 설정
		if (endDate < startDate) {
			start.value = document.end.value;
		}
	});
}
