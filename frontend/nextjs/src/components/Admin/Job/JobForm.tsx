import { InputField } from '@/components/FormFields/InputField';
import { JobPayload } from '@/models/jobPayload';
import { Formik } from 'formik';
import * as React from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import * as yup from 'yup';

export interface IJobFormProps {
    initialValues: JobPayload;
    onSubmit: (formValues: JobPayload) => void;

}

export function JobForm({ onSubmit, initialValues }: IJobFormProps) {
    console.log('init value', initialValues);
    const schema = yup.object().shape({
        name: yup.string().required("Vui lòng nhập tên")
    })

    const handleSubmit = async (formValues: JobPayload) => {
        try {
            await onSubmit?.(formValues)
        } catch (error) {
            console.log("Failed create job");
        }
    }

    return (
        <Formik
            validationSchema={schema}
            onSubmit={handleSubmit}
            initialValues={initialValues}
        >
            {({ handleSubmit, handleChange, values, touched, errors }) => (
                <Form noValidate onSubmit={handleSubmit}>
                    <Row className="mb-3">
                        <Form.Group as={Col} md="12" controlId="validationFormik01">
                            <InputField
                                name="name"
                                label="Tên"
                                value={values.name}
                                onChange={handleChange}
                                isValid={touched.name && !errors.name}
                                isInvalid={!!errors.name} errors={errors.name} />
                            {/* <Form.Control
                                type="text"
                                name="name"
                                value={values.name}
                                onChange={handleChange}
                                isValid={touched.name && !errors.name}
                            /> */}
                        </Form.Group>
                    </Row>
                    <Button type="submit" className='btn btn-secondary'>Lưu</Button>
                </Form>
            )}
        </Formik>
    );
}
