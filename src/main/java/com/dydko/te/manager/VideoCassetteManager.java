package com.dydko.te.manager;

import com.dydko.te.dao.VideoCassetteRepo;
import com.dydko.te.entity.VideoCassette;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {
    private VideoCassetteRepo videoCassetteRepo;

    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteCassette(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(3L, "Strazak3 Sam3", LocalDate.of(2013, 03, 03)));
        save(new VideoCassette(1L, "Potop", LocalDate.of(1974, 01, 01)));
        save(new VideoCassette(2L, "Strazak Sam", LocalDate.of(2015, 02, 02)));
        save(new VideoCassette(6L, "Strazak6 Sam6", LocalDate.of(2016, 06, 06)));
    }

}
