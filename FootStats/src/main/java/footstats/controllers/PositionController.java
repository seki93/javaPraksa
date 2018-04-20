package footstats.controllers;

import footstats.model.Position;
import footstats.repository.PositionRepository;
import footstats.service.PositionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping(path = "/all")
    public Iterable<Position> findAll(){
        return positionService.findAll();
    }

    @PostMapping(path = "/add")
    public String addPosition(@RequestParam String name){
        Position position = new Position();
        position.setName(name);

        positionService.save(position);
        return "Saved new position";
    }

    @PostMapping(path = "/delete")
    public String deletePosition(@RequestParam String name){
        Position p = positionService.findByName(name);

        if(p.getId() == null) return "Wrong id";

        positionService.deleteById(p.getId());
        return "Deleted position";
    }
}
