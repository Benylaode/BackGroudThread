package com.example.tugaspraktikum5fahmi;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<MamaliaPurba> mamaliaPurba = generateDummyMamaliaPurba();

    private static ArrayList<MamaliaPurba> generateDummyMamaliaPurba() {
        ArrayList<MamaliaPurba> mamalia = new ArrayList<>();
        mamalia.add(new MamaliaPurba("Gajah Purba", "Raksasa Era Es",
                "Gajah Purba, dengan bulu panjangnya yang tebal dan gading yang mengesankan, berkeliaran di tundra es selama Era Es."
                ,R.drawable.gajah_purba,R.drawable.gajah_purba));

        mamalia.add(new MamaliaPurba("Kucing Gigi Saber", "Smilodon",
                "Kucing Gigi Saber, dengan gigi taringnya yang ikonik, adalah predator menakutkan pada zaman Pleistosen."
                ,R.drawable.kucing_gigi_saber,R.drawable.kucing_gigi_saber));

        mamalia.add(new MamaliaPurba("Sloth Raksasa", "Megatherium",
                "Sloth Raksasa, dengan ukurannya yang besar dan cakar yang kuat, adalah herbivora yang bergerak lambat yang hidup di Amerika selama Era Es."
                ,R.drawable.sloth_raksasa, R.drawable.sloth_raksasa));

        mamalia.add((new MamaliaPurba("Glyptodon", "Raksasa Berkulit",
                "Glyptodon, menyerupai kelelawar raksasa, adalah mamalia berlapis berat yang hidup selama zaman Pleistosen."
                ,R.drawable.glyptodon,R.drawable.glyptodon)));

        mamalia.add(new MamaliaPurba("Megaloceros", "Rusa Irlandia",
                "Megaloceros, juga dikenal sebagai Rusa Irlandia, adalah spesies rusa raksasa dengan tanduk mengesankan yang hidup selama zaman Pleistosen."
                ,R.drawable.megaloceros,R.drawable.megaloceros));

        return mamalia;
    }
}
