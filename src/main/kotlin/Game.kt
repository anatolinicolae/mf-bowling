class Game {
    // 10 frames with 2 possible rolls each and an optional extra shot at the end
    private val rolls = IntArray(21)
    private var currentRoll = 0

    // Store rolled pins in array
    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    /**
     * Calculate a net score including bonuses
     *
     * Should be called once, at the end of the game.
     * Will result in a partial score if called earlier in the game
     * as it doesn't have enough window to compute all bonuses.
     */
    fun score(): Int {
        var score = 0
        var frameIndex = 0
        for (frame in 0 until 10) {
            if (isStrike(frameIndex)) {
                // Add strike bonus to score
                score += 10 + strikeBonus(frameIndex)
                frameIndex++
            } else if (isSpare(frameIndex)) {
                // Add spare bonus to score
                score += 10 + spareBonus(frameIndex)
                frameIndex += 2
            } else {
                score += frameScore(frameIndex)
                frameIndex += 2
            }
        }
        return score
    }

    // Rolling 10 in a frame is a strike
    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10

    // Strike bonus is equal to the value of next two rolls after current frame
    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex + 1] + rolls[frameIndex + 2]

    // Rolling 10 in the current frame (i + i+1) is a spare
    private fun isSpare(frameIndex: Int) = frameScore(frameIndex) == 10

    // Spare bonus is the value of the next roll
    private fun spareBonus(frameIndex: Int) = rolls[frameIndex + 2]

    private fun frameScore(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1]
}
