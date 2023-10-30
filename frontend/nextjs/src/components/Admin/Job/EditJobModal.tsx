import * as React from 'react';
import { Modal } from 'react-bootstrap';
import { JobForm } from './JobForm';
import { toast } from 'react-toastify';
import useSWRMutation from 'swr/mutation';
import { JobPayload } from '@/models/jobPayload';

export interface IEditJobModalProps {
    title: string;
    show: boolean;
    setShow: (value: boolean) => void;
    jobPayload: JobPayload;
}

export function EditJobModal({ title, show, setShow, jobPayload }: IEditJobModalProps) {
    const initialValues: JobPayload = {
        ...jobPayload
    }

    async function updateJob(url: string, { arg }: { arg: JobPayload }) {
        return fetch(`http://localhost:4141/api/v1/admin/jobs/${arg.id}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            // headers: {
            //   Authorization: `Bearer ${bearerToken}`
            // },
            body: JSON.stringify({ name: arg.name })
        })
            .then(res => {
                setShow(false);
                toast.success("Sửa dữ liệu thành công", {
                    position: "bottom-right",
                });
                return res.json()
            })
    }

    const { trigger } = useSWRMutation('http://localhost:4141/api/v1/admin/jobs', updateJob)


    const handleSubmit = async (formValues: JobPayload) => {
        await trigger(formValues);
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
