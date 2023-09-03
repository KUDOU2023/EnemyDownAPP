package plugin.enemydown.app.mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plugin.enemydown.app.mapper.GameConfigMapper;
import plugin.enemydown.app.mapper.data.GameConfig;
import plugin.enemydown.app.mapper.data.SpawnEnemy;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigService {

    //インスタンス（new)すると1つの設計図から
    public final GameConfigMapper mapper;

    public List<GameConfig> searchConfig() {
        return mapper.selectConfigList();
    }
    public GameConfig searchConfig(String difficulty) {
        return mapper.selectConfig(difficulty);
    }

    public List<SpawnEnemy> searchSpawnEnemyList(String difficulty) {
        return mapper.selectSpawnEnemyList(difficulty);
    }
}


