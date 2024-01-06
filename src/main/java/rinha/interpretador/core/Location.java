package rinha.interpretador.core;

public record Location(
        int start,
        int end,
        String filename
) {
}
