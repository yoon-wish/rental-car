$(document).ready(() => {
    $('form').submit(e => {
        e.preventDefault(); // 기본 동작 방지

        // 아이디와 비밀번호 값을 가져오기
        const id = $('#id').val();
        const password = $('#password').val();

        // 아이디나 비밀번호가 비어있는지 확인
        if (id === "" || password === "") {
            alert("아이디와 비밀번호를 모두 입력하세요.");
            return; // 폼 제출 방지
        }

        // 유효성 검사가 통과되면 폼 제출
        e.target.submit();
    });
});