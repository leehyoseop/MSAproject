package kr.datasolution.msa.frontend.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 메인 연결 Controller Layer
 */
@Controller
public class MainController {
    /**
     * 메인 연결 이동
     * @return 게시물 목록 리스트 화면으로 이동
     */
    @GetMapping("")
    public String getViewMain() {
        return "redirect:/board";
    }
}
