package edu.frank.headfirst.facade;

import edu.frank.headfirst.facade.TheaterLight;

/**
 * <p>
 * This class use the facade pattern to construct the home theater
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class HomeTheaterFacade {

	// use combination to integrate all the subsystem module.
	private Amplifier amplifier;
	private Tuner tuner;
	private CdPlayer cdPlayer;
	private DvdPlayer dvdPlayer;
	private Projector projector;
	private TheaterLight theaterLight;
	private Screen screen;
	private PopcornPopper popcornPopper;

	/**
	 *
	 * construct a new <code>HomeTheaterFacade</code> instance for class
	 *
	 * @param amplifier
	 * 			Amplifier object
	 * @param tuner
	 * 			Tuner object
	 * @param cdPlayer
	 * 			CdPlayer object
	 * @param dvdPlayer
	 * 			DvdPlayer object
	 * @param popcornPopper
	 * 			PopcornPopper object
	 * @param projector
	 * 			Projector object
	 * @param screen
	 * 			Screen object
	 * @param theaterLight
	 * 			TheaterLight object
	 * @since JavaBasic 1.0.0.0
	 */
	public HomeTheaterFacade(Amplifier amplifier, Tuner tuner,
			CdPlayer cdPlayer, DvdPlayer dvdPlayer,
			PopcornPopper popcornPopper, Projector projector, Screen screen,
			TheaterLight theaterLight) {
		this.amplifier = amplifier;
		this.tuner  = tuner;
		this.cdPlayer = cdPlayer;
		this.dvdPlayer = dvdPlayer;
		this.projector = projector;
		this.theaterLight = theaterLight;
		this.screen = screen;
		this.popcornPopper = popcornPopper;
	}

	/**
	 *
	 * start watching movie, every step entrust to subsystem module.
	 *
	 * @param movie
	 *			movie name
	 * @since JavaBasic 1.0.0.0
	 */
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie ...");
		popcornPopper.on();
		popcornPopper.pop();
		theaterLight.dim();
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setDvd(dvdPlayer);
		amplifier.setSurroundSound();
		amplifier.setVolume(5);
		dvdPlayer.on();
		dvdPlayer.play(movie);
	}

	/**
	 *
	 * stop watching movie, every step entrust to subsystem module.
	 *
	 *
	 * @since JavaBasic	1.0.0.0
	 */
	public void endMovie() {
		System.out.println("Shutting movie theater down ...");
		popcornPopper.off();
		theaterLight.on();
		screen.up();
		projector.off();
		amplifier.off();
		dvdPlayer.stop();
		dvdPlayer.eject();
		dvdPlayer.off();
	}
}
