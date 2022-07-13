
public abstract class Camera {
    private FilmOperations filmOps;
    private ShutterOperations shutterOps;
    private MirrorOperations mirrorOps;

    protected Camera(FilmOperations filmOps, ShutterOperations shutterOps, MirrorOperations mirrorOps) {
        this.filmOps = filmOps;
        this.shutterOps = shutterOps;
        this.mirrorOps = mirrorOps;
    }

    public String takePhotograph(double shutterSpeed) {
        Logger.getInstance().log(getName() + " is taking a photograph");

        filmOps.engageFilmMechanism();
        filmOps.rollFilm();
        filmOps.releaseFilmMechanism();

        mirrorOps.openMirror();;

        shutterOps.setShutterSpeedSetting(shutterSpeed);
        shutterOps.initializeShutter();
        shutterOps.activateShutter();
        shutterOps.releaseShutter();

        mirrorOps.closeMirror();

       return Logger.getInstance().log(getName() + " is done taking this photograph");
    }

    public String takePhotograph() {
       return takePhotograph(20);
    }

    public abstract String getName() ;
}
