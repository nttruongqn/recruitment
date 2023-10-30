export interface ListParams {
    currentPage?: number;
    pageSize?: number;
    sortAndOrder?: String[];
    [key: string]: any;
}

export interface PaginationParams {
    totalElements: number;
    totalPages: number;
    size: number;
    number: number;
}

export interface ListResponse<T> {
    content: T[];
    pagination: PaginationParams
}
