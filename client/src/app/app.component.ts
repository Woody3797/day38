import { Component, ElementRef, OnInit, ViewChild, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UploadService } from './upload.service';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    @ViewChild('uploadFile')
    uploadFile!: ElementRef

    form!: FormGroup
    fb = inject(FormBuilder)
    uploadService = inject(UploadService)

    ngOnInit(): void {
        this.form = this.fb.group({
            title: this.fb.control<string>('', [ Validators.required]),
            file: this.fb.control<any>('', [ Validators.required])
        })
    }

    upload() {
        const f: File = this.uploadFile.nativeElement.files[0]
        console.info(f)
        const data = this.form.value
        this.form.get('file')?.patchValue({ file: f})

        firstValueFrom(this.uploadService.upload(data['title'], f)).then(
            result => {
                alert('uploaded'),
                this.form.reset()
            })
            .catch(err => {
                alert(JSON.stringify(err))
            })
    }
}
