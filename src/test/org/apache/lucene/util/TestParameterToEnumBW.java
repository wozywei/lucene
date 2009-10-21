/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.lucene.util;

import org.apache.lucene.document.Field;

public class TestParameterToEnumBW extends LuceneTestCase {

  public void test() {
    // This test fails if the change from Parameter to enum did not work
    assertNotSame(Field.Store.YES, Field.Store.NO);
    assertEquals(Field.Store.YES, Field.Store.YES);
    assertEquals("YES", Field.Store.YES.toString());
    assertEquals("NO", Field.Store.NO.toString());
    
    if (Constants.LUCENE_VERSION.compareTo("3.0") >= 0) {
      assertEquals("java.lang.Enum", Field.Store.class.getSuperclass().getName());
    } else {
      assertEquals("org.apache.lucene.util.Parameter", Field.Store.class.getSuperclass().getName());    
    }
  }

}
