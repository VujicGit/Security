﻿import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../service/authentication/authentication.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      const currentUser = this.authenticationService.currentUserValue;
      if (currentUser) {
        // check if route is restricted by role
        if (route.data.roles && route.data.roles.indexOf(currentUser.role) === -1) {
          // role not authorised so redirect to home page
          this.router.navigate(['/']);
          return false;
        }
        
        // if ( this.router.url==="/searchMedication" && route.data.roles && route.data.roles.indexOf(currentUser.role) === 6) {
        //   // role not authorised so redirect to home page
        //   this.router.navigate(['/supplier']);
        //   return false;
        // }

        // authorised so return true
        return true;
      }

      // // not logged in so redirect to login page with the return url
      this.router.navigate(['/login']);
      return false;
    }
}
