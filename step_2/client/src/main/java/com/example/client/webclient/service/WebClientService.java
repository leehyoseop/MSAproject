package com.example.client.webclient.service;

import com.example.client.webclient.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebClientService {

    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8081/board/")
            .build();

    //게시물 목록 조회
    public Flux<BoardDto> getClientBoardList(){
        return webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(BoardDto.class);
    }
    //게시물 상세 조회
    public Flux<BoardDto> getClientBoard(String id){
        return webClient.get()
                .uri("/"+id)
                .retrieve()
                .bodyToFlux(BoardDto.class);
    }
    //게시물 등록
    public Void addClientBoard(BoardDto boardDto){
        return webClient.post()
                .uri("")
                .bodyValue(boardDto)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
    //게시물 삭제
    public Void removeClientBoard(Integer id){
        return webClient.delete()
                .uri("/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
    //게시물 수정
    public Void modClientBoard(int id, BoardDto boardDto){
        boardDto.setId(id);
        return webClient.put()
                .uri("/"+id)
                .bodyValue(boardDto)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
