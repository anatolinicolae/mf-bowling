open class VenusianBowlingGame() : MartianBowlingGame() {
    // Start with 1 pin only
    override var maxPins = 0;

    /**
     * Reset pings on each frame, adding a pin until 11th frame
     */
    override fun resetPins(frame: Int) {
        if (frame < 11) maxPins = frame + 1
    }
}
