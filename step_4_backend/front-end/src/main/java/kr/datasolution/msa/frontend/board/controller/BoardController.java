package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@Controller
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final BoardService boardService;

    @GetMapping("")
    @Operation(summary = "게시물 목록 조회 API", description = "게시물 목록 조회 API")
    public ResponseEntity<List<BoardDto>> getViewBoardMain() {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardList());
    }

    @GetMapping("{id}")
    @Operation(summary = "게시물 상세 조회 API",description = "게시물 상세 조회 API")
    public ResponseEntity<BoardDto> getViewBoard(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoard(id));
    }

    @GetMapping("new")
    @Operation(summary = "게시물 등록 화면",description = "게시물 등록 화면")
    public String getViewBoardNew() {
        return "board/new";
    }

    @GetMapping("{id}/edit")
    @Operation(summary = "게시물 수정 화면",description = "게시물 수정 화면")
    public String getViewBoardEdit(
            @PathVariable("id") int id,
            ModelMap map) {
        map.put("info", boardService.getBoard(id));
        return "board/edit";
    }

    @PostMapping("")
    @Operation(summary = "게시물 등록 처리 API",description = "게시물 등록 처리 API")
    public ResponseEntity<Integer> addBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.addBoard(boardDto));
    }

    @PutMapping("{id}")
    @Operation(summary = "게시물 수정 처리 API",description = "게시물 수정 처리 API")
    public ResponseEntity<Integer> modBoard(@PathVariable("id") int id, @RequestBody BoardDto boardDto) {
        boardDto.setId(id);
        return ResponseEntity.ok(boardService.modBoard(boardDto));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "게시물 삭제 처리 API",description = "게시물 삭제 처리 API")
    public ResponseEntity<Integer> removeBoard(@PathVariable("id") int id) {
        return ResponseEntity.ok(boardService.removeBoard(id));
    }
}
