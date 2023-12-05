# -*- coding: utf-8 -*-            
# @Author : HaiqingSun
# @Time : 2023/10/29 21:16
import argparse
import os
import csv


def execute_predict(original_filepath):
    original_filename = original_filepath.split(os.path.sep)[-1]
    # 检查是否存在 test 文件夹，不存在则创建
    result_folder_path = "test"
    if not os.path.exists(result_folder_path):
        os.makedirs(result_folder_path)

    # 构建 CSV 文件路径
    dot_index = original_filename.rfind('.')
    suffix = 'result'

    # 如果找到点，则在点之前插入后缀，否则直接附加后缀
    if dot_index != -1:
        filename = result_folder_path + os.path.sep + original_filename[:dot_index] + suffix + original_filename[dot_index:]
    else:
        filename = result_folder_path + os.path.sep + original_filename + suffix
    # file_path = os.path.join(result_folder_path, file_name)

    # 写入 CSV 文件
    with open(filename, mode='w', newline='') as csv_file:
        fieldnames = ['SMILES', 'SEQUENCE', 'Probability']
        writer = csv.DictWriter(csv_file, fieldnames=fieldnames)

        # 写入列名
        writer.writeheader()

        # 写入数据行
        writer.writerow({'SMILES': 'CCOc1ccc(NC(=O)[C@@H](C)O)c(N)c1', 'SEQUENCE': 'asdfghjk', 'Probability': '89.3%'})

    # print(f"CSV 文件已生成：{file_path}")
    return filename


def process_args():
    parser = argparse.ArgumentParser(description="Process SMILES and sequence parameters.")
    parser.add_argument("--smiles", help="SMILES data")
    parser.add_argument("--sequence", help="Sequence data")
    parser.add_argument("--predict_path", help="test CSV path")

    args = parser.parse_args()
    return args


def main():
    # 处理命令行参数
    args = process_args()
    if args.csv_path is None:
        print(execute_predict(args.smiles, args.sequence))
    elif args.smiles is None and args.sequence is None and args.csv_path is not None:
        print(execute_predict(args.predict_path))
        # ori_filename = args.csv_path.split(os.path.sep)[-1]
        #         with open(args.csv_path, 'r') as file:
        #     lines = file.readlines()
        #     for line in lines[1:]:
        #         items = line.strip('\n').split(',')
        #         print(execute_predict(items[0], items[1]))
    # # 输出参数值
    # print("SMILES:", args.smiles)
    # print("Sequence:", args.sequence)


if __name__ == "__main__":
    # print(torch.__version__)
    # print(dir(opts))
    # result = inspect.getmembers(opts)
    # print(result)
    # print(torch.cuda.is_available())
    # print(create_and_write_csv('CN(CCS(C)(=O)=O)C(=O)c1cccc([N+](=O)[O-])c1', 'AMTU'))
    main()
