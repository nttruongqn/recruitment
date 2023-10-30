"use client"
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import * as React from 'react';

export interface ISidebarProps {
}

export function Sidebar(props: ISidebarProps) {
    const currentRoute = usePathname();
    const recruitmentLink = [
        { name: "Công việc", href: "/admin/job" },
        { name: "Vị trí", href: "/admin/position" },
        { name: "Bài đăng", href: "/admin/post" },

    ]

    return (
        <>
            <div id="layoutSidenav_nav">
                <nav className="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div className="sb-sidenav-menu">
                        <div className="nav">
                            {/* <div className="sb-sidenav-menu-heading">Core</div>
                            <a className="nav-link" href="index.html">
                                <div className="sb-nav-link-icon"><i className="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a> */}
                            <div className="sb-sidenav-menu-heading">Quản lý hệ thống</div>
                            <a className="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseLayouts">
                                <div className="sb-nav-link-icon"><i className="fa-solid fa-columns"></i></div>
                                Tuyển dụng
                                <div className="sb-sidenav-collapse-arrow"><i className="fas fa-angle-down"></i></div>
                            </a>
                            <div className="collapse" id="collapseOne" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav className="sb-sidenav-menu-nested nav">
                                    {
                                        recruitmentLink.map((item, index) =>
                                        (
                                            <Link href={item.href} className={currentRoute == item.href ? "nav-link active" : "nav-link"} key={index}> {item.name} </Link>
                                        ))
                                    }
                                </nav>
                            </div>
                            <a className="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseLayouts">
                                <div className="sb-nav-link-icon"><i className="fa-solid fa-user"></i></div>
                                Ứng viên
                                <div className="sb-sidenav-collapse-arrow"><i className="fas fa-angle-down"></i></div>
                            </a>
                            <div className="collapse" id="collapseTwo" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav className="sb-sidenav-menu-nested nav">
                                    <a className="nav-link" href="layout-static.html">Hồ sơ</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </>
    );
}
