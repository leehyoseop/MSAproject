package com.example.client.webclient.controller;

import com.example.client.webclient.dto.BoardDto;
import com.example.client.webclient.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Controller
@RequestMapping("/clientboard")
@RequiredArgsConstructor
public class WebClientController {
    private final WebClientService webClientService;

    /**
     * 게시물 목록 Ajax
     * @param
     * @return
     */
    @GetMapping("/getboardlist")
    public Flux<BoardDto> getClientBoardList(){
        return webClientService.getClientBoardList();
    }
    /**
     *게시물 목록 조회 화면
     * @return
     */
    @GetMapping("")
    public String getClientBoardMain(){
        return "board/main";
    }
    /**
     * 게시물 상세 Ajax
     */
    @GetMapping("/getboard/{id}")
    public Flux<BoardDto> getClientBoard(@PathVariable("id") String id){
        return webClientService.getClientBoard(id);
    }
    /**
     * 게시물 상세 조회 화면
     * @param
     * @return
     */
    @GetMapping("{id}")
    public String getViewClientBoard(@PathVariable("id") String id){
        return "board/info";
    }
    /**
     * 게시물 등록 처리
     * @param boardDto
     * @return
     */
    @PostMapping("")
    public String addClientBoard(BoardDto boardDto){
        webClientService.addClientBoard(boardDto);
        return "redirect:/clientboard";
    }
    /**
     * 게시물 등록 화면
     * @return
     */
    @GetMapping("/new")
    public String getViewBoardNew(){
        return "board/new";
    }
    /**
     * 게시물 삭제 처리
     */
    @DeleteMapping("{id}")
    public String removeBoard(@PathVariable("id") Integer id){
        webClientService.removeClientBoard(id);
        return "redirect:/clientboard";
    }

    /**
     * 게시물 수정 처리
     */
    @PutMapping("{id}")
    public String modClientBoard(@PathVariable("id") int id,@RequestBody BoardDto boardDto){
        webClientService.modClientBoard(id, boardDto);
        return "board/main";
    }
    /**
     * 게시물 수정 화면
     */
    @GetMapping ("/edit/{id}")
    public String getViewBoardEdit(){
        return "board/edit";
    }
}