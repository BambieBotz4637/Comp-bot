package frc.robot.subsystems;


import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.AddressableLED.ColorOrder;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.units.measure.Time;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.util.Color;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.Second;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.LEDPattern;

public class LedSubsystem extends SubsystemBase {

    private static LedSubsystem instance;

    public static LedSubsystem getInstance() {
        if (instance == null) {
            instance = new LedSubsystem();
        }
        return instance;
    }
    
    // Robot states
    public boolean coralPresent = false;
    public boolean isDisabled = false;
    
    // Constants
    private static final int ledLength = 60;
    private static final Distance kLedSpacing = Meters.of(1 / 60.0);

    // the LEDs
    private final AddressableLED m_leds;
    private final AddressableLEDBuffer m_buffer;

    // the Patterns
    private static final LEDPattern m_rainbow = LEDPattern.rainbow(255, 128);
    private static final LEDPattern m_scrollingRainbow =
            m_rainbow.scrollAtAbsoluteSpeed(MetersPerSecond.of(0.10), kLedSpacing);
    private final LEDPattern m_solidYellow = LEDPattern.solid(Color.kYellow);
    private final LEDPattern m_scrollingYellow = 
          m_solidYellow.blink(Second.of(1.0), Second.of(0.5));
    private final LEDPattern m_solidPurple = LEDPattern.solid(Color.kPurple);
    private final LEDPattern m_scrollingPurple = 
         m_solidPurple.blink(Second.of(1.0), Second.of(0.5));
    private final LEDPattern m_solidBrown = LEDPattern.solid(Color.kBrown);
    private final LEDPattern m_scrollingBrown = 
         m_solidBrown.blink(Second.of(1.0), Second.of(0.5));


    /**
     * This subsytem that controls the LEDs.
     */
    private LedSubsystem () {

        m_leds = new AddressableLED(9);
        m_leds.setColorOrder(ColorOrder.kRGB);
        m_buffer = new AddressableLEDBuffer(ledLength);
        m_leds.setLength(ledLength);
        m_leds.setData(m_buffer);
        m_leds.start();

    }

    @Override
    public void periodic() {

        // Update the buffer

        if (coralPresent) {
            m_solidYellow.applyTo(m_buffer);
        } else {
            m_solidBrown.applyTo(m_buffer);
        }
        // m_solidGreen.applyTo(m_buffer);

        // Set the LEDs
        m_leds.setData(m_buffer);

    }

    /**
     *  Method placeholder
     */
    public void doNothing() {

    }

}