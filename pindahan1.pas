procedure CariHarga(Psn:Pasien; N:integer);
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
     while (Not Ketemu) and (i <= N) do
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
         for i := 1 to N do
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

//Isi_Data

writeln('| NO | KODE | NAMA PASIEN | JK |   ALAMAT   | UMUR |   AGAMA  |   PEKERJAAN   |');
   writeln('|=============================================================================|');
for i := 1 to N do
    begin
     gotoxy(1,i+5);
     writeln('|    |      |             |    |            |      |          |               |');
     gotoxy(3,i+5);write(i);
     gotoxy(8,i+5); readln(Psn[i].KODE);
     gotoxy(15,i+5); readln(Psn[i].Nama);
     gotoxy(29,i+5); readln(Psn[i].JK);
     gotoxy(34,i+5); readln(Psn[i].Alamat);
     gotoxy(47,i+5); readln(Psn[i].Umur);
     gotoxy(54,i+5); readln(Psn[i].Agama);
     gotoxy(65,i+5); readln(Psn[i].Pekerjaan);
    end;// End for
     write;
     writeln('------------------------------------------------------------------------------|');
end;// End Procedure


//Isi_Data_rekam_medis


//Isi_Data
gotoxy(1,baris+4); writeln('Kode Pasien   : ',Psn[i].Kode);
          gotoxy(1,baris+5); writeln('Nama Pasien   : ',Psn[i].Nama);
          gotoxy(1,baris+6); writeln('Alamat        : ',Psn[i].Alamat);
          gotoxy(46,baris+4);writeln('Jenis Kelamin : ',Psn[i].JK);
          gotoxy(46,baris+5);writeln('Umur          : ',Psn[i].Umur);
          gotoxy(46,baris+6);writeln('Agama         : ',Psn[i].Agama);
          gotoxy(10,baris+8); writeln('=========================================================================');
          gotoxy(10,baris+9); writeln('|                         -= DATA REKAM MEDIS =-                        |');
          gotoxy(10,baris+10); writeln('========================================================================');
          gotoxy(10,baris+11); writeln('| TGL BEROBAT |   PEMERIKSAAN   |   DIAGNOSIS         |   PENGOBATAN   |');
          gotoxy(10,baris+12); writeln('========================================================================');
          gotoxy(10,baris+13); writeln('|             |                 |                     |                |');
          gotoxy(10,baris+14); writeln('========================================================================');
          gotoxy(23,baris+15); write(Psn[i].TglBerobat);
          gotoxy(27,baris+16); write(Psn[i].Pemeriksaan);
          gotoxy(42,baris+17); write(Psn[i].Diagnosis);
          gotoxy(64,baris+18); write(Psn[i].Pengobatan);



//Isi_Data

procedure Isi_Data(var Psn:Pasien; var N:integer);
{I.S. : }
{F.S. : }
var
 i, baris : integer;
begin
   write('Banyaknya Data : '); readln(N);
   clrscr;
   baris := 4;
   writeln('|=============================================================================|');
   writeln('|                             -= DATA PASIEN =-                               |');
   writeln('|=============================================================================|');
   for i := 1 to N do
    begin
      gotoxy(1,baris); write('No. ',i);
      gotoxy(1,baris+1); write('Kode Pasien   : '); readln(Psn[i].KODE);
      gotoxy(1,baris+2); write('Nama Pasien   : '); readln(Psn[i].Nama);
      gotoxy(1,baris+3); write('Jenis Kelamin : '); readln(Psn[i].JK);
      gotoxy(1,baris+4); write('Alamat        : '); readln(Psn[i].Alamat);
      gotoxy(1,baris+5); write('Umur         : '); readln(Psn[i].Umur);
      gotoxy(1,baris+6); write('Agama        : '); readln(Psn[i].Agama);
      gotoxy(1,baris+7); write('Pekerjaan    : '); readln(Psn[i].Pekerjaan);
      baris := baris + 9 ;
    end;// Endfor
end;// End Procedure

procedure Isi_Rekam_Medis(var Psn:Pasien; Var N:integer);
{I.S. : }
{F.S. : }
var
 i        : integer;
 KodeCari : string;
 Ketemu   : boolean;
 Ulangi   : char;
begin
 repeat;
  clrscr;
  writeln('|=============================================================================|');
  writeln('|                           -= DAFTAR PASIEN =-                               |');
  writeln('|=============================================================================|');
  for i := 1 to N do
   begin
    gotoxy(1,i+5);  writeln('No. ',i);
    gotoxy(1,i+6);  writeln('Kode Pasien       : ',Psn[i].KODE);
    gotoxy(1,i+7);  writeln('Nama Pasien       : ',Psn[i].Nama);
    gotoxy(1,i+8);  writeln('Jenis Kelamin     : ',Psn[i].JK);
    gotoxy(1,i+9);  writeln('Alamat            : ',Psn[i].Alamat);
    gotoxy(1,i+10); writeln('Umur              : ',Psn[i].Umur);
    gotoxy(1,i+11); writeln('Agama             : ',Psn[i].Agama);
    gotoxy(1,1+12); writeln('Pekerjaan         : ',Psn[i].Pekerjaan);
    writeln('------------------------------------------------------------------------------|');
 end;// Endfor
    write('Masukan Kode Untuk Input Rekam Medis     : '); readln(KodeCari);
    clrscr;
     i := 1;
     Ketemu := false;
      while (Not Ketemu) and (i <= N) do
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
         writeln('Kode Pasien : ',Psn[i].Kode);
         writeln('Nama Pasien : ',Psn[i].Nama);
         writeln('Alamat      : ',Psn[i].Alamat);
        end // End If
        else
         writeln('Kode ',KodeCari,' tidak ditemukan !');
         writeln;
         writeln('======================================================================');
         writeln('|                      -= DATA REKAM MEDIS =-                        |');
         writeln('======================================================================');
         writeln('| TGL BEROBAT |    PEMERIKSAAN    |    DIAGNOSIS    |   PENGOBATAN   |');
         writeln('======================================================================');
         writeln('|             |                   |                 |                |');
         writeln('======================================================================');
         gotoxy(3,10); readln(Psn[i].TglBerobat);
         gotoxy(17,10); readln(Psn[i].Pemeriksaan);
         gotoxy(32,10); readln(Psn[i].Diagnosis);
         gotoxy(54,10); readln(Psn[i].Pengobatan);
         gotoxy(1,14);write('Anda Ingin Input Pasien Lagi (Y/T)');
       repeat
        readln(Ulangi);
        until (Ulangi = 'y') or ( Ulangi = 't');
        until (Ulangi = 't');
end; //endprocedure


{procedure CariNama1(Psn:Pasien; N:integer);
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
     while (Not Ketemu) and (i <= N) do
      begin
       if (Psn[i].Nama = NamaCari)
        then
          begin
            Ketemu := true;
          end //endif
        else
        begin
          i := i + 1;
        end; //endif
        end; //endwhile
     if (Ketemu)
      then
       begin
        writeln('              <> DATA PASIEN YANG DICARI BERDASARKAN ( NAMA ) <>              ');
        writeln;
        writeln(' Nama Yang Di Cari : ',Psn[i].Nama,'                                          ');
        Po := 0;
         for i := 1 to N do
          begin
           if (Psn[i].Nama = NamaCari)
            then
              begin
                writeln;
                writeln('==============================================================================');
                writeln('                              Data Pasien Ke-',i,'                            ');
                writeln('==============================================================================');
                Po := Po + 1;                                                                             
                gotoxy(1,Po+7); writeln(Psn[i].KODE);                                                         
                gotoxy(1,Po+8); writeln(Psn[i].Nama);                                                             
                gotoxy(1,Po+9); writeln(Psn[i].JK);                                                         
                gotoxy(1,Po+10); writeln(Psn[i].Alamat);                                                  
                gotoxy(1,Po+11); writeln(Psn[i].Umur);                                                    
                gotoxy(1,Po+12); writeln(Psn[i].Agama);                                                 
                writeln('------------------------------------------------------------------------------');                

              end; //endif
          end; //Endfor
          end //endif
            else
            begin
              writeln('Nama ',NamaCari,' tidak ditemukan !');
              readln;
            end;
end; //endprocedure
}


            repeat
              clrscr;
              gotoxy(1,1); writeln('===============================================================================');
              gotoxy(1,2); writeln('                            -= KLINIK KATAMSO =-                               ');
              gotoxy(1,3); writeln('   Jl. Brigjen Katamso, Cihaurgeulis, Cibeunying Kaler, Bandung, Jawa Barat    ');
              gotoxy(1,4); writeln('===============================================================================');
              gotoxy(17,7);  write('=================================================');
              gotoxy(17,8);  write('|               -= Menu Isi Data =-             |');
              gotoxy(17,9);  write('=================================================');
              gotoxy(17,10); write('|                                               |');
              gotoxy(17,11); write('| 1. Isi Data Pasien                            |');
              gotoxy(17,12); write('| 2. Isi Data Rekam Medis                       |');
              gotoxy(17,13); write('| 0. Keluar ke Menu Utama                       |');
              gotoxy(17,14); write('|                                               |');
              gotoxy(17,15); write('| Pilihan Anda ?                                |');
              gotoxy(17,16); write('|                                               |');
              gotoxy(17,17); write('=================================================');
              gotoxy(1,25); writeln('===============================================================================');
              gotoxy(38,15); readln(Menu1);
              case Menu1 of

              1 : begin
                    clrscr;
                    Isi_Data(Psn);
                    readln;
                    Urut_Kode(Psn);
                    writeln;
                    writeln('Tekan Enter Untuk Ke Menu..!!');
                    readln;
                  end;
              
              2 : begin
                    clrscr;
                      Isi_Rekam_Medis(Psn);
                      writeln;
                      writeln('Tekan Enter Untuk Ke Menu..!!');
                      readln;
                    end;
                  end;
            until(Menu1 = 0);
          end;              
