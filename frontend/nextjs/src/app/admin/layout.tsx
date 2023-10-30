import type { Metadata } from 'next'
import 'bootstrap/dist/css/bootstrap.min.css';
import '@/styles/styles.css'
import { Header } from '@/components/Admin/Common/Header';
import { Helmet } from "react-helmet";
import { useEffect, useState } from 'react';
import Script from 'next/script';
import { Sidebar } from '@/components/Admin/Common/Sidebar';
import { Footer } from '@/components/Admin/Common/Footer';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

// import './globals.css'
export const metadata: Metadata = {
    title: 'Admin',
    description: 'Trang Admin',
}

export default function RootLayout({
    children,
}: {
    children: React.ReactNode
}) {

    return (
        <>
            {/* <body className="sb-nav-fixed"> */}
            <Header />
            <div id="layoutSidenav">
                <Sidebar />
                <div id="layoutSidenav_content">
                    <main>
                        {children}
                    </main>
                    <Footer />
                </div>
            </div>
            <ToastContainer/>
            {/* <LinkLibraries></LinkLibraries> */}
            <Script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></Script>
            <Script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></Script>
            <Script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"></Script>
            {/* </body> */}

        </>
    )
}
