#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>

enum class NumberSystem {
    Fibonacci,
    Factorial,
    Classic
};

void ThrowError(const std::string& string_error) {
    throw std::invalid_argument("Input error: " + string_error);
}

void TypeSystem(NumberSystem& type_system_, std::string& number_system_) {
    if (std::all_of(number_system_.begin(), number_system_.end(), ::isdigit) || 
         number_system_[0] == '-' && std::all_of(number_system_.substr(1, std::string::npos).begin(), 
         number_system_.substr(1, std::string::npos).end(), ::isdigit)) {
        
        type_system_ = NumberSystem::Classic;
    } else if (number_system_ == "Fib" || number_system_ == "Fibonacci") {
        type_system_ = NumberSystem::Fibonacci;
    } else if (number_system_ == "Fac" || number_system_ == "Factorial") {
        type_system_ = NumberSystem::Factorial;
    } else if (std::find(number_system_.begin(), number_system_.end(), 'S') == number_system_.end() - 1) {
        type_system_ = NumberSystem::Classic;

        std::string system_without_S = "";
        system_without_S = number_system_.substr(0, number_system_.size() - 1);

        if (!(std::stoi(system_without_S) % 2)) {
            ThrowError("Symmetric number system does not happen with an even base");
        }

        number_system_ = system_without_S;
    } else {
        ThrowError(number_system_ + " - this number system is not supported");
    }
}

void ParsingNumberVector(std::vector<int>& vector_number, const std::string& number) {
    bool is_negative = false;
    for (auto digit_char : number) {
        if (digit_char == '{') {
            is_negative = true;
            continue;
        }
        if (digit_char == '}') {
            is_negative = false;
            continue;
        }

        vector_number.push_back(std::isdigit(digit_char) ? (digit_char - '0') : (digit_char - 'A' + 10)); 

        if (is_negative) {
            vector_number[vector_number.size() - 1] *= -1; 
        }

    }
}

std::vector<int> DecimalToClassical(int old_number, int future_system) {
    std::vector<int> ans_num;

    do {
        ans_num.push_back(((old_number % future_system) + future_system) % future_system);
        old_number /= future_system;
    } while (old_number != 0);

    std::reverse(ans_num.begin(), ans_num.end());

    return ans_num;
}

void ClassicalToDecimal(std::vector<int>& old_number, int old_system) {
    int degree = 1;
    int ans = 0;

    for (int i = old_number.size() - 1; i >= 0; --i) {
        ans += degree * old_number[i];
        degree *= old_system;
    }

    std::vector<int> ans_vector;
    ParsingNumberVector(ans_vector, std::to_string(ans));

    old_number.resize(ans_vector.size());
    for (int i = 0; i < ans_vector.size(); ++i) {
        old_number[i] = ans_vector[i];
    }

}

std::vector<int> DecimalToFib(int old_number) {
    std::vector<int> fib_posl = {1, 2};

    int size_posl_fib = 2;

    while (fib_posl[size_posl_fib - 1] < old_number) {
        fib_posl.push_back(fib_posl[size_posl_fib - 1] + fib_posl[size_posl_fib - 2]);
        ++size_posl_fib;
    }

    std::vector<int> ans;

    --size_posl_fib;

    while (old_number != 0) {
        if (old_number >= fib_posl[size_posl_fib - 1]) {
            ans.push_back(1);
            old_number -= fib_posl[size_posl_fib - 1];
        } else {
            ans.push_back(0);
        }

        --size_posl_fib;
    }

    while (size_posl_fib--) {
        ans.push_back(0);
    }

    return ans;
}

std::vector<int> DecimalToFact(int old_number) {
    std::vector<int> fact = {1};

    int i = 2;
    int size_fact = 1;
    while (fact[size_fact - 1] < old_number) {
        fact.push_back(fact[size_fact - 1] * i);
        ++size_fact;
        ++i;
    }

    --size_fact;
    std::vector<int> ans;

    while (old_number != 0) {
        if (old_number >= fact[size_fact - 1]) {
            ans.push_back(old_number / fact[size_fact - 1]);
            old_number -= (old_number / fact[size_fact - 1]) * fact[size_fact - 1];
        } else {
            ans.push_back(0);
        }

        --size_fact;
    }

    while (size_fact--) {
        ans.push_back(0);
    }

    return ans;
}

void GenAns(const std::vector<int>& vec_ans) {
    for (auto i : vec_ans) {
        if (i > 9) {
            std::cout << ('A' + i - 10);
            continue;
        }
        
        std::cout << i;
    }

    std::cout << std::endl;
}

void FromClassic(const NumberSystem& type_system_future, std::string& number_system_old, 
                 std::string& number_system_future, const std::string& number) {
    
    std::vector<int> vector_number;

    ParsingNumberVector(vector_number, number);

    ClassicalToDecimal(vector_number, std::stoi(number_system_old));

    int vector_to_num = 0;
    int pow_10 = 1;
    for (int i = vector_number.size() - 1; i >= 0; --i) {
        vector_to_num += vector_number[i] * pow_10;
        pow_10 *= 10;
    }

    if (type_system_future == NumberSystem::Classic) {
        GenAns(DecimalToClassical(vector_to_num, std::stoi(number_system_future)));
    } else if (type_system_future == NumberSystem::Factorial) {
        GenAns(DecimalToFact(vector_to_num));
    } else {
        GenAns(DecimalToFib(vector_to_num));
    }
}

void FromFib(const NumberSystem& type_system_future, 
             std::string& number_system_future, const std::string& number) {

    std::vector<int> fib = {1, 2};

    int int_num = 0;
    for (int i = 0; i < number.size(); ++i) {
        int_num += fib[i] * (number[number.size() - i - 1] - '0');
        fib.push_back(fib[fib.size() - 1] + fib[fib.size() - 2]);
    }

    std::string old_system = "10";
    FromClassic(type_system_future, old_system, number_system_future, std::to_string(int_num));
}

void FromFact(const NumberSystem& type_system_future, 
              std::string& number_system_future, const std::string& number) {
    
    int calc_dec = 0;
    int factorial = 1;

    for (int i = 0; i < number.size(); ++i) {
        calc_dec += factorial * (number[number.size() - i - 1] - '0');
        factorial *= i + 2;
    }

    std::string old_system = "10";
    FromClassic(type_system_future, old_system, number_system_future, std::to_string(calc_dec));
}

main() {
    std::string number_;
    std::string number_system_now_;
    std::string number_system_future_;

    std::cin >> number_ >> number_system_now_ >> number_system_future_;

    NumberSystem type_system_now_;
    NumberSystem type_system_future_;

    TypeSystem(type_system_now_, number_system_now_);
    TypeSystem(type_system_future_, number_system_future_);

    switch (type_system_now_) {
        case NumberSystem::Classic:
            FromClassic(type_system_future_, number_system_now_, number_system_future_, number_);
            break;
        case NumberSystem::Factorial:
            FromFact(type_system_future_, number_system_future_, number_);
            break;
        case NumberSystem::Fibonacci:
            FromFib(type_system_future_, number_system_future_, number_);
            break;
        default:
            break;

    }

}
