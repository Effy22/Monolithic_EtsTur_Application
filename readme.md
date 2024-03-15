db.createUser({ user: "tatiluser", pwd: "tatiluser*", roles: ["readWrite","dbAdmin"]})

# MONGO DB
    Database Name: EtsTurDB
    Kullanıcı: tatiluser
    Şifre: tatiluser*

/********
* Uygulamada olacak sayfalar ve Kullanılacak end-point listesi
* -- Login
*  +----- auth/dologin (giriş için kullanılacak ve token dönecek)  YAPILDI
* -- Register
*  +----- auth/register (yeni kullanıcı üyeliği için kullanılacak) YAPILDI
* -- AnaSayfa
*  +----- otel/filter-list (sol tarafta bulunan filtreleme başlıklarını listelemek için kullanılacak) YAPILDI
*  +----- otel/find-all (popüler otellerden başlayarak ana sayfada gösterilecek otellerin listesini dönecek -) YAPILDI
*  +----- otel/find-search (aram çubuğuna yazılan ifadeye göre filtreleme yaparak otel listesi dönecek) YAPILDI
* -- Otel Detay
*  +----- otel/find-by-id (otel e ait detay bilgilerini dönecek, resimler, açıklamalar, odalar v.s.) YAPILDI
*
*  +----- user/add-favori (kullanıcı otel i beğenebilecek.)  YAPILDI
* -- Kullanıcı Sayfası
*  +----- user/find-by-token (kullanıcıya ait bilgileri dönecek) YAPILDI
*  +----- user/update (kullanıcı bilgilerini güncelleyecek) YAPILDI
*  +----- user/favori (kullanıcının beğendiği otellerin listesini dönecek)
*  --------------------------------
*/

docker build --platform linux/amd64 -t elifgur/monolithic_etstur_application:v.0.5 .
