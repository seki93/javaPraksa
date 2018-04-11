package footstats.controllers;

import footstats.model.Position;
import footstats.repository.PositionRepository;
import footstats.service.PositionService;
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
    public String deletePosition(@RequestParam Integer id){
        if(id == null) return "Wrong id";

        positionService.deleteById(id);
        return "Deleted position";
    }
}
