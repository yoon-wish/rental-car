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


$(document).ready(() => {
	$('#error-msg-id').hide();
	$('#error-msg-password').hide();
	$('#error-msg-email').hide();
	$('#error-msg-name').hide();
	$('#error-msg-birth').hide();
	$('#error-msg-telecom').hide();
	$('#error-msg-phone').hide();
	$('#error-msg-license').hide();
	$('#error-msg-agree').hide();

	$('#id').focusout(e => {
		if ($('#id').val() === "") {
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-id').hide();
			$('#id').css('border', 'solid 1px #9DB2BF');
			$('#id').css('border-bottom', 'none');
		}
	});

	$('#password').focusout(e => {
		if ($('#password').val() === "") {
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px #9DB2BF');
			$('#password').css('border-bottom', 'none');
		}
	});

	$('#email').focusout(e => {
		if ($('#email').val() === "") {
			$('#error-msg-email').show();
			$('#email').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-email').hide();
			$('#email').css('border', 'solid 1px #9DB2BF');
			$('#email').css('border-bottom', 'none');
		}
	});

	$('#name').focusout(e => {
		if ($('#name').val() === "") {
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-name').hide();
			$('#name').css('border', 'solid 1px 9DB2BF');
			$('#name').css('border-bottom', 'none');
		}
	});

	$('#birth').focusout(e => {
		if ($('#birth').val() === "") {
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-birth').hide();
			$('#birth').css('border', 'solid 1px 9DB2BF');
			$('#birth').css('border-bottom', 'none');
		}
	});

	$('#telecom').focusout(e => {
		if ($('#telecom').val() === null) {
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-telecom').hide();
			$('#telecom').css('border', 'solid 1px 9DB2BF');
			$('#telecom').css('border-bottom', 'none');
		}
	});

	$('#phone').focusout(e => {
		if ($('#phone').val() === "") {
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px 9DB2BF');
		}

		const phone = $('#phone').val();

		if (phone.match(/\d{3}-\d{4}-\d{4}|\d{11}/) === null) {
			$('#error-msg-phone-pattern').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			if (phone.length === 11) {
				const update = `${phone.substr(0, 3)}-${phone.substr(3, 4)}-${phone.substr(7, 4)}`;
				$('#phone').val(update);
			}
		}
	});

	$('#license').focusout(e => {
		if ($('#license').val() === null) {
			$('#error-msg-license').show();
			$('#license').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-license').hide();
			$('#license').css('border', 'solid 1px 9DB2BF');
			$('#license').css('border-bottom', 'none');
		}
	});

	$('#agree').focusout(e => {
		if ($('#agree')[0].checked) {
			$('#error-msg-agree').hide();
		} else {
			$('#error-msg-agree').show();
		}
	});

	$('form').submit(e => {
		e.preventDefault();

		const id = $('#id').val();
		const password = $('#password').val();
		const email = $('#email').val();

		const name = $('#name').val();
		const age = $('#age').val();
		const telecom = $('#telecom').val();
		const phone = $('#phone').val();

		const license = e.target.license.value;

		const agree = $('#agree')[0].checked;


		// 유효성 검사 
		let isValid = true;

		if (id === "") {
			isValid = false;
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		}
		if (password === "") {
			isValid = false;
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		}
		if (email === "") {
			isValid = false;
			$('#error-msg-email').show();
			$('#email').css('border', 'solid 1px tomato');
		}
		if (name === "") {
			isValid = false;
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px tomato');
		}
		if (birth === "") {
			isValid = false;
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px tomato');
		}
		if (telecom === null) {
			isValid = false;
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px tomato');
		}
		if (phone === "") {
			isValid = false;
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		}
		if (license === "") {
			isValid = false;
			$('#error-msg-license').show();
			$('#radio-container').css('border', 'solid 1px tomato');
			$('#license_yes').css('border', 'solid 1px tomato');
			$('#license_no').css('border', 'solid 1px tomato');
		}
		if (!$('#agree').prop('checked')) {
			isValid = false;
			$('#error-msg-agree').show();
			$('#agree-container').css('border', 'solid 1px tomato');
		}

		if (isValid) {
			e.target.submit();
		}
	});
});