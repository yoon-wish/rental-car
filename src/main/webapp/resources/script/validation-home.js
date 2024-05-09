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


// 페이지가 로드될 때 이전에 입력한 값을 가져와서 표시하는 함수를 호출합니다.
window.onload = function() {
    setDate();
};

// 이전에 입력한 값을 가져와서 표시하는 함수입니다.
function setDate(){
	console.log('입력');
    // 이전에 입력한 값을 로컬 스토리지에서 가져옵니다.
    let startValueFromStorage = localStorage.getItem('startValue');
    let endValueFromStorage = localStorage.getItem('endValue');
    
    // 가져온 값이 있다면 입력 요소에 설정합니다.
    if (startValueFromStorage !== null && endValueFromStorage !== null) {
        start.value = startValueFromStorage;
        end.value = endValueFromStorage;
    }
}

// 입력된 값을 저장하는 함수입니다.
function saveDate(){
    // 입력 요소의 값들을 가져와 변수에 저장합니다.
    let startValue = start.value;
    let endValue = end.value;
    
    // 로컬 스토리지에 저장합니다.
    localStorage.setItem('startValue', startValue);
    localStorage.setItem('endValue', endValue);
}

function moveToPage(page) {
    let startValue = document.getElementById('start').value; 
    let endValue = document.getElementById('end').value;
    let url = '/main?page=' + page + '&start=' + startValue + '&end=' + endValue; 
    window.location.href = url; 
}

