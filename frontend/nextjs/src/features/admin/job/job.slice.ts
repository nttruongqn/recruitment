import { ListParams, ListResponse, PaginationParams } from "@/models/common";
import { Job } from "@/models/job";
import { JobPayload } from "@/models/jobPayload";
import { RootState } from "@/redux/store";
import { PayloadAction, createSlice } from "@reduxjs/toolkit";
export interface JobSlice {
    loading: boolean;
    error: any;
    list: Job[];
    filter: ListParams;
    pagination: PaginationParams;
}

const initialState: JobSlice = {
    loading: false,
    error: null,
    list: [],
    filter: {
        currentPage: 0,
        pageSize: 20,
        sortAndOrder: ["createdAt#desc"]
    },
    pagination: {
        totalPages: 1,
        totalElements: 1,
        size: 1,
        number: 1
    }
}

const jobSlice = createSlice({
    name: "job",
    initialState,
    reducers: {
        fetchJobAll(state) {
            state.loading = true;
        },
        fetchJobList(state, action: PayloadAction<ListParams>) {
            state.loading = true;
        },
        fetchJobListSuccess(state, action: PayloadAction<ListResponse<Job>>) {
            state.loading = false;
            state.list = action.payload.content;
            state.pagination = action.payload.pagination;
        },
        fetchJobListFailed(state, action: PayloadAction<any>) {
            state.loading = false;
            state.error = action.payload;
        },
        setFilter(state, action: PayloadAction<ListParams>) {
            state.filter = action.payload;
        },
        setFilterWithDebounce(state, action: PayloadAction<ListParams>) { },
        addJob(state, action: PayloadAction<JobPayload>){
        },
        addJobSuccess(state, action: PayloadAction<ListResponse<Job>>) {
        },
        addJobFailed(state, action: PayloadAction<any>) {
            state.error = action.payload;
        }

    }
})

export const jobActions = jobSlice.actions;

export const selectJobFilter = (state: RootState) => state.job.filter;
export const selectJobList = (state: RootState) => state.job.list;
export const selectJobPagination = (state: RootState) => state.job.pagination;
export const selectJobLoading = (state: RootState) => state.job.loading;
export const selectJobError = (state: RootState) => state.job.error;
  
const jobReducer = jobSlice.reducer;
export default jobReducer;