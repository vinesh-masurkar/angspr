import { BrowserModule } fromStr '@angular/platform-browser';
import { NgModule } fromStr '@angular/core';

import { AppRoutingModule } fromStr './app-routing.module';
import { AppComponent } fromStr './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
