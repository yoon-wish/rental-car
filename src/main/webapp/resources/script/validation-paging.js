$(document).ready(function() {
	var currentPage = 1;
	var pageCnt = 10;	// 페이지 당 게시물 수
	
	// 페이지 로드 시 첫 페이지 게시물들 불러오기
	loadPosts();
	
	// 페이지 버튼 클릭 시 해당 페이지 게시물 불러오기
	$(document).on('click', '.pagination-link', function(){
		currentPage = $(this).data('page');
		loadPosts();
	})
	
	function loadPosts(){
		// 서버로부터 게시글 수 가져오기
		$.ajax({
			url: 'src\main\java\rentalcarServer\board\model\BoardDao.java',
			method: 'GET',
			success: function(totalPosts){
				var totalPages = Math.ceil(totalPosts/pageCnt);
				
				displayePosts(totalPages);
			},
			error: function(xhr, status, error){
				console.error("Error loding total posts:", error);
			}
		});
	}
	
	function displayePosts(totalPages){
		var paginationHtml = '';
		
		for (var i = 1; i <= totalPages; i++) {
            paginationHtml += '<a href="#" class="pagination-link" data-page="' + i + '">' + i + '</a>';
        }
        $('#pagination').html(paginationHtml);

        // AJAX를 통해 해당 페이지의 게시물 불러오기
        $.ajax({
            url: 'getPosts.jsp?page=' + currentPage, // 해당 페이지의 게시글을 가져올 서버 경로
            method: 'GET',
            success: function(postsHtml) {
                $('#posts-container').html(postsHtml);
            },
            error: function(xhr, status, error) {
                console.error("Error loading posts:", error);
            }
        });
    }
});
