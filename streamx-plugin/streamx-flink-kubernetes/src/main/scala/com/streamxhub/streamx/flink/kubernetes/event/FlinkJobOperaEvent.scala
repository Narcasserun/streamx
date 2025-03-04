/*
 * Copyright (c) 2021 The StreamX Project
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.streamxhub.streamx.flink.kubernetes.event

import com.streamxhub.streamx.flink.kubernetes.enums.FlinkJobState
import com.streamxhub.streamx.flink.kubernetes.model.TrkId

/**
 * Notification of expecting changes to flink job state cache
 * held internally by K8sFlinkMonitor.
 *
 * @author Al-assad
 */
case class FlinkJobOperaEvent(trkId: TrkId, expectJobState: FlinkJobOpera) extends BuildInEvent {
  def this(trkId: TrkId, expectJobState: FlinkJobState.Value) = this(trkId, FlinkJobOpera(expectJobState, System.currentTimeMillis))
}

case class FlinkJobOpera(expect: FlinkJobState.Value, pollTime: Long)
