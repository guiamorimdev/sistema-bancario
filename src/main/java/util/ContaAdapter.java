package util;

import com.google.gson.*;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.lang.reflect.Type;

public class ContaAdapter implements JsonSerializer<Conta>, JsonDeserializer<Conta> {

    @Override
    public JsonElement serialize(Conta src, Type typeOfSrc, JsonSerializationContext context) {
        Gson gsonBasico = new GsonBuilder()
                .registerTypeAdapter(java.time.LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        JsonObject jsonObject = gsonBasico.toJsonTree(src).getAsJsonObject();

        if (src instanceof ContaCorrente) {
            jsonObject.addProperty("tipoConta", "CORRENTE");
        } else if (src instanceof ContaPoupanca) {
            jsonObject.addProperty("tipoConta", "POUPANCA");
        }

        return jsonObject;
    }

    @Override
    public Conta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement tipoElement = jsonObject.get("tipoConta");

        String tipo = (tipoElement != null && !tipoElement.isJsonNull())
                ? tipoElement.getAsString()
                : "CORRENTE";

        Gson gsonBasico = new GsonBuilder()
                .registerTypeAdapter(java.time.LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        if ("POUPANCA".equals(tipo)) {
            return gsonBasico.fromJson(jsonObject, ContaPoupanca.class);
        } else {
            return gsonBasico.fromJson(jsonObject, ContaCorrente.class);
        }
    }
}