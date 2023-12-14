
INSERT INTO menu_layanan (nama_paket,jumlah_pertemuan) VALUES ('paket-1', '3 hari');
INSERT INTO menu_layanan (nama_paket,jumlah_pertemuan) VALUES ('paket-2', '3 hari');

INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-1', '20 Menit' , 100000 , 'Senin' );
INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-2', '20 Menit' , 100000 , 'Selasa' );
INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-3', '20 Menit' , 100000 , 'Rabu' );
INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-4', '20 Menit' , 100000 , 'Kamis' );
INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-5', '20 Menit' , 100000 , 'Jumat' );
INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-6', '20 Menit' , 100000 , 'Sabtu' );
INSERT INTO detail_layanan (nama_latihan, durasi_menit, harga, hari) VALUES ('joging-7', '20 Menit' , 100000 , 'Minggu' );

INSERT INTO paket_layanan (nama_paket, nama_latihan) VALUES ('paket-1', 'joging-1');
INSERT INTO paket_layanan (nama_paket, nama_latihan) VALUES ('paket-1', 'joging-2');
INSERT INTO paket_layanan (nama_paket, nama_latihan) VALUES ('paket-1', 'joging-3');
INSERT INTO paket_layanan (nama_paket, nama_latihan) VALUES ('paket-2', 'joging-4');
INSERT INTO paket_layanan (nama_paket, nama_latihan) VALUES ('paket-2', 'joging-5');
INSERT INTO paket_layanan (nama_paket, nama_latihan) VALUES ('paket-2', 'joging-6');
