//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.model.ts.e.vm
//
import {UserGroup} from '../userGroup/userGroup.model';
import {Permission} from '../permission/permission.model';

export class User {
    // Raw attributes
    id : number;
    password : string;
    status : number;
    username : string;
    version : number;
    // many-to-many
    userGroups : UserGroup[];
    permissions : Permission[];
}
