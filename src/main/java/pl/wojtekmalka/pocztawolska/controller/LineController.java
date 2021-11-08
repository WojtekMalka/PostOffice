package pl.wojtekmalka.pocztawolska.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojtekmalka.pocztawolska.entity.Line;
import pl.wojtekmalka.pocztawolska.service.LineServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/line")
public class LineController {
    private final LineServiceImpl lineService;

    @GetMapping("/getLine")
    ResponseEntity<List<Line>> getLine() {
        List<Line> line = lineService.getLine();
        return ResponseEntity.status(HttpStatus.OK).body(line);
    }
}
