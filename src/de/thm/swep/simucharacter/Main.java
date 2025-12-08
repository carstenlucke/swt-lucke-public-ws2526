package de.thm.swep.simucharacter;

import de.thm.swep.simucharacter.characters.*;

/**
 * Client-Klasse, die das Strategy Pattern demonstriert.
 *
 * <p>Diese Klasse zeigt die Verwendung des Strategy Patterns in der Praxis.
 * Verschiedene Character-Objekte werden mit ihren jeweiligen Strategien erstellt
 * und ausgeführt, ohne dass der Client-Code die konkreten Implementierungen
 * der Strategien kennen muss.</p>
 *
 * <p><b>Demonstration des Strategy Patterns:</b></p>
 * <ul>
 *   <li>Jeder Charakter hat sein eigenes Waffenverhalten (Strategy)</li>
 *   <li>Der Client-Code arbeitet mit der Character-Schnittstelle</li>
 *   <li>Die konkrete Strategie wird zur Laufzeit ausgeführt (Polymorphie)</li>
 *   <li>Unterschiedliches Verhalten wird durch verschiedene Strategy-Objekte erreicht,
 *       nicht durch bedingte Anweisungen</li>
 * </ul>
 *
 * <p><b>Ausgabebeispiel:</b></p>
 * <pre>
 * class de.thm.swep.simucharacter.characters.King kämpt: Schießt mit Pfeil und Bogen.
 * class de.thm.swep.simucharacter.characters.Queen kämpt: Schneidet mit Messer.
 * class de.thm.swep.simucharacter.characters.Knight kämpt: Schwingt das Schwert.
 * class de.thm.swep.simucharacter.characters.Troll kämpt: Hackt mit der Axt.
 * </pre>
 *
 * @see Character
 * @see de.thm.swep.simucharacter.behaviors.weapon.WeaponBehavior
 */
public class Main {

    /**
     * Hauptmethode, die verschiedene Charaktere mit ihren jeweiligen Strategien erstellt
     * und ausführt.
     *
     * <p>Diese Methode demonstriert das Strategy Pattern, indem sie zeigt, wie
     * verschiedene Character-Objekte mit unterschiedlichen Strategien erstellt
     * und polymorphisch verwendet werden können.</p>
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        _fight(new King());
        _fight(new Queen());
        _fight(new Knight());
        _fight(new Troll());
        _fight(new ThmStudent());
    }

    /**
     * Hilfsmethode, die einen Charakter kämpfen lässt.
     *
     * <p>Diese Methode zeigt den zentralen Vorteil des Strategy Patterns:
     * Der Client-Code kennt nur die Character-Schnittstelle und ruft fight() auf.
     * Die konkrete Strategie (Waffenverhalten) wird zur Laufzeit durch den
     * jeweiligen Character bestimmt, ohne dass hier bedingte Anweisungen
     * (if/switch) nötig sind.</p>
     *
     * @param c der Charakter, der kämpfen soll
     */
    private static void _fight(Character c) {
        System.out.printf("%s kämpft: ", c.getClass());
        c.fight();
    }
}
