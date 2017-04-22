//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.model.ts.e.vm
//
import {DepartmentUnit} from '../departmentUnit/departmentUnit.model';

export class Instrument {
    // Raw attributes
    id : number;
    contact : string;
    description : string;
    indexNo : string;
    name : string;
    // x-to-one
    departmentUnit : DepartmentUnit;
}
