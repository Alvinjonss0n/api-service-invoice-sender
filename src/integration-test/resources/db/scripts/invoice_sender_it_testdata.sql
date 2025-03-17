INSERT INTO batch_executions(id, basename, started_at, completed_at, total_invoices, ignored_invoices, sent_invoices,
                             municipality_id, target_path, local_path, archive_path, processing_enabled, completed,
                             data, date, batch_status)
VALUES (1, 'Faktura-pdf-200101_000001', '2024-01-01 00:00:00.00', '2024-01-01 00:01:00.00', 4, 0, 0, 2281,
        '/storage/return', '/storage/incoming',
        '/storage/archive', 1, 0, NULL, '2024-01-01', 'NEW'),
       (2, 'Faktura-pdf-200102_000002', '2024-01-01 00:00:00.00', '2024-01-01 00:01:00.00', 7, 1, 5, 2281,
        '/storage/return', '/storage/incoming',
        '/storage/archive', 1, 0, NULL, '2024-01-01', 'READY'),
       (3, 'Faktura-pdf-200103_000003', '2024-01-01 00:00:00.00', '2024-01-01 00:01:00.00', 7, 1, 5, 2281,
        '/storage/return', '/storage/incoming',
        '/storage/archive', 1, 0, NULL, '2024-01-01', 'NEW');



INSERT INTO batch_items(id, batch_id, filename, status, type)
VALUES (1, 1, 'Faktura_00000001_to_9001011234.pdf', 'NOT_SENT', 'INVOICE'),
       (2, 1, 'Faktura_00000002_to_9101011234.pdf', 'NOT_SENT', 'INVOICE'),
       (3, 1, 'Faktura_00000003_to_9201011234.pdf', 'NOT_SENT', 'INVOICE'),
       (4, 1, 'Faktura_00000004_to_9301011234.pdf', 'NOT_SENT', 'INVOICE'),

       (5, 2, 'Faktura_00000001_to_202107142388.pdf', 'SENT', 'INVOICE'),
       (6, 2, 'Faktura_00000002_to_202108022399.pdf', 'SENT', 'INVOICE'),


       (7, 2, 'Faktura_00000001_to_202107142388.pdf', 'SENT', 'INVOICE'),
       (8, 2, 'Faktura_00000002_to_202108022399.pdf', 'SENT', 'INVOICE'),
       (9, 2, 'Faktura_00000003_to_202108132388.pdf', 'SENT', 'INVOICE'),
       (10, 2, 'Faktura_00000004_to_20323217.pdf', 'NOT_SENT', 'INVOICE');
