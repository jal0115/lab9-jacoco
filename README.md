# Лаб 9: Код хамралт, JaCoCo

**Оюутан:** Г. Лувсанжал, **код:** B242270016
**GitHub:** jal0115

## Орчин

    java version "23.0.1" 2024-10-15
    Java(TM) SE Runtime Environment (build 23.0.1+11-39)
    Java HotSpot(TM) 64-Bit Server VM (build 23.0.1+11-39, mixed mode, sharing)
    Apache Maven 3.9.9
    Maven home: /usr/share/maven
    Java version: 23.0.1, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-23
    Default locale: en, platform encoding: UTF-8
    OS name: "linux", version: "6.12.107+deb13-amd64", arch: "amd64", family: "unix"

## A: Happy path ба эхний хэмжилт

Хэвийн урсгалын 5 тест бичсэн (`letterGrade` 2, `gpa` 1, `scholarship` 2): `results/mvn-verify-A.txt` дахь `Tests run: 5, Failures: 0`.

`results/jacoco-A.csv`-ээс: **Branch 22/41 хамрагдсан** (19 дутуу, ≈ 53.7%), **Line 16/25 хамрагдсан** (9 дутуу, 64%). JaCoCo-ийн HTML тайлан Branch-ийг `53%` гэж таслан харуулдаг.

Тайлан дээрх ажиглалт: улаан (огт хүрээгүй) мөрүүд нь бүх `throw new IllegalArgumentException` алдааны замууд, мөн `D`/`F` үсгэн дүн буцаах мөрүүд, `scholarship()`-ийн сахилгын зөрчилтэй (`hasViolation`) зам ба 50, 0 тэтгэлэг буцаах мөрүүд. Шар ромботой мөрүүд нь `if (... || ...)` ба `&&` нөхцөлтэй мөрүүд: happy path тестүүд нөхцөл бүрийн зөвхөн нэг талд (үнэн биш талд) хүрсэн тул ердөө хагас хамрагдсан.

## AI ашигласан тухай

Энэ лабт AI туслахыг (Claude) алхам бүрийг тайлбарлуулах, тестийн ноорог болон README-ийн ноорог бичүүлэхэд ашигласан. Бүх тестийг өөрөө ажиллуулж, JaCoCo тайланг өөрөө нээж шалгасан, results/ файлууд бодит `mvn verify` гаралт болно.
