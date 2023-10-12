public class VolumeCalculator {
        public static void main(String[] args) {
            // diameters of Earth and Sun in miles
            double diameterEarth = 7600.0;
            double diameterSun = 865000.0;
            // radius of Earth and Sun
            double radiusEarth = diameterEarth / 2.0;
            double radiusSun = diameterSun / 2.0;
    
            // Calculate the volumes of Earth and Sun
            double volumeEarth = (4.0 / 3.0) * Math.PI * Math.pow(radiusEarth, 3);
            double volumeSun = (4.0 / 3.0) * Math.PI * Math.pow(radiusSun, 3);
    
            // Calculate the ratio of the volume of Sun to the volume of Earth
            double ratio = volumeSun / volumeEarth;
    
            // Output the results
            System.out.println("The volume of the Earth is " + volumeEarth + " cubic miles.");
            System.out.println("The volume of the Sun is " + volumeSun + " cubic miles.");
            System.out.println("The ratio of the volume of the Sun to the volume of the Earth is " + ratio);
        }
}
