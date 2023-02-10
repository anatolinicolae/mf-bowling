fun main(args: Array<String>) {
    val bowlingGame = BowlingGame()

    val enableStepScore = true

    // Frame 1
    bowlingGame.roll(1)
    bowlingGame.roll(4)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 2
    bowlingGame.roll(4)
    bowlingGame.roll(5)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 3
    bowlingGame.roll(6)
    bowlingGame.roll(4)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 4
    bowlingGame.roll(5)
    bowlingGame.roll(5)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 5
    bowlingGame.roll(10)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 6
    bowlingGame.roll(0)
    bowlingGame.roll(1)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 7
    bowlingGame.roll(7)
    bowlingGame.roll(3)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 8
    bowlingGame.roll(6)
    bowlingGame.roll(4)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 9
    bowlingGame.roll(10)
    if (enableStepScore) println(bowlingGame.score())

    // Frame 10
    bowlingGame.roll(2)
    bowlingGame.roll(8)
    bowlingGame.roll(6)
    println(bowlingGame.score())
}
