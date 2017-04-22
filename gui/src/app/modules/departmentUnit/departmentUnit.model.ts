//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.model.ts.e.vm
//
import {Department} from '../department/department.model';

export class DepartmentUnit {
    // Raw attributes
    id : number;
    name : string;
    // x-to-one
    department : Department;
}
