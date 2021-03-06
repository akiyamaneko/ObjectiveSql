/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.braisdom.objsql;

import com.github.braisdom.objsql.pagination.Paginatable;
import com.github.braisdom.objsql.relation.Relationship;

import java.sql.SQLException;
import java.util.List;

/**
 * A programmable structure for SQL statement.
 * @param <T>
 */
public interface Query<T> extends Paginatable {

    Query where(String filter, Object... args);

    Query select(String... columns);

    Query fetch(long rowCount);

    Query fetch(long rowCount, boolean first);

    Query offset(long offset);

    Query groupBy(String groupBy);

    Query having(String having);

    Query orderBy(String orderBy);

    List<T> execute(Relationship... relationships) throws SQLException;

    T queryFirst(Relationship... relationships) throws SQLException;
}
