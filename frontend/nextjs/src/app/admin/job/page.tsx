"use client"
import { jobApi } from '@/api/jobApi';
import { AddJobModal } from '@/components/Admin/Job/AddJobModal';
import { EditJobModal } from '@/components/Admin/Job/EditJobModal';
import { JobListTable } from '@/components/Admin/Job/JobListTable';
import { Title } from '@/components/Admin/Title';
import { jobActions, selectJobError, selectJobFilter, selectJobList, selectJobLoading, selectJobPagination } from '@/features/admin/job/job.slice';
import { ListParams } from '@/models/common';
import { Job } from '@/models/job';
import { JobPayload } from '@/models/jobPayload';
import { useAppDispatch, useAppSelector } from '@/redux/hooks';
import * as React from 'react';
import { HashLoader } from 'react-spinners';
import { toast } from 'react-toastify';
import useSWR, { useSWRConfig } from 'swr';

export default function JobPage() {
  const [showAddModal, setShowAddModal] = React.useState<boolean>(false);
  const [showEditModal, setShowEditModal] = React.useState<boolean>(false);
  const [jobPayload, setJobPayload] = React.useState<JobPayload>();

  const loading = useAppSelector(selectJobLoading);
  const error = useAppSelector(selectJobError);
  const jobList = useAppSelector(selectJobList);
  const filter = useAppSelector(selectJobFilter);
  const pagination = useAppSelector(selectJobPagination);
 

  const dispatch = useAppDispatch();

  React.useEffect(() => {
    dispatch(jobActions.fetchJobList(filter));
  }, [dispatch, filter]);


  const showModalAdd = () => {
    setShowAddModal(true);
  }

  const handleEdit = (formValues: JobPayload) => {
    setShowEditModal(true);
    setJobPayload(formValues);
  }

  const handleAddJob = async (formValues: JobPayload) => {
    // try {
    //   await jobApi.create(formValues);
    //   setShowAddModal(false);
    //   window.location.href = "/admin/job";
    // } catch (error) {
    //   toast.error("Lưu dữ liệu thất bại", {
    //     delay: 1000,
    //     position: "bottom-right",
    //   });
    // }
      dispatch(jobActions.addJob(formValues));
      setShowAddModal(false);
  }

  return (
    <>
      <Title title={"Jobs"} showModalAdd={showModalAdd} />
      <AddJobModal
        show={showAddModal}
        setShow={setShowAddModal}
        title="Thêm dữ liệu"
        onAddJob={handleAddJob}
      />
      <EditJobModal
        show={showEditModal}
        setShow={setShowEditModal}
        title="Sửa dữ liệu"
        jobPayload={jobPayload as JobPayload}
      />
     <JobListTable jobs={jobList} isLoading={loading} onEdit={handleEdit} />
    </>
  );
}
