import * as React from 'react';
import { Button, Modal } from 'react-bootstrap';
import { JobForm } from './JobForm';
import { JobPayload } from '@/models/jobPayload';
import { toast } from 'react-toastify';
import { error } from 'console';
import useSWR, { useSWRConfig } from 'swr';
import { jobApi } from '@/api/jobApi';
import { useRouter } from 'next/navigation';
import { useState, useTransition } from 'react';
import axiosClient from '@/api/axiosClient';
export interface IAddJobModalProps {
  title: string;
  show: boolean;
  setShow: (value: boolean) => void;
  onAddJob: (formValues: JobPayload) => void;
}

export function AddJobModal({ show, setShow, title, onAddJob }: IAddJobModalProps) {
  const initialValues: JobPayload = {
    name: "",
  }

  const handleSubmit = async (formValues: JobPayload) => {
    onAddJob(formValues);
  }

  return (
    <Modal
      show={show}
      onHide={() => setShow(false)}
    // aria-labelledby="contained-modal-title-vcenter"
    // centered
    >
      <Modal.Header closeButton>
        <Modal.Title>{title}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <JobForm initialValues={initialValues} onSubmit={handleSubmit} />
      </Modal.Body>
    </Modal>
  );
}
