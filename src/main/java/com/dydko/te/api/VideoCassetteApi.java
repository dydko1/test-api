package com.dydko.te.api;

import com.dydko.te.entity.VideoCassette;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {
    private List<VideoCassette> videCassettes;

    public VideoCassetteApi() {
        this.videCassettes = new ArrayList<>();
        videCassettes.add(new VideoCassette(3L, "Strazak3 Sam3", LocalDate.of(2013, 03, 03)));
        videCassettes.add(new VideoCassette(1L, "Potop", LocalDate.of(1974, 01, 01)));
        videCassettes.add(new VideoCassette(2L, "Strazak Sam", LocalDate.of(2015, 02, 02)));
        videCassettes.add(new VideoCassette(6L, "Strazak6 Sam6", LocalDate.of(2016, 06, 06)));
    }

    @GetMapping("/all")
    public List<VideoCassette> getAll() {
        return videCassettes;
    }

    @GetMapping
    public VideoCassette getById(@RequestParam int index) {
        Optional<VideoCassette> first = videCassettes.stream().
                filter(e -> e.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addVideo(@RequestBody VideoCassette videoCassette) {
        return videCassettes.add(videoCassette);
    }

    @PutMapping
    public boolean updateVideo(@RequestBody VideoCassette videoCassette) {
        return videCassettes.add(videoCassette);
    }

    @DeleteMapping("{id}")
    //@DeleteMapping
    public boolean deleteVideo(@PathVariable Long id) {
        return videCassettes.removeIf(e -> e.getId() == id);
    }


}
