import { Component, Input } from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'tla-form-label',
  template: '<span class="tla-form-label">{{label}}<span class="asterisk" *ngIf="required">&#42;</span></span>',
  styleUrls: ['tla-form-label.component.css']
})
export class ToleanFormLabelComponent {

  @Input() label: string;
  @Input() required: boolean = false;

}
