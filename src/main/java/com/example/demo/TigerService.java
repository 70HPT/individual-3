package com.example.demo;

import com.example.demo.TigerRepository;
import com.example.demo.tiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class TigerService {
    @Autowired
    private TigerRepository tigerRepository;

    public List<tiger> getAllTigers() {
        return tigerRepository.findAll();
    }

    public tiger getTigerById(@PathVariable long tigerId) {
        return tigerRepository.findById(tigerId).orElse(null);
    }

    public List<tiger> getTigersByName(String name) {
        return tigerRepository.getTigersByName(name);
    }

    public List<tiger> getTigersByHabitatRegion(String region) {
        return tigerRepository.getTigersByHabitatRegion(region);
    }

    public List<tiger> getTigersBySubspecies(String subspecies) {
        return tigerRepository.getTigersBySubspecies(subspecies);
    }

    public tiger addTiger(tiger tiger) {
        return tigerRepository.save(tiger);
    }

    public tiger updateTiger(Long tigerId, tiger tiger) {
        return tigerRepository.save(tiger);  // assumes ID is included in body or preloaded
    }

    public void deleteTiger(Long tigerId) {
        tigerRepository.deleteById(tigerId);
    }

    public String writeJson(tiger tiger) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("com.example.demo.js.json"), tiger);
            return "Tiger written to JSON file successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing com.example.demo.js to JSON file";
        }
    }

    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("com.example.demo.js.json"), tiger.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
