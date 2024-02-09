package dk.acto.blackdragon.service;

import dk.acto.blackdragon.model.Model;
import io.vavr.collection.List;

public class MyModelFactory implements ModelFactory<Model> {
    @Override
    public List<Model> parse(String data) {
        List<Model> models = List.empty();

        String[] lines = data.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] attributes = line.split(",");
            long id = Long.parseLong(attributes[0].trim());
            double weight = Double.parseDouble(attributes[1].trim());
            int cost = Integer.parseInt(attributes[2].trim());
            long inventory = Long.parseLong(attributes[3].trim());

            Model model = new Model(id, cost, inventory, weight);
            models = models.append(model);
        }

        return models;
    }


}
