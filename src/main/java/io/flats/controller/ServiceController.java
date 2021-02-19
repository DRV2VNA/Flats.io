package io.flats.controller;

import io.flats.dto.BasicResponce;
import io.flats.dto.FlatDto;
import io.flats.dto.ResponceCompletedDto;
import io.flats.dto.ResponceNotCompletedDto;
import io.flats.entity.Flat;
import io.flats.payload.FlatDtoPayload;
import io.flats.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/service")
public class ServiceController {
    @Autowired
    FlatService flatService;



    @RequestMapping("/flats")
    public ResponseEntity<ArrayList<FlatDto>> mainPage() {

        List<Flat> lf = flatService.findAll();
        ArrayList<FlatDto> fd = new ArrayList<>();

        for(Flat flat : lf) {
            fd.add(new FlatDto(flat.getCountry(), flat.getTown(), flat.getStreet(), flat.getHouseNom(), flat.getFloor(), flat.getDescription()));
        }

        return ResponseEntity.ok(fd);
    }

    @RequestMapping("filterred-flats")
    public ResponseEntity returnFilterredFlats() {
        //TODO: дописать метод

        return null;
    }

    @RequestMapping("add-rent-flat")
    public ResponseEntity addRentFlats() {
        //TODO: дописать метод

        return null;
    }

    @RequestMapping("add-sale-flat")
    public ResponseEntity<BasicResponce> addFilterredFlats(@RequestBody FlatDtoPayload newFlatDao) {

        boolean stat = flatService.addSaleFlat(newFlatDao);

        if (!stat) {
            return ResponseEntity.ok(new ResponceNotCompletedDto());
        }

        return ResponseEntity.ok(new ResponceCompletedDto());
    }
}
