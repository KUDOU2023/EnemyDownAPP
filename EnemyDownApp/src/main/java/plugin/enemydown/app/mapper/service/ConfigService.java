package plugin.enemydown.app.mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plugin.enemydown.app.mapper.GameConfigMapper;
import plugin.enemydown.app.mapper.data.GameConfig;
import plugin.enemydown.app.mapper.data.SpawnEnemy;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ConfigService {
    //インスタンス（new)管理
    private final GameConfigMapper mapper;

    public List<GameConfig> searchConfig() {
        return mapper.selectConfigList();
    }
    public GameConfig searchConfig(String difficulty) {
        return mapper.selectConfig(difficulty);
    }

    public List<SpawnEnemy> searchSpawnEnemyList(String difficulty) {
        return mapper.selectSpawnEnemyList(difficulty);
    }

    public GameConfig registerConfig(GameConfig config) throws Exception {
        GameConfig existsConfig = searchConfig(config.getDifficulty());
        if (existsConfig != null){
            throw new Exception();
        }
        mapper.insertConfig(config);
        return mapper.selectConfig(config.getDifficulty());
    }

    public List<SpawnEnemy> updateEnemyScore(SpawnEnemy enemy){
        mapper.updateEnemyScore(enemy);
        return mapper.selectSpawnEnemyList(enemy.getDifficulty());
    }
}


