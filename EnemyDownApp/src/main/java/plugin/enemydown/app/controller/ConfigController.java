package plugin.enemydown.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plugin.enemydown.app.mapper.data.GameConfig;
import plugin.enemydown.app.mapper.data.SpawnEnemy;
import plugin.enemydown.app.mapper.service.ConfigService;

import java.util.List;

@RestController

public class ConfigController {

@Autowired
    private ConfigService service;

    @RequestMapping(value = "/configList", method = RequestMethod.GET)
    public List<GameConfig> configList(){
        return service.searchConfig();
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public GameConfig config(@RequestParam String difficulty){
        return service.searchConfig(difficulty);
    }

    @RequestMapping(value = "/spawnEnemyList", method = RequestMethod.GET)
    public List<SpawnEnemy> spawnEnemyList(@RequestParam String difficulty){
        return service.searchSpawnEnemyList(difficulty);
    }
}
