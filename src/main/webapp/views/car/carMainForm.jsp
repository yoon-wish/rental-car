<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/header" />
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/car.css">
</head>
<body>

	<div class='container2'>
		<div class="country">
			<button id='local'>국산차</button>
			<button id='foreign'>수입차</button>
		</div>

		<div class="local-list">
			<div class="local-detail1" id="local-detail1">
				<button id="local1" onclick="location.href='/readCarByBrand?brand=현대'">
						<img src="https://www.hyundai.com/content/dam/hyundai/ww/en/images/about-hyundai/ir/hyundai-logo-fb-original.jpg" />
				</button>
				<p>현대</p>
			</div>

			<div class="local-detail2" id="local-detail2">
				<button id="local2" onclick="location.href='/readCarByBrand?brand=제네시스'">
				
					<img src="https://cdn.menews.co.kr/news/photo/201811/7875_7624_648.jpg" />
				</button>
				<p>제네시스</p>
			</div>
			
			<div class="local-detail3" id="local-detail3">
				<button id="local3" onclick="location.href='/readCarByBrand?brand=기아'">
					<img src="https://image.edaily.co.kr/images/Photo/files/NP/S/2021/02/PS21021600409.jpg" />
				</button>
				<p>기아</p>
			</div>
			
			<div class="local-detail4" id="local-detail4">
				<button id="local4" onclick="location.href='/readCarByBrand?brand=쉐보레'">
					<img src="https://mblogthumb-phinf.pstatic.net/MjAxOTA3MDhfMTYz/MDAxNTYyNTQzODQ4ODE5.9a1s3O3A4Xw2riVwlz3u6fzQ8FLMjj1wxBub8NOumr8g.uLIgVBWOujhEo5ROJyRMlQgBkhcKTxXABVrcB3LaiBsg.PNG.cogram/chevy.png?type=w800" />
				</button>
				<p>쉐보레</p>
			</div>
			
			<div class="local-detail5" id="local-detail5">
				<button id="local5" onclick="location.href='/readCarByBrand?brand=르노'">
					<img src="data:image/jpeg;base64,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" />
				</button>
				<p>르노</p>
			</div>
			
			<div class="local-detail6" id="local-detail6">
				<button id="local6" onclick="location.href='/readCarByBrand?brand=KGM'">
					<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqeuFnHsWk3NiMSu7uYpM2SP6zEIS6D2fk-S_ghDTjIEdiJ-UwcEct1HO2magYPB3caFA&usqp=CAU" />
				</button>
				<p>KGM(구 쌍용)</p>
			</div>

		</div>


		<div class="foreign-list">
			<div class="foreign-detail1" id="foreign-detail1">
				<button id="foreign1" onclick="location.href='/readCarByBrand?brand=벤츠'">
						<img src="https://w7.pngwing.com/pngs/352/130/png-transparent-mercedes-benz-car-motor-vehicle-service-luxury-vehicle-mercedes-logo-angle-emblem-trademark-thumbnail.png" />
				</button>
				<p>벤츠</p>
			</div>
	
			<div class="foreign-detail2" id="foreign-detail2">
				<button id="foreign2" onclick="location.href='/readCarByBrand?brand=BMW'">
						<img src="https://mblogthumb-phinf.pstatic.net/20160705_13/myredsuns_1467694860567XutrA_JPEG/2.jpg?type=w800" />
				</button>
				<p>BMW</p>
			</div>
			
			<div class="foreign-detail3" id="foreign-detail3">
				<button id="foreign3" onclick="location.href='/readCarByBrand?brand=아우디'">
						<img src="https://mblogthumb-phinf.pstatic.net/20160707_229/ppanppane_14678628245076rkc5_PNG/%BE%C6%BF%EC%B5%F0%B7%CE%B0%ED_%283%29.png?type=w800" />
				</button>
				<p>아우디</p>
			</div>
			
			<div class="foreign-detail4" id="foreign-detail4">
				<button id="foreign4" onclick="location.href='/readCarByBrand?brand=폭스바겐'">
						<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRm8CySyDHsK5XeevGIYEFsjppQqNgPfwzDch3uFVLRlQ&s" />
				</button>
				<p>폭스바겐</p>
			</div>
			
			<div class="foreign-detail5" id="foreign-detail5">
				<button id="foreign5" onclick="location.href='/readCarByBrand?brand=볼보'">
						<img src="https://cdn.autotribune.co.kr/news/photo/202109/6217_36259_291.jpg" />
				</button>
				<p>볼보</p>
			</div>
			
			<div class="foreign-detail6" id="foreign-detail6">
				<button id="foreign6" onclick="location.href='/readCarByBrand?brand=미니'">
						<img src="https://mblogthumb-phinf.pstatic.net/MjAxNzEyMThfMTk4/MDAxNTEzNTI1NTczNzY2.toCShc24I4Z7jNp8q5HNvL0fYiJu0M5DCp4H9GyA3L0g.aajps7WaDrn7p78H6BjYaS5nA9xuN1M8O1WyrNbWIFUg.PNG.komi2014/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2017-12-18_%EC%98%A4%EC%A0%84_12.37.38.png?type=w800" />
				</button>
				<p>미니</p>
			</div>
		</div>

	</div>

	<script src="\resources\script\validation-car.js"></script>
</body>
</html>