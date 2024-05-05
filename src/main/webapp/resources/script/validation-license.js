document.addEventListener("DOMContentLoaded", function() {
	var licenseYes = document.getElementById("license_yes");
	var licenseNo = document.getElementById("license_no");
	var licenseYearContainer = document.getElementById("license-year-container");

	// 운전 면허증 보유 여부 라디오 버튼 변경 이벤트를 감지하여 취득년도 입력 창 표시 여부 결정
	function toggleLicenseYearInput() {
		if (licenseYes.checked) {
			licenseYearContainer.style.display = "block";
		} else {
			licenseYearContainer.style.display = "none";
		}
	}

	// 페이지 로드시 초기화
	toggleLicenseYearInput();

	// 라디오 버튼 변경 이벤트 리스너 등록
	licenseYes.addEventListener("change", toggleLicenseYearInput);
	licenseNo.addEventListener("change", toggleLicenseYearInput);
});

function enableLicense() {
    document.getElementById("license_yes").disabled = false;
}