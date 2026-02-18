package com.flexnet.lfs.callout;

import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.util.Properties;


public class PingInfo {
//  public String version;

  public static class BuildInfo {
    public final String author;
    public final String date;
    public final String time;
    public final String timestamp;
    public final String build;

    BuildInfo() {
      try {
        final Properties props = new Properties();

        props.load(PingInfo.class.getResourceAsStream("/revenera.properties"));

        author = props.getProperty("build.username");
        date = props.getProperty("build.date");
        time = props.getProperty("build.time");
        timestamp = props.getProperty("build.timestamp");
        build = props.getProperty("build.number");
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
  public static class OperatingSystem {
    public final String name = SystemUtils.OS_NAME;
    public final String version = SystemUtils.OS_VERSION;
    public final String architecture = SystemUtils.OS_ARCH;
  }

  public static class Environment {
    public final Integer availableProcessors;
    public final Long freeMemory;
    public final Long totalMemory;
    public final Long maxMemory;

    Environment() {
      final Runtime runtime = Runtime.getRuntime();

      this.availableProcessors = runtime.availableProcessors();
      this.freeMemory = runtime.freeMemory();
      this.totalMemory = runtime.totalMemory();
      this.maxMemory = runtime.maxMemory();
    }
  }

  public final BuildInfo build = new BuildInfo();
  public final OperatingSystem system = new OperatingSystem();
  public final Environment environment = new Environment();

  public final String hostName = SystemUtils.getHostName();

  public final String userName = SystemProperties.getUserName("unknown");//SystemUtils.getUserName();

  PingInfo() {

  }

  public static PingInfo create() {
    return new PingInfo();
  }

}
