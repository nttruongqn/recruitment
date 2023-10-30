import { ListParams, ListResponse } from "@/models/common";
import { Job } from "@/models/job";
import axiosClient from "./axiosClient";
import useSWR, { mutate } from "swr";
import { JobPayload } from "@/models/jobPayload";
import { AxiosRequestConfig } from "axios";

export const jobApi = {
    findAll(params: ListParams): Promise<ListResponse<Job>> {
        const url = "api/v1/admin/jobs/all";
        return axiosClient.get(url, {
            params
        });
    },

    create(data: JobPayload): Promise<Job> {
        const url = "/api/v1/admin/jobs/create";
        return axiosClient.post(url, data);
    }
}