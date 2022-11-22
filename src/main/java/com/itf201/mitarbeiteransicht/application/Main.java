package com.itf201.mitarbeiteransicht.application;

import com.itf201.mitarbeiteransicht.backend.CSVRepository;
import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;
import com.itf201.mitarbeiteransicht.backend.ReaderWriter;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import com.itf201.mitarbeiteransicht.frontend.MitarbeiterWindow;
import com.itf201.mitarbeiteransicht.rollenspiel.characters.King;
import com.itf201.mitarbeiteransicht.rollenspiel.characters.Knight;
import com.itf201.mitarbeiteransicht.rollenspiel.characters.Queen;
import com.itf201.mitarbeiteransicht.rollenspiel.characters.Troll;
import com.itf201.mitarbeiteransicht.rollenspiel.weapons.Axe;
import com.itf201.mitarbeiteransicht.rollenspiel.weapons.BowAndArrow;
import com.itf201.mitarbeiteransicht.rollenspiel.weapons.Knife;
import com.itf201.mitarbeiteransicht.rollenspiel.weapons.Sword;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        //createApp();
        createRolePlay();
    }

    private static void createRolePlay() {
        Troll troll = new Troll(new BowAndArrow());
        King king = new King(new Axe());
        Queen queen = new Queen(new Sword());
        Knight knight = new Knight(new Knife());

        knight.fight();
        knight.setWeapon(new Axe());
        knight.fight();

        queen.fight();
        king.fight();
        troll.fight();
    }

    private static void createApp() {
        // Create a few users for new ""database""
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                3040,
                "Angela Merkel",
                MitarbeiterTyp.SCHICHTARBEITER,
                1.0,
                1.0,
                1.0,
                1));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                3030,
                "Erik Borner",
                MitarbeiterTyp.SCHICHTARBEITER,
                1.0,
                1.0,
                1.0,
                1));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                3032,
                "Marcell Davis",
                MitarbeiterTyp.SCHICHTARBEITER,
                1.0,
                1.0,
                1.0,
                1));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                5105,
                "Der Manager",
                MitarbeiterTyp.MANAGER,
                1.0,
                1.0,
                1.0,
                1));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                5109,
                "Der andere Manager",
                MitarbeiterTyp.MANAGER,
                1.0,
                1.0,
                1.0,
                1));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                5012,
                "NAME NAME",
                MitarbeiterTyp.BUEROARBEITER,
                1.0,
                1.0,
                1.0,
                1));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                5051,
                "Was geht",
                MitarbeiterTyp.BUEROARBEITER,
                1.0,
                1.0,
                1.0,
                1));

        // Open Window
        MitarbeiterWindow window = new MitarbeiterWindow(onClose());

    }

    private static Runnable onClose() {
        File file = new File(CSVRepository.FILE_PATH);
        final boolean result = file.delete();
        return null;
    }
}
