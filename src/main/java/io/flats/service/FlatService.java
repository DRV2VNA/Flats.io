package io.flats.service;

import io.flats.dto.FlatDto;
import io.flats.entity.Comments;
import io.flats.entity.Flat;
import io.flats.entity.FlatsImages;
import io.flats.entity.Likes;
import io.flats.exception.UserNotFoundExeption;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Flat service.
 */
@Service
public class FlatService {
    /**
     * The Flat repository.
     */
    @Autowired
    FlatRepository flatRepository;

    /**
     * The Flat order type repository.
     */
    @Autowired
    FlatOrderTypeRepository flatOrderTypeRepository;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    CommentsRepository commentsRepository;


    /**
     * Find images by flat id list.
     *
     * @param flatId the flat id
     * @return the list
     */
    public List<String> findImagesByFlatId(long flatId) {

        Flat currentFlat = flatRepository.findById(flatId).orElseThrow(
                () -> { throw new NoSuchElementException("No such flat found."); }
        );

        List<String> res = new ArrayList<>();
        for(FlatsImages entity : currentFlat.getFlatsImages()) {
            res.add(entity.getImgUrl());
        }

        return res;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Flat> findAll() {
        List<Flat> resArray = new ArrayList<>();

        for (int i = 1; i <= flatRepository.count(); ++i) {
            Flat curFlat = flatRepository.findById(Long.valueOf(i)).orElseThrow(
                    () -> { throw new NoSuchElementException("No such role found."); }
            );

            resArray.add(curFlat);
        }

        return resArray;
    }

    /**
     * Add sale flat boolean.
     *
     * @param newFlatDao the new flat dao
     * @return the boolean
     */
    public boolean addSaleFlat(FlatDtoPayload newFlatDao) {
        Flat newFlat = new Flat();
        newFlat.setCountry(newFlatDao.getCountry());
        newFlat.setTown(newFlatDao.getTown());
        newFlat.setStreet(newFlatDao.getStreet());
        newFlat.setHouseNom(newFlatDao.getHouseNom());
        newFlat.setFloor(newFlatDao.getFloor());
        newFlat.setPrice(newFlatDao.getPrice());
        newFlat.setDescription(newFlatDao.getDescription());
        newFlat.setOrderType(flatOrderTypeRepository.findById(1L).get());

        //TODO: исправить на получение юзверя из авторизации
        newFlat.setOwner(userRepository.findById(newFlatDao.getUserId()).orElseThrow(
                () -> { throw new UserNotFoundExeption(); }
        ));

        //TODO: проверка на то, что такая квартира уже существует

        flatRepository.save(newFlat);

        return true;
    }

}
