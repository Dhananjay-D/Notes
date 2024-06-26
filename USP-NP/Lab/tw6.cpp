#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

static void charactertime(const char *); // Change to const char*

int main() {
    int pid;
    if ((pid = fork()) < 0) {
        printf("fork error\n");
    } else if (pid == 0) {
        charactertime("Output of the Child\n");
    } else {
        charactertime("Output of the Parent\n");
    }
    _exit(0);
}

static void charactertime(const char *str) { // Change to const char*
    const char *ptr; // Change to const char*
    int c;
    setbuf(stdout, NULL); // Disable buffering for stdout
    for (ptr = str; (c = *ptr++) != 0; ) {
        putc(c, stdout); // Output each character one at a time
    }
}
