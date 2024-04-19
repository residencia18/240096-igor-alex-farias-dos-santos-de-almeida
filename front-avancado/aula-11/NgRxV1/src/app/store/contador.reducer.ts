import { createReducer, on } from "@ngrx/store";
import { incrementar, decrementar, duplica } from "./contador.actions";

const estadoInicial = 0;

export const contadorReducer = createReducer(
    estadoInicial,
    on(incrementar, (estado, action) => estado + action.valor),
    on(decrementar, (estado, action) => estado - action.valor),
    on(duplica, (estado, action) => estado * action.valor),
);

// //sintaxe alternativa
// export function contadorReducer(estado = estadoInicial, action:ContadorActions) {
//     if(action.type === '[Contador]Incrementar') {
//         return estado + action.valor;
//     }
//     return estado;
// }
