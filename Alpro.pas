program Data_Rekam_Medis;
{I.S. : }
{F.S. : }
uses crt;
// Kamus Global

const
  Maks_Psn = 50;
  filepsn = 'D:\tugas\filepasien.dat';
type
    Dt_Psn = record
      Kode,Nama,JK,Penanganan,Penyakit,Alamat : string;
      Agama,Umur,Pekerjaan,Titer,Dokter,TglBerobat : string;
      N,Biaya : integer;
    end;//End Record
      Pasien = array[1..Maks_Psn] of Dt_Psn;
var
 Psn           : Pasien;
 FilePasien    : File of Pasien;
 Menu        : integer;

procedure Login;
{I.S. : }
{F.S. : }
 var
   user,pass,us,ps:string;
   x,i:integer;

 begin
     textbackground(15); clrscr;
     textcolor(blue);
     user := 'user';
     pass := 'password';
     x:=0;
     for i:=1 to 3 do
     begin
          gotoxy(32,2);writeln ('-= KLINIK SARI ASIH =-');
          gotoxy(25,5);writeln ('===================================');
          gotoxy(25,6);writeln ('| Silahkan Masukan Nama dan Sandi |');
          gotoxy(25,7);writeln ('===================================');
          gotoxy(25,8);writeln ('|                                 |');
          gotoxy(25,9);write   ('|  NAMA     :                     |');
          gotoxy(25,10);write  ('|  SANDI    :                     |');
          gotoxy(25,11);writeln('|                                 |');
          gotoxy(25,12);writeln('===================================');
          gotoxy(39,9);readln(us);
          gotoxy(39,10);readln(ps);
           if user = us then
            begin
               if ps = pass then
               begin
                    x:= 1;
                    break;
               end; // End If
            end; // End If
          clrscr;
          writeln('Nama dan Sandi tidak cocok');
          writeln;
     end; // End For
     clrscr;
     if x = 0 then
        writeln('Maaf akun anda di blokir')
     else
       if x = 1 then
        writeln('Selamat Datang di Klinik Sari Asih ! ',user,'!');
     readln;
end;// EndProcedure


procedure Isi_Data{(var Psn:Pasien; var N:integer)};
{I.S. : }
{F.S. : }
var
 i,a : integer;
begin
    a:=0;
    assign(FilePasien,filepsn);
    rewrite(FilePasien);
    write('Banyaknya Data : '); readln(Psn[1].N);
    for i := 1 to Psn[1].N do
    begin
     clrscr;
     writeln(' ------------------------------------------------------------------------------');
     writeln('|                          -= KLINIK KATAMSO =-                                |');
     writeln(' ==============================================================================');
     //gotoxy(1,5+a);
     writeln();
     writeln('-------------------------------DATA PASIEN Ke- ',i,'--------------------------------');
     //gotoxy(1,7+a);
      write('Kode Pasien                : ');readln(Psn[i].Kode);
     //gotoxy(1,8+a);
      write('Nama Pasien                : ');readln(Psn[i].Nama);
     //gotoxy(1,9+a);
      write('Alamat                     : ');readln(Psn[i].Alamat);
     //gotoxy(1,10+a);
      write('Pekerjaan                  : ');readln(Psn[i].Pekerjaan);
     //gotoxy(1,11+a);
     write('Jenis Kelamin              : ');readln(Psn[i].JK);
     //gotoxy(1,12+a);
     write('Umur Pasien                : ');readln(Psn[i].Umur);
     //gotoxy(1,13+a);
     write('Agama Pasien               : ');readln(Psn[i].Agama);
     gotoxy(1,15+a);
     writeln('|----------------------------------------------------------------------------');
     writeln('|                       -= DATA REKAM MEDIS =-                              |');
     writeln('----------------------------------------------------------------------------');
     writeln('| TGL_BEROBAT |   PENYAKIT   |   TINDAKAN DOKTER   |        DOKTER          |');
     writeln('============================================================================');
     writeln('|             |              |                     |                        |');
     writeln('============================================================================');
     gotoxy(3,20); readln(Psn[i].TglBerobat);
     gotoxy(17,20); readln(Psn[i].Penyakit);
     gotoxy(32,20); readln(Psn[i].Titer);
     gotoxy(54,20); readln(Psn[i].Dokter);
     gotoxy(1,22); writeln('------------------------------------------------------------------------------|');
     //gotoxy(70,17+a); readln(Psn[i].Biaya);
   end;
   write(FilePasien,Psn);
   close(FilePasien);
end;// End Procedure



procedure Urut_Kode(var Psn:Pasien{; var N:integer});
{I.S. : }
{F.S. : }
var
 i,j,min : integer;
 Temp    : Dt_Psn;
begin
 assign(FilePasien,filepsn);
 reset (FilePasien);
 read (FilePasien,Psn);
 for i := 1 to (Psn[1].N-1) do
   begin
     min := i;
       for j := (i+1) to Psn[1].N do
         begin
           if(Psn[j].Kode < Psn[min].Kode)
            then
              min := j;
         end; // End For

         // Menukarkan Data
         Temp     := Psn[i];
         Psn[i]   := Psn[min];
         Psn[min] := Temp;

   end; // End For
close (FilePasien);
readkey;
end;// End Procedure


procedure Tampil_Data(Psn:Pasien{; N:integer});

var
 i : integer;
begin
   clrscr;
   writeln('|-----------------------------------------------------------------------------|');
   writeln('|                       -= DATA PASIEN REKAM MEDIS=-                          |');
   writeln('|-----------------------------------------------------------------------------|');
   writeln('| KODE | NAMA PASIEN |  PENYAKIT  | TINDAKAAN DOKTER |       DOKTER           |');
   writeln('|=============================================================================|');
   for i := 1 to Psn[1].N do
 begin
   gotoxy(1,i+5);
   writeln('|      |             |            |                  |                        |');
    begin
     gotoxy(3,i+5); writeln(Psn[i].KODE);
     gotoxy(10,i+5); writeln(Psn[i].Nama);
     gotoxy(24,i+5); writeln(Psn[i].Penyakit);
     gotoxy(37,i+5); writeln(Psn[i].Titer);
     gotoxy(56,i+5); writeln(Psn[i].Dokter);
     //gotoxy(70,i+5); writeln(Psn[i].Biaya);
    end;
 end;// End for
   write;
   writeln('------------------------------------------------------------------------------|');
end; //endprocedure}


procedure CariKode(Psn:Pasien{; N:integer});
{I.S. : }
{F.S. : }
var
   i : integer;
   KodeCari : string;
   Ketemu  : boolean;
begin
     clrscr;
     writeln('               <> DATA PASIEN YANG DICARI BERDASARKAN KODE <>                  ');
     writeln;
     write('Masukan Kode yang dicari : '); readln(KodeCari);

     clrscr;
     i := 1;
     Ketemu := false;
     while (Not Ketemu) and (i <= Psn[1].N) do
      begin
       if (Psn[i].Kode = KodeCari)
        then
         Ketemu := true
        else
         i := i + 1;
        end; //endwhile
         if (Ketemu)
          then
            begin
             writeln('               <> DATA PASIEN YANG DICARI BERDASARKAN KODE <>                  ');
             writeln;
             writeln('Kode Pasien   : ',Psn[i].Kode);
             writeln('Nama Pasien   : ',Psn[i].Nama);
             writeln('Alamat        : ',Psn[i].Alamat);
             writeln('Pekerjaan     : ',Psn[i].Pekerjaan);
             gotoxy(46,3);writeln('Jenis Kelamin : ',Psn[i].JK);
             gotoxy(46,4);writeln('Umur Pasien   : ',Psn[i].Umur);
             gotoxy(46,5);writeln('Agama Pasien  : ',Psn[i].Agama);
             writeln;
             writeln('-------------------------------------------------------------------------------');
             writeln('|                           -= DATA REKAM MEDIS =-                            |');
             writeln('-------------------------------------------------------------------------------');
             writeln('| TGL_BEROBAT |   PENYAKIT   |   TINDAKAN DOKTER   |        DOKTER            |');
             writeln('===============================================================================');
             writeln('|             |              |                     |                          |');
             writeln('===============================================================================');
             gotoxy(3,12); write(Psn[i].TglBerobat);
             gotoxy(17,12); write(Psn[i].Penyakit);
             gotoxy(32,12); write(Psn[i].Titer);
             gotoxy(54,12); write(Psn[i].Dokter);
             //gotoxy(70,12); write(Psn[i].Biaya);
            end
            else
             writeln('Kode ',KodeCari,' tidak ditemukan !');
             readln;
end; //endprocedure


procedure CariNama(Psn:Pasien{; N:integer});
{I.S. : }
{F.S. : }
var
   i,Po : integer;
   NamaCari : string;
   Ketemu  : boolean;
begin
     clrscr;
     write('Masukan Nama yang dicari : '); readln(NamaCari);
     clrscr;
     i := 1;
     Ketemu := false;
     while (Not Ketemu) and (i <= Psn[1].N) do
      begin
       if (Psn[i].Nama = NamaCari)
        then
         Ketemu := true
        else
         i := i + 1;
        end; //endwhile
     if (Ketemu)
      then
       begin
        writeln('              <> DATA PASIEN YANG DICARI BERDASARKAN ( NAMA ) <>              ');
        writeln;
        writeln(' Nama Yang Di Cari : ',Psn[i].Nama,'                                          ');
        writeln;
        writeln('|=============================================================================|');
        writeln('| KODE |   NAMA PASIEN  | JK |    ALAMAT    | UMUR |   AGAMA  |   PEKERJAAN   |');
        writeln('|=============================================================================|');
        Po := 0;
         for i := 1 to Psn[1].N do
          begin
           if (Psn[i].Nama = NamaCari)
            then
             begin
              Po := Po + 1;
              gotoxy(1,Po+7);
              writeln('|      |                |    |              |      |          |               |');
              gotoxy(3,Po+7); writeln(Psn[i].KODE);
              gotoxy(10,Po+7); writeln(Psn[i].Nama);
              gotoxy(28,Po+7); writeln(Psn[i].JK);
              gotoxy(32,Po+7); writeln(Psn[i].Alamat);
              gotoxy(47,Po+7); writeln(Psn[i].Umur);
              gotoxy(54,Po+7); writeln(Psn[i].Agama);
              gotoxy(65,Po+7); writeln(Psn[i].Pekerjaan);
             end;
          end;// End for
           write;
           writeln('|-----------------------------------------------------------------------------|');
          end
          else
           writeln('Nama ',NamaCari,' tidak ditemukan !');
           readln;
end; //endprocedure


procedure CariHarga(Psn:Pasien{; N:integer});
{I.S. : }
{F.S. : }
var
   i,Po : integer;
   HargaCari : integer;
   Ketemu  : boolean;
begin
     clrscr;
     write('Masukan Harga yang dicari : '); readln(HargaCari);
     clrscr;
     i := 1;
     Ketemu := false;
     while (Not Ketemu) and (i <= Psn[1].N) do
      begin
       if (Psn[i].Biaya = HargaCari)
        then
         Ketemu := true
        else
         i := i + 1;
      end; //endwhile

     if (Ketemu)
      then
       begin
        writeln('             <> DATA PASIEN YANG DICARI BERDASARKAN ( HARGA ) <>              ');
        writeln;
        writeln(' Harga Yang Di Cari : Rp.',Psn[i].Biaya,'                                     ');
        writeln;
        writeln('|=============================================================================|');
        writeln('| KODE | NAMA PASIEN |  PENYAKIT  |  TINDAKAN DOKTER |   DOKTER  |   BIAYA    |');
        writeln('|=============================================================================|');
        Po := 0;
         for i := 1 to Psn[1].N do
          begin
           if (Psn[i].Biaya = HargaCari)
            then
             begin
              Po := Po + 1;
              gotoxy(1,Po+7);
              writeln('|      |            |             |                  |           |Rp.         |');
              gotoxy(3,Po+7); writeln(Psn[i].KODE);
              gotoxy(10,Po+7); writeln(Psn[i].Nama);
              gotoxy(24,Po+7); writeln(Psn[i].Penyakit);
              gotoxy(37,Po+7); writeln(Psn[i].Titer);
              gotoxy(57,Po+7); writeln(Psn[i].Dokter);
              gotoxy(73,Po+7); writeln(Psn[i].Biaya);
             end;
          end;// End for
          write;
          writeln('|-----------------------------------------------------------------------------|');
          end
          else
           writeln('Nama ',HargaCari,' tidak ditemukan !');
           readln;
end; //endprocedure


procedure Tampil_Menu(var Menu:integer);
{I.S. : }
{F.S. : }
var
 menu1 : integer;
begin
 repeat
  textbackground(15); clrscr;
  textcolor(blue);
  writeln('===============================================================================');
  writeln('                       -= KLINIK PRATAMA SARI ASIH =-                          ');
  writeln('          Jl.Sekaloa Gang.Loa II Bandung 40132 Tlp.(022)2503868                ');
  writeln('===============================================================================');
  gotoxy(17,7);  write('=================================================');
  gotoxy(17,8);  write('|          <>   -= MENU UTAMA =-   <>           |');
  gotoxy(17,9);  write('=================================================');
  gotoxy(17,10); write('| 1. Isi Data Pasien                            |');
  gotoxy(17,11); write('| 2. Cari Data Berdasarkan Kode                 |');
  gotoxy(17,12); write('| 3. Cari Data Berdasarkan Nama                 |');
  gotoxy(17,13); write('| 4. Cari Data Berdasarkan Harga                |');
  gotoxy(17,14); write('| 5. Tampil Data Keseluruhan Yang Sudah Terurut |');
  gotoxy(17,15); write('| 0. Keluar                                     |');
  gotoxy(17,16); write('|                                               |');
  gotoxy(17,17); write('| Pilihan Anda ?                                |');
  gotoxy(17,18); write('=================================================');
  gotoxy(1,24);writeln('===============================================================================');
  gotoxy(38,17); readln(Menu);
  case Menu of
     1 :  begin
            clrscr;
            Isi_Data{(Psn , N )};
            readln;
            end;

     2 : begin
            clrscr;
            Urut_Kode(Psn);
            CariKode(Psn{,N});
            writeln();
            writeln('Tekan Enter Untuk Ke Menu..!!');
            readln;
         end;

     3 : begin
           clrscr;
           Urut_Kode(Psn);
           CariNama(Psn{,N});
           writeln();
           writeln('Tekan Enter Untuk Ke Menu..!!');
           readln;
          end;

     4 : begin
           clrscr;
           Urut_Kode(Psn{,N});
           CariHarga(Psn{,N});
           writeln();
           writeln('Tekan Enter Untuk Ke Menu..!!');
           readln;
       end;

     5 : begin
          clrscr;
            Urut_Kode(Psn{,N});
            Tampil_Data(Psn{,N});
            writeln;
            writeln('Tekan Enter Untuk Ke Menu..!!');
            readln;

        end;
    end;
  until(Menu = 0);

end;// End Procedure


// Program Utama
begin
  //Login;
  Tampil_Menu(Menu);

  readln;
end.

