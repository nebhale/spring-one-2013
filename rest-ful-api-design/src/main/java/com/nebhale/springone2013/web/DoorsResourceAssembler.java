/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nebhale.springone2013.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import com.nebhale.springone2013.model.Door;
import com.nebhale.springone2013.model.Game;

@Component
final class DoorsResourceAssembler implements ResourceAssembler<Game, Resources<Resource<Door>>> {

    private final DoorResourceAssembler doorResourceAssembler;

    @Autowired
    DoorsResourceAssembler(DoorResourceAssembler doorResourceAssembler) {
        this.doorResourceAssembler = doorResourceAssembler;
    }

    @Override
    public Resources<Resource<Door>> toResource(Game game) {
        Set<Resource<Door>> doors = new HashSet<>();

        for (Door door : game.getDoors()) {
            doors.add(this.doorResourceAssembler.toResource(game, door));
        }

        Resources<Resource<Door>> resource = new Resources<>(doors);
        resource.add(linkTo(GamesController.class).slash(game.getId()).slash("doors").withSelfRel());

        return resource;
    }

}
