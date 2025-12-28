package section12.Challenges.GenericClassChallengeBuildingReusableStructures;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        //  Tim Buchalka's solution for this challenge is very different but also very interesting, check it out!

        River lima = new River("Rio Lima");

        Bridge limaPonte = new Bridge(41.76982107817811, -8.586622382438915, "Ponte do Lima", "Ponte de Lima", lima);
        Bridge barca = new Bridge(41.809649256847024, -8.420718728531366, "Ponte da Barca", "Ponte da Barca", lima);
        Bridge eifel = new Bridge(41.69373664457334, -8.818617332048468, "Ponte Eifel", "Viana do Castelo", lima);

        lima.getLine().addPoint(limaPonte.getPoint(), 0);
        lima.getLine().addPoint(barca.getPoint(), 0);
        lima.getLine().addPoint(eifel.getPoint());

        // System.out.println(lima.render());
        // System.out.println(limaPonte.render());
        // System.out.println(barca.render());
        // System.out.println(eifel.render());

        Layer<Mappable> layerFull = new Layer<>(new ArrayList<>());
        layerFull.addElement(lima);
        layerFull.addElement(limaPonte);
        layerFull.addElement(barca);
        layerFull.addElement(eifel);

        layerFull.renderLayer();

        Layer<River> layerRivers = new Layer<>(new ArrayList<>());
        layerRivers.addElement(lima);
        Layer<Bridge> layerBridges = new Layer<>(new ArrayList<>());
        layerBridges.addElement(limaPonte);
        layerBridges.addElement(barca);
        layerBridges.addElement(eifel);

        System.out.printf("%n%n%n");
        layerRivers.renderLayer();

        System.out.printf("%n%n%n");
        layerBridges.renderLayer();

    }

}
