package com.iptgroup.BadgerFight.services;

import com.iptgroup.BadgerFight.entity.PlayerEntity;
import com.iptgroup.BadgerFight.entity.PlayerQuestProgressEntity;
import com.iptgroup.BadgerFight.entity.QuestEntity;
import com.iptgroup.BadgerFight.entity.QuestStepEntity;
import com.iptgroup.BadgerFight.repository.PlayerQuestProgressRepository;
import com.iptgroup.BadgerFight.repository.QuestRepository;
import com.iptgroup.BadgerFight.repository.QuestStepRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
public class QuestService {

    private final QuestRepository questRepository;
    private final QuestStepRepository questStepRepository;
    private final PlayerQuestProgressRepository progressRepository;

    @Autowired
    public QuestService(QuestRepository questRepository, PlayerQuestProgressRepository progressRepository, QuestStepRepository questStepRepository) {
        this.questRepository = questRepository;
        this.questStepRepository = questStepRepository;
        this.progressRepository = progressRepository;
    }

    // Метод для начала квеста
    public String startQuest(Long playerId, Long questId) {
        Optional<PlayerQuestProgressEntity> existingProgress = progressRepository.findByPlayerIdAndQuestId(playerId, questId);
        if (existingProgress.isPresent()) {
            return "Вы уже начали этот квест!";
        }

        PlayerQuestProgressEntity progress = new PlayerQuestProgressEntity();
        progress.setPlayer(new PlayerEntity());
        progress.getPlayer().setId(playerId);
        progress.setQuest(new QuestEntity());
        progress.getQuest().setId(questId);
        progress.setCurrentStep(1);
        progress.setCompleted(false);

        progressRepository.save(progress);
        return "Квест начат!";
    }

    // Метод для обновления прогресса квеста
    public String updateQuestProgress(Long playerId, Long questId, String answer) {
        Optional<PlayerQuestProgressEntity> progressOpt = progressRepository.findByPlayerIdAndQuestId(playerId, questId);

        if (progressOpt.isEmpty()) {
            return "Квест не найден!";
        }

        PlayerQuestProgressEntity progress = progressOpt.get();
        Optional<QuestStepEntity> stepOpt = questStepRepository.findById((long) progress.getCurrentStep());

        if (stepOpt.isPresent()) {
            QuestStepEntity step = stepOpt.get();
            if (step.getCorrectAnswer().equalsIgnoreCase(answer.trim())) {
                progress.setCurrentStep(progress.getCurrentStep() + 1);

                if (progress.getCurrentStep() > 3) { // Например, если всего 3 этапа
                    progress.setCompleted(true);
                    progressRepository.save(progress);
                    return "Квест завершен!";
                }

                progressRepository.save(progress);
                return "Правильный ответ! Продолжайте!";
            } else {
                return "Неправильный ответ! Попробуйте еще раз.";
            }
        }
        return "Ошибка! Этап не найден!";
    }

    // Создание нового квеста
    public QuestEntity createQuest(QuestEntity quest) {
        return questRepository.save(quest);
    }

    // Получение квеста по ID
    public Optional<QuestEntity> getQuestById(Long id) {
        return questRepository.findById(id);
    }

    // Проверка ответа на конкретный этап квеста
    public String checkAnswer(Long stepId, String answer) {
        Optional<QuestStepEntity> stepOptional = questStepRepository.findById(stepId);

        if (stepOptional.isPresent()) {
            QuestStepEntity step = stepOptional.get();
            if (step.getCorrectAnswer().equalsIgnoreCase(answer.trim())) {
                return "Правильный ответ! Вы переходите на следующий этап.";
            } else {
                return "Ответ неверный. Попробуйте еще раз!";
            }
        } else {
            return "Этап квеста не найден.";
        }
    }
}

