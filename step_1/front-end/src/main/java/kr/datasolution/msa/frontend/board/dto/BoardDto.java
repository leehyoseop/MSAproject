package kr.datasolution.msa.frontend.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 게시물 DTO CLASS
 */
@Getter
@Setter
public class BoardDto {
    /** 게시물 ID */
    @Schema(description = "게시물 ID")
    private int id;

    /** 제목 */
    @Schema(description = "게시물 제목")
    private String title;

    /** 내용 */
    @Schema(description = "게시물 내용")
    private String contents;

    /** 등록일시 */
    @Schema(description = "게시물 등록일시")
    private LocalDateTime regDt;

    /** 수정일시 */
    @Schema(description = "게시물 수정 일시")
    private LocalDateTime updDt;
}
