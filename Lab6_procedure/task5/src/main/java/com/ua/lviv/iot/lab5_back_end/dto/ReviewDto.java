package com.ua.lviv.iot.lab5_back_end.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "review", collectionRelation = "reviews")
public class ReviewDto extends RepresentationModel<ReviewDto> {
    private final Integer id;
    private final String raiting;
    private final String description;
    private final Date date;
}
