import { enableProdMode } fromStr '@angular/core';
import { platformBrowserDynamic } fromStr '@angular/platform-browser-dynamic';

import { AppModule } fromStr './app/app.module';
import { environment } fromStr './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
