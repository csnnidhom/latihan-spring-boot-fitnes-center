## API ORDER

## Get List Data Layanan

End Point : GET /api/paket

Response Body :

```json
[
  {
    "namaPaket": "paket-1",
    "jumlahPertemuan": "3 hari",
    "detailLayanan": [
      {
        "namaLatihan": "joging-1",
        "harga": "100000",
        "hari": "Senin",
        "durasiMenit" : "20 Menit"
      },
      {
        "namaLatihan": "joging-2",
        "harga": "100000",
        "hari": "Selasa",
        "durasiMenit" : "20 Menit"
      },
      {
        "namaLatihan": "joging-3",
        "harga": "100000",
        "hari": "Rabu",
        "durasiMenit" : "20 Menit"
      }
    ]
  },
  {
    "namaPaket": "paket-2",
    "jumlahPertemuan": "3 hari",
    "detailLayanan": [
      {
        "namaLatihan": "joging-4",
        "harga": "100000",
        "hari": "Kamis",
        "durasiMenit" : "20 Menit"
      },
      {
        "namaLatihan": "joging-5",
        "harga": "100000",
        "hari": "Jumat",
        "durasiMenit" : "20 Menit"
      },
      {
        "namaLatihan": "joging-6",
        "harga": "100000",
        "hari": "Sabtu",
        "durasiMenit" : "20 Menit"
      }
    ]
  }
  
]
```

## Order Paket

End Point : POST /api/paket/order-paket

Request Header :

- X-API-TOKEN or Bearer Token

Request Body :
```json
{
  "paketLayanan" : "paket-1"
}
```

Response Body - Failed (404) :
```json
{
  "errors" : "Paket layanan tidak ada"
}
```

Response Body - Failed (401) :
```json
{
  "erros" : "Unauthorized"
}
```

Response Body - Success :
```json
{
  "idOrder" : "52532f5d-38ac-4c2a-8c21-f7cf470222cb",
  "pemberitahuan" : "Order paket berhasil"
}
```

## Order Tambahan Pertemuan 

Request Header :

- X-API-TOKEN or Bearer Token

Request Body :
```json
{
  "orderId" : "6ae93878-2ff0-4e9f-ac9a-f0e79279a83a",
  "namaLatihan" : "joging-7"
}
```
Response Body - Failed (401) :
```json
{
  "errors": "Unauthorized"
}
```

Response Body - Failed (404) :
```json
{
    "errors": "List Latihan yg dipilih tidak ada"
}
```

Response Body - Success :
```json
{
    "data": "Berhasil tambah pertemuan"
}
```

## Get All Data Order User

End Pont : GET /api/paket/get-order-paket

Request Header :

- X-API-TOKEN or Bearer Token

Response Body - Failed (401) :
```json
{
  "errors": "Unauthorized"
}
```

Response Success :
```json
{
  "id": "52532f5d-38ac-4c2a-8c21-f7cf470222cb",
  "user": {
    "email": "dhom@gmail.com",
    "name": "dhom",
    "password": "$2a$10$MwJzbTLYcGwCAmanDWEFo.EwBTZKbAlXn7d/6d2rDdQD/GM86JAAK",
    "phone": "0987865",
    "active": true,
    "otp": "533658",
    "otp_generated_time": "2023-12-13T14:59:48",
    "token": "f9055626-662b-4275-b565-bde7d2fa415c",
    "tokenExpiredAt": 1702584482602,
    "name_credit_card": "dhom card",
    "number_credit_card": "47825628",
    "card_expired": "2023-12-04T00:00:00.000+00:00"
  },
  "menuLayanan": {
    "namaPaket": "paket-1",
    "jumlahPertemuan": "3 hari",
    "detailLayanans": [
      {
        "namaLatihan": "joging-3",
        "harga": 100000,
        "hari": "Rabu",
        "durasiMenit": "20 Menit"
      },
      {
        "namaLatihan": "joging-1",
        "harga": 100000,
        "hari": "Senin",
        "durasiMenit": "20 Menit"
      },
      {
        "namaLatihan": "joging-2",
        "harga": 100000,
        "hari": "Selasa",
        "durasiMenit": "20 Menit"
      }
    ]
  },
  "tambahanLayanan": [
    {
      "namaLatihan": "joging-1",
      "harga": 100000,
      "hari": "Senin",
      "durasiMenit": "20 Menit"
    },
    {
      "namaLatihan": "joging-2",
      "harga": 100000,
      "hari": "Selasa",
      "durasiMenit": "20 Menit"
    }
  ]
}
```

## Delete Data Order Paket Layanan

End Point : Delete /api/paket/hapus-order-paket/{idOrder}

Request Header :

- X-API-TOKEN or Bearer Token

Response Body - Failed (401) :
```json
{
  "errors": "Unauthorized"
}
```

Response Body - Success :
```json
{
  "data": "Menghapus paket order sukses"
}
```

## Delete Data Tambahan Pertemuan

End Point : Delete /api/paket/hapus-order-tambahan/{idOrder}/{idTambahanPertemuan}

Request Header :

- X-API-TOKEN or Bearer Token

Response Body - Failed (401) :
```json
{
  "errors": "Unauthorized"
}
```

Response Body - Success :
```json
{
    "data": "Menghapus order tambahan pertemuan sukses"
}
```
