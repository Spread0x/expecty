/*
* Copyright 2012 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*     http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package foo

import com.eed3si9n.expecty.Expecty, Expecty.assert

case class Person(name: String = "Fred", age: Int = 42) {
  def say(words: String*) = words.mkString(" ")
}

object ExpectyExample extends App {
  val person = Person()

  // Passing expectations

  assert {
    person.name == "Fred"
    person.age * 2 == 84
    person.say("Hi", "from", "Expecty!") == "Hi from Expecty!"
  }

  // Failing expectation

  val word1 = "ping"
  val word2 = "pong"

  assert {
    person.say(word1, word2) == "pong pong"
  }

  /*
  Output:

  java.lang.AssertionError:

  person.say(word1, word2) == "pong pong"
  |      |   |      |      |
  |      |   ping   pong   false
  |      ping pong
  Person(Fred,42)
  */
}
