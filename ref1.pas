program PasienRawatInap;
uses crt,sysutils;

const
  nama_file = 'E:\DataMahasiswa\Tugas\Alpro\tugas_besar\data_pasien.txt';
  Maks_pasien = 200;
  user = 'rafli' ;
  pass = '10116132' ;
type
  dt_pasien = record
    kode_pasien, Nama_pasien : string;
    Umur                     : string;
  end;

  arr_pasien = array [1..Maks_pasien] of dt_pasien;

var
  Pasien       : arr_pasien;
  N, Menu      : integer; // N = banyaknya pasien
  file_pasien  : file of dt_pasien;
  Nmp          : string; //Nama pasien
  np, ks       : string; // KS: KaNP: Nama Pengguna, ta Sandi
  i,l          : integer;
// fungsi login
function menu_login(np, ks: string): boolean;
var
  kesempatan: integer;
begin
  kesempatan := 1;
  menu_login := false;
  while ((np <> user) or (ks <> pass)) and (kesempatan <> 3) do begin
    gotoxy(1, 3); write('Salah login');
    readkey;
    gotoxy(1, 3); clreol; // hapus error
    gotoxy(12, 1); clreol; readln(np);
    gotoxy(12, 2); clreol; readln(ks);
    kesempatan := kesempatan + 1;
  end;
  if (kesempatan <= 3) and (np = user) and (ks = pass) then begin
    menu_login := true;
  end
end;

//prosedure Menu Pilihan
procedure MenuPilihan (var Menu: integer);
begin
    gotoxy(30,8);write('MENU PILIHAN');
    gotoxy(30,9);write('============');
    gotoxy(30,10);write('1. ISI DATA PASIEN');
    gotoxy(30,11);write('2. CARI BERDASARKAN KODE');
    gotoxy(30,12);write('3. CARI BERDASARKAN NAMA');
    gotoxy(30,13);write('4. CARI BERDASARKAN UMUR');
    gotoxy(30,14);write('5. TAMPIL DARA KESELURUHAN YANG SUDAH TERURUT');
    gotoxy(30,15);write('0. Keluar');
    gotoxy(30,16);write('PILIHAN ANDA?');
    gotoxy(43,16);readln(Menu);
    //validasi Menu Pilihan
    while (Menu < 0) or (menu > 5) do
    begin
       gotoxy(18,17);write('Pilihan Hanya Boleh 0/1/2/3/4,5 ulangi Tekan Enter !');
       readln;
       gotoxy(43,16);clreol;
       gotoxy(18,17);clreol;
       gotoxy(43,15);readln(Menu);
    end;
end;

//prosedure buka file
procedure buka_file;
var
  i,L: integer;
begin
 assign(file_pasien, Nama_file);
 {$I-}
 reset(file_pasien);
 {$I+}
 if (ioresult <> 0) then begin
    writeln('error creating / reading file!');
    rewrite(file_Pasien);
  end
  else
  begin
    i:=1;
    L:=filesize(file_pasien);
    seek(file_Pasien,0);
    while not eof(file_pasien) do
    begin
      seek(file_pasien,i-1);
      read(file_pasien,pasien[i]);
      i:=i+1;
  end;
  end;
end;


//prosedure Memasukan data pasien
procedure IsiDataPasien (var n:integer; var pasien:arr_pasien);
var
  i : integer;
begin
  clrscr;
  buka_file; //memanggil prosedur buka file
  write('Banyaknya Data Pasien : '); readln(N);
  while (N<1) or (N>Maks_pasien) do
  begin
    write('Banyaknya Data Buku Hanya Boleh Antara 1-200 !');
    readln;
    gotoxy(1,2);clreol;
    gotoxy(22,1);clreol;
    readln(N);
  end;
  clrscr;
  gotoxy(30,1);Write('DAFTAR PASIEN');
  gotoxy(1,3);
  write('-----------------------------------------------');
  gotoxy(1,4);
  write('| KODE PASIEN |       NAMA PASIEN      | UMUR |');
  gotoxy(1,5);
  write('-----------------------------------------------');
  for i := 1 to N do
  begin
    gotoxy(1,i+5);
    write('|             |                        |      |');
    gotoxy(3,i+5);readln(Pasien[i+l].kode_pasien);
    gotoxy(17,i+5);readln(Pasien[i+l].Nama_pasien);
    gotoxy(42,i+5);readln(pasien[i+l].umur);
    seek(file_pasien, filesize(file_pasien));
    write(file_pasien,Pasien[i+l]);
  end;
  gotoxy(1,i+6);
  write('-----------------------------------------------');
  readln;
  close(file_pasien);
end;

//prosedure Mengurutkan data
procedure UrutDataPasien (N:integer; var Pasien:arr_pasien);
var
  i,j,min : integer;
  temp    : dt_pasien;
begin
  buka_file; // memanggil prosedur buka file
  //metode minimum sort secara ascending
  for i := 1 to (N-1) do
  begin
    min := i;
      for j := i + 1 to N do
      begin
        if(Pasien[j].Kode_pasien < pasien[min].Kode_pasien)
        then
          min := j;
      end;
      temp        := Pasien[i];
      Pasien[i]   := Pasien[min];
      Pasien[min] := temp;
  end;
  close(file_pasien);
end;

procedure simpan_file;
var
  i : integer;
begin
  rewrite(file_pasien);
  for i:= 1 to N do
  begin
    seek(file_pasien,i-1);
    write(file_pasien,pasien[i]);
  end;
end;



procedure CariKode (N : integer; pasien : arr_pasien);
var
  ia,ib,k : integer;
  ketemu  : boolean;
  Kode    : string;
begin
  buka_file; // memanggil prosedur buka file

  write('Kode Pasien yang Dicari : ');readln(Kode);
  Ia := 1;
  Ib := N;
  Ketemu := false;
  while (not ketemu) and (Ia <= Ib) do
  begin
    K := (Ia + Ib) div 2;
    if (Pasien[K].kode_pasien = kode)
    then
      ketemu := true
    else
      if (pasien[K].kode_pasien < kode)
        then
          Ia := K + 1  //pencarian dilanjutkan ke kanan
        else
          Ib := K - 1; //pencarian dilanjutkan ke kiri
  end;
  if (ketemu)
  then
    begin
      clrscr;
      gotoxy(30,3);Write('DAFTAR PASIEN');
      gotoxy(1,5);
      write('-----------------------------------------------');
      gotoxy(1,6);
      write('| Kode Pasien |       Nama Pasien      | Umur |');
      gotoxy(1,7);
      write('-----------------------------------------------');
      gotoxy(1,8);
      write('|             |                        |      |');
      gotoxy(3,8);writeln(Kode);
      gotoxy(17,8);writeln(Pasien[k].Nama_pasien);
      gotoxy(42,8);writeln(Pasien[k].Umur);
      gotoxy(1,9);
      write('-----------------------------------------------');
    end
    else
      writeln('Kode Pasien ',Kode,' tidak ada!');
      close(file_pasien);
end;

Procedure CariNama (N:integer; pasien:arr_pasien; NmP:string);
var
  i,j,baris  : integer;
  temp       : arr_pasien;
begin
  buka_file; // memanggil prosedur buka file
  write('Nama Pengarang yang dicari: ');readln(Nmp);
  i := 1;
  j := 0;
  while (i<=N) do
  begin
    if (pos(lowercase(NmP),lowercase(Pasien[i].Nama_pasien)) > 0 )
    then
    begin
      j:= J + 1;
      Temp[j]:= Pasien[i];
    end;
    i := i+1;
  end; //endwhile
  if (j>0)
  then
  begin
    clrscr;gotoxy(30,1);Write('DATA PASIEN');
    gotoxy(1,3);
    write('Nama Pasien : ',NmP);
    gotoxy(1,4);
    write('----------------------');
    gotoxy(1,5);
    write('| Kode Pasien | Umur |');
    gotoxy(1,6);
    write('----------------------');
    baris := 6;
    for i := 1 to J do
    begin
      gotoxy(1,baris+1);
      write('|           |                      |       |');
      gotoxy(3,baris+1);writeln(temp[i].Kode_pasien);
      gotoxy(15,baris+1);writeln(temp[i].Umur);
      baris := baris + 1;
    end;
      gotoxy(1,baris+1);
      write('--------------------------------------------');
  end
  else
    writeln('Pasien ',Nmp,' tidak ada!');
end;

//prosedure Menampilkan data pasien yang sudah terurut
procedure TampilDataPasien (N:integer; Pasien:arr_pasien);
var
  i:integer;
begin
  buka_file; // memanggil prosedur buka file

  clrscr;
  gotoxy(30,1);Write('DAFTAR PASIEN');
  gotoxy(1,3);
  write('-----------------------------------------------');
  gotoxy(1,4);
  write('| Kode Pasien |       Nama Pasien      | Umur |');
  gotoxy(1,5);
  write('-----------------------------------------------');
  for i := 1 to N do
  begin
    gotoxy(1,i+5);
    write('|             |                        |      |');
    gotoxy(3,i+5);writeln(Pasien[i].Kode_pasien);
    gotoxy(15,i+5);writeln(pasien[i].Nama_pasien);
    gotoxy(38,i+5);writeln(pasien[i].Umur);
  end;
  gotoxy(1,i+6);
  write('--------------------------------------------------------------------');
end;


begin
  clrscr;
  write('User : '); readln(np);
  write('Password : '); readln(ks);
  if (menu_login(np, ks))
  then
  begin
    n := 0;
    repeat
    clrscr;
    menupilihan(menu);
    case (menu) of
    1: isidatapasien(n, pasien);
    2: begin
       urutdatapasien(n, pasien);
       readkey;
       simpan_file;
       carikode(n, pasien);
       readkey;
       end;


    end;
    until (menu = 0);
  end;

end.