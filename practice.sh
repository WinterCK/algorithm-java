#!/bin/bash  
  
# 获取输入参数  
copy_type="$1"  
output_folder="$2"  
  
# 数据格式校验  
if [[ -z "$copy_type" || -z "$output_folder" ]]; then  
  echo "错误：复制类型或输出文件夹为空"  
  exit 1  
fi  
  
  
if [[ -e "$output_folder" && ! -d "$output_folder" ]]; then  
  echo "错误：输出路径存在，但不是文件夹"  
  exit 1  
fi  
  
# 复制文件  
source=$PWD/src/main/java/org/algorithm/chenjk/practice/template/$copy_type
output=$PWD/src/main/java/org/algorithm/chenjk/practice/z$output_folder/$copy_type
mkdir -p "$output"
cp -r "$source"/* "$output"


# 对output目录下的所有*.java文件的首行package做替换
#replace_package="package org.algorithm.chenjk.practice.z$output_folder.$copy_type;"
replace_package=$(printf 'package org.algorithm.chenjk.practice.z%s.%s;\n' "$output_folder" "$copy_type")

#echo "$replace_package"
for file in "$output"/*.java; do
#  echo "$file"
  gsed -i '1s|.*|'"$replace_package"'|' "$file"
done
echo "文件复制和替换完成"
