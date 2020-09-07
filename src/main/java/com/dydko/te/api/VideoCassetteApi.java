package com.dydko.te.api;

import com.dydko.te.entity.VideoCassette;
import com.dydko.te.manager.VideoCassetteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {
    private VideoCassetteManager videCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videCassettes) {
        this.videCassettes = videCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return videCassettes.findById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {

        return videCassettes.save(videoCassette);
    }

    @DeleteMapping("{id}")
    //@DeleteMapping
    public void deleteVideo(@PathVariable Long id) {
        videCassettes.deleteCassette(id);
    }

}
