package com.example.auth.service;

import com.example.auth.config.JwtTokenUtils;
import com.example.auth.dto.request.LoginRequest;
import com.example.auth.dto.request.SignupRequest;
import com.example.auth.dto.request.UserRequest;
import com.example.auth.dto.response.UserResponse;
import com.example.auth.global.domain.entity.User;
import com.example.auth.global.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final JwtTokenUtils jwtTokenUtils;
    private final PasswordEncoder passwordEncoder;
    public String login(LoginRequest request){
//         디비에 있는 것을 찾는다 username 가지고와서
        List<User> byUsername = userRepository.findByUsername(request.username());
        if(byUsername.isEmpty()){
            throw new IllegalArgumentException("로그인 실패");
        }
//         패스워드 비교를 할 것이다.
        User user = byUsername.get(0);
        if(!passwordEncoder.matches(request.password(), user.getPassword())){
            throw new IllegalArgumentException("로그인 실패");
        }

//         맞으면 토큰을 리턴 할 것이다.
        return jwtTokenUtils.createToken(user);
    }
    public void signUp(SignupRequest request){
        String encoded = passwordEncoder.encode(request.password());
        if(!userRepository.findByUsername(request.username()).isEmpty())
            throw new IllegalArgumentException("있음");
        User entity = request.toEntity(encoded);
        userRepository.save(entity);
    }

    @Override
    public void save(UserRequest req) {
        userRepository.save(req.toEntity());
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from).toList();
//        return userRepository.findAll();
    }
}
