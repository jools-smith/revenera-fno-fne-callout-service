package lfs.callout;

import java.util.function.Supplier;

public final class ServiceException extends RuntimeException {
  final int status;
  ServiceException(final String message, final int status) {
    super(message);
    this.status = status;
  }
}
