package pl.wojtekmalka.pocztawolska.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    //        @ExceptionHandler(ConstraintViolationException.class)
//        public ResponseEntity<Set<String>> handleConstraintViolation(ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> constraintViolations = e.ConstraintViolationException();
//            Set<String> messages = new HashSet<>(constraintViolations.size());
//            messages.addAll(constraintViolations.stream()
//                    .map(constraintViolation -> String.format("Field %s has value '%s'. Validator message: %s",
//                            constraintViolation.getPropertyPath(),
//                            constraintViolation.getInvalidValue(),
//                            constraintViolation.getMessage()))
//                    .collect(Collectors.toList()));
//
//            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
//        }
//    }
}
