export interface Page<T> {
  content: T[];
  totalElements: Number;
  totalPages: Number;
  last: Boolean;
  numberOfElements: Number;
  sort;
  first: Boolean;
  size: Number;
  number: Number;
}
