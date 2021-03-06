/*
 * Copyright 2013 Tsukasa Kitachi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.kxbmap.configs
package support.scalikejdbc.async

import org.scalatest.{Matchers, FunSpec}
import com.typesafe.config.ConfigFactory
import scalikejdbc.async.AsyncConnectionPoolSettings

class AsyncDBSettingsSpec extends FunSpec with Matchers {

  describe("Configs instance") {

    it ("should be available") {
      val c = ConfigFactory.parseString(
        """driver = "com.mysql.jdbc.Driver"
          |url = "jdbc:mysql://localhost/configs"
          |user = kxbmap
          |password = secret
          |asyncPool.maxPoolSize = 30
          |""".stripMargin)

      c.extract[AsyncDBSettings] shouldBe AsyncDBSettings(
        url = "jdbc:mysql://localhost/configs",
        user = "kxbmap",
        password = "secret",
        asyncPool = AsyncConnectionPoolSettings(maxPoolSize = 30)
      )
    }
  }
}
