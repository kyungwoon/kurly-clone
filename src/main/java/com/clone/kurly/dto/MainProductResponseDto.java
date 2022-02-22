package com.clone.kurly.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class MainProductResponseDto {
    private Long pid;
    private String mainImageUrl;
    private String name;
    private String shortDescription;
    private boolean isKurlyOnly;
    private boolean isSales;
    private Long originalPrice;
    private Long discountedPrice;
    private Long discountPercent;
    private int categoryNo;
    private String categoryName;
}




/*


public class ArticleResponseDto {
    private Long article_id; //게시글 ID
    private Long writer_id; //글쓴이 ID
    private String writer_nickname; //글쓴이 닉네임
    private List<Long> liked_users; //좋아요 누른 사용자 ID 리스트
    private String image_url;
    private List<String> tags; //["귀여워", "멍멍이"]
    private String created_date; //작성 날짜
 */