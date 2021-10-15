package cl.coopeuch.back.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "\"task\"")
@ApiModel(value = "Task table", description = "Task table")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {

    @Id
    @ApiModelProperty(value = "Task Id", hidden = true)
    @Getter
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "Description of task")
    @Column(name = "code", nullable = false)
    @Getter
    @Setter
    private String description;

    @ApiModelProperty(value = "date of Task")
    @Column(name = "createdAt", nullable = false)
    @Getter
    @Setter
    @JsonFormat(
            timezone = "America/Santiago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ApiModelProperty(value = "Valid task")
    @Column(name = "valid", nullable = false)
    @Getter
    @Setter
    private Boolean valid;


}
