//vim recipes-hello/hello/files/hello_world.c
#include <stdio.h>

void print_helloworld() {
    printf("#   #  #####  #       #          ###         #     #    ###    ###   #       #####  \n");
    printf("#   #  #      #       #        #     #       #     #  #     #  #  #  #       #    # \n"); 
    printf("#####  #####  #       #        #     #       #     #  #     #  ###   #       #    # \n"); 
    printf("#   #  #      #       #        #     #       #  #  #  #     #  # #   #       #    # \n");
    printf("#   #  #####  ######  ######     ###          #  #      ###    #  #  ######  #####  \n");
}


int main() {
    print_helloworld();
    
    return 0;
}