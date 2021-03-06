/*
 * Copyright 2008-2012 Opera Software ASA
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

package com.opera.core.systems.scope.services;

import com.opera.core.systems.scope.Service;
import com.opera.core.systems.scope.protos.CoreProtos.ClearFlags;

import java.util.List;

/**
 * Core utility service exposing metadata about the browser core in general, i.e. information which
 * can not be associated to any one window, document, or object.
 */
public interface Core extends Service {

  static final String SERVICE_NAME = "core";

  /**
   * Which Core version this instance is running, e.g. "2.8.119".
   *
   * @return version number
   */
  String getCoreVersion();

  /**
   * Gets a string which describes the operating system the connected Opera instance is running on.
   * An example would be
   *
   * "Window NT 6.1"
   *
   * @return operating system
   */
  String getOperatingSystem();

  /**
   * A string which describes the product.  For regular desktop builds this will be "desktop". Other
   * examples are "mobile" and "gogi".
   *
   * @return product type
   */
  String getProduct();

  /**
   * The full path of the currently running binary.
   *
   * @return path
   */
  String getBinaryPath();

  /**
   * Gets the User-Agent string, typically something like
   *
   * "Opera/9.80 (Windows NT 6.1; U; en) Presto/2.7.62 Version/11.01"
   *
   * @return user agent
   */
  String getUserAgent();

  /**
   * Gets the process ID of connected Opera instance.  Might not be present if the build does not
   * support retrieving process ID's.
   *
   * @return pid, or null if not available
   */
  Integer getProcessID();

  /**
   * Clears specified browser data.
   *
   * @param flags list of private data to be cleared
   */
  void clearPrivateData(List<ClearFlags> flags);

}