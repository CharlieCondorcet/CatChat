/*
 * MIT License
 *
 * Copyright (c) 2020 CharlieCondorcet
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.charlie.p2pchat;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * LiveDataTestUtil tested since:
 * https://github.com/android/architecture-components-samples/blob/master/BasicSample/app/src/androidTest/java/com/example/android/persistence/LiveDataTestUtil.java
 *
 * @author Charlie Condorcet.
 */
public class LiveDataTestUtil {
  /**
   * Get the value from a LiveData object. We're waiting for LiveData to emit, for 2 seconds.
   * Once we got a notification via onChanged, we stop observing.
   */
  public static <T> T getValue(final LiveData<T> liveData) throws InterruptedException {
    final Object[] data = new Object[1];
    final CountDownLatch latch = new CountDownLatch(1);
    Observer<T> observer = new Observer<T>() {
      @Override
      public void onChanged(@Nullable T o) {
        data[0] = o;
        latch.countDown();
        liveData.removeObserver(this);
      }
    };
    liveData.observeForever(observer);
    latch.await(2, TimeUnit.SECONDS);
    //noinspection unchecked
    return (T) data[0];
  }
}
