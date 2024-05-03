document.addEventListener("DOMContentLoaded", function() {
    var licenseYesRadio = document.getElementById("license_yes");
    var licenseNoRadio = document.getElementById("license_no");
    var licenseYearContainer = document.getElementById("license-year-container");

    // 운전 면허증 보유 여부 라디오 버튼 변경 이벤트를 감지하여 취득년도 입력 창 표시 여부 결정
    function toggleLicenseYearInput() {
        if (licenseYesRadio.checked) {
            licenseYearContainer.style.display = "block";
        } else {
            licenseYearContainer.style.display = "none";
        }
    }

    // 페이지 로드시 초기화
    toggleLicenseYearInput();

    // 라디오 버튼 변경 이벤트 리스너 등록
    licenseYesRadio.addEventListener("change", toggleLicenseYearInput);
    licenseNoRadio.addEventListener("change", toggleLicenseYearInput);
});

document.addEventListener("DOMContentLoaded", function() {
    var adminYesRadio = document.getElementById("admin_yes");
    var adminNoRadio = document.getElementById("admin_no");
    var adminPasswordContainer = document.getElementById("admin-password-container");

    // 관리자 여부 라디오 버튼 변경 이벤트를 감지하여 암호 입력 창 표시 여부 결정
    function toggleAdminPasswordInput() {
        if (adminYesRadio.checked) {
            adminPasswordContainer.style.display = "block";
        } else {
            adminPasswordContainer.style.display = "none";
        }
    }

    // 페이지 로드시 초기화
    toggleAdminPasswordInput();

    // 라디오 버튼 변경 이벤트 리스너 등록
    adminYesRadio.addEventListener("change", toggleAdminPasswordInput);
    adminNoRadio.addEventListener("change", toggleAdminPasswordInput);
});