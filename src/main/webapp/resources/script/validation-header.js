const indicator = document.querySelector('.nav-indicator');
const items = document.querySelectorAll('.nav-item');

function handleIndicator(item) {
	indicator.style.width = `${item.offsetWidth}px`;
	indicator.style.left = `${item.offsetLeft}px`;
	indicator.style.backgroundColor = item.getAttribute('active-color');

	item.style.color = item.getAttribute('active-color');
}


items.forEach((item) => {
	item.addEventListener('click', (e) => { handleIndicator(e.target) });
})

items.forEach((item) => {
	item.addEventListener('click', (e) => { handleIndicator(e.target) });
})


// 모든 네비게이션 요소를 가져와 각각에 클릭 이벤트 리스너를 등록합니다.
let navElements = document.querySelectorAll('a');
navElements.forEach(function(navElement) {
	navElement.addEventListener("click", function() {
		let clickedValue = this.innerHTML; // 클릭된 내용을 가져옵니다.
		localStorage.setItem('clickedNav', clickedValue); // 클릭된 값을 로컬 스토리지에 저장합니다.
		updateNav(); // 네비게이션을 업데이트합니다.
	});
});

// 페이지가 로드될 때 클릭된 상태를 확인하고 네비게이션을 업데이트합니다.
window.onload = updateNav();

function updateNav() {
	let clickedValue = localStorage.getItem('clickedNav'); // 로컬 스토리지에서 클릭된 값을 가져옵니다.
	let elements = document.querySelectorAll('a');
	elements.forEach(function(elements) {
		if (elements.textContent.includes(clickedValue)) {
			handleIndicator(elements);
		}
	});
}

const loginBtn = document.getElementById('loginBtn');
const logoutBtn = document.getElementById('logoutBtn');
let form = document.getElementById('my-form');

/*window.onload = function() {
	const loggedInUser = sessionStorage.getItem('user'); // 'user' 키로부터 값 가져오기
	if (loggedInUser !== null) {
		// 로그인 상태인 경우
		loginBtn.style.display = 'none';
		logoutBtn.style.display = 'block';
		form.action = "/logout";
	} else {
		// 로그아웃 상태인 경우
		loginBtn.style.display = 'block';
		logoutBtn.style.display = 'none';
		form.action = "/login";
	}
}*/

let clear = document.getElementById('clear');
clear.addEventListener('click', clearValues);

function clearValues() {
    start.value = '';
    end.value = '';
    
    // 로컬 스토리지에서도 값을 지움.
    localStorage.removeItem('startValue');
    localStorage.removeItem('endValue');
}
