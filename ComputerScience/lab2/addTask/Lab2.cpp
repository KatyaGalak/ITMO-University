#include <iostream>
#include <string>
#include <cstring>
#include <cmath>

int countSyndrom(std::string& message) {
    int numberControlDig = 0;
    while ((1 << numberControlDig) < message.size() + 1) {
        ++numberControlDig;
    }

    int syndrom = 0;

    for (int r = 0; r < numberControlDig; ++r) {
        int parity = 0;
        for (int i = (1 << r) - 1; i < message.size(); i += (1 << (r + 1))) {
            for (int j = i; j < i + (1 << r) && j < message.size(); ++j) {
                parity ^= (message[j] - '0');
            }
        }

        syndrom += parity * (1 << r);
    }

    return syndrom;
}

int parsingArgv(int argc, char** argv) {
    std::string ansString = "";
    for (std::size_t i = 1; i < argc; ++i) {
        for (std::size_t j = 0; j < strlen(argv[i]); ++j) {
            if (argv[i][j] == '-' || argv[i][j] == 'p' || argv[i][j] == '=') {
                continue;
            }
            ansString += argv[i][j];

        }
    }

    return stoi(ansString);
}

main(int argc, char** argv) {
    std::string message;
    std::cout << "Enter a message: " << std::endl;
    std::cin >> message;

    int messegeSize = message.size();

    if (argc > 1) {
        int parity = parsingArgv(argc, argv);

        if (message.size() > (1 << parity) - 1) {
            throw std::invalid_argument("Too few parity bits: " + parity);
        }

        while (message.size() < (1 << parity) - 1) {
            message += '0';
        }
    }

    int S = countSyndrom(message);

    if (!S) {
        std::cout << "There are no errors in the entered message" << std::endl;
        std::cout << "Information bits of the message: " << std::endl;
    } else {
        std::cout << "An error was found in bit number: " << S;
        message[S - 1] = (message[S - 1] == '0') ? '1' : '0';  

        if (!(S & (S - 1))) {
            std::cout << " (r" << (int)log2(S) + 1 << ")" << std::endl;
        } else {
            std::cout << " (i" << S - (int)log2(S) - 1 << ")" << std::endl;
        }
    }

    for (int i = 1; i <= message.size() && i <= messegeSize; ++i) {
        if (!(i & (i - 1))) { // проверка на степень двойки
            continue; 
        }

        std::cout << message[i - 1];
    }

    std::cout << std::endl;
}
