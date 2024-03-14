package com.elif.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(5200, "Sunucu Hatasi",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST (4200,"Parametre hatasi", HttpStatus.BAD_REQUEST),
    ACTIVATION_CODE_ERROR (4300,"Aktivasyon Kodu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    LOGIN_ERROR (4300,"Giriş hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    TOKEN_NOT_CREATED (4300,"Token oluşturulamadı.", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_DUPLICATE (4300,"Bu kullanıcı adı ile zaten mevcut kayıt var.", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_ALLREADY_EXIST(4211,"Böyle bir kullanici adi ya da email ile olusturulmus bir kullanıcı mevcuttur...", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4212,"Böyle bir kullanici bulunamadi...",HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_ACTIVE(4212,"Bu kullanıcı aktif değildir...",HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(4213,"Kullanıcı oluşturulamadı..." ,HttpStatus.BAD_REQUEST ),
    OTEL_NOT_FOUND(4213,"Otel bulunamadı..." ,HttpStatus.BAD_REQUEST ),
    INVALID_TOKEN(4214,"Geçersiz token" ,HttpStatus.BAD_REQUEST),
    CATEGORY_PROPERTIES_ALREADY_EXIST(4215, "Boyle bir CATEGORY_PROPERTY daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    TAG_ALLREADY_EXIST(4215, "Boyle bir TAG daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    CATEGORY_ALREADY_EXIST(4215, "Boyle bir kategori daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    PROPERTIES_ALREADY_EXIST(4215, "Boyle bir özellik daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    ROOM_ALREADY_EXIST(4215, "Boyle bir oda daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    ADDRESS_ALREADY_EXIST(4215, "Boyle bir adres daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    IMAGE_ALREADY_EXIST(4215, "Boyle bir resim daha once olusturulmustur",HttpStatus.BAD_REQUEST),
    OTEL_ALREADY_EXIST(4215, "Boyle bir otel daha once olusturulmustur",HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;
}
