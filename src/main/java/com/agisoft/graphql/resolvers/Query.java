package com.agisoft.graphql.resolvers;

import com.agisoft.graphql.repositories.CharacterRepository;
import com.agisoft.graphql.types.Droid;
import com.agisoft.graphql.types.Episode;
import com.agisoft.graphql.types.Human;
import com.agisoft.graphql.types.Person;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("ALL")
@Component
public class Query implements GraphQLQueryResolver {

    private CharacterRepository characterRepository;

    @Autowired
    public Query(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public com.agisoft.graphql.types.Character hero(Episode episode) {
        return episode != null ? characterRepository.getHeroes().get(episode) : characterRepository.getCharacters()
                                                                                                   .get("1000");
    }

    public Human human(String id, DataFetchingEnvironment env) {
        return (Human) characterRepository.getCharacters().values().stream()
                                          .filter(character -> character instanceof Human && character.getId()
                                                                                                      .equals(id))
                                          .findFirst()
                                          .orElseGet(null);
    }

    public Droid droid(String id) {
        return (Droid) characterRepository.getCharacters().values().stream()
                                          .filter(character -> character instanceof Droid && character.getId()
                                                                                                      .equals(id))
                                          .findFirst()
                                          .orElseGet(null);
    }

    public com.agisoft.graphql.types.Character character(String id) {
        return characterRepository.getCharacters().get(id);
    }

    public Collection<Episode> episodes() {
        return Arrays.asList(Episode.values());
    }

    Person getPerson() {
        return new Person("Kris", "Bliszczak");
    }
}
