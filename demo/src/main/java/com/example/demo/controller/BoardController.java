package com.example.demo.controller;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.request.BoardRequest;
import com.example.demo.domain.response.BoardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// api endpoint 에 의해 데이터 뽑아가는 것
// rest api

// method: GET, POST

// board insert
// method: POST
// endpoint: /board
// {content: "sdf", username: "123"}

// board update
// method: PUT(POST)
// endpoint: /board/1
// {content: "sdf111", username: "123"}

// board delete
// method: DELETE(GET)
// endpoint: /board/1

// 4번 게시글 지울 것
// method: DELETE
// endpoint: /boards/4

// status code
// 200 -> 성공(OK)
// 201 : CREATED -> Insert 를 했을 때 200이 아닌 201을 띄워줌
// 204 : NO CONTENT(그런 거 없어요)
// 4xx -> client error
// 400 : Bad request
// 404 : 없는 url 을 요청했을 때
// 5xx -> server error
// 500 : Code 에 문제가 생겼을 때 -> 서버는 500번대 에러를 내면 안됨

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final List<Board> boards;

    @GetMapping
    public List<BoardResponse> getBoard() {
        List<BoardResponse> boardResponses = new ArrayList<>();
        List<BoardResponse> list = boards.stream().map(BoardController::getBoardResponse
        ).toList();

        return list;
    }

    // localhost:81/board/1
    // dynamic route path variable(변수)
    @GetMapping("/{id}")
    public BoardResponse getBoardById(@PathVariable("id") int id){

        List<BoardResponse> list = boards
                .stream()
                .filter(b -> b.getId() == id)
                .map(BoardController::getBoardResponse)
                .toList();
        if(list.isEmpty()) return null;

        return list.get(0);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBoard(@RequestBody BoardRequest request){
        boards.add(
                new Board(
                        boards.get(boards.size()-1).getId()+1,
                        request.content(),
                        request.username())
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBoard(@PathVariable("id") int id){
//        boards.removeIf(board -> board.getId() == id);
        boards.remove(findIndexById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(@RequestBody BoardRequest request, @PathVariable("id") int id){
        boards.set(
                findIndexById(id), new Board(
                        id,
                        request.content(),
                        request.username()
                )
        );
    }

    public BoardController() {
        boards = new ArrayList<>();
        boards.add(new Board(1, "123", "test"));
        boards.add(new Board(2, "222", "test"));
        boards.add(new Board(3, "333", "park"));
    }

    private static BoardResponse getBoardResponse(Board b) {
        return new BoardResponse(
                b.getId(),
                b.getContent() + "aaa",
                b.getUsername());
    }

    private int findIndexById(int id) {
        for (int i = 0; i < boards.size(); i++) {
            if (boards.get(i).getId() == id) return i;
        }
        throw new IllegalArgumentException("없는 데이터");
    }
}
