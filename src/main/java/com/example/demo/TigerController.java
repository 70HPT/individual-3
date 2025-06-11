package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tigers")
public class TigerController {
    @Autowired
    private TigerService tigerService;

    @GetMapping
    public List<tiger> getAllTigers() {
        return tigerService.getAllTigers();
    }

    @GetMapping("/{id}")
    public tiger getTigerById(@PathVariable long id) {
        return tigerService.getTigerById(id);
    }

    @GetMapping("/name")
    public List<tiger> getTigersByName(@RequestParam String key) {
        if (key != null) {
            return tigerService.getTigersByName(key);
        } else {
            return tigerService.getAllTigers();
        }
    }

    @GetMapping("/habitat/{region}")
    public List<tiger> getTigersByHabitatRegion(@PathVariable String region) {
        return tigerService.getTigersByHabitatRegion(region);
    }

    @GetMapping("/subspecies/{subspecies}")
    public List<tiger> getTigersBySubspecies(@PathVariable String subspecies) {
        return tigerService.getTigersBySubspecies(subspecies);
    }

    @PostMapping
    public Object addTiger(@RequestBody tiger tiger) {
        return tigerService.addTiger(tiger);
    }

    @PutMapping("/{id}")
    public tiger updateTiger(@PathVariable Long id, @RequestBody tiger tiger) {
        tigerService.updateTiger(id, tiger);
        return tigerService.getTigerById(id);
    }

    @DeleteMapping("/{id}")
    public Object deleteTiger(@PathVariable Long id) {
        tigerService.deleteTiger(id);
        return tigerService.getAllTigers();
    }

    @PostMapping("/writeFile")
    public Object writeJson(@RequestBody tiger tiger) {
        return tigerService.writeJson(tiger);
    }

    @GetMapping("/readFile")
    public Object readJson() {
        return tigerService.readJson();
    }
}
