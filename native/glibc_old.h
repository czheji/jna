//
// Created by czj on 2017/8/24.
//

#ifndef CKEYS_GLIBC_H
#define CKEYS_GLIBC_H
#if defined(__linux__) && defined(__GNUC__) && !defined(__ANDROID__)
__asm__(".symver memcpy,memcpy@GLIBC_2.2.5");
#endif
#endif //CKEYS_GLIBC_H
