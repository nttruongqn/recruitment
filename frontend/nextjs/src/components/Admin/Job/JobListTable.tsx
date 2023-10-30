import { formatDate } from '@/core/formatDate';
import { Job } from '@/models/job';
import { JobPayload } from '@/models/jobPayload';
import * as React from 'react';
import { Table } from 'react-bootstrap';
import { HashLoader } from 'react-spinners';

export interface IJobListTableProps {
    jobs: Job[];
    isLoading: boolean;
    onEdit: (formValues: JobPayload) => void;
}

export function JobListTable({ jobs, isLoading, onEdit }: IJobListTableProps) {
    const height = '225px';

    if (isLoading) return <div className='d-flex justify-content-center align-items-center' style={{
        minHeight: `calc(100vh - ${height})`,
    }}><HashLoader color="#333333" /></div>
    // if (error) return <div className='d-flex justify-content-center border align-items-center' style={{
    //     minHeight: `calc(100vh - ${height})`,
    // }}>Lỗi</div>
  
    if (jobs && jobs.length > 0) return (
        <>
            <div className="container-fluid">
                <Table striped bordered hover size="sm">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Id</th>
                            <th>Tên</th>
                            <th>Ngày tạo</th>
                            <th>Ngày cập nhật</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            jobs.map((job, index) =>
                                <tr key={index}>
                                    <td className='align-middle'>{index + 1}</td>
                                    <td className='align-middle'>{job.id}</td>
                                    <td className='align-middle'>{job.name}</td>
                                    <td className='align-middle'>{formatDate(job.createdAt)}</td>
                                    <td className='align-middle'>{formatDate(job.updatedAt)}</td>
                                    <td>
                                        <div className="d-flex gap-2 ">
                                            <button className='btn btn-warning' onClick={() => onEdit(job)}>Sửa</button>
                                            <button className='btn btn-danger'>Xóa</button>
                                        </div>
                                    </td>
                                </tr>
                            )
                        }

                    </tbody>
                </Table>
            </div>


        </>
    );
}
