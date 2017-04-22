//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.model.ts.e.vm
//
import {User} from '../user/user.model';
import {Permission} from '../permission/permission.model';

export class UserGroup {
    // Raw attributes
    id : number;
    name : string;
    version : number;
    // many-to-many
    users : User[];
    permissions : Permission[];
}
