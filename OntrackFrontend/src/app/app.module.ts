import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OntrackModule } from './ontrack/ontrack.module';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OntrackModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
