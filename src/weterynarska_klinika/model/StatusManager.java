package weterynarska_klinika.model;

import weterynarska_klinika.enumy.*;

public class StatusManager {
    public static void zmienStatus(Zwierze z, StatusZwierzecia status) {
        z.setStatus(status);
    }
}
