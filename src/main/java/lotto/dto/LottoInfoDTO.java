package lotto.dto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class LottoInfoDTO {
    private final Lotto lotto;
    private Integer matchCount;
    private boolean matchBonus;
    public LottoInfoDTO(Lotto lotto) {
        this.lotto = lotto;
        this.matchCount = 0;
        this.matchBonus = false;
    }
    public Lotto getLotto() {
        return this.lotto;
    }
    public Integer getMatchCount() {
        return this.matchCount;
    }
    public boolean isMatchBonus(BonusNumber bonusNumber) {
        this.matchBonus = this.contain(bonusNumber.bonusNumber());
        return this.matchBonus;
    }
    public boolean contain(Integer number) {
        return this.lotto.numbers().contains(number);
    }
    public void countMatch(Lotto winningLotto) {
        winningLotto.numbers().stream().filter(this::contain).forEach(number -> this.matchCount++);
    }
}
