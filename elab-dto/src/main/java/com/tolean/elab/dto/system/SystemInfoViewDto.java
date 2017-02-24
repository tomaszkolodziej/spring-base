package com.tolean.elab.dto.system;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Przechowuje informacje o systemie (nazwa, wersja, itp.)
 * Created by Tomasz Kołodziej
 */
@Data
@Component
public class SystemInfoViewDto {

    @Value("${elab.name}")
    private String name;

    @Value("${elab.version}")
    private String version;

}
