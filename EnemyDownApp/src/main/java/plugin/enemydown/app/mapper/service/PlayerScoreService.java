package plugin.enemydown.app.mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plugin.enemydown.app.mapper.PlayerScoreMapper;
import plugin.enemydown.app.mapper.data.PlayerScore;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerScoreService {

    private final PlayerScoreMapper mapper;
    public List<PlayerScore> searchPlayerScoreList() {
        return mapper.selectPlayerScoreList();
    }
}
