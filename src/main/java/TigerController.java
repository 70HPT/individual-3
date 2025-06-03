import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TigerController {
    @Autowired
    private TigerService tigerService;

    @GetMapping("/tigers")
    public Object getAllTigers() {
        return tigerService.getAllTigers();
    }

    @GetMapping("/tigers/{id}")
    public tiger getTigerById(@PathVariable long id) {
        return tigerService.getTigerById(id);
    }

    @GetMapping("/tigers/name")
    public Object getTigersByName(@RequestParam String key) {
        if (key != null) {
            return tigerService.getTigersByName(key);
        } else {
            return tigerService.getAllTigers();
        }
    }

    @GetMapping("/tigers/habitat/{region}")
    public Object getTigersByHabitatRegion(@PathVariable String region) {
        return tigerService.getTigersByHabitatRegion(region);
    }

    @GetMapping("/tigers/subspecies/{subspecies}")
    public Object getTigersBySubspecies(@PathVariable String subspecies) {
        return tigerService.getTigersBySubspecies(subspecies);
    }

    @PostMapping("/tigers")
    public Object addTiger(@RequestBody tiger tiger) {
        return tigerService.addTiger(tiger);
    }

    @PutMapping("/tigers/{id}")
    public tiger updateTiger(@PathVariable Long id, @RequestBody tiger tiger) {
        tigerService.updateTiger(id, tiger);
        return tigerService.getTigerById(id);
    }

    @DeleteMapping("/tigers/{id}")
    public Object deleteTiger(@PathVariable Long id) {
        tigerService.deleteTiger(id);
        return tigerService.getAllTigers();
    }

    @PostMapping("/tigers/writeFile")
    public Object writeJson(@RequestBody tiger tiger) {
        return tigerService.writeJson(tiger);
    }

    @GetMapping("/tigers/readFile")
    public Object readJson() {
        return tigerService.readJson();
    }
}
