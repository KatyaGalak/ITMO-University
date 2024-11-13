#include<bits/stdc++.h>
using namespace std;

main() {
    freopen("BigAnswer_1.txt", "r", stdin);
    freopen("out.txt", "w", stdout);

    vector<string> ans;

    string s;

    while (cin>>s) {
        ans.push_back(s);
    }

    for (auto i : ans) {
        cout << "'" << i << "', ";
    }
}