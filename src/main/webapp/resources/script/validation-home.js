let start = document.getElementById('start');
let end = document.getElementById('end');

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