#define _POSIX_SOURCE
#define _POSIX_C_SOURCE 199309L
#include <iostream>
#include <unistd.h>
#include <limits.h>
using namespace std;

int main() {
#ifdef _POSIX_JOB_CONTROL
	cout << "System supports job control " << _POSIX_JOB_CONTROL << endl;
#else 
	cout << "System does not support" << endl;
#endif

#ifdef _POSIX_SAVED_IDS
	cout << "System supports saved ids " << _POSIX_SAVED_IDS << endl;
#else
	cout << "System does not support" << endl;
#endif

#ifdef _POSIX_CHOWN_RESTRICTED
	cout << "System supports change ownership " << _POSIX_CHOWN_RESTRICTED << endl;
#else
	cout << "System does not support" << endl;
#endif

#ifdef _POSIX_NO_TRUNC
	cout << "System supports path truncation " << _POSIX_NO_TRUNC << endl;
#else
	cout << "System does not support" << endl;
#endif

#ifdef _POSIX_VDISABLE
	cout << "System supports disable characters for files " << _POSIX_VDISABLE << endl;
#else
	cout << "System does not support" << endl;
#endif

	return 0;
}
