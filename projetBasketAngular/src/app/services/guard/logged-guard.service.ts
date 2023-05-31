import { Injectable } from '@angular/core';
import {
  Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../authentification.service';

@Injectable({
  providedIn: 'root',
})
export class LoggedGuardService {
  constructor(
    private authSrv: AuthentificationService,
    private router: Router
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean | UrlTree {
    if (this.authSrv.isLogged()) {
      return true;
    } else {
      return this.router.createUrlTree(['/login']);
    }
  }
}
