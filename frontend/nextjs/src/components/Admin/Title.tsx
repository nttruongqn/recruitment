import * as React from 'react';

export interface ITitleProps {
  title: String,
  showModalAdd: () => void;
}


export function Title({ title, showModalAdd }: ITitleProps) {
  return (
    <div>
      <div className="container-fluid">
        <div className="p-4">
          <div className="d-flex justify-content-between">
            <p className="fs-4 fw-bold">{ title }</p>
            <button className='btn btn-secondary fw-bold' onClick={showModalAdd}>Thêm</button>
          </div>
        </div>
      </div>
    </div>
  );
}
