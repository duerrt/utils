#!/usr/bin/env bash

# script to find ip address of specified interface
# and replace the string localhost with the ip address.
# also renames the changed file from .cfg to .conf

root_dir="/etc/testFiles"
if  [ ! -d "$root_dir" ] ;
    then
    printf 'root directory - %s is not valid\n' "$root_dir"
    exit 0
fi

interface="eth0"
if [ "$#" -eq  "1" ]
    then
    interface=$1
fi
echo "Using interface $interface"

ip=$(ifconfig $interface | awk '/inet addr/{print substr($2,6)}')
if [ -z $ip ]
    then
    printf 'Interface %s not active or present\n' $interface
    exit 0
fi

find "$root_dir" -maxdepth 1 -type f -name '*.cfg' -print0 | while IFS=
read -r -d '' file; do
    printf 'Updating file %s \n' "$file"
    filename=${file%.*}
    sed -e "s/localhost/${ip}/g" "$file" > "$filename.conf"
done
