import { Address } from "./Address";
import { Name } from "./Name";

export interface Patient {
    resourcetype: string;
    id: string;
    name: Name[];
    gender: string;
    birthDate: Date;
    address: Address[];
}