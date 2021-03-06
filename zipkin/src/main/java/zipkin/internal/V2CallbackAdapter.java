/**
 * Copyright 2015-2017 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin.internal;

import javax.annotation.Nullable;
import zipkin.storage.Callback;

final class V2CallbackAdapter<T> implements zipkin2.Callback<T> {
  final Callback<T> callback;

  V2CallbackAdapter(Callback<T> callback) {
    this.callback = callback;
  }

  @Override public void onSuccess(@Nullable T value) {
    callback.onSuccess(value);
  }

  @Override public void onError(Throwable t) {
    callback.onError(t);
  }
}
