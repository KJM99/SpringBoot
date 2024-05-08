package com.example.auth.api;

import com.example.auth.dto.request.UpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ApiPlaylist {
    public final FeignPlaylist feignPlaylist;
    public static List<Map<String, Object>> failList = new ArrayList<>();

    @Async
    // 한번 playlist 를 끄고 호출해봐라
    public void updatePlaylist(Long id, UpdateRequest request) {
        try{
            feignPlaylist.updatePlaylist(id, request);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("request", request);
            failList.add(map);
        }
    }
//    @Scheduled(cron = "*/3 * * * *")
//    public void send(){
//        failList.forEach(map -> {
//            updatePlaylist(
//                    (Long) map.get("id")
//                    , (UpdateRequest) map.get("request"));
//        });
//    }


}
