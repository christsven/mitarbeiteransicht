package com.itf201.mitarbeiteransicht.application;

import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;
import com.itf201.mitarbeiteransicht.backend.ReaderWriter;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import com.itf201.mitarbeiteransicht.composite.lego.LegoBausatz;
import com.itf201.mitarbeiteransicht.composite.lego.LegoCity;
import com.itf201.mitarbeiteransicht.composite.lego.LegoStein;
import com.itf201.mitarbeiteransicht.frontend.MitarbeiterWindow;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters.King;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters.Knight;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters.Queen;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.characters.Troll;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.Axe;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.BowAndArrow;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.Knife;
import com.itf201.mitarbeiteransicht.rollenspiel.strategy.weapons.Sword;
import com.itf201.mitarbeiteransicht.rollenspiel.template.characters.TemplateKing;
import com.itf201.mitarbeiteransicht.rollenspiel.template.characters.TemplateKnight;
import com.itf201.mitarbeiteransicht.rollenspiel.template.characters.TemplateQueen;
import com.itf201.mitarbeiteransicht.rollenspiel.template.characters.TemplateTroll;
import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateAxe;
import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateBow;
import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateKnife;
import com.itf201.mitarbeiteransicht.rollenspiel.template.weapons.TemplateSword;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        createLegoCity();
    }

    private static void createTemplateRolePlay() {
        final TemplateKing king = new TemplateKing(new TemplateAxe());
        final TemplateKnight knight = new TemplateKnight(new TemplateBow());
        final TemplateTroll troll = new TemplateTroll(new TemplateSword());
        final TemplateQueen queen = new TemplateQueen(new TemplateKnife());

        king.fight();
        queen.fight();
        troll.fight();
        knight.fight();

        queen.setWeapon(new TemplateSword());
        queen.fight();
    }

    private static void createRolePlay() {
        final Troll troll = new Troll(new BowAndArrow());
        final King king = new King(new Axe());
        final Queen queen = new Queen(new Sword());
        final Knight knight = new Knight(new Knife());

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
                -1,
                "Angela Merkel",
                MitarbeiterTyp.SCHICHTARBEITER,
                0.0,
                40.0,
                0.0,
                41));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                -1,
                "Erik Borner",
                MitarbeiterTyp.SCHICHTARBEITER,
                114.0,
                1516.0,
                16.0,
                41));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                -1,
                "Marcell Davis",
                MitarbeiterTyp.SCHICHTARBEITER,
                163.0,
                16.0,
                136.0,
                41));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                -1,
                "Der Manager",
                MitarbeiterTyp.MANAGER,
                17.0,
                137.0,
                371.0,
                41));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                -1,
                "Der andere Manager",
                MitarbeiterTyp.MANAGER,
                271.0,
                126.0,
                17.0,
                14));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                -1,
                "NAME NAME",
                MitarbeiterTyp.BUEROARBEITER,
                1.0,
                1.0,
                1.0,
                41));
        ReaderWriter.createMitarbeiter(new MitarbeiterDto(
                -1,
                "Was geht",
                MitarbeiterTyp.BUEROARBEITER,
                0.0,
                15.0,
                0.0,
                41));

        // Open Window
        MitarbeiterWindow window = new MitarbeiterWindow();

    }

    private static void createLegoCity() {
        final LegoStein brick = new LegoStein("Doppelsteil", 0.5);
        final LegoStein brick0 = new LegoStein("Einzelteil", 0.25);
        final LegoStein brick1 = new LegoStein("Riesenstein", 2.4);
        final LegoStein brick2 = new LegoStein("Stein", 4);
        final LegoStein brick3 = new LegoStein("Premiumblock", 24);

        final LegoBausatz bausatzHaus = new LegoBausatz("Kleines Haus", List.of(brick, brick3));
        final LegoBausatz bausatzSkyScraper = new LegoBausatz("Wolkenkratzer", List.of(brick0, brick1, brick2));

        final LegoCity city = new LegoCity(List.of(bausatzHaus, bausatzSkyScraper));

        System.out.println(brick.getPrice());
        System.out.println(brick0.getPrice());
        System.out.println(brick1.getPrice());
        System.out.println(brick2.getPrice());
        System.out.println(brick3.getPrice());
        System.out.println("***********************");
        System.out.println(bausatzHaus.getPrice());
        System.out.println(bausatzSkyScraper.getPrice());
        System.out.println("***********************");
        System.out.println(city.getPrice());
    }
}
