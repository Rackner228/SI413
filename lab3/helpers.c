#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Making the helper functions
char* reverse(char* string) {
    int length = strlen(string) + 1;
    char * reverseString = (char *)calloc(length, sizeof(char));
    for (int i = length - 1; i--; i >= 0) {
        

    }

}
char* concat(char* word1, char* word2) {
    int length1 = strlen(word1);
    int length2 = strlen(word2);
    total = length1 + length2 + t;
    char *combine = (char *)calloc(total, sizeof(char));
    return combine;
}
char* get_input() {
    // Getting input without a set buffer
    char *line = NULL;
    size_t len = 0;
    ssize_t read;   
    read = getline(&line, &len, stdin);
    return read;
}
