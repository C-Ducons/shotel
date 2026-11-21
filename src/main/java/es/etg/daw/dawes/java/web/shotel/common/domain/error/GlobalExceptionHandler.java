package es.etg.daw.dawes.java.web.shotel.common.domain.error;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.HtmlUtils;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML)
                .body(buildErrorHtml(cr));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder detalles = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
            detalles.append(field).append(": ").append(error.getDefaultMessage()).append(" | ");
        });
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, detalles.toString());
        return ResponseEntity.status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML)
                .body(buildErrorHtml(cr));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML)
                .body(buildErrorHtml(cr));
    }

    private String buildErrorHtml(CustomResponse cr) {
        return """
            <!DOCTYPE html>
            <html lang="es">
            <head><meta charset="UTF-8"><title>Error</title></head>
            <body>
                <h1>Se ha producido un error</h1>
                <p><strong>Fecha:</strong> %s</p>
                <p><strong>Código:</strong> %s - %s</p>
                <p><strong>Mensaje:</strong> %s</p>
            </body>                </html>
        """.formatted(
            HtmlUtils.htmlEscape(String.valueOf(cr.getDate())),
            cr.getStatus().value(),
            HtmlUtils.htmlEscape(cr.getStatus().getReasonPhrase()),
            HtmlUtils.htmlEscape(cr.getMessage() != null ? cr.getMessage() : ""));
    }
}
