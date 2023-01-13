fun main(args: Array<String>) {
    val game = Game()

    val enableStepScore = true

    // Frame 1
    game.roll(1)
    game.roll(4)
    if (enableStepScore) println(game.score())

    // Frame 2
    game.roll(4)
    game.roll(5)
    if (enableStepScore) println(game.score())

    // Frame 3
    game.roll(6)
    game.roll(4)
    if (enableStepScore) println(game.score())

    // Frame 4
    game.roll(5)
    game.roll(5)
    if (enableStepScore) println(game.score())

    // Frame 5
    game.roll(10)
    if (enableStepScore) println(game.score())

    // Frame 6
    game.roll(0)
    game.roll(1)
    if (enableStepScore) println(game.score())

    // Frame 7
    game.roll(7)
    game.roll(3)
    if (enableStepScore) println(game.score())

    // Frame 8
    game.roll(6)
    game.roll(4)
    if (enableStepScore) println(game.score())

    // Frame 9
    game.roll(10)
    if (enableStepScore) println(game.score())

    // Frame 10
    game.roll(2)
    game.roll(8)
    game.roll(6)
    println(game.score())
}
