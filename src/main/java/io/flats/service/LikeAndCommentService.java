package io.flats.service;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.flats.JWT_AUTH.exeption.NotFoundException;
import io.flats.entity.Comments;
import io.flats.entity.Flat;
import io.flats.entity.Likes;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.CommentsRepository;
import io.flats.repository.FlatRepository;
import io.flats.repository.LikesRepository;
import io.flats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeAndCommentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FlatRepository flatRepository;

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    CommentsRepository commentsRepository;

    public boolean setLike(long id_from, long id_to){
        Likes like = new Likes();
        like.setUser(userRepository.findById(id_from).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        ));
        like.setFlat(flatRepository.findById(id_to).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        ));
        likesRepository.save(like);
        return true;
    }

    public boolean setComment(long id_from, long id_to, String commentText, float rating){
        Comments comment = new Comments();
        comment.setUser_from(userRepository.findById(id_from).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        ));

        User toUser = userRepository.findById(id_to).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        );
        comment.setUserTo(toUser);
        comment.setRating(rating);
        comment.setCommentText(commentText);
        commentsRepository.save(comment);
        toUser.getReceivedCommentsToFlats().add(comment);
        userRepository.save(toUser);

        float rat = rating;
        int cnt = 1;
        for(Optional<Comments> _comment :commentsRepository.findAllByUserTo(toUser)) {
            rat += _comment.get().getRating();
            cnt += 1;
        }

        toUser.setRating(rat/cnt);
        userRepository.save(toUser);

        return true;
    }

    public List<Comments> getReceivedCommentsByUserId(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        );

        return user.getReceivedCommentsToFlats();
    }

    public List<Comments> getPuttedCommentsByUserId(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        );

        return user.getPuttedCommentsToFlats();
    }

    public List<Likes> getLikesOfFlatById(long id) {
        Flat flat = flatRepository.findById(id).orElseThrow(
                () -> { throw new NotFoundException(); }
        );

        return flat.getFlatsLikes();
    }

    public List<Likes> getLikesOfUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> { throw new NotFoundException(); }
        );

        return user.getPuttedLikesToFlats();
    }
}
