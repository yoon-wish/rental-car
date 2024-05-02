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


//


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
window.onload = updateNav;

function updateNav() {
	let clickedValue = localStorage.getItem('clickedNav'); // 로컬 스토리지에서 클릭된 값을 가져옵니다.

	let elements = document.querySelectorAll('a');
	elements.forEach(function(elements) {
		if (elements.textContent.includes(clickedValue)) {
			handleIndicator(elements);
		}
	});
		
}
/*		if (clickedValue) {
			navElements.forEach(function(navElement) {
				if (navElement.innerHTML === clickedValue) { // 클릭된 값과 일치하는 요소를 찾습니다.
					handleIndicator(clickedValue); // 해당 요소에 clicked 클래스를 추가하여 스타일을 변경합니다.
				} else {
					navElement.classList.remove('clicked'); // 다른 요소에서는 clicked 클래스를 제거합니다.
				}
			});
	}*/
