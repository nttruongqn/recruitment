import { call, debounce, put, takeLatest } from "redux-saga/effects";
import { jobActions } from "./job.slice";
import useSWR from "swr";
import { jobApi } from "@/api/jobApi";
import { ListParams, ListResponse } from "@/models/common";
import { Job } from "@/models/job";
import { PayloadAction } from "@reduxjs/toolkit";
import { JobPayload } from "@/models/jobPayload";
import { toast } from "react-toastify";

export function* fetchJobList(action: PayloadAction<ListParams>) {
  try {
    const response: ListResponse<Job> = yield call(
      jobApi.findAll,
      action.payload
    );
    yield put(jobActions.fetchJobListSuccess(response));
  } catch (error) {
    console.log("Fetch category list failed");
    yield put(jobActions.fetchJobListFailed(error));
  }
}

function* handleSearchDebounce(action: PayloadAction<ListParams>) {
  yield put(jobActions.setFilter(action.payload));
}

function* addJob(action: PayloadAction<JobPayload>) {
  const defaultParams: ListParams = {
    currentPage: 0,
    pageSize: 20
  }
  try {
    yield call(jobApi.create, action.payload);
    toast.info('Success', {
      autoClose: 500,
      position: "bottom-right"
    })
    const response: ListResponse<Job> = yield call(
      jobApi.findAll,
      defaultParams
    );
    yield put(jobActions.fetchJobListSuccess(response));
  } catch (error) {
    yield put(jobActions.addJobFailed(error));
    toast.info('Error', {
      autoClose: 500,
      position: "bottom-right"
    })
  }


}

export default function* jobSaga() {
  yield takeLatest(jobActions.fetchJobList.type, fetchJobList);
  yield takeLatest(jobActions.addJob.type, addJob);
  yield debounce(
    500,
    jobActions.setFilterWithDebounce.type,
    handleSearchDebounce
  );
}