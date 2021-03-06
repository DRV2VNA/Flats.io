package io.flats.controller;

import io.flats.JWT_AUTH.dto.UserDto;
import io.flats.JWT_AUTH.jwt.JwtUser;
import io.flats.JWT_AUTH.jwt.JwtUserDetailsService;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.*;
import io.flats.entity.Comments;
import io.flats.entity.Likes;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.payload.CommentDtoPayload;
import io.flats.payload.LikeDtoPayload;
import io.flats.repository.UserRepository;
import io.flats.service.FlatService;
import io.flats.service.LikeAndCommentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.AuthProvider;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User basic controller.
 */
@Controller
@RequestMapping("/api/user/public")
public class UserBasicController {
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Authentication.
     */
    @Autowired
    JwtUserDetailsService authentication;

    @Autowired
    FlatService flatService;

    @Autowired
    LikeAndCommentService likeAndCommentService;


    /**
     * Gets user profile image url by username.
     *
     * @param username the username
     * @return the user profile image url by username
     */
    @RequestMapping("get_user_img_url_by_username")
    public ResponseEntity<UserProfileImageUrlDto> getUserProfileImageUrlByUsername(@RequestParam String username) { //TODO: сменить id на токен
//        System.out.println("d");

        //String url = "https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg";
        String url = userRepository.findByUsername(username).orElseThrow(
                () -> {throw new UserNotFoundExeption();}
        ).getUserProfileImageUrl();


        return ResponseEntity.ok(new UserProfileImageUrlDto(url));
    }

    /**
     * Gets user info.
     *
     * @param token the token
     * @return the user info
     */
    @RequestMapping("get_user_info_from_token")
    public ResponseEntity<User> getUserInfo(@RequestParam String token) {


        return null;
    }

    /**
     * Gets user posted flats.
     *
     * @return the user posted flats
     */
    @RequestMapping("get_user_posted_flats")
    public ResponseEntity<ArrayList<String>> getUserPostedFlats() {


        return null;
    }

    /**
     * Gets user info.
     *
     * @param userDto the user dto
     * @return the user info
     */
    @RequestMapping("get_user_info")
    public ResponseEntity<io.flats.dto.UserDto> getUserInfo(@RequestBody UserDto userDto) {
        User user = userService.findByUsername(userDto.getUsername()).get(); //TODO:

        io.flats.dto.UserDto userResponce = new io.flats.dto.UserDto();

        userResponce.setId(user.getId());
        userResponce.setUsername(user.getUsername());
        userResponce.setEmail(user.getEmail());
        userResponce.setFirstName(user.getFirstName());
        userResponce.setLastName(user.getLastName());
        userResponce.setRole(user.getRole().getName());
        userResponce.setSecondName(user.getSecondName());
        userResponce.setPhoneNumber(user.getPhoneNumber());
        userResponce.setRating(user.getRating());
        userResponce.setDateUserFrom(java.util.Date
                .from(user.getTimeOfAccountCreation().atZone(ZoneId.systemDefault())
                        .toInstant()));

        return ResponseEntity.ok(userResponce);
    }


    @PostMapping("set_like_to_flat")
    public ResponseEntity<BasicResponce> setLike(@RequestBody LikeDtoPayload likeDtoPayload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption();}
        );
        likeAndCommentService.setLike(currentUser.getId(), likeDtoPayload.getId_to());
        return ResponseEntity.ok(new ResponceCompletedDto());
    }

    @PostMapping("set_comment_to_user")
    public ResponseEntity<BasicResponce> setComment(@RequestBody CommentDtoPayload commentDtoPayload) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {
                    throw new UserNotFoundExeption();
                }
        );
        likeAndCommentService.setComment(currentUser.getId(), commentDtoPayload.getId_to(), commentDtoPayload.getCommentText(), commentDtoPayload.getRating());
        return ResponseEntity.ok(new ResponceCompletedDto());
    }

    @RequestMapping("/get_all_realtors")
    public ResponseEntity<List<io.flats.dto.UserDto>> getAllRieltors() {
        List<io.flats.dto.UserDto> responseDto = new ArrayList<>();

        List<User> rieltors = userService.findAllRieltors();
        for (User user : rieltors) {
            io.flats.dto.UserDto userResponce = new io.flats.dto.UserDto();
            userResponce.setId(user.getId());
            userResponce.setUsername(user.getUsername());
            userResponce.setEmail(user.getEmail());
            userResponce.setFirstName(user.getFirstName());
            userResponce.setLastName(user.getLastName());
            userResponce.setRole(user.getRole().getName());
            userResponce.setSecondName(user.getSecondName());
            userResponce.setPhoneNumber(user.getPhoneNumber());
            userResponce.setRating(user.getRating());
            userResponce.setDateUserFrom(java.util.Date
                    .from(user.getTimeOfAccountCreation().atZone(ZoneId.systemDefault())
                            .toInstant()));
            userResponce.setRealtorsCommentsNomber(
                    likeAndCommentService.getReceivedCommentsByUserId(user.getId()).size()
            );

            responseDto.add(userResponce);
        }

        return ResponseEntity.ok(responseDto);
    }

    @RequestMapping("/get_comments_to_user_by_id")
    public ResponseEntity<List<CommentDto>> getCommentsToUserById(@RequestParam long id) {

        List<CommentDto> responseList = new ArrayList<>();
        List<Comments> comments = likeAndCommentService.getReceivedCommentsByUserId(id);
        for (Comments comment : comments) {
            CommentDto cd = new CommentDto();
            cd.setComment(comment.getCommentText());
            cd.setUser_from(new io.flats.dto.UserDto(comment.getUser_from()));
            cd.setImg_from(new UserProfileImageUrlDto(comment.getUser_from().getUserProfileImageUrl()));
            cd.setRating(comment.getRating());

            responseList.add(cd);
        }

        return ResponseEntity.ok(responseList);
    }

    @RequestMapping("/get_likes_from_user_by_id")
    public ResponseEntity<List<LikeDto>> getLikesFromUserById(@RequestParam long id) {

        List<LikeDto> responseList = new ArrayList<>();
        List<Likes> likes = likeAndCommentService.getLikesOfUserById(id);
        for (Likes like : likes) {
            LikeDto cd = new LikeDto();
            cd.setUser(userService.convertUserToUserDto( like.getUser()));
            cd.setFlat(flatService.convertFlatToFlatDto(like.getFlat()));

            responseList.add(cd);
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/get_additional_info_about_realtor")
    public ResponseEntity<Integer> getAddRealtorInfo(@RequestParam long id) {
        return ResponseEntity.ok(userService.getAdditRealtorInfo(id));
    }
}
