/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.toml.generator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.config.diff.creater.exception.ConfigMigrateException;
import org.wso2.toml.generator.util.TomlGenerator;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * New config model generator class.
 */
public class TomlGeneratorTool {

    private static final Log log = LogFactory.getLog(TomlGeneratorTool.class);

    public static void main(String[] args) throws IOException, ConfigMigrateException {

        String outputCSVFilePath = args[0];
        String outputKeyValueFilePath = args[1];
        String deploymentTomlFilePath = args[2];

        TomlGenerator tomlGenerator = new TomlGenerator();
        Map<String, Object> tomlKeyValueMap = tomlGenerator.getTomlKeyValueMap(new File(outputCSVFilePath),
                new File(outputKeyValueFilePath), new File(deploymentTomlFilePath));

        TomlGenerator.writeToTOMLFile(tomlKeyValueMap);

    }


}