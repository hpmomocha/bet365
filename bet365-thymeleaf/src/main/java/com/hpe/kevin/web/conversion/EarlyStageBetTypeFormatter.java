/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package com.hpe.kevin.web.conversion;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.hpe.kevin.business.entities.TMEarlyStageBetType;


public class EarlyStageBetTypeFormatter implements Formatter<TMEarlyStageBetType> {

    public EarlyStageBetTypeFormatter() {
        super();
    }

    public TMEarlyStageBetType parse(final String text, final Locale locale) throws ParseException {
        final Integer betTypeId = Integer.valueOf(text);
        return new TMEarlyStageBetType(betTypeId);
    }


    public String print(final TMEarlyStageBetType object, final Locale locale) {
        return (object != null ? String.valueOf(object.getBetTypeId()) : "");
    }

}
