package ibf2022.csf.day38.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
@CrossOrigin(origins = "*")
public class UploadController {
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<String> postUpload(@RequestPart String title, @RequestPart MultipartFile myFile) {


        return null;
    }
}
