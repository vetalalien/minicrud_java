package com.vetalalien.miniservice.service;


import com.vetalalien.miniservice.dto.EnumDto;
import com.vetalalien.miniservice.dto.InterestCorrectionMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InterestCorrectionMapper {

    private static final Logger logger = LoggerFactory.getLogger(InterestCorrectionMapper.class);

    public EnumDto toEnumDto(String code) {
        InterestCorrectionMethod method = InterestCorrectionMethod
                .getInterestCorrectionMethodByCode(code);
        if (method != null) {
            return new EnumDto(code, method.getName());
        }
        if (logger.isDebugEnabled()) {
            logger.debug("InterestCorrectionMethod for code \'{}\' not found", code);
        }
        return null;

    }

    public String toCodeInterestCorrectionMethod(EnumDto enumDto) {
        return enumDto != null ? enumDto.getCode() : null;
    }
}

