#include <bits/stdc++.h>
using namespace std;

int n, m;
unordered_map<string, int> wordMap;

int compare(pair<string, int> &p1, pair<string, int> &p2) {

    if (p1.second != p2.second) return p1.second > p2.second;
    
    if (p1.first.length() != p2.first.length()) return p1.first.length() > p2.first.length();
    
    return p1.first < p2.first;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> n >> m;

    while(n--) {
        string s;
        cin >> s;
        if (s.length() < m) continue;

        if (wordMap.find(s) == wordMap.end()) {
            wordMap.insert({ s, 1 });
        } else {
            wordMap[s]++;
        }
    }

    vector<pair<string, int>> v;

    for (auto p : wordMap) {
        v.push_back(p);
    }

    sort(v.begin(), v.end(), compare);

    for (auto p : v) {
        cout << p.first << '\n';
    }
}