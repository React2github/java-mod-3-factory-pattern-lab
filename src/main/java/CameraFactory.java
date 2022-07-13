
        public class CameraFactory {
            public enum CameraManufacturer {
                CANON_FILM("Canon Film");

                String name;

                private CameraManufacturer(String name) {
                    this.name = name;
                }
            }

            public Camera makeCamera(CameraManufacturer manufacturer) {
                if (manufacturer == CameraManufacturer.CANON_FILM) {
                    return new CanonCamera(new CanonFilm(), new CanonShutter(), new CanonMirror());
                }

                return null; // will never happen because we're using an enum but required to satisfy the
                             // compiler
            }
        }
