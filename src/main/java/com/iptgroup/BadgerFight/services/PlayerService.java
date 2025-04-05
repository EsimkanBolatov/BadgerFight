package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.PlayerEntity;
import com.iptgroup.BadgerFight.entity.UserEntity;
import com.iptgroup.BadgerFight.repository.PlayerRepository;
import com.iptgroup.BadgerFight.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final UserRepository userRepository;

    public PlayerService(PlayerRepository playerRepository, UserRepository userRepository) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
    }

    public PlayerEntity createPlayerForUser(String username, String playerName) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPlayer() != null) {
            throw new RuntimeException("User already has a player");
        }

        PlayerEntity player = new PlayerEntity();
        player.setName(playerName);
        player.setLevel(1);
        player.setUser(user);

        return playerRepository.save(player);
    }

    public PlayerEntity updatePlayer(Long id, PlayerEntity playerDetails) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(playerDetails.getName());
                    player.setLevel(playerDetails.getLevel());
                    return playerRepository.save(player);
                })
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }


}

