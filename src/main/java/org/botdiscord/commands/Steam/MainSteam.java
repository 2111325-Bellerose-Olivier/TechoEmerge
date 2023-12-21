package org.botdiscord.commands.Steam;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class MainSteam {
    public static String main() {
        String apiKey = "9AE1A7120B96C892BA47012BB5C2641E";
        String jeuRecherche = "Fallout 4"; // Remplacez par le nom du jeu que vous souhaitez rechercher
        String message;

        // 1. Effectuez une requête de recherche pour obtenir l'ID du jeu
        String appId = getGameId(apiKey, jeuRecherche);
        appId = "377160";

        if (appId != null) {
            // 2. Utilisez l'ID pour obtenir les détails du jeu, y compris le prix
            String prix = getGamePrice(apiKey, appId);

            if (prix != null) {
                return message = ("Le prix de " + jeuRecherche + " est : " + prix);
            } else {
               return message = "Impossible d'obtenir le prix du jeu.";
            }
        } else {
            return message = "jeu non trouvé";
        }
    }

    // Fonction pour obtenir l'ID du jeu par son nom
    private static String getGameId(String apiKey, String jeuRecherche) {
        OkHttpClient client = new OkHttpClient();
        String url = "http://api.steampowered.com/ISteamApps/GetAppList/v0002/";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();

            // Analyser la réponse JSON pour obtenir l'ID du jeu par son nom
            JSONObject jsonObject = new JSONObject(responseData);
            JSONObject appList = jsonObject.getJSONObject("applist");
            JSONObject apps = appList.getJSONObject("apps");
            if (apps.has(jeuRecherche)) {
                return apps.getJSONObject(jeuRecherche).getString("appid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Fonction pour obtenir le prix du jeu par son ID
    private static String getGamePrice(String apiKey, String appId) {
        OkHttpClient client = new OkHttpClient();
        String url = "http://store.steampowered.com/api/appdetails?appids=" + appId + "&cc=fr&l=fr";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();

            // Analyser la réponse JSON pour obtenir le prix du jeu
            JSONObject jsonObject = new JSONObject(responseData);
            JSONObject appDetails = jsonObject.getJSONObject(appId);
            JSONObject data = appDetails.getJSONObject("data");

            if (data.has("price_overview")) {
                return data.getJSONObject("price_overview").getString("final_formatted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
