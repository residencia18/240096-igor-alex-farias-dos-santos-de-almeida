import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { Store } from "@ngrx/store";
import { tap, withLatestFrom } from "rxjs";
import { selectorContador } from "./contador.selectors";
import { incrementar, decrementar, duplica } from "./contador.actions";

@Injectable()
export class ContadorEffects {
    constructor(private actions$: Actions, private store: Store<{contador:number}>) { }
  
    logarAcoes = createEffect( 
            () =>  
                this.actions$.pipe(
                    ofType(incrementar, decrementar, duplica),
                    withLatestFrom(this.store.select(selectorContador)),
                    tap(([action, contador]) => console.log("Effects:"+ action + "Contador: "+ contador))
                ),
            {dispatch: false}   
    );
}

    // 
    // @Effect({dispatch: false})
    // logarAcoes = this.actions$.pipe(
    //     tap(action => console.log(action))
    // );
    // 
    // @Effect()
    // incrementar$ = this.actions$.pipe(
    //     ofType(incrementar),
    //     map(action => incrementar({valor: action.valor + 1}))
    // );
    // 
    // @Effect()
    // decrementar$ = this.actions$.pipe(
    //     ofType(decrementar),
    //     map(action => decrementar({valor: action.valor - 1}))
    // );
