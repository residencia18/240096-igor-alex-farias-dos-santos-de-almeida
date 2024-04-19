import { createAction, props } from "@ngrx/store";
import { Action } from "@ngrx/store";

export const incrementar =createAction(
    '[Contador]Incrementar',
    props<{valor:number}>()
);

export const decrementar =createAction(
    '[Contador]Decrementar',
    props<{valor:number}>()
);

export const duplica =createAction(
    '[Contador]Duplica',
    props<{valor:number}>()
);

// // //sintaxe alternativa
// export class IncrementarAction implements Action {
//     readonly type = '[Contador]Incrementar';

//     constructor(public valor: number) {
//     }
// }

// export type ContadorActions = IncrementarAction;
