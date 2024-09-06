package com.workintech.s19d1.controller;


import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id) {
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor) {
        actor.setId(id);
        return actorService.save(actor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> delete(@PathVariable Long id) {
        Actor actor = actorService.findById(id);
        if (actor != null) {
            actorService.delete(actor);
            return ResponseEntity.ok(actor);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
