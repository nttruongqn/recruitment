import * as React from 'react';
import { Form } from 'react-bootstrap';

export interface IInputFieldProps {
    name: string;
    label: string;
    value: any;
    onChange: any;
    isValid?: any;
    isInvalid?: any;
    errors: any;
}

export function InputField({ label, name, value, onChange, isValid, isInvalid, errors }: IInputFieldProps) {
    return (
        <div>
            <Form.Label>{label}</Form.Label>
            <Form.Control
                type="text"
                name={name}
                value={value}
                onChange={onChange}
                isValid={isValid}
                isInvalid={isInvalid}
                aria-describedby="inputGroupPrepend"
            />
            <Form.Control.Feedback>Thông tin hợp lệ</Form.Control.Feedback>
            <Form.Control.Feedback type="invalid">
                {errors}
            </Form.Control.Feedback>
        </div>
    );
}
