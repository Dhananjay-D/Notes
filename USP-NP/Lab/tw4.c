#include <stdio.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[])
{
    char temp[1000];
    struct flock fvar;
    int fdesc;
    char buf;
    int rc;
    off_t offset;

    if (argc != 2) {
        printf("Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    fdesc = open(argv[1], O_RDWR);
    if (fdesc == -1) {
        perror("Error opening file");
        return 1;
    }

    offset = lseek(fdesc, -100, SEEK_END);
    
    fvar.l_type = F_WRLCK;
    fvar.l_whence = SEEK_CUR;
    fvar.l_start = 0;
    fvar.l_len = 100;

    if (fcntl(fdesc, F_SETLK, &fvar) == -1)
    {
        printf("\n---- File has been locked by: \n");
        while (fcntl(fdesc, F_GETLK, &fvar) != -1 && fvar.l_type != F_UNLCK)
        {
            printf("\nFile: %s is locked by process with pid: %d\n", argv[1], fvar.l_pid);
        }
    }
    else
    {
        printf("\n---- \n");
        printf("\nFile: %s was not locked and acquiring of exclusive lock was:", argv[1]);
        printf(" Successful By Process Id: %d\n", getpid());

        offset = lseek(fdesc, -50, SEEK_END);
        printf("\nLast 50 bytes of file %s = \n", argv[1]);
        while ((rc = read(fdesc, &buf, 1)) > 0) printf("%c", buf);
        
        offset = lseek(fdesc, -100, SEEK_END);
        fvar.l_type = F_UNLCK;
        fvar.l_whence = SEEK_CUR;
        fvar.l_start = 0;
        fvar.l_len = 100;

        fcntl(fdesc, F_SETLKW, &fvar);
        printf("\nFile unlocked successfully\n");
    }

    close(fdesc);
    return 0;
}
