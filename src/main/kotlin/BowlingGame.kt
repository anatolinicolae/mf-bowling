import java.lang.IndexOutOfBoundsException

open class BowlingGame {
    // 10 frames with 2 possible rolls each and an optional extra shot at the end
    protected open var maxFrames = 10;
    protected open var maxRolls = 2;
    protected open var extraRolls = 1;
    protected open var maxPins = 10;

    private val rolls by lazy { IntArray(maxFrames * maxRolls + extraRolls) }
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
        for (frame in 0 until maxFrames) {
            resetPins(frame)

            if (isStrike(frameIndex)) {
                // Add strike bonus to score
                score += maxPins + strikeBonus(frameIndex)
                frameIndex++
            } else if (isSpare(frameIndex)) {
                // Add spare bonus to score
                score += maxPins + spareBonus(frameIndex)
                frameIndex += maxRolls
            } else {
                score += frameScore(frameIndex)
                frameIndex += maxRolls
            }
        }
        return score
    }

    /**
     * Reset pings on each frame
     *
     * Doesn't change in a basic game, as pins reset to 10 by default.
     */
    open fun resetPins(frame: Int) {
        // maxPins = 10
    }

    // Rolling 10 in a frame is a strike
    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == maxPins

    // Strike bonus is equal to the value of next two rolls after current frame
    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex + 1] + rolls[frameIndex + 2]

    // Rolling 10 in the current frame (i + i+1) is a spare
    private fun isSpare(frameIndex: Int) = frameScore(frameIndex) == maxPins

    // Spare bonus is the value of the next roll
    private fun spareBonus(frameIndex: Int) = rolls[frameIndex + maxRolls]

    // Sum frame rolls between startIndex until startIndex + maxRolls
    private fun frameScore(startIndex: Int): Int {
        var sum = 0
        try {
            for (i in 0 until maxRolls) {
                sum += rolls[startIndex + i]
            }
        } catch (_: IndexOutOfBoundsException) {
        }
        return sum
    }
}
