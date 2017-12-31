program Data_Rekam_Medis;
{I.S. : User memasukkan data pasien}
{F.S. : Menampilkan data pasien yang sudah terurut}

uses crt;

// Kamus Global
const
  Maks_Psn     = 50;
  NamaPengguna = 'admin';
  KataSandi    = 'rootadmin';
  filepsn      = 'D:\[Unikom]\TugasBesar\Alpro\filepasien.dat';

type
    Dt_Psn = record
      Kode,Nama,JK,Alamat,Agama,Umur,Pekerjaan    : string; //JK : Jenis Kelamin
      Pemeriksaan,Diagnosis,Pengobatan,TglBerobat : string;
      N : integer;
    end;//End Record
    Pasien = array[1..Maks_Psn] of Dt_Psn;
var
 Psn           : Pasien;
 FilePasien    : File of Pasien;
 Menu          : integer;
 NP,KS         : string;

function Login(NP,KS : string): boolean;
{I.S. : nama pengguna (NP) dan kata sandi (KS) sudah terdefinisi}
{F.S. : menghasilkan fungsi login}
var
    i : integer;
begin
  i := 1;
  while((NP <> NamaPengguna) or (KS <> KataSandi)) and (i <> 3) do
  begin
    gotoxy(20,14); write('Salah Login!');
    readln; gotoxy(20,14); clreol; gotoxy(39,9); clreol;
    gotoxy(39,10); clreol; 
    gotoxy(39,9); readln(NP); gotoxy(39,10); readln(KS);
    i := i + 1;
  end;
  if(i <= 3) and (NP = NamaPengguna) and (KS = KataSandi)
  then 
    Login := true
  else
    Login := false;
end;

procedure Isi_Data{(var Psn:Pasien; var N:integer)};
{I.S. : user memasukkan banyaknya data (N) dan data pasien}
{F.S. : menghasilkan banyaknya data (N) dan pasien}
var
 i : integer;
begin
    assign(FilePasien,filepsn);
    rewrite(FilePasien);
    write('Banyaknya Data : '); readln(Psn[1].N);
    for i := 1 to Psn[1].N do
    begin
      clrscr;
      writeln('================================================================================');
      writeln('|                          -= KLINIK KATAMSO =-                                |');
      writeln('================================================================================');
      writeln;
      writeln('-----------------------------DATA PASIEN Ke-',i,'-----------------------------------');
      write('Kode Pasien                : '); readln(Psn[i].Kode);
      write('Nama Pasien                : '); readln(Psn[i].Nama);
      write('Alamat                     : '); readln(Psn[i].Alamat);
      write('Pekerjaan                  : '); readln(Psn[i].Pekerjaan);
      write('Jenis Kelamin              : '); readln(Psn[i].JK);
      write('Umur Pasien                : '); readln(Psn[i].Umur);    
      write('Agama Pasien               : '); readln(Psn[i].Agama);
      writeln('======================================================================');
      writeln('|                      -= DATA REKAM MEDIS =-                        |');
      writeln('======================================================================');
      writeln('| TGL BEROBAT |    PEMERIKSAAN    |    DIAGNOSIS    |   PENGOBATAN   |');
      writeln('======================================================================');
      writeln('|             |                   |                 |                |');
      writeln('======================================================================');
      gotoxy(3,18);  readln(Psn[i].TglBerobat);
      gotoxy(17,18); readln(Psn[i].Pemeriksaan);
      gotoxy(37,18); readln(Psn[i].Diagnosis);
      gotoxy(55,18); readln(Psn[i].Pengobatan);
      gotoxy(1,21);  writeln('--------------------------------------------------------------------------------');
      readln;
    end;
   write(FilePasien,Psn);
   close(FilePasien);
end;// Endprocedure

procedure Urut_Kode(var Psn:Pasien);
{I.S. : banyaknya data (N) dan data pasien sudah terdefinisi}
{F.S. : menghasilkan data pasien yang sudah terurut berdasarkan kode}
var
 i,j,min : integer;
 Temp    : Dt_Psn;
begin
  assign(FilePasien,filepsn);
  reset (FilePasien);
  read  (FilePasien,Psn);
  for i := 1 to (Psn[1].N-1) do
    begin
      min := i;
      for j := (i+1) to Psn[1].N do
        begin
          if(Psn[j].Kode < Psn[min].Kode)
            then
              begin
                min := j;
              end;
        end; // End For

        // Menukarkan Data
        Temp     := Psn[i];
        Psn[i]   := Psn[min];
        Psn[min] := Temp;
    end; // Endfor
    close (FilePasien);
end;// End Procedure

procedure Tampil_Data(Psn:Pasien);
{I.S. : banyaknya data (N) dan data pasien sudah terdefinisi}
{F.S. : menampilkan banyaknya data (N) dan pasien}
var
 i,baris : integer;
begin
  clrscr;
  writeln('|=============================================================================|');
  writeln('|                       -= DATA PASIEN REKAM MEDIS=-                          |');
  writeln('|=============================================================================|');
  baris := 5;
  for i := 1 to Psn[1].N do
    begin
      gotoxy(1,baris);     writeln('-----------------------------DATA PASIEN Ke-',i,'-------------------------------');
      gotoxy(1,baris+1);   writeln('Kode Pasien   : ',Psn[i].Kode);
      gotoxy(1,baris+2);   writeln('Nama Pasien   : ',Psn[i].Nama);
      gotoxy(1,baris+3);   writeln('Alamat        : ',Psn[i].Alamat);
      gotoxy(46,baris+1);  writeln('Jenis Kelamin : ',Psn[i].JK);
      gotoxy(46,baris+2);  writeln('Umur          : ',Psn[i].Umur);
      gotoxy(46,baris+3);  writeln('Agama         : ',Psn[i].Agama);
      gotoxy(1,baris+5);   writeln('========================================================================');
      gotoxy(1,baris+6);   writeln('|                         -= DATA REKAM MEDIS =-                       |');
      gotoxy(1,baris+7);   writeln('========================================================================');
      gotoxy(1,baris+8);   writeln('| TGL BEROBAT |   PEMERIKSAAN   |       DIAGNOSIS     |   PENGOBATAN   |');
      gotoxy(1,baris+9);   writeln('========================================================================');
      gotoxy(1,baris+10);  writeln('|             |                 |                     |                |');
      gotoxy(1,baris+11);  writeln('========================================================================');
      gotoxy(3,baris+10);  write(Psn[i].TglBerobat);
      gotoxy(17,baris+10); write(Psn[i].Pemeriksaan);
      gotoxy(36,baris+10); write(Psn[i].Diagnosis);
      gotoxy(59,baris+10); write(Psn[i].Pengobatan);
      baris := baris + 13;
    end;
    writeln;
    write('==============================================================================');
end; //endprocedure


procedure CariKode(Psn:Pasien);
{I.S. : Banyaknya data(N) dan data pasien sudah terdefinisi}
{F.S. : mencari data buku berdasarkan kode pasien}
var
   i : integer;
   KodeCari : string;
   Ketemu  : boolean;
begin
     clrscr;
     writeln('               <> DATA PASIEN YANG DICARI BERDASARKAN KODE <>                  ');
     writeln;
     write('Masukan Kode yang dicari : '); readln(KodeCari);
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
              clrscr;
              writeln('               <> DATA PASIEN YANG DICARI BERDASARKAN KODE <>                  ');
              writeln;
              writeln('Kode Yang Dicari : ',KodeCari);
              writeln;
              writeln('Kode Pasien   : ',Psn[i].Kode);
              writeln('Nama Pasien   : ',Psn[i].Nama);
              writeln('Alamat        : ',Psn[i].Alamat);
              gotoxy(46,5);writeln('Jenis Kelamin : ',Psn[i].JK);
              gotoxy(46,6);writeln('Umur Pasien   : ',Psn[i].Umur);
              gotoxy(46,7);writeln('Agama Pasien  : ',Psn[i].Agama);
              writeln;
              writeln('========================================================================');
              writeln('|                         -= DATA REKAM MEDIS =-                       |');
              writeln('========================================================================');
              writeln('| TGL BEROBAT |   PEMERIKSAAN   |   DIAGNOSIS         |   PENGOBATAN   |');
              writeln('========================================================================');
              writeln('|             |                 |                     |                |');
              writeln('========================================================================');
              gotoxy(3,14);  write(Psn[i].TglBerobat);
              gotoxy(17,14); write(Psn[i].Pemeriksaan);
              gotoxy(32,14); write(Psn[i].Diagnosis);
              gotoxy(54,14); write(Psn[i].Pengobatan);
            end
          else
            begin
              writeln('Kode ',KodeCari,' tidak ditemukan !');
              readln;
            end;
end; //endprocedure

Procedure CariNama (Psn:Pasien);
var
  i,j,baris  : integer;
  temp       : Pasien;
  NmP        : string; //NmP : Nama Pasien
begin
  write('Nama Pasien yang dicari : ') ;readln(Nmp);
  i := 1;
  j := 0;
  while (i <= Psn[1].N) do
  begin
    if (pos(lowercase(NmP),lowercase(Psn[i].Nama)) > 0 )
    then
    begin
      j:= J + 1;
      Temp[j]:= Psn[i];
    end;
    i := i+1;
  end; //endwhile
  if (j>0)
  then
  begin
    clrscr;
    baris := 5;        
    gotoxy(15,1);Write('CARI DATA PASIEN BERDASARKAN NAMA');
    gotoxy(1,3);
    write('Nama Pasien Yang Dicari : ',NmP);
    for i := 1 to J do
    begin
      gotoxy(1,baris);     writeln('------------------------------------------------------------------------------');
      gotoxy(1,baris+1);   writeln('Kode Pasien   : ',temp[i].Kode);
      gotoxy(1,baris+2);   writeln('Nama Pasien   : ',temp[i].Nama);
      gotoxy(1,baris+3);   writeln('Alamat        : ',temp[i].Alamat);
      gotoxy(1,baris+4);   writeln('Jenis Kelamin : ',temp[i].JK);
      gotoxy(1,baris+5);   writeln('Umur          : ',temp[i].Umur);
      gotoxy(1,baris+6);   writeln('Agama         : ',temp[i].Agama);
      gotoxy(1,baris+8);   writeln('========================================================================');
      gotoxy(1,baris+9);   writeln('|                         -= DATA REKAM MEDIS =-                       |');
      gotoxy(1,baris+10);  writeln('========================================================================');
      gotoxy(1,baris+11);  writeln('| TGL BEROBAT |   PEMERIKSAAN   |   DIAGNOSIS         |   PENGOBATAN   |');
      gotoxy(1,baris+12);  writeln('========================================================================');
      gotoxy(1,baris+13);  writeln('|             |                 |                     |                |');
      gotoxy(1,baris+14);  writeln('========================================================================');
      gotoxy(3,baris+13);  write(temp[i].TglBerobat);
      gotoxy(17,baris+13); write(temp[i].Pemeriksaan);
      gotoxy(36,baris+13); write(temp[i].Diagnosis);
      gotoxy(59,baris+13); write(temp[i].Pengobatan);
      baris := baris + 16;
    end
  end
  else
    writeln('Pasien ',Nmp,' tidak ada!');
end; //Endprocedure

procedure CariUmur(Psn:Pasien{; N:integer});
{I.S. : Banyaknya data(N) dan data pasien sudah terdefinisi}
{F.S. : mencari data pasien berdasarkan umur pasien}      

var
   i,baris  : integer;
   UmurCari : string;
   Ketemu   : boolean;
begin
     clrscr;
     write('Masukan Umur yang dicari : '); readln(UmurCari);
     i := 1;
     Ketemu := false;
     while (Not Ketemu) and (i <= Psn[1].N) do
      begin
       if (Psn[i].Umur = UmurCari)
        then
         Ketemu := true
        else
         i := i + 1;
      end; //endwhile

     if (Ketemu)
      then
       begin
        clrscr;
        writeln('             <> DATA PASIEN YANG DICARI BERDASARKAN ( Umur ) <>              ');
        writeln;
        writeln(' Umur Yang Di Cari : ',UmurCari); 
        writeln;
        baris := 6;
        for i := 1 to Psn[1].N do
          begin
            if (Psn[i].Umur = UmurCari)
              then
                begin
                  gotoxy(1,baris);     writeln('------------------------------------------------------------------------------');
                  gotoxy(1,baris+1);   writeln('Kode Pasien   : ',Psn[i].Kode);                                           
                  gotoxy(1,baris+2);   writeln('Nama Pasien   : ',Psn[i].Nama);                                                     
                  gotoxy(1,baris+3);   writeln('Alamat        : ',Psn[i].Alamat);                                             
                  gotoxy(46,baris+1);  writeln('Jenis Kelamin : ',Psn[i].JK);                                                 
                  gotoxy(46,baris+2);  writeln('Umur          : ',Psn[i].Umur);                                             
                  gotoxy(46,baris+3);  writeln('Agama         : ',Psn[i].Agama);                                          
                  gotoxy(1,baris+5);   writeln('========================================================================');
                  gotoxy(1,baris+6);   writeln('|                         -= DATA REKAM MEDIS =-                       |');
                  gotoxy(1,baris+7);   writeln('========================================================================');
                  gotoxy(1,baris+8);   writeln('| TGL BEROBAT |   PEMERIKSAAN   |       DIAGNOSIS     |   PENGOBATAN   |');
                  gotoxy(1,baris+9);   writeln('========================================================================');
                  gotoxy(1,baris+10);  writeln('|             |                 |                     |                |');
                  gotoxy(1,baris+11);  writeln('========================================================================');
                  gotoxy(3,baris+10);  write(Psn[i].TglBerobat);                                                                        
                  gotoxy(17,baris+10); write(Psn[i].Pemeriksaan);                                                             
                  gotoxy(36,baris+10); write(Psn[i].Diagnosis);                                                             
                  gotoxy(59,baris+10); write(Psn[i].Pengobatan);                                                                
                  baris := baris + 14;
                end;
        end;// End for
        write;
        gotoxy(1,baris+1); writeln('-------------------------------------------------------------------------------');
        end
        else
          begin
            writeln('Nama ',UmurCari,' tidak ditemukan !');
            readln;
          end;
end; //endprocedure

procedure Tampil_Menu(var Menu:integer);
{I.S. : user memilih salah satu menu}
{F.S. : menghasilkan menu yang dipilih}

begin
 repeat
  clrscr;
  writeln('===============================================================================');
  writeln('                            -= KLINIK KATAMSO =-                               ');
  writeln('   Jl. Brigjen Katamso, Cihaurgeulis, Cibeunying Kaler, Bandung, Jawa Barat    ');
  writeln('===============================================================================');
  gotoxy(17,7);  write('=================================================');
  gotoxy(17,8);  write('|          <>   -= MENU UTAMA =-   <>           |');
  gotoxy(17,9);  write('=================================================');
  gotoxy(17,10); write('|                                               |');
  gotoxy(17,11); write('| 1. Isi Data Pasien                            |');
  gotoxy(17,12); write('| 2. Cari Data Berdasarkan Kode                 |');
  gotoxy(17,13); write('| 3. Cari Data Berdasarkan Nama                 |');
  gotoxy(17,14); write('| 4. Cari Data Berdasarkan Umur                 |');
  gotoxy(17,15); write('| 5. Tampil Data Keseluruhan Yang Sudah Terurut |');
  gotoxy(17,16); write('| 0. Keluar                                     |');
  gotoxy(17,17); write('|                                               |');
  gotoxy(17,18); write('| Pilihan Anda ?                                |');
  gotoxy(17,19); write('|                                               |');
  gotoxy(17,20); write('=================================================');
  gotoxy(1,25);  writeln('===============================================================================');
  gotoxy(38,18); readln(Menu);
  case Menu of
                                            
     1 :  begin
            clrscr;
            Isi_Data;
            readln;
            end;

     2 :  begin
            clrscr;
            Urut_Kode(Psn);
            CariKode(Psn);
            writeln;
            writeln;
            writeln('Tekan Enter Untuk Ke Menu..!!');
            readln;
          end;

     3 :  begin
            clrscr;
            Urut_Kode(Psn);
            CariNama(Psn);
            writeln;
            writeln;
            writeln('Tekan Enter Untuk Ke Menu..!!');
            readln;
          end;

     4 :  begin
            clrscr;
            Urut_Kode(Psn);
            CariUmur(Psn);
            writeln;
            writeln;
            writeln('Tekan Enter Untuk Ke Menu..!!');
            readln;
          end;

     5 : begin
          clrscr;
          Urut_Kode(Psn);
          Tampil_Data(Psn);
          writeln;
          writeln;         
          writeln('Tekan Enter Untuk Ke Menu..!!');
          readln;
         end;

  end;
  until(Menu = 0);
end;// End Procedure

// Program Utama

begin
  //window(1,1,80,25);
  clrscr;
  gotoxy(20,5);  writeln ('=================================================');
  gotoxy(20,6);  writeln ('| Silahkan Masukan Nama Pengguna dan Kata Sandi |');
  gotoxy(20,7);  writeln ('=================================================');
  gotoxy(20,8);  writeln ('                                                 ');
  gotoxy(20,9);  writeln ('   Nama Pengguna :                               ');
  gotoxy(20,10); writeln ('   Kata Sandi    :                               ');
  gotoxy(20,11); writeln ('                                                 ');
  gotoxy(20,12); writeln ('=================================================');
  gotoxy(39,9);  readln(NP);
  gotoxy(39,10); readln(KS);
  if(Login(NP,KS)) //Login Sukses
  then
  begin
    Tampil_Menu(Menu);
  end
  else
  begin    
    gotoxy(20,12); write('Maaf, Sudah 3 kali salah Login!'); readln;
  end;
  readln;
end.
