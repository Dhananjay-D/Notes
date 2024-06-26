#define _POSIX_SOURCE
#define _POSIX_C_SOURCE 199309L
#include <iostream>
#include <unistd.h>
#include <limits.h>
using namespace std;

int main() {
	int ch;
	int res;
	cout << "Enter the choice";
	cin >> ch;
	switch (ch) {
		case 1:
			cout << "Runtime config limits\n";
			if ((res = sysconf(_SC_CLK_TCK))==-1)
				cout << "System does not support\n";
			else
				cout << "Number of Clock Tick: " << res << endl;
			if ((res = sysconf(_SC_CHILD_MAX))==-1)
				cout << "System does not support\n";
			else
				cout << "Number of Child Proc: " << res << endl;
			if ((res = pathconf("/", _PC_PATH_MAX))==-1)
				cout << "System does not support\n";
			else
				cout << "Max Path Length: " << res << endl;
			if ((res = pathconf("/", _PC_NAME_MAX))==-1)
				cout << "System does not support\n";
			else
				cout << "Max name length: " << res << endl;
			if ((res = sysconf(_SC_OPEN_MAX))==-1)
				cout << "System does not support\n";
			else
				cout << "Max open files: " << res << endl;
			break;
		case 2:
			cout << "Compile time config limits\n";
			cout << "Max child processes: " << _POSIX_CHILD_MAX << endl;
			cout << "Max path length: " << _POSIX_PATH_MAX << endl;
			cout << "Max name length: " << _POSIX_NAME_MAX << endl;
			cout << "Max open files: " << _POSIX_OPEN_MAX << endl;
			return 0;
	}
}

