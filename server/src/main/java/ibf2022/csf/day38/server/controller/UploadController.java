package ibf2022.csf.day38.server.controller;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.csf.day38.server.repository.SpacesRepository;

@Controller
@RequestMapping
@CrossOrigin(origins = "*")
public class UploadController {

    @Autowired
    private SpacesRepository spacesRepository;
    
    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<String> postUpload(@RequestPart String title, @RequestPart MultipartFile myFile) {

        System.out.printf(">>> title: %s\n", title);
		System.out.printf(">>> filename: %s\n", myFile.getOriginalFilename());
        
        try {
            URL url = spacesRepository.upload(title, myFile);
            System.out.println(url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("{}");
    }
}
