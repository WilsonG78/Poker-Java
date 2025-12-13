package common.protocol;


interface PokerCommandFactory {
    String toReadableString();
    PokerCommandFactory parserFromString(String rawText);
}
