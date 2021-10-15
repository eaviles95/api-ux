package cl.coopeuch.back.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ApiModel(value = "Parameter DTO", description = "Parameter Data Transfer Object")
public class TaskDTO {

    @ApiModelProperty(value = "Task Id", hidden = true)
    private Integer id;

    @ApiModelProperty(value = "Description of task")
    private String description;

    @ApiModelProperty(value = "date of Task")
    private Date createdAt;

    @ApiModelProperty(value = "Valid task")
    private Boolean valid;


}
