// Copyright (c) 2007-Present Pivotal Software, Inc.  All rights reserved.
//
// This software, the RabbitMQ Java client library, is triple-licensed under the
// Mozilla Public License 1.1 ("MPL"), the GNU General Public License version 2
// ("GPL") and the Apache License version 2 ("ASL"). For the MPL, please see
// LICENSE-MPL-RabbitMQ. For the GPL, please see LICENSE-GPL2.  For the ASL,
// please see LICENSE-APACHE2.
//
// This software is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND,
// either express or implied. See the LICENSE file for specific language governing
// rights and limitations of this software.
//
// If you have any questions regarding licensing, please contact us at
// info@rabbitmq.com.

package com.rabbitmq.client.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 *
 */
public class NioParams {

    private int readByteBufferSize = 8192;

    private int writeByteBufferSize = 8192;

    private int nbIoThreads = 2;

    private int writeEnqueuingTimeoutInMs = 10 * 1000;

    private int writeQueueCapacity = 1000;

    private ExecutorService nioExecutor;

    private ThreadFactory threadFactory;

    public int getReadByteBufferSize() {
        return readByteBufferSize;
    }

    public NioParams setReadByteBufferSize(int readByteBufferSize) {
        if(readByteBufferSize <= 0) {
            throw new IllegalArgumentException("Buffer size must be greater than 0");
        }
        this.readByteBufferSize = readByteBufferSize;
        return this;
    }

    public int getWriteByteBufferSize() {
        return writeByteBufferSize;
    }

    public NioParams setWriteByteBufferSize(int writeByteBufferSize) {
        if(readByteBufferSize <= 0) {
            throw new IllegalArgumentException("Buffer size must be greater than 0");
        }
        this.writeByteBufferSize = writeByteBufferSize;
        return this;
    }

    public int getNbIoThreads() {
        return nbIoThreads;
    }

    public NioParams setNbIoThreads(int nbIoThreads) {
        if(nbIoThreads <= 0) {
            throw new IllegalArgumentException("Number of threads must be greater than 0");
        }
        if(nbIoThreads % 2 != 0) {
            throw new IllegalArgumentException("Number of threads must be even (e.g. 2, 4, 6, etc)");
        }
        this.nbIoThreads = nbIoThreads;
        return this;
    }

    public int getWriteEnqueuingTimeoutInMs() {
        return writeEnqueuingTimeoutInMs;
    }

    public NioParams setWriteEnqueuingTimeoutInMs(int writeEnqueuingTimeoutInMs) {
        this.writeEnqueuingTimeoutInMs = writeEnqueuingTimeoutInMs;
        return this;
    }

    public ExecutorService getNioExecutor() {
        return nioExecutor;
    }

    public NioParams setNioExecutor(ExecutorService nioExecutor) {
        this.nioExecutor = nioExecutor;
        return this;
    }

    public ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    public NioParams setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        return this;
    }

    public int getWriteQueueCapacity() {
        return writeQueueCapacity;
    }

    public NioParams setWriteQueueCapacity(int writeQueueCapacity) {
        if(writeQueueCapacity <= 0) {
            throw new IllegalArgumentException("Write queue capacity must be greater than 0");
        }
        this.writeQueueCapacity = writeQueueCapacity;
        return this;
    }
}
