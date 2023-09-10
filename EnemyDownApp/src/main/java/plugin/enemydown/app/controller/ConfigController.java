package plugin.enemydown.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plugin.enemydown.app.mapper.data.GameConfig;
import plugin.enemydown.app.mapper.data.SpawnEnemy;
import plugin.enemydown.app.mapper.service.ConfigService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConfigController {

    private final ConfigService service;

    @GetMapping(value = "/configList")
    public List<GameConfig> serchConfigList(){
        return service.searchConfig();
    }

    @GetMapping(value = "/config")
    public GameConfig searchConfig(@RequestParam String difficulty){
        return service.searchConfig(difficulty);
    }

    @GetMapping(value = "/spawnEnemyList")
    public List<SpawnEnemy> spawnEnemyList(@RequestParam String difficulty){
        return service.searchSpawnEnemyList(difficulty);
    }


    //@ResponseBodyは@RestControllerがついている時自動で適用される
    @PostMapping(value = "/config")
    public ResponseEntity<GameConfig> registerConfig(@RequestBody GameConfig config) throws Exception {
        GameConfig registerConfig = service.registerConfig(config);
        return new ResponseEntity<>(registerConfig, HttpStatus.OK);
    }

    @PostMapping(value = "/updateEnemyScore")
    public ResponseEntity<List<SpawnEnemy>> updateEnemyScore(@RequestBody SpawnEnemy enemy) {
        List<SpawnEnemy> updatedSpawnEnemyList = service.updateEnemyScore(enemy);
        return new ResponseEntity<>(updatedSpawnEnemyList, HttpStatus.OK);
    }
}
